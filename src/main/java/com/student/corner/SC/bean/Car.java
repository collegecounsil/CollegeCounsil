package com.student.corner.SC.bean;

/**
 * For Testing 
 * 
 * @author Raj
 * @since V1.0.0_14012017
 */

//[TODO] Remove It Later
public class Car {
	
	private int id;
	private String name;
	
	public Car(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
