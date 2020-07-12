/**
 * 
 */
package com.dkatalis.parkingslot.core;

import com.dkatalis.parkingslot.model.Ticket;

/**
 * @author Apple
 * @param <E>
 * @param <E>
 *
 */
public class Parking<E> extends ParkingLot<E> {

	public Parking(int capacity) {
		super(capacity);
		System.out.println("Created Parking lot with " + capacity + " slots");
	}

	public void park(Ticket ticket) {
		try {
			int position = findNearestAvailableSlot();
			insert(position, (E) ticket);
			ticket.setSlot(getSlot(position));
			System.out.println("Allocated slot number :" + ticket.getSlot());
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}

	}

	
	public void remove(Ticket ticket) {
		try {

			int position = getPostion(ticket.getSlot());
			delete(position);
			calculateParkingCharge(ticket);
			System.out.println(" Registration number " + ticket.getRegistrationNumber() + " with Slot Number "
					+ ticket.getSlot() + " is free with  Charge " + ticket.getCharge());

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void status() {
		
	}
	
	private int getSlot(int position) {
		return position + 1;
	}

	private int getPostion(int slot) {
		return slot - 1;
	}



	private void calculateParkingCharge(Ticket ticket) {
		int hour = ticket.getHour();
		double charge = 0;

		if (hour <= 0) {
			charge = 0;
		} else if (hour < 2) {
			charge = 10;
		} else {
			charge = ((hour - 2) * 10) + 10;
		}
		ticket.setCharge(charge);
	}

	private int findNearestAvailableSlot() throws IllegalAccessException {
		return firstUnallocatedSpace();
	}

}
