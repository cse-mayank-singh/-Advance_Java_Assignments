package com.springmvc.demo.dao;

import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.springmvc.demo.model.Product;
@Repository
public class ProductDAO {
	public ArrayList<Product> method() {
	Product product1=new Product(1,"Laptop",75000);
	Product product2=new Product(1,"Desktop",100000);
	Product product3=new Product(1,"Console",50000);
	ArrayList<Product> arr=new ArrayList<>();
	arr.add(product1);arr.add(product2);arr.add(product3);
	return arr;
	}
}
