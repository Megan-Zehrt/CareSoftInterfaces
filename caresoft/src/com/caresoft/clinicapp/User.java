// Pair programmed with Jacob Payne

package com.caresoft.clinicapp;

public class User {
	
	protected Integer id;
	protected int pin;
	
	public User() {}
	
	public User(int pin, Integer id) {
		this.pin = pin;
		this.id = id;
	}
	
	public User(int pin) {
		this.pin = pin;
	}
	
    
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public int getPin() {
		return pin;
	}
	public void setPin(int pin) {
		this.pin = pin;
	}
}
