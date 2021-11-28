package testMovieGo;
import static org.junit.Assert.*;

import java.sql.Date;
import java.time.LocalDateTime;

import org.junit.Test;
import org.junit.jupiter.params.shadow.com.univocity.parsers.conversions.DateConversion;

import obj.DateTime;
public class testDateTime {


	/* toString */
	@Test
	public void testToString() {
		DateTime dTime=new DateTime(2021, 11, 10,21,0);
		
		assertEquals("2021-11-10 21:0", dTime.toString());
		
	}
	
	@Test
	public void testToString2() {
		DateTime dTime=new DateTime(2021, 11, 10,0,0);
		
		assertEquals("2021-11-10 00:00", dTime.toString());
		
	}
	@Test
	public void testToString3() {
		DateTime dTime=new DateTime(2021, 11, 10,0,21);
		
		assertEquals("2021-11-10 0:21", dTime.toString());
		
	}

	@Test
	public void testToString4() {
		DateTime dTime=new DateTime(2021, 11, 10);
		
		assertEquals("2021-11-10 00:00", dTime.toString());
		
	}

	/* Compare To */
	@Test
	public void testCompareTo() {
		DateTime dTime=new DateTime(2022, 11, 10,0,21);
		DateTime dTime2=new DateTime(2022, 11, 10,0,21);
		
		assertEquals(0, dTime.compareTo(dTime2));
		
	}
	@Test
	public void testCompareTo2() {
		DateTime dTime=new DateTime(2021, 11, 10,0,21);
		DateTime dTime2=new DateTime(2022, 11, 10,0,21);
		
		assertEquals(-1, dTime.compareTo(dTime2));
		
	}
	@Test
	public void testCompareTo3() {
		DateTime dTime=new DateTime(2022, 10, 10,0,21);
		DateTime dTime2=new DateTime(2022, 11, 10,0,21);
		
		assertEquals(-1, dTime.compareTo(dTime2));
		
	}
	@Test
	public void testCompareTo4() {
		DateTime dTime=new DateTime(2022, 11, 9,0,21);
		DateTime dTime2=new DateTime(2022, 11, 10,0,21);
		
		assertEquals(-1, dTime.compareTo(dTime2));
		
	}
	@Test
	public void testCompareTo5() {
		DateTime dTime=new DateTime(2022, 11, 10,0,21);
		DateTime dTime2=new DateTime(2022, 11, 10,1,21);
		
		assertEquals(-1, dTime.compareTo(dTime2));
		
	}
	@Test
	public void testCompareTo6() {
		DateTime dTime=new DateTime(2022, 11, 10,0,20);
		DateTime dTime2=new DateTime(2022, 11, 10,0,21);
		
		assertEquals(-1, dTime.compareTo(dTime2));
		
	}


	/* clone */
	@Test
	public void testClone() {
		DateTime dTime=new DateTime(2022, 11, 10,0,20);
		DateTime dTime2=DateTime.clone(dTime);
		
		assertEquals(0, dTime.compareTo(dTime2));
		
	}


	/* today, now */
	@Test
	public void testToday() {
		LocalDateTime ldt = LocalDateTime.now();
		DateTime expected = new DateTime(
									ldt.getYear(),
									ldt.getMonthValue(),
									ldt.getDayOfMonth()
								);
		DateTime dt = DateTime.today();

		assertEquals(0, dt.compareTo(expected));
	}
	@Test
	public void testNow() {
		LocalDateTime ldt = LocalDateTime.now();
		DateTime expected = new DateTime(
									ldt.getYear(),
									ldt.getMonthValue(),
									ldt.getDayOfMonth(),
									ldt.getHour(),
									ldt.getMinute()
								);
		DateTime dt = DateTime.now();

		assertEquals(0, dt.compareTo(expected));
	}


	/* addMinute, addHour, addDay, addMonth */
	@Test
	public void testAddMinute() {
		DateTime dt = new DateTime(2021, 11, 30, 11, 30);
		dt.addMinute(15);
		DateTime expected = new DateTime(2021, 11, 30, 11, 45);
		
		assertEquals(0, dt.compareTo(expected));
	}

	@Test
	public void testAddMinute2() {
		DateTime dt = new DateTime(2021, 11, 30, 11, 30);
		dt.addMinute(30);
		DateTime expected = new DateTime(2021, 11, 30, 12, 00);
		
		assertEquals(0, dt.compareTo(expected));
	}

	@Test
	public void testAddHour() {
		DateTime dt = new DateTime(2021, 11, 30, 23, 30);
		dt.addHour(2);
		DateTime expected = new DateTime(2021, 11, 31, 1, 30);
		
		assertEquals(0, dt.compareTo(expected));
	}

	@Test
	public void testAddDay() {
		DateTime dt = new DateTime(2021, 11, 31, 23, 30);
		dt.addDay(1);
		DateTime expected = new DateTime(2021, 12, 1, 23, 30);
		
		assertEquals(0, dt.compareTo(expected));
	}

	@Test
	public void testAddDay2() {
		DateTime dt = new DateTime(2021, 8, 31, 23, 30);
		dt.addDay(31);
		DateTime expected = new DateTime(2021, 10, 1, 23, 30);
		
		assertEquals(0, dt.compareTo(expected));
	}

	@Test
	public void testAddMonth() {
		DateTime dt = new DateTime(2021, 8, 31, 23, 30);
		dt.addMonth(5);
		DateTime expected = new DateTime(2022, 1, 31, 23, 30);

		assertEquals(0, dt.compareTo(expected));
	}

	@Test
	public void testAddMonth2() {
		DateTime dt = new DateTime(2021, 8, 31, 23, 30);
		dt.addMonth(16);
		DateTime expected = new DateTime(2023, 1, 31, 23, 30);

		assertEquals(0, dt.compareTo(expected));
	}

}
