package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Hotel;
import com.example.demo.exception.DuplicateHotelNameException;

public interface HotelService {

	public Hotel insertHotelDataIntoDataBase(String hotelName, Hotel hotel) throws DuplicateHotelNameException;

	public List<Hotel> getAllHotelFromDatabase();

	public String assignDishToHotel(int hotelId, int dishId);

	public List<Hotel> getHotelDetails();

}
