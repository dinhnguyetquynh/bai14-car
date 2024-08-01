package com.demo.car.service;

import java.util.List;

import com.demo.car.entity.Car;

public interface CarService {
	public List<Car> getAllCars();
	public Car addCar(Car car);
	public String deleteCar(int id);
	public Car findCarById(int id);
	public Car updateCar(Car car);
}
