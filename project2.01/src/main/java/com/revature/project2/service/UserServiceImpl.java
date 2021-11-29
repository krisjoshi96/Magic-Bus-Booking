package com.revature.project2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.project2.model.User;
import com.revature.project2.repo.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserRepository userRepository;
	
	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

	@Override
	public User findByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	@Override
	public User findById(int id) {
		return userRepository.findById(id).get();
	}

	@Override
	public void save(User user) {
		userRepository.save(user);

	}

	@Override
	public void update(int id, User user) {
		userRepository.save(user);

	}

	@Override
	public void delete(int id) {
		userRepository.deleteById(id);

	}


}
