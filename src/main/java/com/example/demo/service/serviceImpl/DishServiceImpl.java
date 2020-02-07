package com.example.demo.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Dish;

import com.example.demo.exception.DuplicateDishNameException;
import com.example.demo.exception.IdDoesNotException;
import com.example.demo.repository.DishRepository;
import com.example.demo.repository.HotelRepository;
import com.example.demo.service.DishService;
@Service
public class DishServiceImpl implements DishService{
	
	@Autowired
	DishRepository dishRepo;
	
	@Autowired
	HotelRepository hotelRepo;

	@Override
	public Dish insertDishDataIntoDataBase(String dishName, Dish dish) throws DuplicateDishNameException {
			for(Dish dish1 : dishRepo.findAll()) {
				if(dish1.getDishName().equalsIgnoreCase(dish.getDishName())) {
					throw new DuplicateDishNameException("Dish Name already exists");
				}
				}
			return dishRepo.save(dish);

	}
	@Override
	public List<Dish> getAllDishFromDatabase() {
		
		return dishRepo.findAll();
	}

	@Override
	public void deleteDishDataIntoDataBase(int dishId, Dish dish) throws IdDoesNotException {
		if(dishRepo.existsById(dishId)) {
			dishRepo.deleteById(dishId);
			}
			else { 
				throw new IdDoesNotException("invalid id name");
			}
		}

	
	@Override
	public Dish updateDetails(Dish dishh, int rating, int dishPrice, int dishId) {
		 dishRepo.findById(dishId).get();
		dishh.setRating(rating);
		dishh.setDishPrice(dishPrice);
		 return dishRepo.saveAndFlush(dishh);
		
	}
	
	
		
	}
	
	
	


