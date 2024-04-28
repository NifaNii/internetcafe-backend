package com.group9.internetcafe.Service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.group9.internetcafe.Entity.QueueEntity;
import com.group9.internetcafe.Repository.QueueRepository;

@Service
public class QueueService {
	@Autowired
	QueueRepository queueRepo;
	
	public QueueEntity insertQueue(QueueEntity queue) {
		return queueRepo.save(queue);
	}
	
	public QueueEntity popQueue() {
		List<QueueEntity> allQueue = queueRepo.findAll();
		
		if(!allQueue.isEmpty()) {
			QueueEntity firstQueue = allQueue.get(0);
			int firstID = firstQueue.getId();
			queueRepo.deleteById(firstID);
			return firstQueue;
		}
		return null;
	}
	
	public String skipQueue() {
		List<QueueEntity> allQueue = queueRepo.findAll();
		
		if(!allQueue.isEmpty()) {
			QueueEntity firstQueue = allQueue.get(0);
			int firstID = firstQueue.getId();
			queueRepo.deleteById(firstID);
			
			queueRepo.save(firstQueue);
			return "check daw";
		}
		return "empty Queue";
	}
}
