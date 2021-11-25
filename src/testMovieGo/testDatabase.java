package testMovieGo;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;


import obj.*;
import java.util.*;
public class testDatabase {

	@Test
	public void testGetCinemaList() {
		
		
		CinemaManageAction cManageAction=new CinemaManageAction(Admin.getInstance());
		Database dbInstance=Database.connectDB(cManageAction);
		ArrayList<Cinema> resArrayList=dbInstance.getCinemaList();
		cManageAction.removeCinema(1);
		
		ArrayList<Cinema> expArrayList=new ArrayList<>();
	
	
		assertEquals(expArrayList, resArrayList);
	}
	@Test
	public void testGetMovieList() {
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
		MovieSessionManageAction cManageAction=new MovieSessionManageAction(Admin.getInstance());
		
		
		
		Database dbInstance=Database.connectDB(cManageAction);	
		cManageAction.removeMovieSessionById(1);
		ArrayList<MovieSession> resArrayList=dbInstance.getMovieSessionList();
	
		ArrayList<MovieSession> expArrayList=new ArrayList<>();
	
	
		assertEquals(expArrayList, resArrayList);
	}
	@Test
	public void testGetPurchaseHistoryList() {
		
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
