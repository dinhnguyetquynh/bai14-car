package com.demo.car.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.demo.car.entity.Car;
@Repository
public interface CarDao {
	public List<Car> getAllCars();
	public Car addCar(Car car);
	public String deleteCar(int id);
	public Car findCarById(int id);
	public Car updateCar(Car car);
}
