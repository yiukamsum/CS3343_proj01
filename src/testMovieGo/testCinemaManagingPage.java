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

		String input="4\n-1\n";
		System.setIn(new ByteArrayInputStream(input.getBytes()));

		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
		
		CinemaManagingPage cinemaManagingPage=new CinemaManagingPage(new AdminConsole());
		cinemaManagingPage.display();	
	
		String expecString= "\n===Manage Cinema===\n"+
                "(1) Show Cinema List\n"+          
                "(2) Add Cinema\n"+          
                "(3) Remove Cinema\n"+
                "(-1) Leave this page\n"+   "Invalid Input\n"+
                
                "\n===Manage Cinema===\n"+
                "(1) Show Cinema List\n"+          
                "(2) Add Cinema\n"+          
                "(3) Remove Cinema\n"+
                "(-1) Leave this page\n";
		
		assertEquals( expecString,outContent.toString());


		
	}

}
