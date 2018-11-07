package com.mycompany.test.pizza.ro;

import com.mycompany.test.base.ro.BaseUpdatableRO;

/**
 * Created by Shani on 18/04/2017.
 */
public class PizzaMenuRO extends BaseUpdatableRO {
	private static final long serialVersionUID = 1L;

	private String name;

	private double price;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
}
