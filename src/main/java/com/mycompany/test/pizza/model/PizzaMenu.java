package com.mycompany.test.pizza.model;

import com.mycompany.test.base.BaseUpdatebleEntity;
import com.mycompany.test.base.ro.BaseRO;
import com.mycompany.test.pizza.ro.PizzaMenuRO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "pizza_menu")
public class PizzaMenu extends BaseUpdatebleEntity {
	
	private static final long serialVersionUID = 1L;

	// ------------------------ Constants -----------------------
	// ------------------------ Fields --------------------------
	private String name;
	
	private double price;
	
	public PizzaMenu() {
	}
	
	@Column(name = "name", nullable = false)
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "price", nullable = false)
	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	@SuppressWarnings("unchecked")
	protected <T extends BaseRO> T newRepresentation() {
		PizzaMenuRO ro = new PizzaMenuRO();
		ro.setId(getId());
		ro.setLastUpdateTime(getLastUpdateTime().getTime());
		ro.setCreationTime(getCreationTime().getTime());
		ro.setName(getName());
		ro.setPrice(getPrice());
		return (T) ro;
	}

	// ------------------------ Private methods -----------------
}
