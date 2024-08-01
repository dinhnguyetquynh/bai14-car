package com.demo.car.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.demo.car.service.CarService;

@Controller
public class CarController {
	@Autowired
	private CarService carService;
	@GetMapping("/get-all-car")
	public ModelAndView getAllCar() {
		return new ModelAndView("home", "cars", carService.getAllCars());
	}
	@GetMapping("/get")
	public ModelAndView getAllCa() {
		return new ModelAndView("view");
	}
}
