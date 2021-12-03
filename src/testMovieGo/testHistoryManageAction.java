package testMovieGo;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import obj.Adult;
import obj.Cinema;
import obj.Database;
import obj.DateTime;
import obj.HistoryManageAction;
import obj.Member;
import obj.Movie;
import obj.MovieSession;
import obj.PurchaseHistory;
import obj.Theatre;
import obj.Ticket;

class testHistoryManageAction {

	@Test
	void test1() {
		
		
		HistoryManageAction test = new HistoryManageAction();
		Database  dbInstance=Database.connectDB(test);
		
		ArrayList<String> actorList = new ArrayList<String>();
		actorList.add("Actor A");
		MovieSession selectSession = new MovieSession(1, new Cinema(1, "loc A", "Cinema A", "12345678"), new Theatre(1, 5, 5) , new Movie(1, "Movie A", new DateTime(2021, 11, 23, 11, 11), 2.0, actorList), DateTime.today());
		
		PurchaseHistory res = new PurchaseHistory(1, new Member(1, "Aaron", "123@gmail.com", "123"), new Ticket(Adult.getInstance(), selectSession, "A0"), new DateTime(2021, 11, 23, 11, 11));
		
		test.addHistory(res);	
		
		assertEquals(true,dbInstance.getPurchaseHistoryList().contains(res));
	}

	
	@Test
	void test2() {
		
		
		HistoryManageAction test = new HistoryManageAction();
		Database  dbInstance=Database.connectDB(test);
		
		ArrayList<String> actorList = new ArrayList<String>();
		actorList.add("Actor A");
		MovieSession selectSession = new MovieSession(1, new Cinema(1, "loc A", "Cinema A", "12345678"), new Theatre(1, 5, 5) , new Movie(1, "Movie A", new DateTime(2021, 11, 23, 11, 11), 2.0, actorList), DateTime.today());
		
		PurchaseHistory res = new PurchaseHistory(1, new Member(3, "Aaron", "123@gmail.com", "123"), new Ticket(Adult.getInstance(), selectSession, "A0"), new DateTime(2021, 11, 23, 11, 11));
		
		int ans = test.getNextHistoryID(1);	
		
		assertEquals(2,ans);
	}
	
	@Test
	void test3() {
		
		
		HistoryManageAction test = new HistoryManageAction();
		Database  dbInstance=Database.connectDB(test);
		
		ArrayList<String> actorList = new ArrayList<String>();
		actorList.add("Actor A");
		MovieSession selectSession = new MovieSession(1, new Cinema(1, "loc A", "Cinema A", "12345678"), new Theatre(1, 5, 5) , new Movie(1, "Movie A", new DateTime(2021, 11, 23, 11, 11), 2.0, actorList), DateTime.today());
		
		PurchaseHistory res = new PurchaseHistory(1, new Member(3, "Aaron", "123@gmail.com", "123"), new Ticket(Adult.getInstance(), selectSession, "A0"), new DateTime(2021, 11, 23, 11, 11));
		
		//test.getHistory();	
		
		assertEquals(dbInstance.getPurchaseHistoryList(),test.getHistory());
	}
	
//	@Test
//	void test4() {
//		
//		
//		HistoryManageAction test = new HistoryManageAction();
//		Database  dbInstance=Database.connectDB(test);
//		
//		ArrayList<String> actorList = new ArrayList<String>();
//		actorList.add("Actor A");
//		MovieSession selectSession = new MovieSession(1, new Cinema(1, "loc A", "Cinema A", "12345678"), new Theatre(1, 5, 5) , new Movie(1, "Movie A", new DateTime(2021, 11, 23, 11, 11), 2.0, actorList), DateTime.today());
//		
//		PurchaseHistory res = new PurchaseHistory(1, new Member(3, "Aaron", "123@gmail.com", "123"), new Ticket(new Adult(), selectSession, "A0"), new DateTime(2021, 11, 23, 11, 11));
//		
//		ArrayList<PurchaseHistory> memberHistory = new ArrayList<>();
//		
//		memberHistory.add(res);
//		//test.getHistory();	
//		//test.addHistory(res);	
//		
//		assertEquals(memberHistory,test.getHistory(3));
//	}
}
