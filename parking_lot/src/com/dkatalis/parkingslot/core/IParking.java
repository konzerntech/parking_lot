/**
 * 
 */
package com.dkatalis.parkingslot.core;

import com.dkatalis.parkingslot.model.Ticket;

/**
 * @author Nijesh
 *
 */
public interface IParking {
	
	public void park(Ticket ticket);
	
	public void leave(Ticket ticket);
	
	public void status();

}
