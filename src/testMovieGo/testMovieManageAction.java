package testMovieGo;

import static org.junit.Assert.*;

import org.junit.Test;

import java.io.ByteArrayOutputStream;

import java.io.PrintStream;

import java.util.ArrayList;

import obj.*;

public class testMovieManageAction{
			
	private PrintStream output;
	private ByteArrayOutputStream outputContent;
	
	public void setOutput() {
		output = System.out;
		outputContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outputContent));
		
	}
	
	public String getOutput() {
		System.setOut(output);
		return outputContent.toString().trim();
	}
	
	@Test
	public void testGetMovieList() {
		getMovieAction movieAction = new getMovieAction();
		MovieManageAction movieManage = new MovieManageAction(Admin.getInstance());
		
		
        ArrayList<Movie>movieList = Database.connectDB(movieAction).getMovieList();    
        ArrayList<Movie> result = movieManage.getMovieList();
        assertEquals(movieList, result);
        
	}
	
	@Test
	public void testAddMovie1() {
		setOutput();
		MovieManageAction movieManage = new MovieManageAction(Admin.getInstance());
		DateTime releaseDate = new DateTime(2021,1,1);
		ArrayList<String>actorList = new ArrayList<String>();
		movieManage.addMovie("Movie 2", releaseDate, 2.0, actorList);
		
		assertEquals(getOutput(), "Added a movie.");
			
	}
	
	@Test
	public void testAddMovie2() {
		setOutput();
		MovieManageAction movieManage = new MovieManageAction(Admin.getInstance());
		DateTime releaseDate = new DateTime(2021,1,1);
		ArrayList<String>actorList = new ArrayList<String>();
		movieManage.addMovie("Movie A", releaseDate, 15, actorList);
		
		assertEquals(getOutput(), "The movie is already existed!");		
	}
	
	@Test
	public void testRemoveMovieByID1() {
		setOutput();
		MovieManageAction movieManage = new MovieManageAction(Admin.getInstance());
		movieManage.removeMovieByID(10);
		assertEquals(getOutput(), "The movie does not exist!");
	}
	
	@Test
	public void testRemoveMovieByID2() {
		setOutput();
		MovieManageAction movieManage = new MovieManageAction(Admin.getInstance());
		movieManage.removeMovieByID(2);
		assertEquals(getOutput(), "Remove the movie.");
	}
	
	@Test
	public void testRemoveMovieByName1() {
		setOutput();
		MovieManageAction movieManage = new MovieManageAction(Admin.getInstance());
		movieManage.removeMovieByName("Name1");
		assertEquals(getOutput(), "The movie does not exist!");
	}
	
	@Test
	public void testRemoveMovieByName2() {
		setOutput();
		MovieManageAction movieManage = new MovieManageAction(Admin.getInstance());
		movieManage.removeMovieByName("Movie C");
		assertEquals(getOutput(), "Remove the movie.");
	}
}
