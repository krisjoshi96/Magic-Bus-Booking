package com.revature.project2.model;


import java.sql.Date;
import java.sql.Time;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "buses")
@Data
@Builder(toBuilder = true)
@AllArgsConstructor()
@NoArgsConstructor()
@Setter()
@Getter
public class Bus {
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		private int id;
		private String busNo;
		private String fromCity;
		private String destinationCity;
		private String date;
		private String time;
		private int fare;
		private int userId;
	
		
		
		
		
	}