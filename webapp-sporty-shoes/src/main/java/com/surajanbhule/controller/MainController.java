package com.surajanbhule.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.surajanbhule.Helper;
import com.surajanbhule.entities.Cart;
import com.surajanbhule.entities.Category;
import com.surajanbhule.entities.Order;
import com.surajanbhule.entities.Product;
import com.surajanbhule.entities.User;
import com.surajanbhule.repositories.CartRepository;
import com.surajanbhule.repositories.CategoryRepository;
import com.surajanbhule.repositories.OrderRepository;
import com.surajanbhule.repositories.ProductRepository;
import com.surajanbhule.repositories.UserRepository;

@Controller
@MultipartConfig
public class MainController {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private CartRepository cartRepository;
	
	@Autowired
	private OrderRepository orderRepository;

	@RequestMapping(path="/")
	public String home(HttpServletRequest request,Model model) {
		String catid=request.getParameter("catid");
		
		HttpSession session=request.getSession();
		User user=(User) session.getAttribute("current-user");
		List<Product>cart_products_list=null;
		if(user==null) {
			cart_products_list =new ArrayList<>();
			System.out.println("No User");
		}
		else {
			cart_products_list  = user.getCart().getCart_products_list();
			for(Product p:cart_products_list)
				System.out.println(p.getProduct_name());
			System.out.println(user.getFirst_name());
		}
	
		List<Category> categories= (List<Category>) categoryRepository.findAll();
		List<User> users= (List<User>) userRepository.findAll();
		List<Cart> cart_list=(List<Cart>) cartRepository.findAll();
		Helper helper=new Helper();
	    model.addAttribute("cart_products_list", cart_products_list);
		model.addAttribute("helper", helper);
		model.addAttribute("categories",categories);
		model.addAttribute("users",users);
		List<Product>products=null;
		
		
		if(catid==null||catid.equals("all"))
		{
		
			products= (List<Product>) productRepository.findAll();
		    model.addAttribute("category_id", 0);
		
		}else {
			
			Optional<Category> catop = categoryRepository.findById(Long.parseLong(catid));
			Category cat= catop.get();
			products= (List<Product>) productRepository.findProductsByCategory(cat);
			System.out.println(products);
			request.setAttribute("cat", cat);
			model.addAttribute("category_id", cat.getCategory_id());
			
			
		}
		model.addAttribute("active", "active");
		model.addAttribute("dont_active", "");
		 model.addAttribute("products",products);
		return "index";
	}

	@PostMapping("/changeAdminPassword")
	public String changePassword(@Param("current_password_name")String current_password_name,
			@Param("new_password_name")String new_password_name
			,HttpServletRequest request, Model model) {
		
		HttpSession session=request.getSession();
		User user=(User)session.getAttribute("current-user");
		
		if(current_password_name.equals(new_password_name)) {
			session.setAttribute("messege", "New Password Can't Be Same");
			session.setAttribute("msg_type", "danger");
			return "redirect:/admin";
		}
		else {
			
			if(current_password_name.equals(user.getPassword())) {
				user.setPassword(new_password_name);
				userRepository.save(user);
				session.setAttribute("messege", "Password Change Successfully");
				session.setAttribute("msg_type", "success");
			}
			else {
				session.setAttribute("messege", "Please enter correct password");
				session.setAttribute("msg_type", "danger");
			}
		
		}
		
		
		return "redirect:/admin";
	}
	
	
	@RequestMapping(path = "/admin")
	public String admin(HttpServletRequest request, Model model) {
		
		
		Helper helper= new Helper();
		
		List<Category> categories= (List<Category>) categoryRepository.findAll();
		List<User> users= (List<User>) userRepository.findAll();
		List<Product>products= (List<Product>) productRepository.findAll();
		List<Order>orders=(List<Order>) orderRepository.findAll();
		model.addAttribute("orders", orders);
		model.addAttribute("helper", helper);
		model.addAttribute("categories",categories);
		model.addAttribute("users",users);
		model.addAttribute("products",products);
		
		
		return "admin";
	}
	
