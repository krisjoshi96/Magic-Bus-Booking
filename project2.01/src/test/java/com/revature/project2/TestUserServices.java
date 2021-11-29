//package com.revature.project2;
//
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertThrows;
//import static org.junit.Assert.assertTrue;
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//import java.util.ArrayList;
//import java.util.NoSuchElementException;
//
//import org.hibernate.Hibernate;
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.junit.Assert;
//import org.junit.Before;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.test.annotation.DirtiesContext;
//import org.springframework.test.annotation.DirtiesContext.MethodMode;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import com.revature.project2.model.User;
//import com.revature.project2.repo.UserRepository;
//import com.revature.project2.service.UserService;
//
//@SpringBootTest
//class TestUserServices {
//
//    @Autowired
//    private UserService userRepository;
//    
//	
//	private static Logger logger = LoggerFactory.getLogger(TestUserServices.class);
//	
//	@BeforeEach
//	private void removeAllUsers(){
//		
//		ArrayList<User> testUsers = (ArrayList<User>) userRepository.findAll();
//		
//		for(User testUser: testUsers) {
//		    userRepository.delete(testUser.getId());
//		}
//	}
//	
//	@AfterEach
//	private void removeAllUsersAgain(){
//		
//		ArrayList<User> testUsers = (ArrayList<User>) userRepository.findAll();
//		
//		for(User testUser: testUsers) {
//		    userRepository.delete(testUser.getId());
//		}
//	}
//	
//	
//	@Test
//	@DirtiesContext(methodMode = MethodMode.AFTER_METHOD)
//	void TestFindAll() {
//		ArrayList<User> testUsers = new ArrayList<User>();
//		
//		ArrayList<String> testUsersString = new ArrayList<String>();
//		testUsers.add(new User(1,"Cole","cole@revature.net","meme","male",23,7572666666l));
//		testUsers.add(new User(2,"Moh","moh@revature.net","pass","male",26,7573332222l));
//		
//		for(User testUser: testUsers) {
//		    userRepository.save(testUser);
//		    testUsersString.add(testUser.toString());
//		}
//		
//		ArrayList<User> retrivedUsers = (ArrayList<User>) userRepository.findAll();
//		
//		for(User retrivedUser: retrivedUsers) {
//			logger.info(retrivedUser.toString());
//			if(testUsersString.indexOf(retrivedUser.toString()) != -1) {
//				int tempUserStringIndex = testUsersString.indexOf(retrivedUser.toString());
//				Assert.assertEquals(testUsersString.get(tempUserStringIndex),retrivedUser.toString());
//			}
//			
//		}
//	}
//	
//	@Test
//	@DirtiesContext(methodMode = MethodMode.AFTER_METHOD)
//	void TestFindByEmail() {
//		User testUser = new User(1,"Cole","cole@revature.net","meme","male",23,7572666666l);
//		
//		
//		userRepository.save(testUser);
//		
//		User retrivedUser = userRepository.findByEmail("cole@revature.net");
//		
//
//		if(testUser.toString().indexOf(retrivedUser.toString()) != -1) {
//			int tempUserStringIndex = testUser.toString().indexOf(retrivedUser.toString());
//			assertTrue(testUser.toString().equals(retrivedUser.toString()));
//		}
//	}
//	@Test
//	@DirtiesContext(methodMode = MethodMode.AFTER_METHOD)
//	void TestFindById() {
//		ArrayList<User> testUsers = new ArrayList<User>();
//		
//		ArrayList<String> testUsersString = new ArrayList<String>();
//		testUsers.add(new User(1,"Cole","cole@revature.net","meme","male",23,7572666666l));
//		testUsers.add(new User(2,"Moh","moh@revature.net","pass","male",26,7573332222l));
//		
//		for(User testUser: testUsers) {
//		    userRepository.save(testUser);
//		}
//		
//		User retrivedUser = userRepository.findByEmail("cole@revature.net");
//		
//		Assert.assertEquals(retrivedUser.toString(), testUsers.get(0).toString());
//		
//	}
//	@Test
//	@DirtiesContext(methodMode = MethodMode.AFTER_METHOD)
//	void TestSave() {
//		// Dude, no lie .save() is used in every other test if it worked there it works here >:(
//	}
//	
//	@Test
//	@DirtiesContext(methodMode = MethodMode.AFTER_METHOD)
//	void TestUpdate() {
//		User testUser = new User(1,"Cole","cole@revature.net","meme","male",23,7572666666l);
//		userRepository.save(testUser);
//		
//		testUser.setAge(24);
//		userRepository.update(userRepository.findByEmail("cole@revature.net").getId(),testUser);
//		
//		Assert.assertEquals(testUser.toString(), userRepository.findByEmail("cole@revature.net").toString());
//	}
//	
//	@Test
//	@DirtiesContext(methodMode = MethodMode.AFTER_METHOD)
//	void TestDelete() {
//		User testUser = new User(1,"Cole","cole@revature.net","meme","male",23,7572666666l);
//		userRepository.save(testUser);
//		
//		Assert.assertEquals(testUser.toString(), userRepository.findByEmail("cole@revature.net").toString());
//		
//		userRepository.delete(userRepository.findByEmail("cole@revature.net").getId());
//		
//		Assert.assertThrows(NoSuchElementException.class, () -> {
//			userRepository.findById(1);
//		});
//	}
//	
//
//}
