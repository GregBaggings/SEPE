package com.cw.page.controllers;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cw.database.model.Car;
import com.cw.database.model.CarDAO;

@Controller
public class RemoveItemController {
	
	@RequestMapping(value = "/admin/removeCar", method = RequestMethod.GET)
	public ModelAndView removeCar() {
		return new ModelAndView("removeCar", "command", new Car());
	}

	@RequestMapping(value = "/admin/list_items_after_delete", method = RequestMethod.POST)
	public String removeCar(@ModelAttribute("SpringWeb") Car car, ModelMap model){

		@SuppressWarnings("resource")
		ApplicationContext context = 
	    		new ClassPathXmlApplicationContext("Spring-Module.xml");
	    	 
	        CarDAO carDAO = (CarDAO) context.getBean("carDAO");
		
		
		model.addAttribute("carID", car.getCarId());


		carDAO.deleteCar(car.getCarId());

		return "list_items";	
	}
}
