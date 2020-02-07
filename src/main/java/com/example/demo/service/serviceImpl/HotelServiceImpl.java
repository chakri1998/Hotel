package com.example.demo.service.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.entity.Dish;
import com.example.demo.entity.Hotel;

import com.example.demo.exception.DuplicateHotelNameException;
import com.example.demo.repository.DishRepository;
import com.example.demo.repository.HotelRepository;
import com.example.demo.service.HotelService;
@Service
public class HotelServiceImpl implements HotelService{

	@Autowired
	DishRepository dishRepo;
	
	@Autowired
	HotelRepository hotelRepo;

	@Override
	public Hotel insertHotelDataIntoDataBase(String hotelName, Hotel hotel) throws DuplicateHotelNameException {
		
		for(Hotel hotel1 : hotelRepo.findAll()) {
			if(hotel1.getHotelName().equalsIgnoreCase(hotel.getHotelName())) {
				throw new DuplicateHotelNameException("Hotel name already exists");
			}
		}
		return hotelRepo.save(hotel);
	
		
	}

	@Override
	public List<Hotel> getAllHotelFromDatabase() {
		
		return hotelRepo.findAll();
	}

	@Override
	public String assignDishToHotel(int hotelId, int dishId) {
		
		int count=0;
		double averageRating=0.0;
		Hotel hotel = hotelRepo.findById(hotelId).get();
		Dish dish = dishRepo.findById(dishId).get();
		
		List<Dish> dish1 = hotel.getDish();
		dish1.add(dish);
		double totalRating = 0;
		for(Dish dishh :dish1) {
		totalRating = totalRating + dishh.getRating();
		count++;
		
		}
		averageRating=totalRating/count;
		hotel.setAverageRating(averageRating);
		hotelRepo.save(hotel);
		dish.setHotel(hotel);
		dishRepo.save(dish);

		return "added";
	}

	@Override
	public List<Hotel> getHotelDetails() {
		List<Hotel> hotel = new ArrayList<Hotel>();
		hotel = hotelRepo.findAll();

		return hotel;
	}	
	
	
}
