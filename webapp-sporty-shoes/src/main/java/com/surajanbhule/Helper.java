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
	
	public String isProductAdded(List<Product> products,long cart_product_id) {
		if(products==null) {
			System.out.println("List is null");
			return "";
		}
		for(Product p:products) {
			if(cart_product_id==p.getProduct_id()) 
				System.out.println("inside it: "+cart_product_id);
				return "disabled";
		}
		
		return "";	
		
	}
}
