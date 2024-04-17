package com.group9.internetcafe.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="tbltesting")
public class TestingEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String devname;
	private String message;
	public TestingEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TestingEntity(int id, String devname, String message) {
		super();
		this.id = id;
		this.devname = devname;
		this.message = message;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDevname() {
		return devname;
	}
	public void setDevname(String devname) {
		this.devname = devname;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
