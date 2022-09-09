package com.surajanbhule;

import java.util.List;

import com.surajanbhule.entities.Product;

public class Helper {
	
	public  String getShortString(String s) {
		if(s.length()<40)
			return s;
		else
			return s.substring(0,20);
	}
	
	public boolean inCart(List<Product> pList,Product product) {
		System.out.println("Inside in cart");
		for(Product p:pList) {
			
			if(p.getProduct_id()==product.getProduct_id()) {
				return true;
			}
		}
		
		return false;
	}
}
