package testMovieGo;
import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;



import obj.*;


public class testCinemaManageAction {

	private void restoreData() {
		getCinemaAction action = new getCinemaAction();
		ArrayList<Cinema> cinemaList = action.getCinemaList();

		cinemaList.clear();

        Cinema cinema = new Cinema(1, "loc A", "Cinema A", "12345678");
        cinema.addTheatre(new Theatre(1, 5, 5));
        cinemaList.add(cinema);
	}	

	
	@Test

	public void testCreateCinemaRecord() {
		restoreData();

		CinemaManageAction cManageAction=new CinemaManageAction(Admin.getInstance());
		Database  dbInstance=Database.connectDB(cManageAction);
		
		Theatre t1=new Theatre(1,3,4);
		ArrayList<Theatre> threatreArrayList= new ArrayList<>();
		threatreArrayList.add(t1);
		Cinema newAddedCinema= cManageAction.createCinemaRecord("Happy Cinema", "Mong Kok", "91234567",threatreArrayList);
		
		
		assertEquals(true,dbInstance.getCinemaList().contains(newAddedCinema));
	}
	
	@Test

	public void testRemoveCinema() {
		restoreData();

		CinemaManageAction cManageAction=new CinemaManageAction(Admin.getInstance());
		Database dbInstance=Database.connectDB(cManageAction);
		
		Theatre t1=new Theatre(1,3,4);
		ArrayList<Theatre> threatreArrayList= new ArrayList<>();
		threatreArrayList.add(t1);
		Cinema newAddedCinema= cManageAction.createCinemaRecord("Happy Cinema", "Mong Kok", "91234567",threatreArrayList);
		
		cManageAction.removeCinema(2);
		
		assertEquals(false,dbInstance.getCinemaList().contains(newAddedCinema));
	}
	
	@Test

	public void testAddTheatre() {
		restoreData();

		CinemaManageAction cManageAction=new CinemaManageAction(Admin.getInstance());
		Database dbInstance=Database.connectDB(cManageAction);
		
		Theatre t1=new Theatre(1,3,4);
		ArrayList<Theatre> threatreArrayList= new ArrayList<>();
		threatreArrayList.add(t1);
		Cinema newAddedCinema= cManageAction.createCinemaRecord("Happy Cinema", "Mong Kok", "91234567",threatreArrayList);
		
		Theatre t2=new Theatre(2,4,4);
		cManageAction.addTheatre(2,t2 );
		
		assertEquals(t2,dbInstance.getCinemaList().get(1).getTheatre(2));
	}
	
	@Test

	public void testRemoveTheatre() {
		restoreData();

		CinemaManageAction cManageAction=new CinemaManageAction(Admin.getInstance());
		Database dbInstance=Database.connectDB(cManageAction);
		
		Theatre t1=new Theatre(1,3,4);
		ArrayList<Theatre> threatreArrayList= new ArrayList<>();
		threatreArrayList.add(t1);
		Cinema newAddedCinema= cManageAction.createCinemaRecord("Happy Cinema", "Mong Kok", "91234567",threatreArrayList);
		
		Theatre t2=new Theatre(2,4,4);
		cManageAction.addTheatre(3, t2);
		
		cManageAction.removeTheatre(3, t2);

		assertEquals(2,dbInstance.getCinemaList().size());
	}
	@Test

	public void testRemoveTheatre2() {
		restoreData();

		ByteArrayOutputStream stream=new ByteArrayOutputStream();
		PrintStream printStream=new PrintStream(stream);
		System.setOut(printStream);
		
		CinemaManageAction cManageAction=new CinemaManageAction(Admin.getInstance());
		Database dbInstance=Database.connectDB(cManageAction);
		
		Theatre t1=new Theatre(1,3,4);


		cManageAction.removeTheatre(93, t1);
		assertEquals("Cannot find the cinema!",stream.toString().trim());
	}


	@Test

	public void testAddTheatre2() {
		restoreData();

		ByteArrayOutputStream stream=new ByteArrayOutputStream();
		PrintStream printStream=new PrintStream(stream);
		System.setOut(printStream);
		
		CinemaManageAction cManageAction=new CinemaManageAction(Admin.getInstance());
		Database dbInstance=Database.connectDB(cManageAction);
		
		Theatre t1=new Theatre(1,3,4);


		cManageAction.addTheatre(93, t1);
		assertEquals("Cannot find the cinema!",stream.toString().trim());
	}

}
