package com.revature.project2.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.project2.model.Bus;
import com.revature.project2.service.BusService;

@RestController
@CrossOrigin(origins="*")
public class BusController {
	@Autowired
	BusService busService;
	
	
	@GetMapping("/buses")
	public List<Bus> findall(){
		return busService.findAll();
	}
	
	@GetMapping("/busesById/{userId}")
	public List<Bus> findByUserId(@PathVariable int userId){
		return busService.findByUserId(userId);
	}
	
	@GetMapping("/busesByBusNumber/{number}")
	public List<Bus> findByBusNo(@PathVariable String number) {
		return busService.findByBusNo(number);
	}

	@GetMapping("/buses/{id}")
	public Bus findById(@PathVariable int id) {
		return busService.findById(id);
	}

	@PostMapping("/buses")
	public void save(@RequestBody Bus bus) {
		busService.save(bus);

	}

//	@PostMapping("/users/bulk")
//	public void save(@RequestBody User[] users) {
//		for (User user : users) {
//			userService.save(user);
//		}
//	}

	@PutMapping("/buses/{id}")
	public void update(@PathVariable int id, @RequestBody Bus bus) {
		busService.save(bus);

	}

	@DeleteMapping("/buses/{id}")
	public void delete(@PathVariable int id) {
		busService.delete(id);

	}

}