package com.cw.page.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cw.database.cars.Car;
import com.cw.database.cars.CarDAO;

@Controller
public class AddItemController {

	@Autowired
	CarDAO carDAO;

	@RequestMapping(value = "/admin/addCar", method = RequestMethod.GET)
	public ModelAndView addCar() {
		return new ModelAndView("addCar", "command", new Car());
	}

	@ModelAttribute(value = "list_cars")
	public List<Car> getCarList() {
		return carDAO.findAll();

	}

	@RequestMapping(value = "/admin/list_items", method = RequestMethod.POST)
	public String addCar(@ModelAttribute("SpringWeb") Car car, ModelMap model) {

		carDAO.saveNewCar(car);
		// model.addAttribute("list", carDAO.findAll());

		return "list_items";

	}
}
