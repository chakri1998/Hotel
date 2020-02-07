package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import com.example.demo.entity.Dish;
import com.example.demo.entity.Hotel;
import com.example.demo.exception.DuplicateDishNameException;
import com.example.demo.exception.DuplicateHotelNameException;
import com.example.demo.exception.HotelApplicationException;
import com.example.demo.exception.IdDoesNotException;
import com.example.demo.service.DishService;
import com.example.demo.service.HotelService;

@Controller
public class AppController {

	
	@Autowired
	DishService dishService;
	Dish dishh = new Dish();
	
	@Autowired
	HotelService hotelService;
	
	@GetMapping("/home")
	public String index() {
		return "index";
	}
/*	
    @RequestMapping("/")
    public String login() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        System.out.println(auth.getPrincipal());
        return "/index";
    }
    
    @RequestMapping("/callback")
    public String callback() {
        System.out.println("redirecting to home page");
        return "/menu";
    }
*/
	
	
	@GetMapping("/form")
	public String index1() {
		return "hotel";
	}
	@PostMapping("/addHotel")
	public String addHotelDetails(@RequestParam("hotelName") String hotelName,@ModelAttribute("hotel") Hotel hotel) throws HotelApplicationException  {

		hotelService.insertHotelDataIntoDataBase(hotelName,hotel);
		
		return "index";
	}
	
	@GetMapping("/form1")
	public String index2() {
		return "dish";
	}
	
	@PostMapping("/addDish")
	public String addDishDetails(@RequestParam("dishName") String dishName,@ModelAttribute("dish") Dish dish) throws HotelApplicationException  {

		dishService.insertDishDataIntoDataBase(dishName,dish);
	
		return "index";
	}
	@GetMapping("/form2")
	public String index3(Model model) {
		List<Hotel> hotel = hotelService.getAllHotelFromDatabase();
		List<Dish> dish = dishService.getAllDishFromDatabase();
		model.addAttribute("Hotel", hotel);
		model.addAttribute("Dish", dish);
		return "hotelDish";
	}
	
	@PostMapping("/assignDishToHotel")
	public String assignDishToHotel(@RequestParam("hotelId") int hotelId, @RequestParam("dishId") int dishId,
			Model model) {

		model.addAttribute("message", hotelService.assignDishToHotel(hotelId, dishId));
		
		return "message";
	}
	
	@GetMapping("/form4")
	public String index4() {
		return "delete";
	}
	@RequestMapping("/deleteDish")
	public String deleteUser(@RequestParam("dishId") int dishId,@ModelAttribute("dish") Dish dish) throws HotelApplicationException  {

		dishService.deleteDishDataIntoDataBase(dishId,dish);
		//System.out.println(bankName);
		return "index";
	}
	@GetMapping("/form3")
	public String index5() {
		return "update";
	}
	
	@RequestMapping("/updatedishName")
	public String updateDetails(Model model, @PathVariable int dishId,@RequestParam("rating") int rating,@RequestParam("dishPrice") int dishPrice) {
		Dish dish = dishService.updateDetails(dishh, rating,dishPrice,dishId);
		List<Dish> dish1 = dishService.getAllDishFromDatabase();
		model.addAttribute("dish1", dish1);
		return "index";
	}
	@GetMapping("/getdata")
	public String getBankDetails(Model model) {
		List<Hotel> hotel = hotelService.getHotelDetails();
		
		model.addAttribute("hotel", hotel);
	    
		return "view";

	}
}
