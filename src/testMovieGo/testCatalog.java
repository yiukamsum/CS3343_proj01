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
	@Test
	public void testShow() {	
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
		ArrayList<Cinema> lCinema=new ArrayList<>();
		Catalog< Cinema>catalog= new Catalog<>(lCinema);
		catalog.show();


		assertEquals("No Item", outContent.toString().trim());
		
	}
	@Test
	public void testShow2() {	
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
		ArrayList<Cinema> lCinema=new ArrayList<>();
		Cinema c1= new Cinema(1, "TST","Hello Cinema", "91234568");
		lCinema.add(c1);
		
		Catalog< Cinema>catalog= new Catalog<>(lCinema);
		catalog.show();


		assertEquals(String.format("%d. %s\n",1,c1.toCatalogItemString()), outContent.toString());
		
	}

	@Test
	public void testgetItem() {	
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
		ArrayList<Cinema> lCinema=new ArrayList<>();
		Cinema c1= new Cinema(1, "TST","Hello Cinema", "91234568");
		lCinema.add(c1);
		
		Catalog< Cinema>catalog= new Catalog<>(lCinema);
		Cinema cinema= catalog.getItem(0);


		assertEquals(c1,cinema);
		
	}
	@Test
	public void testgetItem2() {	
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
		ArrayList<Cinema> lCinema=new ArrayList<>();
		Cinema c1= new Cinema(1, "TST","Hello Cinema", "91234568");
		lCinema.add(c1);
		
		Catalog< Cinema>catalog= new Catalog<>(lCinema);
		Cinema cinema= catalog.getItem(4);


		assertEquals(null,cinema);
		
	}
	@Test
	public void testgetItem3() {	
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
		ArrayList<Cinema> lCinema=new ArrayList<>();
		Cinema c1= new Cinema(1, "TST","Hello Cinema", "91234568");
		lCinema.add(c1);
		
		Catalog< Cinema>catalog= new Catalog<>(lCinema);
		Cinema cinema= catalog.getItem(-1);


		assertEquals(null,cinema);
		
	}
	

}
