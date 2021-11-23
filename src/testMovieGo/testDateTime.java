package testMovieGo;
import static org.junit.Assert.*;

import java.time.LocalDateTime;

import org.junit.Test;
import obj.DateTime;
public class testDateTime {

	@Test
	public void testToString() {
		DateTime dTime=new DateTime(2021, 11, 10,21,0);
		
		assertEquals("2021-11-10 21:0", dTime.toString());
		
	}
	
	@Test
	public void testToString2() {
		DateTime dTime=new DateTime(2021, 11, 10,0,0);
		
		assertEquals("2021-11-10", dTime.toString());
		
	}
	@Test
	public void testToString3() {
		DateTime dTime=new DateTime(2021, 11, 10,0,21);
		
		assertEquals("2021-11-10 0:21", dTime.toString());
		
	}
	@Test
	public void testCompareTo() {
		DateTime dTime=new DateTime(2021, 11, 10,0,21);
		DateTime dTime2=new DateTime(2022, 11, 10,0,21);
		
		assertEquals(-1, dTime.compareTo(dTime2));
		
	}

}
