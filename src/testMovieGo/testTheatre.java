package testMovieGo;

import static org.junit.Assert.*;
import org.junit.Test;
import obj.Theatre;

public class testTheatre {

	@Test
	public void testGetColNum() {
		Theatre t= new Theatre(1,3,4);
		int TheatreColNum=t.getColNum();
		assertEquals(3,TheatreColNum);
	}
	@Test
	public void testGetRowNum() {
		Theatre t= new Theatre(1,3,4);
		int TheatreRowNum=t.getRowNum();
		assertEquals(4,TheatreRowNum);
	}
	@Test
	public void testGetTheatreID() {
		Theatre t= new Theatre(1,3,4);
		int TheatreID=t.getTheatreID();
		assertEquals(1,TheatreID);
	}	
	@Test
	public void testcompareTo() {
		Theatre t1= new Theatre(1,3,4);
		Theatre t2= new Theatre(2,3,4);
		int compareToRes=t1.compareTo(t2);
		assertEquals(-1,compareToRes);
	}
	@Test
	public void testToCatalogItemString() {
		Theatre t1= new Theatre(1,3,4);;
		String toCalalogItemStringRes=t1.toCatalogItemString();
		assertEquals("row num 4, col num 3\n",toCalalogItemStringRes);
	}
	
}
