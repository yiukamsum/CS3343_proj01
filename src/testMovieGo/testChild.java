package testMovieGo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import obj.Adult;
import obj.Child;
import obj.TicketType;

class testChild {

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testGetPrice() {
		TicketType child = Child.getInstance();
		double result = child.getPrice();
		assertEquals(75.00, result);
	}
	
	@Test
	void testGetType() {
		TicketType child = Child.getInstance();
		String result = child.getType();
		assertEquals("Child", result);
	}

}
