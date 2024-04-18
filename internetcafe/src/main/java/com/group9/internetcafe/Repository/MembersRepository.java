package com.group9.internetcafe.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.group9.internetcafe.Entity.MembersEntity;

@Repository
public interface MembersRepository extends JpaRepository<MembersEntity, Integer> {

}
