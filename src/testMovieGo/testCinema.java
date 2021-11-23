package testMovieGo;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import org.junit.Test;
import obj.Cinema;
import obj.Theatre;


public class testCinema {

	@Test
	public void testGetName() {
		Cinema c= new Cinema(1,"Mong Kok","Happy Cinema","91234567");
		String cinemaName=c.getName();
		assertEquals("Happy Cinema",cinemaName);
	}
	@Test
	public void testGetCinemaID() {
		Cinema c= new Cinema(1,"Mong Kok","Happy Cinema","91234567");
		int cinemaID=c.getCinemaID();
		assertEquals(1,cinemaID);
	}
	@Test
	public void testGetTheatreSize() {
		Cinema c= new Cinema(1,"Mong Kok","Happy Cinema","91234567");
		int theatreSize=c.getTheatreSize();
		assertEquals(0,theatreSize);
	}
	@Test
	public void testGetTheatre() {
		Cinema c= new Cinema(1,"Mong Kok","Happy Cinema","91234567");
		Theatre t=c.getTheatre(1);
		assertEquals(null,t);
	}
	@Test
	public void testGetTheatre2() {
		Cinema c= new Cinema(1,"Mong Kok","Happy Cinema","91234567");
		Theatre t1= new Theatre(1,3,4);
		Theatre t2= new Theatre(2,4,4);
		Theatre t3= new Theatre(3,3,4);
		Theatre t4= new Theatre(4,4,4);
		Theatre t5= new Theatre(5,3,4);
		Theatre t6= new Theatre(6,4,4);
		
		c.addTheatre(t1);
		c.addTheatre(t2);
		c.addTheatre(t3);
		c.addTheatre(t4);
		c.addTheatre(t5);
		c.addTheatre(t6);
		Theatre res=c.getTheatre(5);
		
	
		assertEquals(t5,res);
	}

	@Test
	public void testAddTheatre1() {
		Cinema c= new Cinema(1,"Mong Kok","Happy Cinema","91234567");
		Theatre t1= new Theatre(1,3,4);
		c.addTheatre(t1);
		c.addTheatre(t1);
		
		ArrayList<Theatre> resArrayList=c.getTheatraList();
		
		ArrayList<Theatre> expectedArrayList=new ArrayList<>();
		expectedArrayList.add(t1);
		assertEquals(expectedArrayList,resArrayList);
	}

	@Test
	public void testAddTheatre2() {
		Cinema c= new Cinema(1,"Mong Kok","Happy Cinema","91234567");
		Theatre t1= new Theatre(1,3,4);
		Theatre t2= new Theatre(2,4,4);
		
		c.addTheatre(t1);
		c.addTheatre(t2);
		
		ArrayList<Theatre> resArrayList=c.getTheatraList();
		
		ArrayList<Theatre> expectedArrayList=new ArrayList<>();
		expectedArrayList.add(t1);
		expectedArrayList.add(t2);
		assertEquals(expectedArrayList,resArrayList);
	}
	@Test
	public void testAddTheatre3() {
		Cinema c= new Cinema(1,"Mong Kok","Happy Cinema","91234567");	
		Theatre t1= new Theatre(3,4,4);
		Theatre t2= new Theatre(1,3,4);
		Theatre t3= new Theatre(2,4,4);
		Theatre t4= new Theatre(6,3,4);
		Theatre t5= new Theatre(7,4,4);
		Theatre t6= new Theatre(4,3,4);
		
		
		c.addTheatre(t1);
		c.addTheatre(t2);
		c.addTheatre(t3);
		c.addTheatre(t4);
		c.addTheatre(t5);
		c.addTheatre(t6);
		ArrayList<Theatre> resArrayList=c.getTheatraList();
		
		ArrayList<Theatre> expectedArrayList=new ArrayList<>();
		expectedArrayList.add(t2);
		expectedArrayList.add(t3);
		expectedArrayList.add(t1);
		expectedArrayList.add(t6);
		expectedArrayList.add(t4);
		expectedArrayList.add(t5);
		assertEquals(expectedArrayList,resArrayList);
	}
	@Test
	public void testAddTheatre4() {
		Cinema c= new Cinema(1,"Mong Kok","Happy Cinema","91234567");
		Theatre t1= new Theatre(1,3,4);
		Theatre t2= new Theatre(1,4,4);
		
		c.addTheatre(t1);
		c.addTheatre(t2);
		
		ArrayList<Theatre> resArrayList=c.getTheatraList();
		
		ArrayList<Theatre> expectedArrayList=new ArrayList<>();
		expectedArrayList.add(t1);
		assertEquals(expectedArrayList,resArrayList);
	}

	@Test
	public void testRemoveTheatre1() {
		ByteArrayOutputStream stream=new ByteArrayOutputStream();
		PrintStream printStream=new PrintStream(stream);
		System.setOut(printStream);
		
		Cinema c= new Cinema(1,"Mong Kok","Happy Cinema","91234567");
		Theatre t1= new Theatre(1,3,4);
		Theatre t2= new Theatre(2,4,4);
		
		c.addTheatre(t1);
		c.addTheatre(t2);
		c.removeTheatre(t2);
		
		assertEquals("Remove a theatre.",stream.toString().trim());
	}
	@Test
	public void testRemoveTheatre2() {
		ByteArrayOutputStream stream=new ByteArrayOutputStream();
		PrintStream printStream=new PrintStream(stream);
		System.setOut(printStream);
		Cinema c= new Cinema(1,"Mong Kok","Happy Cinema","91234567");
		Theatre t1= new Theatre(1,3,4);
		Theatre t2= new Theatre(2,4,4);
		
		c.addTheatre(t1);
		c.addTheatre(t2);
		Theatre t3 =new Theatre(3,4, 4);
		c.removeTheatre(t3);
		
		

		assertEquals("Cannot Find the theatre!",stream.toString().trim());
	}
	@Test
	public void testRemoveTheatre3() {
		ByteArrayOutputStream stream=new ByteArrayOutputStream();
		PrintStream printStream=new PrintStream(stream);
		System.setOut(printStream);
		Cinema c= new Cinema(1,"Mong Kok","Happy Cinema","91234567");
		Theatre t1= new Theatre(1,3,4);

		c.removeTheatre(t1);
		
		assertEquals("Cannot Find the theatre!",stream.toString().trim());
	}
	@Test
	public void testcompareTo() {
		Cinema c1= new Cinema(1,"Mong Kok","Happy Cinema","91234567");
		Cinema c2= new Cinema(2,"Prince Edward","ABC Cinema","98765432");


		int res=c1.compareTo(c2);
		
	
		assertEquals(-1,res);
	}
	@Test
	public void testToCatalogItemString() {
		Cinema c1= new Cinema(1,"Mong Kok","Happy Cinema","91234567");



		String res=c1.toCatalogItemString();
		String expectedString="\tCinema ID: \t1\n"+
				"\tCinema Name: \tHappy Cinema\n"+
				"\tLocation: \tMong Kok\n"+
				"\tPhone Number: \t91234567\n";
		
	
		assertEquals(expectedString,res);
	}
	
}
