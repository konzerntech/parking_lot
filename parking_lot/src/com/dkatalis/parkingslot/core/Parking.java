/**
 * 
 */
package com.dkatalis.parkingslot.core;

import com.dkatalis.parkingslot.model.Ticket;

/**
 * @author Nijesh
 * @param <E>
 * @param <E>
 *
 */
public class Parking<E> extends ParkingLot<E> implements IParking {

	public Parking(int capacity) {
		super(capacity);
		System.out.println("Created Parking lot with " + capacity + " slots");
	}

	@Override
	public void park(Ticket ticket) {
		try {

			if (isFull()) {
				System.out.println("Sorry, parking lot is full");
			} else {

				int position = findNearestAvailableSlot();
				insert(position, (E) ticket);
				ticket.setSlot(getSlot(position));
				System.out.println("Allocated slot number :" + ticket.getSlot());

			}

		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void leave(Ticket ticket) {
		try {

			if (ticket.getSlot() <= 0) {
				System.out.println("Registration number " + ticket.getRegistrationNumber() + " not found");
			} else {

				int position = getPostion(ticket.getSlot());
				delete(position);
				calculateParkingCharge(ticket);
				System.out.println("Registration number " + ticket.getRegistrationNumber() + " with Slot Number "
						+ ticket.getSlot() + " is free with  Charge " + ticket.getCharge());
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void status() {

		E[] objs = getData();

		System.out.println("Slot No \t\t Registration No ");

		for (E obj : objs) {

			if (null != obj) {
				Ticket ticket = (Ticket) obj;

				System.out.println(ticket.getSlot() + "\t\t" + ticket.getRegistrationNumber());
			}
		}

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
