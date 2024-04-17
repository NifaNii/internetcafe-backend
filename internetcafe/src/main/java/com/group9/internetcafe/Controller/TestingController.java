package com.group9.internetcafe.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.group9.internetcafe.Entity.TestingEntity;
import com.group9.internetcafe.Service.TestingService;

@RestController
@RequestMapping("/testing")
public class TestingController {
	@Autowired
	TestingService testserv;
	
	@GetMapping("/message")
	public String testMessage() {
		return "Looking, Good!";
	}
	
	//CRUD testing
	
	//C
	@PostMapping("/insertTest")
	public TestingEntity insertTest(@RequestBody TestingEntity test) {
		return testserv.insertTest(test);
	}
	
	//R
	@GetMapping("/getAllTest")
	public List<TestingEntity> getAllTest(){
		return testserv.getAllTest();
	}
	
	//U
	@PutMapping("/updateTest")
	public TestingEntity updateTest(@RequestParam int id, @RequestBody TestingEntity newTestingEntity) {
		return testserv.updateTest(id, newTestingEntity);
	}
	
	//D
	@DeleteMapping("/deleteTest/{id}")
	public String deleteTest(@PathVariable int id) {
		return testserv.deleteTest(id);
	}
}
