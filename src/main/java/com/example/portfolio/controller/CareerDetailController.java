package com.example.portfolio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.portfolio.entity.CareerDetailEntity;
import com.example.portfolio.service.CareerDetailService;


@RestController
public class CareerDetailController {
	
	@Autowired
	CareerDetailService careerDetailService;
	
	@GetMapping(value = "/test")
	public List<CareerDetailEntity> getAllCareerDetail() {
		List<CareerDetailEntity> careerDetailList = careerDetailService.findAll();
		return careerDetailList;
	}
	
	@PostMapping(value = "/test")
	public CareerDetailEntity getSelectCareerDetail(@RequestParam("id") int id) {
		CareerDetailEntity careerDetail = careerDetailService.search(id);
		return careerDetail;
	}
	
	

}
