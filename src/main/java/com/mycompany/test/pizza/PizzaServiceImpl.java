package com.mycompany.test.pizza;

import com.mycompany.test.base.ro.ResultRO;
import com.mycompany.test.pizza.model.PizzaMenu;
import com.mycompany.test.pizza.ro.PizzaMenuRO;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Service("pizzaService")
public class PizzaServiceImpl implements PizzaService {
	
	protected Log log = LogFactory.getLog(getClass());

	@Autowired
	private PizzaHandler pizzaHandler;

	@Override
	public ResultRO getMenu(String name) {
		ResultRO resultRO = new ResultRO();
		try {
			List<PizzaMenu> menu = pizzaHandler.getPizzaMenu(name);
			List<PizzaMenuRO> menuRO = new ArrayList<PizzaMenuRO>();

			for(PizzaMenu pizzaMenu : menu) {
				menuRO.add((PizzaMenuRO) pizzaMenu.getRepresentation());
			}

			resultRO.setResult(menuRO);
		} catch(Exception e) {
			resultRO.setSuccess(false);
			resultRO.setError(e.getMessage());
		}
		return resultRO;
	}
}
