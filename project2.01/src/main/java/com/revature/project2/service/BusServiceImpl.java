package com.revature.project2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.project2.model.Bus;
import com.revature.project2.repo.BusRepository;
@Service
public class BusServiceImpl implements BusService {
	@Autowired
	BusRepository busRepository;
	
	@Override
	public List<Bus> findAll() {
		// TODO Auto-generated method stub
		return busRepository.findAll();
	}

	@Override
	public List<Bus> findByBusNo(String busNo) {
		return busRepository.findByBusNo(busNo);
	}

	@Override
	public Bus findById(int id) {
		return busRepository.findById(id).get();
	}

	@Override
	public void save(Bus bus) {
		busRepository.save(bus);

	}

	@Override
	public void update(int id, Bus bus) {
		busRepository.save(bus);

	}

	@Override
	public void delete(int id) {
		busRepository.deleteById(id);

	}

	@Override
	public List<Bus> findByUserId(int userId) {
		// TODO Auto-generated method stub
		return busRepository.findByUserId(userId);
	}

}