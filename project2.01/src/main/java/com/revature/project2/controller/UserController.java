package com.revature.project2.controller;

import java.util.List;
import java.util.Objects;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.revature.project2.model.User;
import com.revature.project2.service.UserService;

@RestController
@CrossOrigin(origins="*")
public class UserController {
	@Autowired
	UserService userService;
	
	private static Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@PostMapping("/login")
	public User verifyUser (@RequestBody String payload){
		//Gson g=new Gson();
		//JsonObject convertedObject = new Gson().fromJson(g.toJson(payload), JsonObject.class);
		JSONParser parser = new JSONParser();  
		
		
		try {
			JSONObject json = (JSONObject) parser.parse(payload);
			String email=(String) json.get("username");
			String password=(String) json.get("password");
			logger.info( email);
			logger.info( (String) json.get("password"));
			User user= userService.findByEmail(email);
			logger.info(user.getPassword());
			logger.info(user.toString());
			if(user.getPassword().equals(password)) {
				logger.info("It Worked");
				return user;
			}
			else {
				logger.info("Password doesn't match");
				return null;
			}
			
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		
		
		return null;
	
	}
	
	
	@GetMapping("/users")
	public List<User> findall(){
		return userService.findAll();
	}
	
	
	@GetMapping("/usersByEmail/{email}")
	public User findByEmail(@PathVariable String email) {
		return userService.findByEmail(email);
	}

	@GetMapping("/users/{id}")
	public User findById(@PathVariable int id) {
		return userService.findById(id);
	}

	@PostMapping("/users")
	public void save(@RequestBody User user) {
		userService.save(user);

	}

	@PostMapping("/users/bulk")
	public void save(@RequestBody User[] users) {
		for (User user : users) {
			userService.save(user);
		}
	}

	@PutMapping("/users/{id}")
	public void update(@PathVariable int id, @RequestBody User user) {
		userService.save(user);

	}

	@DeleteMapping("/users/{id}")
	public void delete(@PathVariable int id) {
		userService.delete(id);

	}

}
