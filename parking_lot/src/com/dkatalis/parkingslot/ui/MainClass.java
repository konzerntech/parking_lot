/**
 * 
 */
package com.dkatalis.parkingslot.ui;

import com.dkatalis.parkingslot.core.IParking;
import com.dkatalis.parkingslot.core.Parking;
import com.dkatalis.parkingslot.model.Ticket;

/**
 * @author Apple
 *
 */
public class MainClass  {
	
	
public static void main(String[] args) {
	
	
	MainClass m = new MainClass();
	m.start();
	
	
	
}

private void start() {
	
	Ticket ticket = new Ticket();
	ticket.setRegistrationNumber("KA-01-HH-1234");
	
	Ticket ticket2 = new Ticket();
	ticket2.setRegistrationNumber("KA-01-HH-9999");
	
	Ticket ticket3 = new Ticket();
	ticket3.setRegistrationNumber("KA-01-BB-0001");
	
	Ticket ticket4 = new Ticket();
	ticket4.setRegistrationNumber("KA-01-HH-7777");
	
	Ticket ticket5 = new Ticket();
	ticket5.setRegistrationNumber("KA-01-HH-2701");
	
	Ticket ticket6 = new Ticket();
	ticket6.setRegistrationNumber("KA-01-HH-3141");
	
	Ticket ticket7 = new Ticket();
	ticket7.setRegistrationNumber("KA-01-P-333");
	
	Ticket ticket8 = new Ticket();
	ticket8.setRegistrationNumber("DL-12-AA-9999");
	
	Ticket ticket9 = new Ticket();
	ticket9.setRegistrationNumber("KA-09-HH-0987");
	
	Ticket ticket10 = new Ticket();
	ticket10.setRegistrationNumber("CA-09-IO-1111");
	
	Ticket ticket11 = new Ticket();
	ticket11.setRegistrationNumber("CA-09-IO-1111");
	
	IParking p = new Parking<>(6);
	p.park(ticket);
	p.park(ticket2);
	p.park(ticket3);
	p.park(ticket4);
	p.park(ticket5);
	p.park(ticket6);
	
	ticket6.setHour(4);
	p.leave(ticket6);
	
	p.status();
	
	p.park(ticket7);
	
	p.park(ticket8);
	
	ticket.setHour(4);
	p.leave(ticket);
	
	ticket3.setHour(6);
	p.leave(ticket3);
	
	ticket8.setHour(2);
	p.leave(ticket8);
	
	p.park(ticket9);
	
	p.park(ticket10);
	
	p.park(ticket11);
	
	p.status();
	
	System.out.println();
	
}
	
	
	
	

}
