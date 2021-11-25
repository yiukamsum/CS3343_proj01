package testMovieGo;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import obj.Adult;
import obj.Cinema;
import obj.DateTime;
import obj.Movie;
import obj.MovieSession;
import obj.Theatre;
import obj.Ticket;
import obj.TicketType;

class testTicket {

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	public void testGetType() {
		Cinema C01 = new Cinema(1, "HK", "Cinema01", "12345678");
		Theatre T01 = new Theatre (1, 1, 1);
		DateTime Date = new DateTime(2021, 01, 01);
		ArrayList<String> actorList = new ArrayList<String>();
		Movie M01 = new Movie(1, "Movie01", Date, 1.01, actorList);
		MovieSession session01 = new MovieSession(1, C01, T01, M01, Date);
		Ticket ticket1 = new Ticket(Adult.getInstance(), session01, "A01");
		String result = ticket1.getType();
		assertEquals("Adult", result);		
	}
	
	@Test
	public void testGetPrice() {
		Cinema C01 = new Cinema(1, "HK", "Cinema01", "12345678");
		Theatre T01 = new Theatre (1, 1, 1);
		DateTime Date = new DateTime(2021, 01, 01);
		ArrayList<String> actorList = new ArrayList<String>();
		Movie M01 = new Movie(1, "Movie01", Date, 1.01, actorList);
		MovieSession session01 = new MovieSession(1, C01, T01, M01, Date);
		Ticket ticket1 = new Ticket(Adult.getInstance(), session01, "A01");
		double result = ticket1.getPrice();
		assertEquals(100.00, result);		
	}
	
	@Test
	public void testGetSession() {
		Cinema C01 = new Cinema(1, "HK", "Cinema01", "12345678");
		Theatre T01 = new Theatre (1, 1, 1);
		DateTime Date = new DateTime(2021, 01, 01);
		ArrayList<String> actorList = new ArrayList<String>();
		Movie M01 = new Movie(1, "Movie01", Date, 1.01, actorList);
		MovieSession session01 = new MovieSession(1, C01, T01, M01, Date);
		Ticket ticket1 = new Ticket(Adult.getInstance(), session01, "A01");
		MovieSession result = ticket1.getSession();
		assertEquals(session01, result);		
	}
	
	@Test
	public void testGetSeat() {
		Cinema C01 = new Cinema(1, "HK", "Cinema01", "12345678");
		Theatre T01 = new Theatre (1, 1, 1);
		DateTime Date = new DateTime(2021, 01, 01);
		ArrayList<String> actorList = new ArrayList<String>();
		Movie M01 = new Movie(1, "Movie01", Date, 1.01, actorList);
		MovieSession session01 = new MovieSession(1, C01, T01, M01, Date);
		Ticket ticket1 = new Ticket(Adult.getInstance(), session01, "A01");
		String result = ticket1.getSeat();
		assertEquals("A01", result);		
	}

}
