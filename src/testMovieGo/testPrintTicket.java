package testMovieGo;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import org.junit.Test;

import obj.*;
public class testPrintTicket {

	@Test
	public void testPrint() {
		
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
		
		PrintTicket printTicket=new PrintTicket();
		Cinema cinema= new Cinema(1,"TST","Happy Cinema","91234567");
		Theatre theatre =new Theatre(1, 3, 3);
		Movie movie =new Movie(1,"007",DateTime.today(),2.0,new ArrayList<String>());
		MovieSession movieSession=new MovieSession(1, cinema,theatre , movie , DateTime.today());
		printTicket.print(new Ticket(Adult.getInstance(),movieSession,"A01"));
		
		

		
		assertEquals("ticket is printed\r\n", outContent.toString());
	}
}
