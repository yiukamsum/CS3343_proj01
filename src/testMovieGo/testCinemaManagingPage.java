package testMovieGo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;

import obj.Cinema;
import obj.CinemaManagingPage;
import obj.AdminConsole;
import obj.Catalog;


public class testCinemaManagingPage {
	
	public PrintStream test;
	
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
                "(-1) Leave this page\n"+   "Invalid Input\r\n"+
                
                "\n===Manage Cinema===\n"+
                "(1) Show Cinema List\n"+          
                "(2) Add Cinema\n"+          
                "(3) Remove Cinema\n"+
                "(-1) Leave this page\n";
		
		assertEquals( expecString,outContent.toString());


		
	}
	
	@Test
	public void testDisplay2() {

		String input="1\n-1\n";
		System.setIn(new ByteArrayInputStream(input.getBytes()));
		

		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
		
		CinemaManagingPage cinemaManagingPage=new CinemaManagingPage(new AdminConsole());
		cinemaManagingPage.display();	
	
		String expecString= "\n===Manage Cinema===\n"+
                "(1) Show Cinema List\n"+          
                "(2) Add Cinema\n"+          
                "(3) Remove Cinema\n"+
                "(-1) Leave this page\n"+   
                
                
				"\n---Cinema Catalog---\r\n"
				+ "1. 	Cinema ID: 	1\n"
				+ "	Cinema Name: 	Cinema A\n"
				+ "	Location: 	loc A\n"
				+ "	Phone Number: 	12345678\n"
				+ "\n"
				+ "--------------------\r\n"+


                
                "\n===Manage Cinema===\n"+
                "(1) Show Cinema List\n"+          
                "(2) Add Cinema\n"+          
                "(3) Remove Cinema\n"+
                "(-1) Leave this page\n";
		
		assertEquals( expecString,outContent.toString());


		
	}
	@Test
	public void testDisplay3() {

		String input="2\nHello Cinema\nMong Kok\n91234567\n1\n3\n3\n-1\n";
		System.setIn(new ByteArrayInputStream(input.getBytes()));

		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
		
		CinemaManagingPage cinemaManagingPage=new CinemaManagingPage(new AdminConsole());
		cinemaManagingPage.display();	
	
		String expecString= "\n===Manage Cinema===\n"+
                "(1) Show Cinema List\n"+          
                "(2) Add Cinema\n"+          
                "(3) Remove Cinema\n"+
                "(-1) Leave this page\n"+  
                
                
                "---Add Cinema---\r\n"
                + "(Enter -1 to go back)\r\n"
                + "\n"
                + "Enter the cinema name: Enter the cinema location: Enter the cinema phone number: Enter the Number of theatra this cinema has: [Theatra 1]\n"
                + "Enter the row number: Enter the column number: \n"
                + "---Cinema Catalog---\r\n"
                + "1. 	Cinema ID: 	1\n"
                + "	Cinema Name: 	Cinema A\n"
                + "	Location: 	loc A\n"
                + "	Phone Number: 	12345678\n"
                + "\n"
                + "2. 	Cinema ID: 	2\n"
                + "	Cinema Name: 	Hello Cinema\n"
                + "	Location: 	Mong Kok\n"
                + "	Phone Number: 	91234567\n"
                + "\n"
                + "--------------------\r\n"+
                
                "\n===Manage Cinema===\n"+
                "(1) Show Cinema List\n"+          
                "(2) Add Cinema\n"+          
                "(3) Remove Cinema\n"+
                "(-1) Leave this page\n";
		
		assertEquals( expecString,outContent.toString());


		
	}
	@Test
	public void testDisplay4() {

		String input="3\n1\n-1\n";
		System.setIn(new ByteArrayInputStream(input.getBytes()));

		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
		
		CinemaManagingPage cinemaManagingPage=new CinemaManagingPage(new AdminConsole());
		cinemaManagingPage.display();	
	
		String expecString= "\n===Manage Cinema===\n"+
                "(1) Show Cinema List\n"+          
                "(2) Add Cinema\n"+          
                "(3) Remove Cinema\n"+
                "(-1) Leave this page\n"   
                
                +"---Remove Cinema---\r\n"
                + "(Enter -1 to go back)\r\n"
                + "Enter the item number of the cinema you want to remove: Delete Success\r\n"
				
				+"\n---Cinema Catalog---\r\n"
				+"1. 	Cinema ID: 	2\n"
				+ "	Cinema Name: 	Hello Cinema\n"
				+ "	Location: 	Mong Kok\n"
				+ "	Phone Number: 	91234567"
				+ "\n"
				+ "\n--------------------\r\n"+


                
                "\n===Manage Cinema===\n"+
                "(1) Show Cinema List\n"+          
                "(2) Add Cinema\n"+          
                "(3) Remove Cinema\n"+
                "(-1) Leave this page\n";
		
		assertEquals( expecString,outContent.toString());


		
	}

}
