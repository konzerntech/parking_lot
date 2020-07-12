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
			System.out.println("Allocated slot number :"+ticket.getSlot());
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		
	}
	
	private int getSlot(int position) {
		return position +1;
	}
	
	private int getPostion(int slot) {
		return slot -1;
	}

	public void remove(Ticket ticket) {
		try {
			
			int position = getPostion(ticket.getSlot());
			delete(position);
			
			int charge =0;
			System.out.println(" Registration number "+ticket.getRegistrationNumber()+" with Slot Number "+ticket.getSlot() +" is free with  Charge "+charge );
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}



	private int findNearestAvailableSlot() throws IllegalAccessException {
		return firstUnallocatedSpace();
	}
	
	

}
