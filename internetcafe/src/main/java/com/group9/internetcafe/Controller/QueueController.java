package com.group9.internetcafe.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.group9.internetcafe.Entity.QueueEntity;
import com.group9.internetcafe.Service.QueueService;

@RestController
@RequestMapping("/queue")
@CrossOrigin
public class QueueController {
	@Autowired
	QueueService queueServ;
	
	@PostMapping("/insertQueue")
	public QueueEntity insertQueue(@RequestBody QueueEntity queue) {
		return queueServ.insertQueue(queue);
	}
	
	@GetMapping("/popQueue")
	public QueueEntity popQueue() {
		return queueServ.popQueue();
	}
	
	@GetMapping("/skipQueue")
	public String skipQueue() {
		return queueServ.skipQueue();
	}
	
	@GetMapping("/getAllQueue")
	public List<QueueEntity> getAllQueue(){
		return queueServ.getAllQueue();
	}
	
	@DeleteMapping("/cancelQueue/{id}")
	public String cancnelQueue(@PathVariable int id) {
		return queueServ.cancelQueue(id);
	}
	
	// check if user is already in queue
	@GetMapping("/onList")
	public int onList(@RequestParam String firstname) {
		return queueServ.onList(firstname);
	}
	
	// prints out the called number
	@GetMapping("/calledNumb")
	public QueueEntity calledNumb() {
		return queueServ.calledNumb();
	}
}
