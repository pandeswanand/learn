package com.cg.collection;
import java.util.Comparator;

public class PriceComparator implements Comparator<Product<Long,Double>>{

	@Override
	public int compare(Product<Long, Double> p1, Product<Long, Double> p2) {
		// TODO Auto-generated method stub
		
		return p1.productName.compareTo(p2.productName);
	}
}