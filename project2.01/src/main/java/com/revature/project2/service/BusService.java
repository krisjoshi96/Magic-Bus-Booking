package com.revature.project2.service;

import java.util.List;

import com.revature.project2.model.Bus;

public interface BusService {
	
	public List<Bus> findAll();

	public List<Bus> findByBusNo(String busNo);
	
	public List<Bus> findByUserId(int userId);

	public Bus findById(int id);

	public void save(Bus bus);

	public void update(int id, Bus bus);

	public void delete(int id);

}