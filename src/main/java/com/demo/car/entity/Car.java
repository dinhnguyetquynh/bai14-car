package com.demo.car.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Car {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int carId;
	private String name;
	private double price;
	private int modelYear;
	private String carDes;
	private String imgURL;
	public Car() {
		// TODO Auto-generated constructor stub
	}
	public int getCarId() {
		return carId;
	}
	public void setCarId(int carId) {
		this.carId = carId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getModelYear() {
		return modelYear;
	}
	public void setModelYear(int modelYear) {
		this.modelYear = modelYear;
	}
	public String getCarDes() {
		return carDes;
	}
	public void setCarDes(String carDes) {
		this.carDes = carDes;
	}
	public String getImgURL() {
		return imgURL;
	}
	public void setImgURL(String imgURL) {
		this.imgURL = imgURL;
	}
	public Car(int carId, String name, double price, int modelYear, String carDes, String imgURL) {
		super();
		this.carId = carId;
		this.name = name;
		this.price = price;
		this.modelYear = modelYear;
		this.carDes = carDes;
		this.imgURL = imgURL;
	}
	@Override
	public String toString() {
		return "Car [carId=" + carId + ", name=" + name + ", price=" + price + ", modelYear=" + modelYear + ", carDes="
				+ carDes + ", imgURL=" + imgURL + "]";
	}
}
