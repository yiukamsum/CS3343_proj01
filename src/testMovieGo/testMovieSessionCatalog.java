package testMovieGo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import obj.Cinema;
import obj.DateTime;
import obj.Movie;
import obj.MovieSession;
import obj.MovieSessionCatalog;
import obj.Theatre;

public class testMovieSessionCatalog {
    private MovieSessionCatalog getTestCatalog() {
        MovieSession testSession1, testSession2, testSession3, testSession4, testSession5;
        Cinema testCinema1, testCinema2, testCinema3;
        Theatre testTheatre;
        Movie testMovie1, testMovie2, testMovie3;
        DateTime testStartTime;

        /* create cinema */
        testCinema1 = new Cinema(1, "loc A", "Cinema A", "12345678");
        testCinema2 = new Cinema(2, "loc B", "Cinema B", "12345678");
        testCinema3 = new Cinema(3, "loc C", "Cinema C", "12345678");
        testTheatre = new Theatre(1, 5, 5);
        testCinema1.addTheatre(testTheatre);
        testCinema2.addTheatre(testTheatre);
        testCinema3.addTheatre(testTheatre);

        /* create movie */
        testMovie1 = new Movie(1, "Movie A", DateTime.today(), 2, new ArrayList<String>());
        testMovie2 = new Movie(2, "Movie B", DateTime.today(), 2, new ArrayList<String>());
        testMovie3 = new Movie(3, "Movie C", DateTime.today(), 2, new ArrayList<String>());

        testStartTime = new DateTime(2020, 11, 30, 9, 30);

        testSession1 = new MovieSession(1, testCinema1, testTheatre, testMovie1, testStartTime);
        testSession2 = new MovieSession(2, testCinema2, testTheatre, testMovie2, testStartTime);
        testSession3 = new MovieSession(3, testCinema3, testTheatre, testMovie1, testStartTime);
        testSession4 = new MovieSession(4, testCinema1, testTheatre, testMovie1, testStartTime);
        testSession5 = new MovieSession(5, testCinema1, testTheatre, testMovie3, testStartTime);

        /* create movie session list */
        ArrayList<MovieSession> itemList = new ArrayList<>();
        itemList.add(testSession1);
        itemList.add(testSession2);
        itemList.add(testSession3);
        itemList.add(testSession4);
        itemList.add(testSession5);

        /* create test movie session catalog */
        MovieSessionCatalog testCatalog = new MovieSessionCatalog(itemList);
        return testCatalog;
    }

    @Test
    public void testFilterByMovieName() {
        MovieSessionCatalog testSessionCatalog = getTestCatalog();
        testSessionCatalog.filterByMovieName("Movie A");

        boolean isAllMovieA = true;

        for(int idx = 0; idx < testSessionCatalog.size(); idx++) {
            MovieSession curSession = testSessionCatalog.getItem(idx);
            if(!curSession.getMovieName().equals("Movie A")) {
                isAllMovieA = false;
                break;
            }
        }

        assertEquals(true, isAllMovieA);
    }

    @Test
    public void testFilterByCinemaName() {
        MovieSessionCatalog testSessionCatalog = getTestCatalog();
        testSessionCatalog.filterByCinemaName("Cinema A");

        boolean isAllCinemaA = true;

        for(int idx = 0; idx < testSessionCatalog.size(); idx++) {
            MovieSession curSession = testSessionCatalog.getItem(idx);
            if(!curSession.getCinemaName().equals("Cinema A")) {
                isAllCinemaA = false;
                break;
            }
        }

        assertEquals(true, isAllCinemaA);
    }

    @Test
    public void testRemoveFilter() {
        MovieSessionCatalog testSessionCatalog = getTestCatalog();
        testSessionCatalog.filterByCinemaName("Cinema A");
        testSessionCatalog.removeFilter();

        assertEquals(5, testSessionCatalog.size());
    }
}
