package com.example.portfolio.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.portfolio.entity.CareerDetailEntity;

@Mapper
public interface CareerDetailMapper {
	
	List<CareerDetailEntity> findAll();
	
	CareerDetailEntity search(int id);
	
	void createCareerDetail(CareerDetailEntity careerDetail);
	
	void updateCareerDetail(CareerDetailEntity careerDetail);
	
	void deleteCareerDetail(int id);
	
}
