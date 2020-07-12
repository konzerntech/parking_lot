/**
 * 
 */
package com.dkatalis.parkingslot.core;

/**
 * @author Nijesh
 *
 */
public abstract class ParkingLot<E> {

	private final int MAX_LOT_CAPACITY;

	protected E data[];

	private int allocationCount = 0;

	public ParkingLot(int capacity) {
		this.MAX_LOT_CAPACITY = capacity;
		initializeLot();
		
	}

	private void initializeLot() {
		this.data = (E[]) new Object[MAX_LOT_CAPACITY];
	}

	public void insert(int position, E data) {

		if (isFull()) {
			throw new IllegalArgumentException("The lot is full");
		}else if (isCurrentSlotAllocated(position)) {
			throw new IllegalArgumentException("The lot is already allocated");
		}

		this.data[position] = data;
		allocationCount ++;

	}
	
	
	public void delete(int position) {
		
		if(isEmpty()) {
			throw new IllegalAccessError("The lot is empty");
		}
		
		this.data[position] = null;
		allocationCount --;
		
		
	}
	
	public E getData() {
		return (E) data;
	}
	
	public void print() {
		
		if(isEmpty()) {
			throw new IllegalArgumentException("The lot is empty");
		}
		
		for(int slot = 0; slot < MAX_LOT_CAPACITY; slot ++ ) {
			
			if(null!= this.data[slot]) {
				System.out.println(this.data[slot] );
			}
			
		}
		
	}
	
	

	private boolean isCurrentSlotAllocated(int position) {
		
		if(isEmpty()) {
			return false;
		}else if (null != this.data[position]) {
			return true;
		}
		return false;
	}

	private boolean isFull() {

		if (MAX_LOT_CAPACITY == allocationCount + 1) {
			return true;
		}

		return false;
	}

	private boolean isEmpty() {

		if (allocationCount <= 0) {
			return true;
		}

		return false;
	}
	
	protected int firstUnallocatedSpace() throws IllegalAccessException {
		
		if(isFull()) {
			throw new IllegalAccessException("slot is full");
		}
		
		if(isEmpty()) {
			return 0;
		}
		
		for(int slot = 0; slot < MAX_LOT_CAPACITY; slot ++ ) {
			
			if(null ==data[slot]) {
				return slot;
			}
			
		}
		
		return -1;
	}

}
