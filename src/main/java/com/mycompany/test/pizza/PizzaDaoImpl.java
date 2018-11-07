package com.mycompany.test.pizza;

import com.mycompany.test.base.BaseDaoImpl;
import com.mycompany.test.pizza.model.PizzaMenu;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PizzaDaoImpl extends BaseDaoImpl implements PizzaDao {


	@Override
	public List<PizzaMenu> getPizzaMenus(String name) {
		//return sessionFactory.getCurrentSession().createCriteria(PizzaMenu.class).list();
		
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(PizzaMenu.class).add(Restrictions.like("name", "%"+name+"%"));
		
		return (List<PizzaMenu>) criteria.list();
		
		
	}
}
