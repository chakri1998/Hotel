package com.example.demo.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Hotel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int hotelId;
	
	private String hotelName;
	
	private double averageRating;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "hotel")
	 private List<Dish> dish;

	public Hotel() {
		super();
	}

	public Hotel(int hotelId, String hotelName, double averageRating, List<Dish> dish) {
		super();
		this.hotelId = hotelId;
		this.hotelName = hotelName;
		this.averageRating = averageRating;
		this.dish = dish;
	}

	public int getHotelId() {
		return hotelId;
	}

	public void setHotelId(int hotelId) {
		this.hotelId = hotelId;
	}

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public double getAverageRating() {
		return averageRating;
	}

	public void setAverageRating(double averageRating) {
		this.averageRating = averageRating;
	}

	public List<Dish> getDish() {
		return dish;
	}

	public void setDish(List<Dish> dish) {
		this.dish = dish;
	}

	
	
	
}
