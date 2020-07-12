/**
 * 
 */
package com.dkatalis.parkingslot.ui;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.dkatalis.parkingslot.core.IParking;
import com.dkatalis.parkingslot.core.Parking;
import com.dkatalis.parkingslot.model.Ticket;

/**
 * @author Apple
 *
 */
public class ReadInput {

	public static void readInputFile() {
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader("parking_lot file_inputs.txt"));
			String line = reader.readLine();
			
			Map<String, Ticket> ticketMap = new HashMap<>();
			
			IParking p = null;
			
			while (line != null) {
				
				if(line.contains("create_parking_lot")) {
					
					String[] value = line.split("\\s");
					int size = Integer.valueOf(value[1].trim());
					p = new Parking<>(size);
					
				}else if(line.contains("park")) {
					
					String[] value = line.split("\\s");
					String regNo = value[1].trim();
					Ticket ticket = new Ticket();
					ticket.setRegistrationNumber(regNo);
					ticketMap.put(regNo, ticket);
					p.park(ticket);
					
				}else if(line.contains("leave")) {
					
					String[] value = line.split("\\s");
					String regNo = value[1].trim();
					int hour = Integer.valueOf(value[2].trim());
					Ticket ticket = ticketMap.get(regNo);
					ticket.setHour(hour);
					p.leave(ticket);
					
					
				}else if(line.contains("status")) {
					
					p.status();
				}
				
				// read next line
				line = reader.readLine();
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	

}
