package com.example.portfolio.entity;
import java.util.Date;

import lombok.Data;

@Data
public class CareerDetailEntity {

	private Integer id;
	private Boolean externalFlg;
	private Date fromDate;
	private Date toDate;
	private String title;
	private String content;
	
}