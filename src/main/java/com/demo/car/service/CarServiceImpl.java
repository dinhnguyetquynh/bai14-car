package com.demo.car.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.car.dao.CarDao;
import com.demo.car.entity.Car;

@Service
public class CarServiceImpl implements CarService {
	@Autowired
	private CarDao carDao;

	@Override
	public List<Car> getAllCars() {
		return carDao.getAllCars();
	}

	@Override
	public void addCar(Car car) {
		carDao.addCar(car);
	}

	@Override
	public String deleteCar(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Car findCarById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Car updateCar(Car car) {
		// TODO Auto-generated method stub
		return null;
	}

}
