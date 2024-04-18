// PC.java
package com.group9.internetcafe.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="tblpc")
public class PC {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int pcNumber;
    private String status;
	public PC() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PC(int id, int pcNumber, String status) {
		super();
		this.id = id;
		this.pcNumber = pcNumber;
		this.status = status;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPcNumber() {
		return pcNumber;
	}
	public void setPcNumber(int pcNumber) {
		this.pcNumber = pcNumber;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
    
}
