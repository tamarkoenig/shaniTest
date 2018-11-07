package com.mycompany.test.pizza;

import com.mycompany.test.pizza.model.PizzaMenu;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component(value = "pizzaHandler")
public class PizzaHandlerImpl implements PizzaHandler {
	
	protected Log log = LogFactory.getLog(getClass());

	@Autowired
	private PizzaDao pizzaDao;


	@Override
	@Transactional(readOnly = true)
	public List<PizzaMenu> getPizzaMenu(String name) {
		return pizzaDao.getPizzaMenus(name);
		//tostring?
	}
	
}
