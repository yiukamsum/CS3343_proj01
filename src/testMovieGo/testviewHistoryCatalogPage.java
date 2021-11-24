package testMovieGo;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import obj.Adult;
import obj.Catalog;
import obj.Cinema;
import obj.Database;
import obj.DateTime;
import obj.DbAction;
import obj.HistoryManageAction;
import obj.Member;
import obj.MemberConsole;
import obj.Movie;
import obj.MovieSession;
import obj.PurchaseHistory;
import obj.PurchaseTicketPage;
import obj.Theatre;
import obj.Ticket;
import obj.TicketType;
import obj.viewHistoryCatalogPage;

class testviewHistoryCatalogPage {
	
	public PrintStream test;
	

	@Test
	void test1() {
//		Member member = new Member(1, "Aaron", "123@gmail.com", "123");
//		
////		class testStubHistoryManageAction extends DbAction {
////			ArrayList<PurchaseHistory> historyList;
////
////			testStubHistoryManageAction() {
////				historyList = getDatabase().getPurchaseHistoryList();
////			}
////			
////			public ArrayList<PurchaseHistory> getDB() {
////				return historyList;
////			}
////		}
////		
////		
////		testStubHistoryManageAction db = new testStubHistoryManageAction();
////		
////		HistoryManageAction historyAct = new HistoryManageAction();
////		
////		ArrayList<PurchaseHistory> historyList = db.getDB().getPurchaseHistoryList();
////		
////		PurchaseHistory history = new PurchaseHistory(1, member, ticket, DateTime.now());
////		historyAct.addHistory(history);
////		
////		PurchaseHistory history = new PurchaseHistory(historyID, this.console.getMember(), ticket, DateTime.now());
////		historyAct.addHistory(history);
////		
////		ArrayList<PurchaseHistory> historyList = new HistoryManageAction().getHistory(member.getMemberId());
////        historyCatalog = new Catalog<PurchaseHistory>(historyList);
//
//		ArrayList<PurchaseHistory> historyList = new ArrayList<PurchaseHistory>();	
//		
//		ArrayList<String> actorList = new ArrayList<String>();
//        actorList.add("Actor A");
//
//		MovieSession selectSession = new MovieSession(1, new Cinema(1, "loc A", "Cinema A", "12345678"), new Theatre(1, 5, 5) , new Movie(1, "Movie A", new DateTime(2021, 11, 23, 11, 11), 2.0, actorList), DateTime.today());
//		
//		Ticket ticket = new Ticket(new Adult(), selectSession, "A0");
//
//		historyList.add(new PurchaseHistory(1, member, ticket, DateTime.now()));
//		
//		
//		class testStub extends Catalog {
//			
//			public testStub(ArrayList itemList) {
//				super(itemList);
//			}
//
//
////			ArrayList<PurchaseHistory> historyList;
////
////			public void show() {
////		        if(getItemList().size() == 0) {
////		            System.out.println("No Item");
////		        }
////
////		        for(int idx = 0; idx < getItemList().size(); idx++) {
////		            System.out.printf("%d. %s\n", idx+1, ((PurchaseHistory) getItemList().get(idx)).toCatalogItemString());
////		        }
////		    }	
//		}
//		
//		testStub test = new testStub(historyList);
//		
////		String input="5\n1\n2\nMovie A\n3\nCinema A\n4\n-1\n4\n2\n1\n1\n5\n1\nA0\nN\n1\n1\n2\nA0\nN\n1\n1\n3\nA0\nN\n1\n1\n4\nA0\nN\n-1\n-1\n";
////		System.setIn(new ByteArrayInputStream(input.getBytes()));
////
////		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
////		System.setOut(new PrintStream(outContent));
////		
////		PurchaseTicketPage page = new PurchaseTicketPage(new MemberConsole());
////		page.display();
////		
////		display();
//		
//		class testStubviewHistoryCatalogPage extends viewHistoryCatalogPage {
//
//			public testStubviewHistoryCatalogPage(MemberConsole console) {
//				super(console);
//				
//				ArrayList<PurchaseHistory> temp = historyList;
//		        historyCatalog = new Catalog<PurchaseHistory>(historyList);
//				// TODO Auto-generated constructor stub
//			}
//
//        }
		
		
		class testStubMemberConsole extends MemberConsole {
			
			public Member getMember() {
				return new Member(1, "Peter", "123@gmail.com", "123");
			}
		}
		
		
		String input="2\n-1\n";
		System.setIn(new ByteArrayInputStream(input.getBytes()));

		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
		
		viewHistoryCatalogPage res = new viewHistoryCatalogPage(new testStubMemberConsole());

		res.display();
		
		String expecString= 
				"\n====Purchase History====\n" + 
				"(1) Show Purchase History list\n"+          
		        "(-1) Leave this page\n" + 
				"Invalid input!" + "\r\n"+
				"(1) Show Purchase History list\n"+          
		        "(-1) Leave this page\n";
		
		
		assertEquals(outContent.toString(), expecString);
		
		
	}
	
	
	@Test
	void test2() {
	class testStubMemberConsole extends MemberConsole {
		
		public Member getMember() {
			return new Member(1, "Peter", "123@gmail.com", "123");
		}
	}
	
	
	String input="-1\n-1\n";
	System.setIn(new ByteArrayInputStream(input.getBytes()));

	ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	System.setOut(new PrintStream(outContent));
	
	viewHistoryCatalogPage res = new viewHistoryCatalogPage(new testStubMemberConsole());

	res.display();
	
	String expecString= 
			"\n====Purchase History====\n" + 
			"(1) Show Purchase History list\n"+          
	        "(-1) Leave this page\n";
	
	
	assertEquals(outContent.toString(), expecString);
	
	
}
	
	@Test
	void test3() {
	class testStubMemberConsole extends MemberConsole {
		
		public Member getMember() {
			return new Member(1, "Peter", "123@gmail.com", "123");
		}
	}
	
	
	String input="1\n-1\n";
	System.setIn(new ByteArrayInputStream(input.getBytes()));

	ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	System.setOut(new PrintStream(outContent));
	
	viewHistoryCatalogPage res = new viewHistoryCatalogPage(new testStubMemberConsole());

	res.display();
	
	String expecString= 
			"\n====Purchase History====\n" + 
			"(1) Show Purchase History list\n"+          
	        "(-1) Leave this page\n" +
			
			"\n---Purchase History List---\n"+
			
			"No Item\r\n"+
			
			"\n-------------------------\n"+
			
			"(1) Show Purchase History list\n"+          
			"(-1) Leave this page\n";
	
	
	assertEquals(outContent.toString(), expecString);
	
	
}
	
	

}
