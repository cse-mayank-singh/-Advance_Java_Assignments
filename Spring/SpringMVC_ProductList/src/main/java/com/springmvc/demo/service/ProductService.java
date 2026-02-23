package com.springmvc.demo.service;

import org.springframework.stereotype.Service;

import com.springmvc.demo.dao.ProductDAO;
import com.springmvc.demo.model.Product;

import java.util.ArrayList;
@Service
public class ProductService {
	private ProductDAO productdao;
	public ProductService(ProductDAO productdao){
		this.productdao=productdao;
	}
	public ArrayList<Product> fetchProducts(){
		return productdao.method();
	}
}
