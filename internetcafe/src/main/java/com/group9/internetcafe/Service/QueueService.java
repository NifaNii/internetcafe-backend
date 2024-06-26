package com.group9.internetcafe.Service;


import java.util.List;
import java.util.NoSuchElementException;

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
	
	@SuppressWarnings("finally")
	public QueueEntity popQueue() {
		List<QueueEntity> allQueue = queueRepo.findAll();
		
		for(QueueEntity queue : allQueue) {
			if(queue.getIsPopped() != 1) {
				try {
					
					List<QueueEntity> allQueue2 = queueRepo.findAll();
					
					for(int i = allQueue2.size() - 1; i >= 0; i--) {
						QueueEntity queue2 = allQueue2.get(i);
						if(queue2.getIsPopped() == 1 && queue2.getIslogged() == 0) {
							queue2.setIslogged(1);
							queueRepo.save(queue2);
						}
					}
					
					queue.setIsPopped(1);
				}catch (NoSuchElementException ex) {
					throw new NoSuchElementException("lols");
				}finally {
					queueRepo.save(queue);
					return queue;
				}
				
//				int firstID = firstQueue.getId();
//				queueRepo.deleteById(firstID);
//				return firstQueue;
			}
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
	
	public List<QueueEntity> getAllQueue(){
		return queueRepo.findAll();
	}
	
	public String cancelQueue(int id) {
		String msg ="";
		if(queueRepo.findById(id) != null) {
			queueRepo.deleteById(id);
			msg = "deleted";
		}else {
			msg = "woopsies!";
		}
		return msg;
	}
	
	//check if user is already in queue
	public int onList(String firstname) {
//		QueueEntity queue = queueRepo.findByFirstname(firstname);
//		
//		if(queue != null) {
//			return queue.getId();
//		}else {
//			return 0;
//		}
		
		List<QueueEntity> allQueue = queueRepo.findAll();
		
		for(QueueEntity queue : allQueue) {
			if(queue.getIslogged() == 0 && queue.getFirstname().equals(firstname)) {
				return queue.getId();
			}
		}
		return 0;
	}
	
	// prints out the called number
	public QueueEntity calledNumb() {
		List<QueueEntity> allQueue = queueRepo.findAll();
		
		for(int i = allQueue.size() - 1; i >= 0; i--) {
			QueueEntity queue = allQueue.get(i);
			if(queue.getIsPopped() == 1 && queue.getIslogged() == 0) {
				return queue;
			}
		}
		return null;
	}
	
	@SuppressWarnings("finally")
	public String isLogged(int id) {
		QueueEntity queue = new QueueEntity();
		
		try {
			queue = queueRepo.findById(id).get();
			
			if(queue.getIslogged() == 1) {
				return "This Queue is already logged in";
			}else {
				queue.setIslogged(1);
				queueRepo.save(queue);
			}
		}catch(NoSuchElementException ex) {
			throw new NoSuchElementException(id + "does not exists");
		}finally {
			return "User successfully logged";
		}
	}
}
