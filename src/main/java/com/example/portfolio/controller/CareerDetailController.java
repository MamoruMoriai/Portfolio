package com.example.portfolio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	public CareerDetailEntity getSelectCareerDetail(@PathVariable("id") int id) {
		CareerDetailEntity careerDetail = careerDetailService.search(id);
		return careerDetail;
	}
	
	@PutMapping(value = "/test")
	public void updateCareerDetail(@RequestBody CareerDetailEntity cde) {
		careerDetailService.updateCareerDetail(cde);
	}
	
	@DeleteMapping(value = "/test")
	public void deleteCareerDetail(@PathVariable("id") int id) {
		careerDetailService.deleteCareerDetail(id);
	}
	
	

}
