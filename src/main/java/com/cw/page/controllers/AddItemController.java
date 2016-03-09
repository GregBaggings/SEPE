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
public class AddItemController {
	
	@RequestMapping(value = "/admin/addCar", method = RequestMethod.GET)
	public ModelAndView addCar() {
		return new ModelAndView("addCar", "command", new Car());
	}

	@RequestMapping(value = "/admin/list_items", method = RequestMethod.POST)
	public String addCar(@ModelAttribute("SpringWeb") Car car, ModelMap model){

		@SuppressWarnings("resource")
		ApplicationContext context = 
	    		new ClassPathXmlApplicationContext("Spring-Module.xml");
	    	 
	        CarDAO carDAO = (CarDAO) context.getBean("carDAO");
		
		
		model.addAttribute("carID", car.getCarId());
		model.addAttribute("name", car.getName());
		model.addAttribute("age", car.getAge());
		model.addAttribute("price", car.getPrice());

		carDAO.saveNewCar(car);

		return "list_items";
		
	}
}
