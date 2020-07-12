/**
 * 
 */
package com.dkatalis.parkingslot.model;

/**
 * @author Nijesh
 * 
 *
 */
public class Car {
	
	private String registrationNumber;
	
	private String color;
	
	private int slot;
	
	private int hour;

	public String getRegistrationNumber() {
		return registrationNumber;
	}

	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getSlot() {
		return slot;
	}

	public void setSlot(int slot) {
		this.slot = slot;
	}

	public int getHour() {
		return hour;
	}

	public void setHour(int hour) {
		this.hour = hour;
	}
	
	

}
