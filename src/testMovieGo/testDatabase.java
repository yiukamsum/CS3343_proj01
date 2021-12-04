package testMovieGo;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;


import obj.*;
import java.util.*;
public class testDatabase {

	private void restoreData() {
		getCinemaAction cinemaAction 			= new getCinemaAction();
		getMovieAction movieAction 				= new getMovieAction();
		getMovieSessionAction sessionAction 	= new getMovieSessionAction();
		HistoryManageAction historyManageAction = new HistoryManageAction();

		ArrayList<Cinema> cinemaList = cinemaAction.getCinemaList();
		ArrayList<Movie> movieList = movieAction.getMovieList();
		ArrayList<MovieSession> sessionList = sessionAction.getMovieSession();
		ArrayList<PurchaseHistory> historyList = historyManageAction.getHistory();

		cinemaList.clear();
        Cinema cinema = new Cinema(1, "loc A", "Cinema A", "12345678");
        cinema.addTheatre(new Theatre(1, 5, 5));
        cinemaList.add(cinema);

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

        sessionList.clear();
        sessionList.add(
            new MovieSession(1, cinemaList.get(0), cinemaList.get(0).getTheatre(1), movieList.get(0), DateTime.now())
        );

        historyList.clear();
	}

	@Test
	public void testGetCinemaList() {
		restoreData();
		
		CinemaManageAction cManageAction=new CinemaManageAction(Admin.getInstance());
		Database dbInstance=Database.connectDB(cManageAction);
		ArrayList<Cinema> resArrayList=dbInstance.getCinemaList();
		cManageAction.removeCinema(1);
		
		ArrayList<Cinema> expArrayList=new ArrayList<>();
	
	
		assertEquals(expArrayList, resArrayList);
	}
	@Test
	public void testGetMovieList() {
		restoreData();

		MovieManageAction cManageAction=new MovieManageAction(Admin.getInstance());
		

		Database dbInstance=Database.connectDB(cManageAction);		
		cManageAction.removeMovieByID(3);
		cManageAction.removeMovieByID(2);
		cManageAction.removeMovieByID(1);
		ArrayList<Movie> resArrayList=dbInstance.getMovieList();
			

	

		ArrayList<Movie> expArrayList=new ArrayList<>();
	
	
		assertEquals(expArrayList, resArrayList);
	}
	
	@Test
	public void testGetMovieSessionList() {
		restoreData();

		MovieSessionManageAction cManageAction=new MovieSessionManageAction(Admin.getInstance());
		
		
		
		Database dbInstance=Database.connectDB(cManageAction);	
		cManageAction.removeMovieSessionById(1);
		ArrayList<MovieSession> resArrayList=dbInstance.getMovieSessionList();
	
		ArrayList<MovieSession> expArrayList=new ArrayList<>();
	
	
		assertEquals(expArrayList, resArrayList);
	}
	@Test
	public void testGetPurchaseHistoryList() {
		restoreData();
		
		Database dbInstanceDatabase=Database.connectDB(new CinemaManageAction(Admin.getInstance()));
		ArrayList<PurchaseHistory> resArrayList=dbInstanceDatabase.getPurchaseHistoryList();
		
	

		ArrayList<PurchaseHistory> expArrayList=new ArrayList<>();
	
	
		assertEquals(expArrayList, resArrayList);
	}
	@Test
	public void testGetMember() {
		
		Database dbInstanceDatabase=Database.connectDB(new CinemaManageAction(Admin.getInstance()));
		Member resMember=dbInstanceDatabase.getMember("Peter", "123");
		String resMemberEmail =  resMember.getEmail();
	

		String expMemberEmail="123@gmail.com";
	
	
		assertEquals(expMemberEmail, resMemberEmail);
	}
	@Test
	public void testGetAdmin() {
		
		Database dbInstanceDatabase=Database.connectDB(new CinemaManageAction(Admin.getInstance()));
		Admin resAdmin=dbInstanceDatabase.getAdmin("Peter", "123");


		Admin expAdmin=null;
	
		assertEquals(expAdmin, resAdmin);
	}
	@Test
	public void testGetAdmin2() {
		
		Database dbInstanceDatabase=Database.connectDB(new CinemaManageAction(Admin.getInstance()));
		Admin resAdmin=dbInstanceDatabase.getAdmin("Jack", "123");


		Admin expAdmin=Admin.getInstance();
	
		assertEquals(expAdmin, resAdmin);
	}
}
