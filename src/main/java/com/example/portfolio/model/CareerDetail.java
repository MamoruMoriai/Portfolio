package com.example.portfolio.model;
import java.util.Date;

import lombok.Data;

@Data
public class CareerDetail {

	private Integer id;
	private Boolean externalFlg;
	private Date fromDate;
	private Date toDate;
	private String title;
	private String content;
	
}
