package testMovieGo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import obj.Adult;
import obj.Student;
import obj.TicketType;

class testStudent {

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testGetPrice() {
		TicketType Student = new Student();
		double result = Student.getPrice();
		assertEquals(85.00, result);
	}
	
	@Test
	void testGetType() {
		TicketType Student = new Student();
		String result = Student.getType();
		assertEquals("Student", result);
	}

}
