package testMovieGo;

import static org.junit.Assert.*;

import org.junit.Test;

import java.util.ArrayList;

import obj.*;

public class testMovie {
	
	@Test
	public void testGetName() {
		DateTime releaseDate = new DateTime(2021, 11, 23);
		ArrayList<String> actorList = new ArrayList<String>();
		Movie movie = new Movie(1, "Movie name 1", releaseDate, 2.21, actorList);
		String name = movie.getName();
		assertEquals(name, "Movie name 1");
	}
	
	@Test
	public void testGetMovieID() {
		DateTime releaseDate = new DateTime(2021, 11, 23);
		ArrayList<String> actorList = new ArrayList<String>();
		Movie movie = new Movie(3, "Movie name 1", releaseDate, 1.30, actorList);
		int movieID = movie.getMovieID();
		assertEquals(movieID, 3);
	}
	
	@Test
	public void testGetDuration() {
		DateTime releaseDate = new DateTime(2021, 11, 23);
		ArrayList<String> actorList = new ArrayList<String>();
		Movie movie = new Movie(1, "Movie name 1", releaseDate, 2.32, actorList);
		double duration = movie.getDuration();
		
		assertEquals(duration, 2.32, 0);
	}
	
	@Test
	public void testToCatalogItemString() {
		DateTime releaseDate = new DateTime(2021, 10, 24);
		ArrayList<String> actorList = new ArrayList<String>();
		
		actorList.add("Anna");
		actorList.add("Ben");
		actorList.add("Sam");
		actorList.add("Simon");
		actorList.add("Harry");
		
		Movie movie = new Movie(3, "Movie name 4", releaseDate, 2.00, actorList);
		String result = movie.toCatalogItemString();
		String expectation = String.format("\tMovie ID: 3\n" +
				                           "\tName: Movie name 4\n" +
				                           "\tRelease Date: 2021-10-24\n" +
				                           "\tActor List:Anna Ben Sam Simon Harry\n" +
				                           "\ttDuration: 2.00");
		
		assertEquals(result, expectation);
	}
	
	@Test
	public void testCompareTo() {
		DateTime releaseDate1 = new DateTime(2021, 11, 23);
		ArrayList<String> actorList1 = new ArrayList<String>();
		Movie movie1 = new Movie(1, "Movie name 1", releaseDate1, 1.30, actorList1);
		
		DateTime releaseDate2 = new DateTime(2021, 11, 23);
		ArrayList<String> actorList2 = new ArrayList<String>();
		Movie movie2 = new Movie(2, "Movie name 1", releaseDate2, 2.00, actorList2);
		
		int result = movie1.compareTo(movie2);

		assertEquals(result ,-1);
	}

}
