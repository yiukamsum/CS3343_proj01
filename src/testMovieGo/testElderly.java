package testMovieGo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import obj.Elderly;
import obj.TicketType;

class testElderly {

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testGetPrice() {
		TicketType elderly = Elderly.getInstance();
		double result = elderly.getPrice();
		assertEquals(70.00, result);
	}
	
	@Test
	void testGetType() {
		TicketType elderly = Elderly.getInstance();
		String result = elderly.getType();
		assertEquals("Elderly", result);
	}


}
