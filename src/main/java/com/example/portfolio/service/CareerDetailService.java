package com.example.portfolio.service;

import java.text.SimpleDateFormat;
import java.util.Date;
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
		List<CareerDetailEntity> cdeList = careerDetailMapper.findAll();
		for(CareerDetailEntity cde : cdeList) {
			cde.setFromDateString(convertDateToString(cde.getFromDate()));
			cde.setToDateString(convertDateToString(cde.getToDate()));
		}
		return cdeList;
	}
	
	public CareerDetailEntity search(int id) {
		CareerDetailEntity cde = careerDetailMapper.search(id);
		cde.setFromDateString(convertDateToString(cde.getFromDate()));
		cde.setToDateString(convertDateToString(cde.getToDate()));
		return cde;
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
	
	// Date型をString型に変換
	public String convertDateToString(Date target) {
		if (target != null) {
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
            return formatter.format(target);
        }
        return null;
	}
	
}
