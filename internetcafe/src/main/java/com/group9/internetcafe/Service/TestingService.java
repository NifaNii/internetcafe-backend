package com.group9.internetcafe.Service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.group9.internetcafe.Entity.TestingEntity;
import com.group9.internetcafe.Repository.TestingRepository;

@Service
public class TestingService {
	@Autowired
	TestingRepository testrepo;
	
	//CRUD test
	
	//C
	public TestingEntity insertTest(TestingEntity test) {
		return testrepo.save(test);
	}
	
	//R
	public List<TestingEntity> getAllTest(){
		return testrepo.findAll();
	}
	
	//U
	@SuppressWarnings("finally")
	public TestingEntity updateTest(int id, TestingEntity newTestingEntity) {
		TestingEntity test = new TestingEntity();
		try {
			test = testrepo.findById(id).get();
			
			test.setDevname(newTestingEntity.getDevname());
			test.setMessage(newTestingEntity.getMessage());
		}catch (NoSuchElementException ex) {
			throw new NoSuchElementException("Update test error! :'(");
		}finally {
			return testrepo.save(test);
		}
	}
	
	//D
	public String deleteTest(int id) {
		String msg = "";
		if(testrepo.findById(id) != null) {
			testrepo.deleteById(id);
			msg = "id " + id + " deleted";
		}else {
			msg = "id " + id + " does not exist";
		}
		return msg;
	}
}
