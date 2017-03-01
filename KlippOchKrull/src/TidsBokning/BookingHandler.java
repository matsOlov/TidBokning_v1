package TidsBokning;

import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class BookingHandler {

	private static ArrayList<Booking> bookingList = new ArrayList<Booking>();
	
	//Formatterar datum och tid
	public DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

	//Arraylist för dubbelbokningar
	public static void addBooking(Booking b) {
		if (BookingHandler.kollaDubbelBokning(b))
			bookingList.add(b);
		else
			System.out.println("Den tid du försöker boka är upptagen, prova en annan");
	}

	public static ArrayList<Booking> getBookingList() {
		return bookingList;
	}
	//Ändra bokning
	public Booking editBooking(String namn){
		for (Booking b : bookingList)
			if(b.getNamn().equalsIgnoreCase(namn)){
				bookingList.add(b);
		return b;
	}
	return null;				
	}

	// Kontroll för dubbelbokningar
	public static boolean kollaDubbelBokning(Booking b) {
		LocalDateTime dubbelBokningStart = b.getStartTid();
		LocalDateTime dubbelBokningSlut = b.getSlutTid();
		for (Booking db : getBookingList())
			if (dubbelBokningStart.isAfter(db.getSlutTid()) || (dubbelBokningSlut.isBefore(db.getStartTid())))
				return true;
			else if (dubbelBokningStart.isBefore(db.getSlutTid()) || (dubbelBokningSlut.isAfter(db.getStartTid())))
				return false;
		return true;
	}
}
