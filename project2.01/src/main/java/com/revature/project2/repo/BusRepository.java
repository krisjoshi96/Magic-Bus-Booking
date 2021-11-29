package com.revature.project2.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.project2.model.Bus;


public interface BusRepository extends JpaRepository<Bus, Integer>{
	public List<Bus> findByBusNo(String busNo);
	
	public List<Bus> findByUserId(int userId);
}