package com.group9.internetcafe.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
}
