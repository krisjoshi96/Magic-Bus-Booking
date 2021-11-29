//package com.revature.project2;
//
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertThrows;
//import static org.junit.Assert.assertTrue;
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//import java.sql.Date;
//import java.sql.Time;
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
//import com.revature.project2.model.Bus;
//import com.revature.project2.repo.UserRepository;
//import com.revature.project2.service.BusService;
//import com.revature.project2.service.UserService;
//
//@SpringBootTest
//class TestBusServices {
//
//    @Autowired
//    private BusService busRepository;
//    
//	
//	private static Logger logger = LoggerFactory.getLogger(TestUserServices.class);
//	
//	@BeforeEach
//	private void removeAllBuses(){
//		
//		ArrayList<Bus> testBuses = (ArrayList<Bus>) busRepository.findAll();
//		
//		for(Bus testBus: testBuses) {
//		    busRepository.delete(testBus.getId());
//		}
//	}
//	
//	@AfterEach
//	private void removeAllBuesAgain(){
//		
//		ArrayList<Bus> testBuses = (ArrayList<Bus>) busRepository.findAll();
//		
//		for(Bus testBus: testBuses) {
//		    busRepository.delete(testBus.getId());
//		}
//	}
//	
//	
//	@Test
//	@DirtiesContext(methodMode = MethodMode.AFTER_METHOD)
//	void TestFindAll() {
//		ArrayList<Bus> testBuses = new ArrayList<Bus>();
//		
//		ArrayList<String> testBusesString = new ArrayList<String>();
//		testBuses.add(new Bus(1,"1","New York","San Fransisco",new Date(10,10,10),new Time(10,10,10),100, 1));
//		testBuses.add(new Bus(2,"2","Phenox","Peoria",new Date(10,10,10),new Time(10,10,10),100,2));
//		
//		for(Bus testBus: testBuses) {
//		    busRepository.save(testBus);
//		    testBusesString.add(testBus.toString());
//		}
//		
//		ArrayList<Bus> retrivedBuses = (ArrayList<Bus>) busRepository.findAll();
//		
//		for(Bus retrivedUser: retrivedBuses) {
//			logger.info(retrivedUser.toString());
//			if(testBusesString.indexOf(retrivedUser.toString()) != -1) {
//				int tempUserStringIndex = testBusesString.indexOf(retrivedUser.toString());
//				Assert.assertEquals(testBusesString.get(tempUserStringIndex),retrivedUser.toString());
//			}
//			
//		}
//	}
//	
//	@Test
//	@DirtiesContext(methodMode = MethodMode.AFTER_METHOD)
//	void TestFindByBusNo() {
//		ArrayList<Bus> testBuses = new ArrayList<Bus>();
//		
//		ArrayList<String> testBusesString = new ArrayList<String>();
//		testBuses.add(new Bus(1,"1","New York","San Fransisco",new Date(10,10,10),new Time(10,10,10),100, 1));
//		testBuses.add(new Bus(2,"2","Phenox","Peoria",new Date(10,10,10),new Time(10,10,10),100,2));
//		
//		for(Bus testBus: testBuses) {
//		    busRepository.save(testBus);
//		    testBusesString.add(testBus.toString());
//		}
//		
//		ArrayList<Bus> retrivedBuses = (ArrayList<Bus>) busRepository.findByBusNo("1");
//		
//		for(Bus retrivedUser: retrivedBuses) {
//			logger.info(retrivedUser.toString());
//			if(testBusesString.indexOf(retrivedUser.toString()) != -1) {
//				int tempUserStringIndex = testBusesString.indexOf(retrivedUser.toString());
//				Assert.assertEquals(testBusesString.get(tempUserStringIndex),retrivedUser.toString());
//			}
//			
//		}
//	}
//	@Test
//	@DirtiesContext(methodMode = MethodMode.AFTER_METHOD)
//	void TestFindById() {
//		ArrayList<Bus> testBuses = new ArrayList<Bus>();
//		
//		ArrayList<String> testBusesString = new ArrayList<String>();
//		testBuses.add(new Bus(1,"1","New York","San Fransisco",new Date(10,10,10),new Time(10,10,10),100, 1));
//		testBuses.add(new Bus(2,"2","Phenox","Peoria",new Date(10,10,10),new Time(10,10,10),100,2));
//		
//		for(Bus testBus: testBuses) {
//		    busRepository.save(testBus);
//		}
//		
//		Bus retrivedBus = busRepository.findById(1);
//		
//		Assert.assertEquals(retrivedBus.toString(), testBuses.get(0).toString());
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
//		Bus testBus = new Bus(1,"1","New York","San Fransisco",new Date(10,10,10),new Time(10,10,10),100, 1);
//		busRepository.save(testBus);
//		
//		testBus.setBusNo("24");
//		busRepository.update(busRepository.findById(1).getId(),testBus);
//		
//		Assert.assertEquals(testBus.toString(), busRepository.findById(1).toString());
//	}
//	
//	@Test
//	@DirtiesContext(methodMode = MethodMode.AFTER_METHOD)
//	void TestDelete() {
//		Bus testBus = new Bus(1,"1","New York","San Fransisco",new Date(10,10,10),new Time(10,10,10),100, 1);
//		busRepository.save(testBus);
//		
//		Assert.assertEquals(testBus.toString(), busRepository.findById(1).toString());
//		
//		busRepository.delete(busRepository.findById(1).getId());
//		
//		Assert.assertThrows(NoSuchElementException.class, () -> {
//			busRepository.findById(1);
//		});
//	}
//	
//
//}
