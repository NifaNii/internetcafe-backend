package com.group9.internetcafe.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.group9.internetcafe.Entity.QueueEntity;

@Repository
public interface QueueRepository extends JpaRepository<QueueEntity, Integer>{

}
