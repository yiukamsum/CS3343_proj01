package testMovieGo;
import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.sql.Date;
import java.util.ArrayList;

import org.junit.Test;

import obj.MovieSession;
import obj.Cinema;
import obj.Theatre;
import obj.Movie;
import obj.DateTime;

public class testMovieSession {

    private MovieSession getTestMovieSession() {
        MovieSession testSession;
        Cinema testCinema;
        Theatre testTheatre;
        Movie testMovie;
        DateTime testStartTime;

        testCinema = new Cinema(1, "loc A", "Cinema A", "12345678");
        testTheatre = new Theatre(1, 5, 5);
        testCinema.addTheatre(testTheatre);

        testMovie = new Movie(1, "Movie A", DateTime.today(), 2, new ArrayList<String>());
        testStartTime = new DateTime(2020, 11, 30, 9, 30);

        testSession = new MovieSession(1, testCinema, testTheatre, testMovie, testStartTime);

        return testSession;
    }

    /* getEndTime */
    @Test
    public void testGetEndTime() {
        DateTime endTime = getTestMovieSession().getEndTime();
        DateTime expected = new DateTime(2020, 11, 30, 11, 30);

        assertEquals(0, endTime.compareTo(expected));
    }

    /* takeSeat */
    @Test
    public void testTakeSeat() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));

        MovieSession ms = getTestMovieSession();

        ms.takeSeat("C2");

        String expected =   "[Screen Here]\r\n"+
                            "A0 A1 A2 A3 A4 \r\n"+
                            "B0 B1 B2 B3 B4 \r\n"+
                            "C0 C1 ## C3 C4 \r\n"+
                            "D0 D1 D2 D3 D4 \r\n"+
                            "E0 E1 E2 E3 E4 \r\n";

        ms.printSeat();

		assertEquals(expected, outContent.toString());
    }
}
