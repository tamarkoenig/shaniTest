package com.mycompany.test.controller;

import com.mycompany.test.base.ro.ResultRO;
import com.mycompany.test.pizza.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Controller for work with REST Trade service.
 */
@Controller
public class PizzaController {

	@Autowired
	private PizzaService routerService;
	
	@RequestMapping(value = "/pizza/menu", method = RequestMethod.GET)
	@ResponseBody
	public ResultRO getMenu(HttpServletRequest request, HttpServletResponse response) {
		//return routerService.getMenu();

		String name = request.getParameter("name");
		//System.out.println(name);
		return routerService.getMenu(name);
	}

	//TODO: Add get menu search by name

}
