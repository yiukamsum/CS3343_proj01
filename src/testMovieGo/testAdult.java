package testMovieGo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import obj.Adult;
import obj.TicketType;

class testAdult {

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testGetPrice() {
		TicketType Adult = new Adult();
		double result = Adult.getPrice();
		assertEquals(100.00, result);
	}
	
	@Test
	void testGetType() {
		TicketType Adult = new Adult();
		String result = Adult.getType();
		assertEquals("Adult", result);
	}

}
