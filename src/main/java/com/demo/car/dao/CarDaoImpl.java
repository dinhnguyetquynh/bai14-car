package com.demo.car.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.demo.car.entity.Car;
@Repository
public class CarDaoImpl implements CarDao{
	@Autowired
	private SessionFactory factory;
	@Transactional
	@Override
	public List<Car> getAllCars() {
		Session session = factory.getCurrentSession();
		Query<Car> query = session.createQuery("from Car", Car.class);
		return query.getResultList();
	}

	@Override
	public Car addCar(Car car) {
		// TODO Auto-generated method stub
		return null;
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
