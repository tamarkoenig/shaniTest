package com.mycompany.test.pizza;

import com.mycompany.test.pizza.model.PizzaMenu;

import java.util.List;

public interface PizzaDao {

	//List<PizzaMenu> getPizzaMenus();
	List<PizzaMenu> getPizzaMenus(String name);


}
