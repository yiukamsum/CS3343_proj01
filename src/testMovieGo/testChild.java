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
		TicketType Child = new Child();
		double result = Child.getPrice();
		assertEquals(75.00, result);
	}
	
	@Test
	void testGetType() {
		TicketType Child = new Child();
		String result = Child.getType();
		assertEquals("Child", result);
	}

}
