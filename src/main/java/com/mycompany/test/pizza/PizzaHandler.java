package com.mycompany.test.pizza;

import java.util.List;

import com.mycompany.test.pizza.model.PizzaMenu;
import eu.bitwalker.useragentutils.BrowserType;
import eu.bitwalker.useragentutils.DeviceType;
import eu.bitwalker.useragentutils.OperatingSystem;

public interface PizzaHandler {

	//List<PizzaMenu> getPizzaMenu();
	List<PizzaMenu> getPizzaMenu(String name);
	
}
