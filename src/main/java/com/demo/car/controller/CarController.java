package com.demo.car.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.demo.car.entity.Car;
import com.demo.car.service.CarService;


@Controller
public class CarController {

	@Autowired
	private CarService carService;

	private static final String UPLOAD_DIRECTORY = "/resources/images";

	@GetMapping("/get-all-car")
	public ModelAndView getAllCar() {
		return new ModelAndView("home", "cars", carService.getAllCars());
	}

	@GetMapping("/form-add")
	public ModelAndView formAd(Car car) {
		return new ModelAndView("add-car", "command", new Car());
	}

	@RequestMapping(value = "savefile", method = RequestMethod.POST)
	public ModelAndView saveImage(@RequestParam("file") CommonsMultipartFile file, HttpSession session,
			@ModelAttribute("car") Car car) throws Exception {
		ServletContext context = session.getServletContext();
		String path = context.getRealPath(UPLOAD_DIRECTORY);
		String filename = file.getOriginalFilename();

		System.out.println("Upload path: " + path + File.separator + filename);

		File uploadDir = new File(path);
		if (!uploadDir.exists()) {
			uploadDir.mkdirs(); // Tạo thư mục nếu chưa tồn tại
		}

		byte[] bytes = file.getBytes();
		BufferedOutputStream stream = new BufferedOutputStream(
				new FileOutputStream(new File(path + File.separator + filename)));
		stream.write(bytes);
		stream.flush();
		stream.close();
		// Lưu đường dẫn vào thuộc tính imgURL của Car
		car.setImgURL(UPLOAD_DIRECTORY + "/" + filename);
		carService.addCar(car);
		return new ModelAndView("redirect:/get-all-car", "filesuccess", "File successfully saved!");
	}
	
	@GetMapping("/delete-car")
	public String deleteCar(@RequestParam("carId") int carId) {
		carService.deleteCar(carId);
		return "redirect:/get-all-car";
		
	}
	
	@GetMapping("/form-update-car")
	public ModelAndView formUpdate(@RequestParam("carId") int id) {
		return new ModelAndView("update-car", "command",carService.findCarById(id));
	}
	@RequestMapping(value = "update-car", method = RequestMethod.POST)
	public ModelAndView updateImage(@RequestParam("file") CommonsMultipartFile file, HttpSession session,
			@ModelAttribute("car") Car car) throws Exception {
		ServletContext context = session.getServletContext();
		String path = context.getRealPath(UPLOAD_DIRECTORY);
		String filename = file.getOriginalFilename();

		System.out.println("Upload path: " + path + File.separator + filename);

		File uploadDir = new File(path);
		if (!uploadDir.exists()) {
			uploadDir.mkdirs(); // Tạo thư mục nếu chưa tồn tại
		}

		byte[] bytes = file.getBytes();
		BufferedOutputStream stream = new BufferedOutputStream(
				new FileOutputStream(new File(path + File.separator + filename)));
		stream.write(bytes);
		stream.flush();
		stream.close();
		// Lưu đường dẫn vào thuộc tính imgURL của Car
		car.setImgURL(UPLOAD_DIRECTORY + "/" + filename);
		carService.updateCar(car);
		return new ModelAndView("redirect:/get-all-car", "filesuccess", "File successfully saved!");
	}
}
