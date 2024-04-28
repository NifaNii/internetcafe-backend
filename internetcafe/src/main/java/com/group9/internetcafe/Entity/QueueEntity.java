package com.group9.internetcafe.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="tblqueue")
public class QueueEntity {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
	private String firstname;
	
	public QueueEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public QueueEntity(int id, String firstname) {
		super();
		this.id = id;
		this.firstname = firstname;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	
	
}
