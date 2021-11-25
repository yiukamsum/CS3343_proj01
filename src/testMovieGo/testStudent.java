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
		TicketType student = Student.getInstance();
		double result = student.getPrice();
		assertEquals(85.00, result);
	}
	
	@Test
	void testGetType() {
		TicketType student = Student.getInstance();
		String result = student.getType();
		assertEquals("Student", result);
	}

}
