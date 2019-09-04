package com.cg.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class App {

	public static void main(String args[]) {
		Product<Long, Double> prodOne = new Product(1, "pen", 15);
		Product<Long, Double> prodTwo = new Product(2, "pencil", 10);
		Product<Long, Double> prodThree = new Product(3, "eraser", 5);
		Product<Long, Double> prodFour = new Product(4, "scale", 20);
		
		List<Product<Long, Double>> mylist = new ArrayList<Product<Long, Double>>();
		mylist.add(prodOne);
		mylist.add(prodTwo);
		mylist.add(prodThree);
		mylist.add(prodFour);
		
		PriceComparator pc = new PriceComparator();
		Collections.sort(mylist, pc);
		for (Product<Long, Double> product : mylist) {
			System.out.println(product.getProductPrice());
		}
	}
	
}
