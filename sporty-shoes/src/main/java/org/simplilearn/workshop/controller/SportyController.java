package org.simplilearn.workshop.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.simplilearn.workshop.model.Admin;
import org.simplilearn.workshop.model.Order;
import org.simplilearn.workshop.model.Orders;
import org.simplilearn.workshop.model.Product;
import org.simplilearn.workshop.model.User;
import org.simplilearn.workshop.service.AdminService;
import org.simplilearn.workshop.service.OrderDetailsService;
import org.simplilearn.workshop.service.ProductService;
import org.simplilearn.workshop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;




@Controller
@RequestMapping("/admin")
public class SportyController{

	@Autowired
	private AdminService adminService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private OrderDetailsService orderDetailsService;
	
	@Autowired
	private ProductService productService;
	
	boolean flag = false;

	// http://localhost:8081/
	@GetMapping("/log")
	public String toLogin(Model theModel, HttpServletRequest request) {
		Cookie cookie[] = request.getCookies();
		for(Cookie temp:cookie) {
			if(temp.getName().equals("Admin_id") && Integer.parseInt(temp.getValue()) > 0) {
				
				return "redirect:/admin/adminLog";
			}
		}
		return "login";
	}
	
	
	@GetMapping("/adminLog")
	public String verifyAdminLogin(Model theModel, HttpServletRequest request) {
		
		// admin1 variable to store admin row
		Admin admin1 = new Admin();
			
		Cookie cookie[] = request.getCookies();
		for(Cookie temp:cookie) {
			if(temp.getName().equals("Admin_id") && Integer.parseInt(temp.getValue()) > 0) {
				admin1 = adminService.findAdmin(Integer.parseInt(temp.getValue()));
				break;
			}
		}
			
		theModel.addAttribute("admin", admin1);
		return "admin-home"; // logical view name
	}
	
	
	@PostMapping("/adminLoged")
	public String verifyAdminLogin(@RequestParam("username") String username, @RequestParam("password") String password,Model theModel,
			HttpServletResponse response) {
		
		// admin1 variable to store admin row
		Admin admin1 = new Admin();
		
		//get customers from the service
		List<Admin> admin = adminService.findAll();
		
		admin1.setId(0);
		
		for(Admin temp : admin) {
			if(temp.getUserName().equals(username) && temp.getPassword().equals(password)) {
				admin1 = temp;
				break;
			}
		}
		if(admin1.getId() == 0) {
			return "redirect:/admin/log";
		}
		
		Cookie cookie = new Cookie("Admin_id", ""+admin1.getId());
		cookie.setMaxAge(2*24*60*60);
		response.addCookie(cookie);
		
		theModel.addAttribute("admin", admin1);
		return "admin-home"; // logical view name
	}
	
	@GetMapping("/loggingout")
	public String Logout(Model theModel, HttpServletRequest request, HttpServletResponse response) {
		
		Cookie cookie[] = request.getCookies();
		for(Cookie temp:cookie) {
			if(temp.getName().equals("Admin_id") && Integer.parseInt(temp.getValue()) > 0) {
				Cookie cookie1 = new Cookie("Admin_id", temp.getValue());
				cookie1.setMaxAge(0);
				response.addCookie(cookie1);
				break;
			}
		}
		return "logout-successfully";
	}
	
	@GetMapping("/usersView")
	public String userController(Model theModel) {
		System.out.println("hello");
		
		List<User> users = userService.findAllUsers();
		
		theModel.addAttribute("users", users);
		
		return "user-view-page";
	}
	
	@PostMapping("/userSearch")
	public String searchUser(@RequestParam("search") String search ,Model theMode) {
		
		List<User> tempUser = new ArrayList<>();
		
		List<User> users = userService.findAllUsers();
		
		Set<Integer> id = new HashSet<>();
		
		for(User temp : users) {
			if((temp.getFirstName().toLowerCase().contains(search) ||
					temp.getLastName().toLowerCase().contains(search))
				&& id.add(temp.getId())) {
				tempUser.add(temp);
			}
		}
		
		theMode.addAttribute("users",tempUser);
		
		return "user-view-page";
		
	}
	
