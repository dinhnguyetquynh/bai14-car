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
	@Transactional
	@Override
	public void addCar(Car car) {
		Session session = factory.getCurrentSession();
		session.saveOrUpdate(car);
	}

	@Override
	@Transactional
	public void deleteCar(int id) {
		Session session = factory.getCurrentSession();
		Query<Car> query = session.createQuery("delete from Car where carId=:id");
		query.setParameter("id", id);
		query.executeUpdate();
	}

	@Override
	@Transactional
	public Car findCarById(int id) {
		return factory.getCurrentSession().get(Car.class, id);
	}
	@Override
	@Transactional
	public void updateCar(Car car) {
		Session session = factory.getCurrentSession();
		Query<Car> query = session.createQuery("update Car set name=:name,price=:price,modelYear=:modelYear,carDes=:carDes,imgURL=:imgURL");
		query.setParameter("name", car.getName());
		query.setParameter("price", car.getPrice());
		query.setParameter("modelYear", car.getModelYear());
		query.setParameter("carDes", car.getCarDes());
		query.setParameter("imgURL", car.getImgURL());
		query.executeUpdate();
		
	}
	
	


}