	@RequestMapping(path = "/addCategory")
	public String addCategory(@ModelAttribute Category category,HttpServletRequest request) {
		HttpSession session=request.getSession();
		
		try {
			Category savedCat = categoryRepository.save(category);
			
			if(savedCat!=null) {
				session.setAttribute("messege", "Category Added Successfully.");
				session.setAttribute("msg_type", "success");
			}else {
				
				session.setAttribute("messege", "Something went wrong, try again");
				session.setAttribute("msg_type", "danger");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		
		
		
		return "redirect:/admin";
	}
	
	
	
	@RequestMapping(path = "/addToCart")
	public String addToCart(HttpServletRequest request) {
		HttpSession session=request.getSession();
		long product_id= Long.parseLong(request.getParameter("product_id"));
		User user= (User)session.getAttribute("current-user"); 
		
		
		if(user==null) {
			session.setAttribute("messege", "Login First To Add To Cart");
			session.setAttribute("msg_type", "danger");
			return "redirect:/login";
		}
		else {
			
			if(user.getUser_type().equals("admin")) {
				session.setAttribute("messege", "Admin Can't Use This");
				session.setAttribute("msg_type", "warning");
				return "redirect:/";
			}
			
		System.out.println("Product Id: "+ product_id);
		System.out.println("User"+user.getFirst_name());
		
		Optional<Product> productOp = productRepository.findById(product_id);
		Product product=productOp.get();
		
		Cart cart= user.getCart();
		List<Product> cart_products_list = cart.getCart_products_list();
		cart_products_list.add(product);
		try {
			cart.setCart_products_list(cart_products_list);
			cartRepository.save(cart);
			productRepository.save(product);
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}
		
		
		
		return "redirect:/";
	 }
	}
	
	
	@RequestMapping(path = "/deleteFromCart")
	public String deleteFromCart(HttpServletRequest request) {
		HttpSession session=request.getSession();
		long product_id= Long.parseLong(request.getParameter("product_id"));
		User user= (User)session.getAttribute("current-user"); 
		
		
		try {
			System.out.println("Try to deleting product from cart");
			 Optional<Product> pO = productRepository.findById(product_id);
			 Product product=pO.get();
			 System.out.println("Product Name "+product.getProduct_name());
			Cart cart= user.getCart();
			List<Product> cart_products_list = cart.getCart_products_list();
			
			for(Product p:cart_products_list) {
				if(p.getProduct_id()==product_id)
				{
					boolean r = cart_products_list.remove(p);
					System.out.println("item removed successfully");
				}
			}
			
			
			
			cart.setCart_products_list(cart_products_list);
			
			cartRepository.save(cart);
			productRepository.save(product);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		return "redirect:/";
	}
	
	
	@RequestMapping(path = "/checkout")
	public String doCheckout(HttpServletRequest request) {
		HttpSession session=request.getSession();
		User user= (User)session.getAttribute("current-user"); 
		Helper helper= new Helper();
		double amount=Double.parseDouble(request.getParameter("amount"));
		try {
		
			Cart cart=user.getCart();
			List<Product> productlist=cart.getCart_products_list();
			
			if(productlist.isEmpty()) {
				session.setAttribute("messege", "Cart Is Empty");
				session.setAttribute("msg_type", "danger");
				return "redirect:/";
			}
			
			long millis=System.currentTimeMillis();
			Date date=new Date(millis);
			
			Order order= new Order();
			order.setUser(user);
			order.setOrder_date(date);
			order.setOrder_status("Placed");
			order.setTotal_amount(amount);
			
			Order savedOrder = orderRepository.save(order);
			
			if(savedOrder!=null) {
				boolean removeAll = productlist.removeAll(productlist);
				String msg= removeAll?"Removed All Products From Cart":"Unable To Remove";
				System.out.println(msg);
				cart.setCart_products_list(productlist);
				cartRepository.save(cart);
				
			}
			
			session.setAttribute("messege", "Your Order Is Placed Succssfully, You Will Received It Shortly");
			session.setAttribute("msg_type", "primary");
		
			
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			session.setAttribute("messege", "Unable To Place Order, Try Later");
			session.setAttribute("msg_type", "danger");
		}
		
		
		return "redirect:/";
	}
	
	
	
	@RequestMapping(path = "/addProduct")
	
	public String addProduct(HttpServletRequest request,
			                 @Param("category")String category,
			                 @Param("image1")MultipartFile image1,
			                 @Param("image2")MultipartFile image2,
			                 @Param("image3")MultipartFile image3,
			                 @Param("image4")MultipartFile image4,
			                 @Param("product_name")String product_name,
			                 @Param("product_description")String product_description,
			                 @Param("product_stock") int product_stock,
			                 @Param(" product_discount")double product_discount,
			                 @Param("product_price")double product_price
			                 ) throws Exception
	{
		System.out.println("Category Output "+category);
		System.out.println("Image1"+image1.getName());
		HttpSession session=request.getSession();
		
		Optional<Category> findCategoryById = categoryRepository.findById(Long.parseLong(category));
		Category categoryOb=findCategoryById.get();
		
		Product product = new Product();
		product.setCategory(categoryOb);
		product.setImage1(product_name+"_"+image1.getOriginalFilename());
		product.setImage2(product_name+"_"+image2.getOriginalFilename());
		product.setImage3(product_name+"_"+image3.getOriginalFilename());
		product.setImage4(product_name+"_"+image4.getOriginalFilename());
		product.setProduct_name(product_name);
		product.setProduct_description(product_description);
		product.setProduct_stock(product_stock);
		product.setProduct_discount(product_discount);
		product.setProduct_price(product_price);
		double product_original_price=   product_price - (product_price * (product_discount/100));
		product.setProduct_original_price(product_original_price);
		
		//Images Uploading
		String rpath1=request.getRealPath("img")+File.separator+"products"+File.separator+product_name+"_"+image1.getOriginalFilename();
		String rpath2=request.getRealPath("img")+File.separator+"products"+File.separator+product_name+"_"+image2.getOriginalFilename();
		String rpath3=request.getRealPath("img")+File.separator+"products"+File.separator+product_name+"_"+image3.getOriginalFilename();
		String rpath4=request.getRealPath("img")+File.separator+"products"+File.separator+product_name+"_"+image4.getOriginalFilename();
		System.out.println("R Path: "+rpath1);
		
		FileOutputStream fos1=new FileOutputStream(rpath1);
		FileOutputStream fos2=new FileOutputStream(rpath2);
		FileOutputStream fos3=new FileOutputStream(rpath3);
		FileOutputStream fos4=new FileOutputStream(rpath4);
		
		InputStream is1= image1.getInputStream();
		InputStream is2= image2.getInputStream();
		InputStream is3= image3.getInputStream();
		InputStream is4= image4.getInputStream();
		
		byte[] data1= new byte[is1.available()];
		byte[] data2= new byte[is2.available()];
		byte[] data3= new byte[is3.available()];
		byte[] data4= new byte[is4.available()];
		
		is1.read(data1);
		is2.read(data2);
		is3.read(data3);
		is4.read(data4);
		
		fos1.write(data1);
		fos2.write(data2);
		fos3.write(data3);
		fos4.write(data4);
		
		fos1.close();
		fos2.close();
		fos3.close();
		fos4.close();
		
		is1.close();
		is2.close();
		is3.close();
		is4.close();
		
		try {
			
			
			
			Product savedProduct = productRepository.save(product);
			
			if(savedProduct!=null) {
				session.setAttribute("messege", "Product added successfully");
				session.setAttribute("msg_type", "success");
			}else {
			session.setAttribute("messege", "Something went wrong");
				session.setAttribute("msg_type", "danger");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		
		
		
		return "redirect:/admin";
	}
	
	@RequestMapping(path = "/login")
	public String login(HttpServletRequest request) {
		
		return "login";
	}
	
	@RequestMapping(path = "/logout")
	public String logout(HttpServletRequest request) {
		HttpSession session= request.getSession();
		session.removeAttribute("current-user");
		return "redirect:/login";
	}

	@RequestMapping(path = "/register")
	public String register(HttpServletRequest request) {
		return "register";
	}

	@PostMapping("/process-register")
	public String processRegister(@ModelAttribute User user, HttpServletRequest request) {
		try {
			HttpSession session = request.getSession();
			user.setUser_type("normal");
			Cart cart=new Cart();
			
			user.setCart(cart);
			
			User save = userRepository.save(user);

			if (save.getUser_id() > 0) {
				session.setAttribute("messege",
						"Registration successfull, username: " + save.getUsername() + " You can login. Cart Id "+save.getCart().getCart_id()
						);
				session.setAttribute("msg_type","success");
			} else {
				session.setAttribute("messege", "Something went wrong");
				session.setAttribute("msg_type","danger");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return "redirect:/login";
	}

	@PostMapping("/login-process")
	public String processLogin(@Param("username") String username, @Param("password") String password,
			HttpServletRequest request) {
		
		HttpSession session= request.getSession();
		
		User user = userRepository.findByUsernameAndPassword(username, password);

		if (user == null) {
			session.setAttribute("messege", "Wrong Credentials, Try Again");
			session.setAttribute("msg_type","danger");
		} else if (user.getUser_type().equals("normal")) {
			session.setAttribute("current-user", user);
			return "redirect:/";

		} else if (user.getUser_type().equals("admin")) {
			session.setAttribute("current-user", user);
			return "redirect:admin";

		} else {
			session.setAttribute("messege", "Wrong Credentials, Try Again");
			session.setAttribute("msg_type","danger");
		}

		return "login";
	}
}
