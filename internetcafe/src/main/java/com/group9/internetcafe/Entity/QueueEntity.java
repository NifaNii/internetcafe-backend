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
	private int ispopped;
	private int islogged;
	private String email;
	
	public QueueEntity() {
		super();
		// TODO Auto-generated constructor stub
		this.ispopped = 0;
		this.islogged = 0;
	}

	public QueueEntity(int id, String firstname, String email) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.email = email;
		this.ispopped = 0;
		this.islogged = 0;
	}
	
	public QueueEntity(int id, String firstname, int isPopped, int islogged, String email) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.email = email;
		this.ispopped = isPopped;
		this.islogged = islogged;
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

	public int getIsPopped() {
		return ispopped;
	}

	public void setIsPopped(int isPopped) {
		this.ispopped = isPopped;
	}

	public int getIslogged() {
		return islogged;
	}

	public void setIslogged(int islogged) {
		this.islogged = islogged;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
}
