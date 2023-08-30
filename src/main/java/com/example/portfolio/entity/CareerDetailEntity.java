package com.example.portfolio.entity;

import java.util.Date;

import lombok.Data;

@Data
public class CareerDetailEntity {

	// テーブルカラム
	private Integer id;
	private boolean externalFlg;
	private Date fromDate;
	private Date toDate;
	private String title;
	private String content;
	
	// 表示用
	private String fromDateString;
	private String toDateString;
	
}