package com.example.demo.handler;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.demo.exception.HotelApplicationException;



@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler
	public String DuplicateHotelNameException(HotelApplicationException h, Model model) {
		Map<String, Object> response = new HashMap<String, Object>();
		response.put("message", h.getMessage());
		response.put("httpStatus", HttpStatus.BAD_REQUEST);
		response.put("timestamp", new Date());
		model.addAttribute("error", response);
		return "error";
	}
	public String IdDoesNotException(HotelApplicationException h, Model model) {
		Map<String, Object> response = new HashMap<String, Object>();
		response.put("message", h.getMessage());
		response.put("httpStatus", HttpStatus.BAD_REQUEST);
		response.put("timestamp", new Date());
		model.addAttribute("error", response);
		return "error";

}
	public String DuplicateUserNameException(HotelApplicationException e, Model model) {
		Map<String, Object> response = new HashMap<String, Object>();
		response.put("message", e.getMessage());
		response.put("httpStatus", HttpStatus.BAD_REQUEST);
		response.put("timestamp", new Date());
		model.addAttribute("error", response);
		return "error";
	}

}


