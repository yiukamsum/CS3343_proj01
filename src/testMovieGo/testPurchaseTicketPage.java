package testMovieGo;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import obj.Cinema;
import obj.DateTime;
import obj.MemberConsole;
import obj.Movie;
import obj.MovieSession;
import obj.PurchaseTicket;
import obj.PurchaseTicketPage;
import obj.Theatre;

class testPurchaseTicketPage {

	public PrintStream test;
	
	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testInvalidCase() {
		String input = "5\n-1\n";
		System.setIn(new ByteArrayInputStream(input.getBytes()));
		
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
		
		PurchaseTicketPage PurchaseTicketPage = new PurchaseTicketPage(new MemberConsole());
		PurchaseTicketPage.display();
		
		String result = "\n===Purchase Ticket===\n"+
                "(1) Show Movie Session List\n"+          
                "(2) Search session by movie name\n"+
                "(3) Search session by cinema name\n"+
                "(4) Purchase ticket\n"+
                "(-1) Leave this page\n"+ 
                "> Invalid Input\n"+
                "\r\n"+


				"\n===Purchase Ticket===\n"+
				"(1) Show Movie Session List\n"+          
				"(2) Search session by movie name\n"+
				"(3) Search session by cinema name\n"+
				"(4) Purchase ticket\n"+
				"(-1) Leave this page\n";
		
		assertEquals(result, outContent.toString());
	}

}