	@GetMapping("/orders")
	public String orderDetail(Model theModel) {
		
		List<Orders> orderDetails = orderDetailsService.findAllOrders();
		
		List<Order> orders = new ArrayList<>();
		
		Set<String> set = new HashSet<>();
		
		for(Orders temp : orderDetails) {
			Order tempOrder = new Order();
			tempOrder.setOrderDetails(temp);
			tempOrder.setProduct(productService.findProduct(temp.getShoeId()));
			tempOrder.setUser(userService.findUser(temp.getUserId()));
			set.add(tempOrder.getProduct().getCategory());
			orders.add(tempOrder);
		}
		
		
		theModel.addAttribute("orders", orders);
		theModel.addAttribute("set", set);
		
		return "order-view";
	}
	
	@PostMapping("/filterSearch")
	public String filterSearch(@RequestParam("date") String date, @RequestParam("category") String category, Model theModel) throws ParseException {
		
		List<Orders> orderDetails = orderDetailsService.findAllOrders();
		
		List<Order> orders = new ArrayList<>();
		
		Set<String> set = new HashSet<>();
		
		for(Orders temp : orderDetails) {
			Order tempOrder = new Order();
			tempOrder.setOrderDetails(temp);
			tempOrder.setProduct(productService.findProduct(temp.getShoeId()));
			tempOrder.setUser(userService.findUser(temp.getUserId()));
			set.add(tempOrder.getProduct().getCategory());
			SimpleDateFormat sdformat = new SimpleDateFormat("yyyy-MM-dd");
			System.out.println("bvhkk"+date+"vhvvh");
			
			if( !date.equals("") && !category.equals("") &&
					sdformat.parse(tempOrder.getOrderDetails().getDate()).compareTo(sdformat.parse(date))>=0
					&& category.equalsIgnoreCase(tempOrder.getProduct().getCategory())) {
				orders.add(tempOrder);
			}
			else if(date.equals("") && !category.equals("") &&
					category.equalsIgnoreCase(tempOrder.getProduct().getCategory())) {
				orders.add(tempOrder);
			}
			else if(!date.equals("") && category.equals("") &&
					sdformat.parse(tempOrder.getOrderDetails().getDate()).compareTo(sdformat.parse(date))>=0) {
				orders.add(tempOrder);
			}
			else if(date.equals("") && category.equals("")) {
				orders.add(tempOrder);
			}
			
		}
		
		
		theModel.addAttribute("orders", orders);
		theModel.addAttribute("set", set);
		
		return "order-view";
	}
	
	@GetMapping("/products")
	public String productController(Model theModel) {
		List<Product> products = productService.findAllProducts();
		
		theModel.addAttribute("products", products);
		
		return "products-view";
	}
	
	@GetMapping("/showFormForAdd")
	public String addProduct(Model theModel) {
		
		Product product = new Product();
		
		theModel.addAttribute("product", product);
		
		return "product-form";
	}
	
	@PostMapping("/saveProduct")
	public String saveProduct(@ModelAttribute("product") Product product, Model theModel) {
		
		productService.updateProduct(product);
		
		return "redirect:/admin/products";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("productId") String id,Model theModel) {
		
		Product product = productService.findProduct(Integer.parseInt(id));
		
		theModel.addAttribute("product", product);
		
		return "product-form";
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam("productId") String id,Model theModel) {
		
		productService.delete(productService.findProduct(Integer.parseInt(id)));
		
		return "redirect:/admin/products";
	}
	
	@GetMapping("/changePassword")
	public String changePassword(Model theModel) {
		theModel.addAttribute("flag",flag);
		
		return "change-password";
	}
	
	@PostMapping("/passwordChange")
	public String passwordChange(@RequestParam("password1") String password1,
			@RequestParam("password2") String password2, Model theModel,
			HttpServletRequest request, HttpServletResponse response) {
		if(!password1.equals(password2)) {
			flag = true;
			return "redirect:/admin/password";
		}
		int id = 0;
		Cookie cookie[] = request.getCookies();
		for(Cookie temp:cookie) {
			if(temp.getName().equals("Admin_id") && Integer.parseInt(temp.getValue()) > 0) {
				
				id = Integer.parseInt(temp.getValue());
				
				temp.setMaxAge(0);
				response.addCookie(temp);
				break;
			}
		}
		
		Admin admin = adminService.findAdmin(id);
		
		admin.setPassword(password1);
		
		adminService.saveOrUpdate(admin);
		
		return "password-confirmation";
	}
	
	
	
	
	
}

