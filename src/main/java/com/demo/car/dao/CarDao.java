package com.demo.car.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.demo.car.entity.Car;
@Repository
public interface CarDao {
	public List<Car> getAllCars();
	public void addCar(Car car);
	public void deleteCar(int id);
	public Car findCarById(int id);
	public void updateCar(Car car);
	
}
