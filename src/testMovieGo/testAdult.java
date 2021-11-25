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
		TicketType adult = Adult.getInstance();
		double result = adult.getPrice();
		assertEquals(100.00, result);
	}
	
	@Test
	void testGetType() {
		TicketType adult = Adult.getInstance();
		String result = adult.getType();
		assertEquals("Adult", result);
	}

}
