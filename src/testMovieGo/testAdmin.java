package testMovieGo;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;

import obj.Admin;
public class testAdmin {

	@Test
	public void testGetName() {
		Admin defaultAdmin= Admin.getInstance();
		String resString=defaultAdmin.getName();
		
		assertEquals("Jack",resString );
	}
}
