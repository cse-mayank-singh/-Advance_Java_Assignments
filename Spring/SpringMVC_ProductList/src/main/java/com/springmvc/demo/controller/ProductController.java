package com.springmvc.demo.controller;
import java.util.ArrayList;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import com.springmvc.demo.model.Product;
import com.springmvc.demo.service.ProductService;
import org.springframework.ui.Model;
@Controller
public class ProductController {
	private ProductService productservice;
	public ProductController(ProductService productservice) {
		this.productservice=productservice;
	}
	@GetMapping("/products")
	public String showProduct(Model model) {
		ArrayList<Product> productList=productservice.fetchProducts();
		model.addAttribute("products",productList);
		return "products";
	}
}
