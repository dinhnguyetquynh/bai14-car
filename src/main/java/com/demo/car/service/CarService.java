package com.demo.car.service;

import java.util.List;

import com.demo.car.entity.Car;

public interface CarService {
	public List<Car> getAllCars();
	public void addCar(Car car);
	public void deleteCar(int id);
	public Car findCarById(int id);
	public void updateCar(Car car);
	
}
