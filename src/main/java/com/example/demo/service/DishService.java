package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Dish;
import com.example.demo.exception.DuplicateDishNameException;
import com.example.demo.exception.IdDoesNotException;

public interface DishService {

	public Dish insertDishDataIntoDataBase(String dishName, Dish dish) throws DuplicateDishNameException;

	public List<Dish> getAllDishFromDatabase();

	public void deleteDishDataIntoDataBase(int dishId, Dish dish) throws IdDoesNotException;

	public Dish updateDetails(Dish dishh, int rating, int dishPrice, int dishId);

}
