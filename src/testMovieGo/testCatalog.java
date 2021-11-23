package testMovieGo;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import org.junit.Test;
import obj.Cinema;
import obj.Catalog;

public class testCatalog {
	@Test
	public void testGetItem() {
		ArrayList<Cinema> lCinema=new ArrayList<>();
		Cinema c1= new Cinema(1, "TST","Hello Cinema", "91234568");
		lCinema.add(c1);
		
		Catalog< Cinema>catalog= new Catalog<>(lCinema);
		assertEquals(c1, catalog.getItem(0));
		
	}


}
