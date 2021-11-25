package testMovieGo;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import obj.Adult;
import obj.Cinema;
import obj.DateTime;
import obj.Member;
import obj.Movie;
import obj.MovieSession;
import obj.PurchaseHistory;
import obj.Theatre;
import obj.Ticket;

class testPurchaseHistory {

	@Test
	public void test1() {	
		
		ArrayList<String> actorList = new ArrayList<String>();
		actorList.add("Actor A");
		MovieSession selectSession = new MovieSession(1, new Cinema(1, "loc A", "Cinema A", "12345678"), new Theatre(1, 5, 5) , new Movie(1, "Movie A", new DateTime(2021, 11, 23, 11, 11), 2.0, actorList), DateTime.today());
		
		//PurchaseHistory res = new PurchaseHistory(1, new Member(1, "Aaron", "123@gmail.com", "123"), new Ticket(new Adult(), selectSession, "A0"), new DateTime(2021, 11, 23, 11, 11));
		
		PurchaseHistory test = new PurchaseHistory(1, new Member(1, "Aaron", "123@gmail.com", "123"), new Ticket(Adult.getInstance(), selectSession, "A0"), new DateTime(2021, 11, 23, 11, 11));
		
		int res = test.getHistoryID();

		assertEquals(1, res);		
	}
	
	@Test
	public void test2() {	
		
		ArrayList<String> actorList = new ArrayList<String>();
		actorList.add("Actor A");
		MovieSession selectSession = new MovieSession(1, new Cinema(1, "loc A", "Cinema A", "12345678"), new Theatre(1, 5, 5) , new Movie(1, "Movie A", new DateTime(2021, 11, 23, 11, 11), 2.0, actorList), DateTime.today());
		
		//PurchaseHistory res = new PurchaseHistory(1, new Member(1, "Aaron", "123@gmail.com", "123"), new Ticket(new Adult(), selectSession, "A0"), new DateTime(2021, 11, 23, 11, 11));
		
		PurchaseHistory test = new PurchaseHistory(1, new Member(1, "Aaron", "123@gmail.com", "123"), new Ticket(Adult.getInstance(), selectSession, "A0"), new DateTime(2021, 11, 23, 11, 11));
		
		int res = test.getMemberID();

		assertEquals(1, res);		
	}

	
	@Test
	public void test3() {	
		
		ArrayList<String> actorList = new ArrayList<String>();
		actorList.add("Actor A");
		MovieSession selectSession = new MovieSession(1, new Cinema(1, "loc A", "Cinema A", "12345678"), new Theatre(1, 5, 5) , new Movie(1, "Movie A", new DateTime(2021, 11, 23, 11, 11), 2.0, actorList), DateTime.today());
		
		//PurchaseHistory res = new PurchaseHistory(1, new Member(1, "Aaron", "123@gmail.com", "123"), new Ticket(new Adult(), selectSession, "A0"), new DateTime(2021, 11, 23, 11, 11));
		
		PurchaseHistory test = new PurchaseHistory(1, new Member(1, "Aaron", "123@gmail.com", "123"), new Ticket(Adult.getInstance(), selectSession, "A0"), new DateTime(2021, 11, 23, 11, 11));
	
		PurchaseHistory testOther = new PurchaseHistory(1, new Member(2, "Peter", "12sdsa3@gmail.com", "abc"), new Ticket(Adult.getInstance(), selectSession, "A1"), new DateTime(2021, 11, 23, 11, 11));
		
		int res = test.compareTo(testOther);

		assertEquals(0, res);		
	}
	
	@Test
	public void test4() {	
		
		ArrayList<String> actorList = new ArrayList<String>();
		actorList.add("Actor A");
		MovieSession selectSession = new MovieSession(1, new Cinema(1, "loc A", "Cinema A", "12345678"), new Theatre(1, 5, 5) , new Movie(1, "Movie A", new DateTime(2021, 11, 23, 11, 11), 2.0, actorList), DateTime.today());
		
		//PurchaseHistory res = new PurchaseHistory(1, new Member(1, "Aaron", "123@gmail.com", "123"), new Ticket(new Adult(), selectSession, "A0"), new DateTime(2021, 11, 23, 11, 11));
		
		PurchaseHistory test = new PurchaseHistory(1, new Member(1, "Aaron", "123@gmail.com", "123"), new Ticket(Adult.getInstance(), selectSession, "A0"), new DateTime(2021, 11, 23, 11, 11));
		
		String res = test.toCatalogItemString();
		
		String output = String.format(
				"\tHistory ID: \t%d\n"+
						"\tMember ID: \t%d\n"+
						"\tTicket Type: \t%s\n"+
			            "\tTicket Price: \t%f\n"+
						"\tPurchase Date: \t%s\n"
					, 1, new Member(1, "Aaron", "123@gmail.com", "123").getMemberId(), new Ticket(Adult.getInstance(), selectSession, "A0").getType(), new Ticket(Adult.getInstance(), selectSession, "A0").getPrice(), new DateTime(2021, 11, 23, 11, 11).toString());

		assertEquals(output, res);		
	}
}
