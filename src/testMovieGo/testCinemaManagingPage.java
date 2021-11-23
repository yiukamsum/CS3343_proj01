package testMovieGo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;



import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import obj.Cinema;
import obj.CinemaManagingPage;
import obj.AdminConsole;
import obj.Catalog;

public class testCinemaManagingPage {
	@Test
	public void testDisplay() {

		String input="4\n\n";
		System.setIn(new ByteArrayInputStream(input.getBytes()));

		
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
		
		CinemaManagingPage cinemaManagingPage=new CinemaManagingPage(new AdminConsole());
		cinemaManagingPage.display();	
	
		String expecString="\n===Start Page===\n"+
                "Login As:\n"+    
                "(1) Member\n"+    
                "(2) Admin\n"+
                "-------------\n"+
                "Enter -1 to exit\n"+""+"\nInvalid Input\n\n";
		
		assertEquals( expecString,outContent.toString().trim());


		
	}

}
