package testMovieGo;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import java.io.ByteArrayOutputStream;
import java.io.ByteArrayInputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import obj.*;

import obj.MovieManagingPage;

public class testMovieManagingPage {
	
	private PrintStream output;
	private ByteArrayOutputStream outputContent;
	
	public void setOutput() {
		output = System.out;
		outputContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outputContent));
		
	}
	
	public String getOutput() {
		System.setOut(output);
		return outputContent.toString();
	}

	public void restoreData() {
		getMovieAction action = new getMovieAction();
		ArrayList<Movie> movieList = action.getMovieList();

		movieList.clear();

        ArrayList<String> actorList1 = new ArrayList<String>();
        actorList1.add("Actor A");
        ArrayList<String> actorList2 = new ArrayList<String>();
        actorList2.add("Actor B");
        ArrayList<String> actorList3 = new ArrayList<String>();
        actorList3.add("Actor C");
        actorList3.add("Actor D");
        movieList.add(new Movie(1, "Movie A", DateTime.today(), 2.0, actorList1));
        movieList.add(new Movie(2, "Movie B", DateTime.today(), 2.0, actorList2));
        movieList.add(new Movie(3, "Movie C", DateTime.today(), 3.0, actorList3));
	}
	
	@Test
	public void testDisplay1() {
		restoreData();

		String input="1\n-1\n";
		System.setIn(new ByteArrayInputStream(input.getBytes()));
		
		setOutput();
		MovieManagingPage movieManaging = new MovieManagingPage(new AdminConsole());
		movieManaging.display();
		
		String expectOutput = String.format("\n====Manage Movie====\n" + 
                                            "(1) Show Movie list\n"+          
                                            "(2) Search Movie by movie ID\n"+
                                            "(3) Search Movie by movie name\n"+
                                            "(4) Add movie\n"+
                                            "(5) Remove movie\n"+
                                            "(-1) Leave this page\n"+
                                            
                            				"\n---Movie List---\n" + 
                            				"0. Movie ID: 1, Movie name: Movie A, Duration: 2.00 \n" +  
                            				"1. Movie ID: 2, Movie name: Movie B, Duration: 2.00 \n" +
                            				"2. Movie ID: 3, Movie name: Movie C, Duration: 3.00 \n" +
                            				"\n--------------\n" +
                            				
                                            "(1) Show Movie list\n"+          
                                            "(2) Search Movie by movie ID\n"+
                                            "(3) Search Movie by movie name\n"+
                                            "(4) Add movie\n" +
                                            "(5) Remove movie\n"+
                                            "(-1) Leave this page\n");
		

		assertEquals(getOutput(), expectOutput);
	}
	
	@Test
	public void testDisplay2() {
		restoreData();

		String input="2\n1\n-1\n";
		System.setIn(new ByteArrayInputStream(input.getBytes()));

		PrintStream sysout = System.out;
		
		setOutput();
		MovieManagingPage movieManaging = new MovieManagingPage(new AdminConsole());
		movieManaging.display();
		
		String expectOutput = String.format("\n====Manage Movie====\n" + 
                                            "(1) Show Movie list\n"+          
                                            "(2) Search Movie by movie ID\n"+
                                            "(3) Search Movie by movie name\n"+
                                            "(4) Add movie\n"+
                                            "(5) Remove movie\n"+
                                            "(-1) Leave this page\n"+
                                            
                            				"Please enter movie ID: \n" + 
                            				"--------------------------\r\n" +
                            				"\tMovie ID: 1\n" +
                            				"\tName: Movie A\n" +
                            				"\tRelease Date %s\n" +
                            				"\tActor List: Actor A \n" +
                            				"\tDuration: 2.0\n" +
                            				"--------------------------\r\n" +                            				
                            				
                                            "(1) Show Movie list\n"+          
                                            "(2) Search Movie by movie ID\n"+
                                            "(3) Search Movie by movie name\n"+
                                            "(4) Add movie\n" +
                                            "(5) Remove movie\n"+
                                            "(-1) Leave this page\n"
											, DateTime.today());

		System.setOut(sysout);

		String out = getOutput();

		System.out.println(out);
		System.out.println(out.length());
		System.out.println(expectOutput);
		System.out.println(expectOutput.length());
		
		assertEquals(getOutput(), expectOutput);
	}
	
	@Test
	public void testDisplay3() {
		restoreData();

		String input="2\n10\n-1\n";
		System.setIn(new ByteArrayInputStream(input.getBytes()));
		
		setOutput();
		MovieManagingPage movieManaging = new MovieManagingPage(new AdminConsole());
		movieManaging.display();
		
		String expectOutput = String.format("\n====Manage Movie====\n" + 
                                            "(1) Show Movie list\n"+          
                                            "(2) Search Movie by movie ID\n"+
                                            "(3) Search Movie by movie name\n"+
                                            "(4) Add movie\n"+
                                            "(5) Remove movie\n"+
                                            "(-1) Leave this page\n"+
                                            
                            				"Please enter movie ID: \n" +                 
                            				"Cannot find the movie!\r\n" +  
                            				
                                            "(1) Show Movie list\n"+          
                                            "(2) Search Movie by movie ID\n"+
                                            "(3) Search Movie by movie name\n"+
                                            "(4) Add movie\n" +
                                            "(5) Remove movie\n"+
                                            "(-1) Leave this page\n");
		
		assertEquals(getOutput(), expectOutput);
	}
	
	@Test
	public void testDisplay4() {
		restoreData();

		String input="3\nMovie B\n-1\n";
		System.setIn(new ByteArrayInputStream(input.getBytes()));
		
		setOutput();
		MovieManagingPage movieManaging = new MovieManagingPage(new AdminConsole());
		movieManaging.display();
		
		String expectOutput = String.format("\n====Manage Movie====\n" + 
                                            "(1) Show Movie list\n"+          
                                            "(2) Search Movie by movie ID\n"+
                                            "(3) Search Movie by movie name\n"+
                                            "(4) Add movie\n"+
                                            "(5) Remove movie\n"+
                                            "(-1) Leave this page\n"+
                                            
                            				"Please enter movie name: \n" +                 
                            				"--------------------------\r\n" +
                            				"\tMovie ID: 2\n" +
                            				"\tName: Movie B\n" +
                            				"\tRelease Date %s\n" +
                            				"\tActor List: Actor B \n" +
                            				"\tDuration: 2.0\n" +
                            				"--------------------------\r\n" +  
                            				
                                            "(1) Show Movie list\n"+          
                                            "(2) Search Movie by movie ID\n"+
                                            "(3) Search Movie by movie name\n"+
                                            "(4) Add movie\n" +
                                            "(5) Remove movie\n"+
                                            "(-1) Leave this page\n"
											, DateTime.today());
		
		assertEquals(getOutput(), expectOutput);
	}
	
	@Test
	public void testDisplay5() {
		restoreData();

		String input="3\nI dont know\n-1\n";
		System.setIn(new ByteArrayInputStream(input.getBytes()));
		
		setOutput();
		MovieManagingPage movieManaging = new MovieManagingPage(new AdminConsole());
		movieManaging.display();
		
		String expectOutput = String.format("\n====Manage Movie====\n" + 
                                            "(1) Show Movie list\n"+          
                                            "(2) Search Movie by movie ID\n"+
                                            "(3) Search Movie by movie name\n"+
                                            "(4) Add movie\n"+
                                            "(5) Remove movie\n"+
                                            "(-1) Leave this page\n"+
                                            
                            				"Please enter movie name: \n" +                 
                            				"Cannot find the movie!\r\n" +  
                            				
                                            "(1) Show Movie list\n"+          
                                            "(2) Search Movie by movie ID\n"+
                                            "(3) Search Movie by movie name\n"+
                                            "(4) Add movie\n" +
                                            "(5) Remove movie\n"+
                                            "(-1) Leave this page\n");
		
		assertEquals(getOutput(), expectOutput);
	}
	
	@Test
	public void testDisplay6() {
		restoreData();

		String input="4\nMovie D\n2021\n10\n12\n2.3\nActor D\nActor E\nActor F\nDone\n3\nMovie D\n-1\n";
		System.setIn(new ByteArrayInputStream(input.getBytes()));
		
		setOutput();
		MovieManagingPage movieManaging = new MovieManagingPage(new AdminConsole());
		movieManaging.display();
		
		String expectOutput = String.format("\n====Manage Movie====\n" + 
                                            "(1) Show Movie list\n"+          
                                            "(2) Search Movie by movie ID\n"+
                                            "(3) Search Movie by movie name\n"+
                                            "(4) Add movie\n"+
                                            "(5) Remove movie\n"+
                                            "(-1) Leave this page\n"+
                                            
                            				"\n====Add Movie====\n\r\n" +                 
                            				"Enter -1 to quit this session\r\n" +  
                            				"Enter the movie name: " +
                            				"Enter the year of the release date: "+
                            				"Enter the month of the release date: " + 
                            				"Enter the day of the release date: " + 
                            				"Enter duration of the movie(in hour): " +
                            				"Enter the actor name. Enter Done to end the action.\r\n" +
                            				"Added a movie.\r\n" + 
                            				
                                            "(1) Show Movie list\n"+          
                                            "(2) Search Movie by movie ID\n"+
                                            "(3) Search Movie by movie name\n"+
                                            "(4) Add movie\n" +
                                            "(5) Remove movie\n"+
                                            "(-1) Leave this page\n"+
                            				
                            				"Please enter movie name: \n" +                 
                            				"--------------------------\r\n" +
                            				"\tMovie ID: 4\n" +
                            				"\tName: Movie D\n" +
                            				"\tRelease Date 2021-10-12 00:00\n" +
                            				"\tActor List: Actor D Actor E Actor F \n" +
                            				"\tDuration: 2.3\n" +
                            				"--------------------------\r\n" +  		
                            				
                                            "(1) Show Movie list\n"+          
                                            "(2) Search Movie by movie ID\n"+
                                            "(3) Search Movie by movie name\n"+
                                            "(4) Add movie\n" +
                                            "(5) Remove movie\n"+
                                            "(-1) Leave this page\n");
		
		assertEquals(getOutput(), expectOutput);
	}
	
	@Test
	public void testDisplay7() {
		restoreData();

		String input="4\n-1\n-1\n";
		System.setIn(new ByteArrayInputStream(input.getBytes()));
		
		setOutput();
		MovieManagingPage movieManaging = new MovieManagingPage(new AdminConsole());
		movieManaging.display();
		
		String expectOutput = String.format("\n====Manage Movie====\n" + 
                                            "(1) Show Movie list\n"+          
                                            "(2) Search Movie by movie ID\n"+
                                            "(3) Search Movie by movie name\n"+
                                            "(4) Add movie\n"+
                                            "(5) Remove movie\n"+
                                            "(-1) Leave this page\n"+
                                            
                            				"\n====Add Movie====\n\r\n" +                 
                            				"Enter -1 to quit this session\r\n" +  
                            				"Enter the movie name: " +
                            				
                                            "(1) Show Movie list\n"+          
                                            "(2) Search Movie by movie ID\n"+
                                            "(3) Search Movie by movie name\n"+
                                            "(4) Add movie\n" +
                                            "(5) Remove movie\n"+
                                            "(-1) Leave this page\n");
		
		assertEquals(getOutput(), expectOutput);
	}
	
	@Test
	public void testDisplay8() {
		restoreData();

		String input="4\nMovie E\n-1\n-1\n";
		System.setIn(new ByteArrayInputStream(input.getBytes()));
		
		setOutput();
		MovieManagingPage movieManaging = new MovieManagingPage(new AdminConsole());
		movieManaging.display();
		
		String expectOutput = String.format("\n====Manage Movie====\n" + 
                                            "(1) Show Movie list\n"+          
                                            "(2) Search Movie by movie ID\n"+
                                            "(3) Search Movie by movie name\n"+
                                            "(4) Add movie\n"+
                                            "(5) Remove movie\n"+
                                            "(-1) Leave this page\n"+
                                            
                            				"\n====Add Movie====\n\r\n" +                 
                            				"Enter -1 to quit this session\r\n" +  
                            				"Enter the movie name: " +
                            				"Enter the year of the release date: "+
                            				
                                            "(1) Show Movie list\n"+          
                                            "(2) Search Movie by movie ID\n"+
                                            "(3) Search Movie by movie name\n"+
                                            "(4) Add movie\n" +
                                            "(5) Remove movie\n"+
                                            "(-1) Leave this page\n");
		
		assertEquals(getOutput(), expectOutput);
	}
	
	@Test
	public void testDisplay9() {
		restoreData();

		String input="4\nMovie E\n2021\n-1\n-1\n";
		System.setIn(new ByteArrayInputStream(input.getBytes()));
		
		setOutput();
		MovieManagingPage movieManaging = new MovieManagingPage(new AdminConsole());
		movieManaging.display();
		
		String expectOutput = String.format("\n====Manage Movie====\n" + 
                                            "(1) Show Movie list\n"+          
                                            "(2) Search Movie by movie ID\n"+
                                            "(3) Search Movie by movie name\n"+
                                            "(4) Add movie\n"+
                                            "(5) Remove movie\n"+
                                            "(-1) Leave this page\n"+
                                            
                            				"\n====Add Movie====\n\r\n" +                 
                            				"Enter -1 to quit this session\r\n" +  
                            				"Enter the movie name: " +
                            				"Enter the year of the release date: "+
                            				"Enter the month of the release date: " + 
                            				
                                            "(1) Show Movie list\n"+          
                                            "(2) Search Movie by movie ID\n"+
                                            "(3) Search Movie by movie name\n"+
                                            "(4) Add movie\n" +
                                            "(5) Remove movie\n"+
                                            "(-1) Leave this page\n");
		
		assertEquals(getOutput(), expectOutput);
	}
	
	@Test
	public void testDisplay10() {
		restoreData();

		String input="4\nMovie E\n2021\n10\n-1\n-1\n";
		System.setIn(new ByteArrayInputStream(input.getBytes()));
		
		setOutput();
		MovieManagingPage movieManaging = new MovieManagingPage(new AdminConsole());
		movieManaging.display();
		
		String expectOutput = String.format("\n====Manage Movie====\n" + 
                                            "(1) Show Movie list\n"+          
                                            "(2) Search Movie by movie ID\n"+
                                            "(3) Search Movie by movie name\n"+
                                            "(4) Add movie\n"+
                                            "(5) Remove movie\n"+
                                            "(-1) Leave this page\n"+
                                            
                            				"\n====Add Movie====\n\r\n" +                 
                            				"Enter -1 to quit this session\r\n" +  
                            				"Enter the movie name: " +
                            				"Enter the year of the release date: "+
                            				"Enter the month of the release date: " + 
                            				"Enter the day of the release date: " + 
                            				
                                            "(1) Show Movie list\n"+          
                                            "(2) Search Movie by movie ID\n"+
                                            "(3) Search Movie by movie name\n"+
                                            "(4) Add movie\n" +
                                            "(5) Remove movie\n"+
                                            "(-1) Leave this page\n");
		
		assertEquals(getOutput(), expectOutput);
	}
	
	@Test
	public void testDisplay11() {
		restoreData();

		String input="4\nMovie E\n2021\n10\n12\n-1.0\n-1\n";
		System.setIn(new ByteArrayInputStream(input.getBytes()));
		
		setOutput();
		MovieManagingPage movieManaging = new MovieManagingPage(new AdminConsole());
		movieManaging.display();
		
		String expectOutput = String.format("\n====Manage Movie====\n" + 
                                            "(1) Show Movie list\n"+          
                                            "(2) Search Movie by movie ID\n"+
                                            "(3) Search Movie by movie name\n"+
                                            "(4) Add movie\n"+
                                            "(5) Remove movie\n"+
                                            "(-1) Leave this page\n"+
                                            
                            				"\n====Add Movie====\n\r\n" +                 
                            				"Enter -1 to quit this session\r\n" +  
                            				"Enter the movie name: " +
                            				"Enter the year of the release date: "+
                            				"Enter the month of the release date: " + 
                            				"Enter the day of the release date: " + 
                            				"Enter duration of the movie(in hour): " +
                            				
                                            "(1) Show Movie list\n"+          
                                            "(2) Search Movie by movie ID\n"+
                                            "(3) Search Movie by movie name\n"+
                                            "(4) Add movie\n" +
                                            "(5) Remove movie\n"+
                                            "(-1) Leave this page\n");
		
		assertEquals(getOutput(), expectOutput);
	}
	
	@Test
	public void testDisplay12() {
		restoreData();

		String input="5\n1\n1\n-1\n";
		System.setIn(new ByteArrayInputStream(input.getBytes()));
		
		setOutput();
		MovieManagingPage movieManaging = new MovieManagingPage(new AdminConsole());
		movieManaging.display();
		
		String expectOutput = String.format("\n====Manage Movie====\n" + 
                                            "(1) Show Movie list\n"+          
                                            "(2) Search Movie by movie ID\n"+
                                            "(3) Search Movie by movie name\n"+
                                            "(4) Add movie\n"+
                                            "(5) Remove movie\n"+
                                            "(-1) Leave this page\n"+
                                            
                                            "\n====Remove Movie====\n\r\n" +
                                            "Enter 1 to remove movie by Id and 2 to remove movie by name\r\n"+
                                            "Enter movie ID (Enter -1 to end this session): "+
                                            "Remove the movie.\r\n"+
                                            
                                            "(1) Show Movie list\n"+          
                                            "(2) Search Movie by movie ID\n"+
                                            "(3) Search Movie by movie name\n"+
                                            "(4) Add movie\n"+
                                            "(5) Remove movie\n"+
                                            "(-1) Leave this page\n");
		
		assertEquals(getOutput(), expectOutput);
	}
	
	@Test
	public void testDisplay13() {
		restoreData();

		String input="5\n1\n10\n-1\n";
		System.setIn(new ByteArrayInputStream(input.getBytes()));
		
		setOutput();
		MovieManagingPage movieManaging = new MovieManagingPage(new AdminConsole());
		movieManaging.display();
		
		String expectOutput = String.format("\n====Manage Movie====\n" + 
                                            "(1) Show Movie list\n"+          
                                            "(2) Search Movie by movie ID\n"+
                                            "(3) Search Movie by movie name\n"+
                                            "(4) Add movie\n"+
                                            "(5) Remove movie\n"+
                                            "(-1) Leave this page\n"+
                                            
                                            "\n====Remove Movie====\n\r\n" +
                                            "Enter 1 to remove movie by Id and 2 to remove movie by name\r\n"+
                                            "Enter movie ID (Enter -1 to end this session): "+
                                            "The movie does not exist!\r\n"+
                                            
                                            "(1) Show Movie list\n"+          
                                            "(2) Search Movie by movie ID\n"+
                                            "(3) Search Movie by movie name\n"+
                                            "(4) Add movie\n"+
                                            "(5) Remove movie\n"+
                                            "(-1) Leave this page\n");
		
		assertEquals(getOutput(), expectOutput);
	}
	
	@Test
	public void testDisplay14() {
		restoreData();

		String input="5\n2\nMovie C\n-1\n";
		System.setIn(new ByteArrayInputStream(input.getBytes()));
		
		setOutput();
		MovieManagingPage movieManaging = new MovieManagingPage(new AdminConsole());
		movieManaging.display();
		
		String expectOutput = String.format("\n====Manage Movie====\n" + 
                                            "(1) Show Movie list\n"+          
                                            "(2) Search Movie by movie ID\n"+
                                            "(3) Search Movie by movie name\n"+
                                            "(4) Add movie\n"+
                                            "(5) Remove movie\n"+
                                            "(-1) Leave this page\n"+
                                            
                                            "\n====Remove Movie====\n\r\n" +
                                            "Enter 1 to remove movie by Id and 2 to remove movie by name\r\n"+
                                            "Enter movie Name (Enter Exit to end this session): "+
                                            "Remove the movie.\r\n"+
                                            
                                            "(1) Show Movie list\n"+          
                                            "(2) Search Movie by movie ID\n"+
                                            "(3) Search Movie by movie name\n"+
                                            "(4) Add movie\n"+
                                            "(5) Remove movie\n"+
                                            "(-1) Leave this page\n");
		
		assertEquals(getOutput(), expectOutput);
	}

	@Test
	public void testDisplay15() {
		restoreData();

		String input="5\n2\nMovie AAA\n-1\n";
		System.setIn(new ByteArrayInputStream(input.getBytes()));
		
		setOutput();
		MovieManagingPage movieManaging = new MovieManagingPage(new AdminConsole());
		movieManaging.display();
		
		String expectOutput = String.format("\n====Manage Movie====\n" + 
                                            "(1) Show Movie list\n"+          
                                            "(2) Search Movie by movie ID\n"+
                                            "(3) Search Movie by movie name\n"+
                                            "(4) Add movie\n"+
                                            "(5) Remove movie\n"+
                                            "(-1) Leave this page\n"+
                                            
                                            "\n====Remove Movie====\n\r\n" +
                                            "Enter 1 to remove movie by Id and 2 to remove movie by name\r\n"+
                                            "Enter movie Name (Enter Exit to end this session): "+
                                            "The movie does not exist!\r\n"+
                                            
                                            "(1) Show Movie list\n"+          
                                            "(2) Search Movie by movie ID\n"+
                                            "(3) Search Movie by movie name\n"+
                                            "(4) Add movie\n"+
                                            "(5) Remove movie\n"+
                                            "(-1) Leave this page\n");
		
		assertEquals(getOutput(), expectOutput);
	}


	@Test
	public void testInvalidInput() {
		restoreData();

		String input="0\n-1\n";
		System.setIn(new ByteArrayInputStream(input.getBytes()));
		
		setOutput();
		MovieManagingPage movieManaging = new MovieManagingPage(new AdminConsole());
		movieManaging.display();
		
		String expectOutput = String.format("\n====Manage Movie====\n" + 
                                            "(1) Show Movie list\n"+          
                                            "(2) Search Movie by movie ID\n"+
                                            "(3) Search Movie by movie name\n"+
                                            "(4) Add movie\n"+
                                            "(5) Remove movie\n"+
                                            "(-1) Leave this page\n"+

											"invalid input!\r\n"+
                                            
                                            "(1) Show Movie list\n"+          
                                            "(2) Search Movie by movie ID\n"+
                                            "(3) Search Movie by movie name\n"+
                                            "(4) Add movie\n"+
                                            "(5) Remove movie\n"+
                                            "(-1) Leave this page\n");
		
		assertEquals(getOutput(), expectOutput);
	}
}
