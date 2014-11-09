package com.example.model;

import java.util.ArrayList;
import java.util.List;

public class BeerExpert {
	public List<String> getBrands(String color) {
		List<String> brands = new ArrayList<>();
		if ("amber".equals(color)) {
			brands.add("Jack Amber");
			brands.add("Red Moose");
		} else {
			brands.add("Jall Pale Ale");
			brands.add("Gout Stout");
		}
		return brands;
	}
}
