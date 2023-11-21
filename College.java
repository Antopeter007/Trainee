package com.demo.annotations;

import org.springframework.stereotype.Component;

@Component
public class College {
	private String number;

	public void CollegeName() {
		System.out.println("Sardar Raja College Of Engineering");
	}

	public void Details() {
		System.out.println("Anto Peter");
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}
}
