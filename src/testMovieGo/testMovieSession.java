package testMovieGo;
import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.sql.Date;
import java.util.ArrayList;

import org.junit.Test;
import org.junit.jupiter.api.TestFactory;

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

    /* isSeatEmpty */
    @Test
    public void testIsSeatEmpty() {
        MovieSession ms = getTestMovieSession();
        ms.takeSeat("C2");
        boolean isEmpty = ms.isSeatEmpty("C2");

        assertEquals(false, isEmpty);
    }

    @Test
    public void testIsSeatEmpty2() {
        MovieSession ms = getTestMovieSession();
        ms.takeSeat("C2");
        boolean isEmpty = ms.isSeatEmpty("C3");

        assertEquals(true, isEmpty);
    }


    /* isFull */
    @Test
    public void testIsFull() {
        MovieSession ms = getTestMovieSession();

        assertEquals(false, ms.isFull());
    }

    @Test
    public void testIsFull2() {
        MovieSession testSession;
        Cinema testCinema;
        Theatre testTheatre;
        Movie testMovie;
        DateTime testStartTime;

        testCinema = new Cinema(1, "loc A", "Cinema A", "12345678");
        testTheatre = new Theatre(1, 1, 1);
        testCinema.addTheatre(testTheatre);

        testMovie = new Movie(1, "Movie A", DateTime.today(), 2, new ArrayList<String>());
        testStartTime = new DateTime(2020, 11, 30, 9, 30);

        testSession = new MovieSession(1, testCinema, testTheatre, testMovie, testStartTime);

        testSession.takeSeat("A0");

        assertEquals(true, testSession.isFull());
    }


    /* doTimeOverlap */
    @Test
    public void testDoTimeOverlap() {
        MovieSession ms1 = getTestMovieSession();

        /* create a session with early start time and later end time */
        MovieSession ms2;
        Cinema testCinema;
        Theatre testTheatre;
        Movie testMovie;
        DateTime testStartTime;

        testCinema = new Cinema(1, "loc A", "Cinema A", "12345678");
        testTheatre = new Theatre(1, 5, 5);
        testCinema.addTheatre(testTheatre);

        testMovie = new Movie(1, "Movie A", DateTime.today(), 4, new ArrayList<String>());
        testStartTime = new DateTime(2020, 11, 30, 8, 30);

        ms2 = new MovieSession(1, testCinema, testTheatre, testMovie, testStartTime);


        assertEquals(true, ms1.doTimeOverlap(ms2));
    }

    @Test
    public void testDoTimeOverlap2() {
        MovieSession ms1 = getTestMovieSession();

        /* create a session with early start time and later end time */
        MovieSession ms2;
        Cinema testCinema;
        Theatre testTheatre;
        Movie testMovie;
        DateTime testStartTime;

        testCinema = new Cinema(1, "loc A", "Cinema A", "12345678");
        testTheatre = new Theatre(1, 5, 5);
        testCinema.addTheatre(testTheatre);

        testMovie = new Movie(1, "Movie A", DateTime.today(), 4, new ArrayList<String>());
        testStartTime = new DateTime(2020, 11, 30, 8, 30);

        ms2 = new MovieSession(1, testCinema, testTheatre, testMovie, testStartTime);


        assertEquals(true, ms2.doTimeOverlap(ms1));
    }

    @Test
    public void testDoTimeOverlap3() {
        MovieSession ms1 = getTestMovieSession();

        /* create a session with early start time and end in ms1 */
        MovieSession ms2;
        Cinema testCinema;
        Theatre testTheatre;
        Movie testMovie;
        DateTime testStartTime;

        testCinema = new Cinema(1, "loc A", "Cinema A", "12345678");
        testTheatre = new Theatre(1, 5, 5);
        testCinema.addTheatre(testTheatre);

        testMovie = new Movie(1, "Movie A", DateTime.today(), 2, new ArrayList<String>());
        testStartTime = new DateTime(2020, 11, 30, 8, 30);

        ms2 = new MovieSession(1, testCinema, testTheatre, testMovie, testStartTime);


        assertEquals(true, ms2.doTimeOverlap(ms1));
    }

    @Test
    public void testDoTimeOverlap4() {
        MovieSession ms1 = getTestMovieSession();

        /* create a session with early start time and end in ms1 */
        MovieSession ms2;
        Cinema testCinema;
        Theatre testTheatre;
        Movie testMovie;
        DateTime testStartTime;

        testCinema = new Cinema(1, "loc A", "Cinema A", "12345678");
        testTheatre = new Theatre(1, 5, 5);
        testCinema.addTheatre(testTheatre);

        testMovie = new Movie(1, "Movie A", DateTime.today(), 2, new ArrayList<String>());
        testStartTime = new DateTime(2020, 11, 30, 8, 30);

        ms2 = new MovieSession(1, testCinema, testTheatre, testMovie, testStartTime);


        assertEquals(true, ms1.doTimeOverlap(ms2));
    }

    @Test
    public void testDoTimeOverlap5() {
        MovieSession ms1 = getTestMovieSession();

        /* create a session do not overlap with ms1 */
        MovieSession ms2;
        Cinema testCinema;
        Theatre testTheatre;
        Movie testMovie;
        DateTime testStartTime;

        testCinema = new Cinema(1, "loc A", "Cinema A", "12345678");
        testTheatre = new Theatre(1, 5, 5);
        testCinema.addTheatre(testTheatre);

        testMovie = new Movie(1, "Movie A", DateTime.today(), 2, new ArrayList<String>());
        testStartTime = new DateTime(2020, 11, 30, 2, 30);

        ms2 = new MovieSession(1, testCinema, testTheatre, testMovie, testStartTime);


        assertEquals(false, ms1.doTimeOverlap(ms2));
    }
}
