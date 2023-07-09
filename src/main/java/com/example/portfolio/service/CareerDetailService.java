package com.example.portfolio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.portfolio.entity.CareerDetailEntity;
import com.example.portfolio.mapper.CareerDetailMapper;

@Service
public class CareerDetailService {

	@Autowired
	private CareerDetailMapper careerDetailMapper;
	
	public List<CareerDetailEntity> findAll() {
		return careerDetailMapper.findAll();
	}
	
	public CareerDetailEntity search(int id) {
		return careerDetailMapper.search(id);
	}
	
	public void createCareerDetail(CareerDetailEntity cde) {
		careerDetailMapper.createCareerDetail(cde);
	}
	
	public void updateCareerDetail(CareerDetailEntity cde) {
		careerDetailMapper.updateCareerDetail(cde);
	}
	
	public void deleteCareerDetail(int id) {
		careerDetailMapper.deleteCareerDetail(id);
	}
	
}
