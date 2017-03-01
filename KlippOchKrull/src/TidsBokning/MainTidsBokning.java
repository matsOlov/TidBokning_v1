package TidsBokning;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;

/* Tidsbokningsprogram f�r Klipp och Krull h�rsalong.*/

public class MainTidsBokning {

	public static void main(String[] args) throws IOException {

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		BookingHandler bh = new BookingHandler();
		String svar = "";

		do {
			System.out.println(
					"1. Boka en tid.\n2. Se bokningar\n3. Ändra bokning\n4. Ta bort bokning.\n5. Avsluta programmet.");
			svar = reader.readLine();
			switch (svar) {
			// Skapa en bokning
			case "1":
				System.out.println("\nSkriv in ditt namn");
				String namn = reader.readLine();

				System.out.println("\nSkriv in en starttid YYYY-MM-dd HH:mm");
				String now = reader.readLine();
//				String now = "2016-11-09 10:30"; //Statisk Bokning

				// Skapa tider för en bokning
				try {
					LocalDateTime startTid = LocalDateTime.parse(now, bh.formatter);
					LocalDateTime slutTid = startTid.plusMinutes(45);

					// Skapa bokning
					Booking b = new Booking();
					b.setNamn(namn);
					b.setStartTid(startTid);
					b.setSlutTid(slutTid);

					// Lägg in i lista
					BookingHandler.addBooking(b);
					System.out.println("Ny tidsbokning för: " + namn + "\nTid: " + startTid.format(bh.formatter) + " : "
							+ slutTid.format(bh.formatter));

				} catch (DateTimeParseException e) {
					System.out.println("Använd siffror och följ formateringen YYYY-MM-dd HH:mm\n");
				}

				break;
			// Se bokningar
			case "2":

				for (Booking bo : BookingHandler.getBookingList())
					System.out.println("Bokning för: " + bo.getNamn() + "\nTid: "
							+ bo.getStartTid().format(bh.formatter) + " : " + bo.getSlutTid().format(bh.formatter));
				break;
			case "3": editList(bh, reader); //Hämtar submeny	
				break;
			case "4":
				break;

			default:
				break;
			}

		} while (!svar.equals("5")); // Avslutar programmet
		System.out.println("Programmet avslutades.\n");
	}

// Submeny för val 3, ändra bokning. Namn och tid
private static void editList (BookingHandler bh, BufferedReader reader) throws IOException{
	System.out.println("Ange namn på kund för att ändra bokning. ");
	Booking b1 = bh.editBooking(reader.readLine());
	System.out.println(b1.getNamn());
	String svar1 = "";
	do {
		System.out.println("1. Ändra Namn\n2. Ändra tid\n3. Ändra sluttid\n4. Avsluta.");
		svar1 = reader.readLine();
		
		switch (svar1){
		case "1" :
			System.out.println("Ange nytt namn: "); //Ändra namn
			String nyttNamn = (reader.readLine());
			if(!nyttNamn.trim().equals(""))
				b1.setNamn(nyttNamn);
			break;
		case "2" :
//			System.out.println("Skriv in en ny starttid YYYY-MM-dd HH:mm"); //Ändra starttid för klippningen
//			String now = "2017-03-10 15:30"; //Statisk Bokning
//			//Skapa tider för bokning
//			LocalDateTime nyStartTid = LocalDateTime.parse(now, bh.formatter);
//			LocalDateTime nySlutTid = nyStartTid.plusMinutes(45);
//			// Skapa bokning
//			Booking b = new Booking();
//			b1.setNamn(nyttNamn);
//			b1.setStartTid(nyStartTid);
//			b1.setSlutTid(nySlutTid);

			// Lägg in i lista
//			BookingHandler.addBooking(b1);
//			System.out.println("Ny tidsbokning för: " +  "\nTid: " 
//					+ nyStartTid.format(bh.formatter) + " : "
//					+ nySlutTid.format(bh.formatter));			
			break;
		case "3" :
			break;
		}		
	} while(!svar1.equals("4")); //Avsluta redigeringsläge och återgå till huvudmenyn
		System.out.println("Avslutat.\n");	
}









}