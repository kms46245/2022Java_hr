package com.my.java.domain;

import java.time.LocalDate;

public class Laborer {
	private int laborerId;
	private String name;
	private LocalDate hireDate;
	
	public Laborer(int laborerId, String name, LocalDate hireDate) {
		this.laborerId = laborerId;
		this.name = name;
		this.hireDate = hireDate;
	}

	public int getLaborerId() {
		return laborerId;
	}

	public String getName() {
		return name;
	}

	public LocalDate getHireDate() {
		return hireDate;
	}

	public void setlaborerId(int laborerId) {
		this.laborerId = laborerId;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setHireDate(LocalDate hireDate) {
		this.hireDate = hireDate;
	}
	
	// @Override
	public String toString() {
		return String.format("%2d %-5s %s", laborerId ,name, hireDate);
	}
	
	
	
}
