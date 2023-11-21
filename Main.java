package com.demo.annotations;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(College.class);
		College college = context.getBean(College.class);
		college.CollegeName();
		college.Details();
		college.setNumber("7092545780");
		System.out.println(college.getNumber());
	}
}
