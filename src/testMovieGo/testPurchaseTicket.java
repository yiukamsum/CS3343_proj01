package testMovieGo;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import obj.Adult;
import obj.Alipay;
import obj.Child;
import obj.Cinema;
import obj.CreditCard;
import obj.DateTime;
import obj.Elderly;
import obj.MemberConsole;
import obj.Movie;
import obj.MovieSession;
import obj.PaymentMethod;
import obj.PurchaseTicket;
import obj.Student;
import obj.Theatre;
import obj.Ticket;
import obj.Member;

class testPurchaseTicket {

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testInvalidImput() {
		String input="0\n-1\n";
		System.setIn(new ByteArrayInputStream(input.getBytes()));
		
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
		
		MemberConsole console = new MemberConsole();
		PurchaseTicket purchase = new PurchaseTicket(console);
		
		Cinema C01 = new Cinema(1, "HK", "Cinema01", "12345678");
		Theatre T01 = new Theatre (1, 1, 1);
		DateTime Date = new DateTime(2021, 01, 01);
		ArrayList<String> actorList = new ArrayList<String>();
		Movie M01 = new Movie(1, "Movie01", Date, 1.01, actorList);
		MovieSession session01 = new MovieSession(1, C01, T01, M01, Date);
		
		Ticket ticket1 = new Ticket(Adult.getInstance(), session01, "A01");
		Ticket ticket2 = new Ticket(Child.getInstance(), session01, "A01");
		Ticket ticket3 = new Ticket(Elderly.getInstance(), session01, "A01");
		Ticket ticket4 = new Ticket(Student.getInstance(), session01, "A01");
		ArrayList<Ticket> ticketList = new ArrayList<Ticket>();
		ticketList.add(ticket1);
		ticketList.add(ticket2);
		ticketList.add(ticket3);
		ticketList.add(ticket4);
		
		purchase.purchase(session01, ticketList);
		
		String result = "\nTotal amount: 330.000000\n"
				+ "How do you want to pay? (1-Alipay, 2-Credit Card):Wrong input\r\n"
				+ "How do you want to pay? (1-Alipay, 2-Credit Card):Payment cancelled\r\n"
				+ "";
		assertEquals(result, outContent.toString());
		
	}


	@Test
	public void testPayFailed() {
		class stubPayment implements PaymentMethod {
			@Override
			public boolean pay(double amount) {
				return false;
			}
		}

		class stubPurchaseTicket extends PurchaseTicket {
			public stubPurchaseTicket(MemberConsole console) {
				super(console);
			}

			@Override
			public PaymentMethod selectPaymentMethod() {
				return new stubPayment();
			}
		}
		
		MemberConsole console = new MemberConsole();
		stubPurchaseTicket purchase = new stubPurchaseTicket(console);
		
		Cinema C01 = new Cinema(1, "HK", "Cinema01", "12345678");
		Theatre T01 = new Theatre (1, 1, 1);
		DateTime Date = new DateTime(2021, 01, 01);
		ArrayList<String> actorList = new ArrayList<String>();
		Movie M01 = new Movie(1, "Movie01", Date, 1.01, actorList);
		MovieSession session01 = new MovieSession(1, C01, T01, M01, Date);
		
		Ticket ticket1 = new Ticket(Adult.getInstance(), session01, "A01");
		Ticket ticket2 = new Ticket(Child.getInstance(), session01, "A01");
		Ticket ticket3 = new Ticket(Elderly.getInstance(), session01, "A01");
		Ticket ticket4 = new Ticket(Student.getInstance(), session01, "A01");
		ArrayList<Ticket> ticketList = new ArrayList<Ticket>();
		ticketList.add(ticket1);
		ticketList.add(ticket2);
		ticketList.add(ticket3);
		ticketList.add(ticket4);
		
		boolean actual = purchase.purchase(session01, ticketList);
		
		assertEquals(false, actual);
	}

	@Test
	void testPaySuccess() {
		// stub class for easier testing
		class stubMemberConsole extends MemberConsole{
			private Member testMember;

			stubMemberConsole() {
				testMember = new Member(999, "test", "123@123.com", "123");
			}

			@Override
			public int getMemberID() {
				return testMember.getMemberId();
			}

			@Override
			public Member getMember() {
				return testMember; 
			}
		}

		String input="1\n";
		System.setIn(new ByteArrayInputStream(input.getBytes()));
		
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
		
		stubMemberConsole console = new stubMemberConsole();
		PurchaseTicket purchase = new PurchaseTicket(console);
		
		Cinema C01 = new Cinema(1, "HK", "Cinema01", "12345678");
		Theatre T01 = new Theatre (1, 1, 1);
		DateTime Date = new DateTime(2021, 01, 01);
		ArrayList<String> actorList = new ArrayList<String>();
		Movie M01 = new Movie(1, "Movie01", Date, 1.01, actorList);
		MovieSession session01 = new MovieSession(1, C01, T01, M01, Date);
		
		Ticket ticket1 = new Ticket(Adult.getInstance(), session01, "A01");
		Ticket ticket2 = new Ticket(Child.getInstance(), session01, "A01");
		Ticket ticket3 = new Ticket(Elderly.getInstance(), session01, "A01");
		Ticket ticket4 = new Ticket(Student.getInstance(), session01, "A01");
		ArrayList<Ticket> ticketList = new ArrayList<Ticket>();
		ticketList.add(ticket1);
		ticketList.add(ticket2);
		ticketList.add(ticket3);
		ticketList.add(ticket4);
		
		boolean actual = purchase.purchase(session01, ticketList);
		
		assertEquals(true, actual);
	}

	@Test
	public void testSelectCreditCard() {
		String input="2\n";
		System.setIn(new ByteArrayInputStream(input.getBytes()));
		
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
		
		MemberConsole console = new MemberConsole();
		PurchaseTicket purchase = new PurchaseTicket(console);

		PaymentMethod actual = purchase.selectPaymentMethod();

		assertEquals(true, actual instanceof CreditCard);
	}
}
