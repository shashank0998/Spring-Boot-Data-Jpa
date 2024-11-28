package com.springboot.jpa.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Employee 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long empId;
	private String name;
	private int age;
	private boolean active;
	private long phoneNumber=(long)(Math.random()*Math.pow(10, 10));
	private String designation;
	private double salary = Math.random()*100000;
}
