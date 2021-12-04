package testMovieGo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import obj.Admin;
import obj.Movie;
import obj.Cinema;
import obj.CinemaManageAction;
import obj.DateTime;
import obj.MovieSession;
import obj.MovieSessionManageAction;
import obj.Theatre;
import obj.getCinemaAction;
import obj.getMovieAction;
import obj.getMovieSessionAction;

public class testMovieSessionManageAction {
    static private MovieSessionManageAction manageAction = new MovieSessionManageAction(Admin.getInstance());
    static private getMovieSessionAction getAction = new getMovieSessionAction();

    private ArrayList<MovieSession> sessionList;


    /////////////////////
    /* HELPER FUNCTION */
    private MovieSession createTestSession(int sessionId) {
        MovieSession testSession;
        Cinema testCinema;
        Theatre testTheatre;
        Movie testMovie;
        DateTime testStartTime;

        testCinema = new getCinemaAction().getCinemaList().get(0);
        testTheatre = new Theatre(1, 5, 5);
        testCinema.addTheatre(testTheatre);

        testMovie = new getMovieAction().getMovieList().get(0);
        testStartTime = new DateTime(2020, 11, 30, 9, 30);

        testSession = new MovieSession(sessionId, testCinema, testTheatre, testMovie, testStartTime);

        return testSession;
    }

    private MovieSession createTestSessionWithCinema(int sessionId, Cinema testCinema) {
        MovieSession testSession;
        Theatre testTheatre;
        Movie testMovie;
        DateTime testStartTime;

        testTheatre = new Theatre(1, 5, 5);
        testCinema.addTheatre(testTheatre);

        testMovie = new getMovieAction().getMovieList().get(0);
        testStartTime = new DateTime(2020, 11, 30, 9, 30);

        testSession = new MovieSession(sessionId, testCinema, testTheatre, testMovie, testStartTime);

        return testSession;
    }

    private MovieSession createSessionWithTime(int sessionId, DateTime startTime) {
        MovieSession testSession;
        Theatre testTheatre;
        Cinema testCinema;
        Movie testMovie;

        testCinema = new getCinemaAction().getCinemaList().get(0);
        testTheatre = new Theatre(1, 5, 5);
        testCinema.addTheatre(testTheatre);

        testMovie = new getMovieAction().getMovieList().get(0);

        testSession = new MovieSession(sessionId, testCinema, testTheatre, testMovie, startTime);

        return testSession;
    }

    private MovieSession createSessionWithTheatreAndTime(int sessionId, Theatre testTheatre, DateTime startTime) {
        MovieSession testSession;
        Cinema testCinema;
        Movie testMovie;

        testCinema = new getCinemaAction().getCinemaList().get(0);
        testCinema.addTheatre(testTheatre);

        testMovie = new getMovieAction().getMovieList().get(0);

        testSession = new MovieSession(sessionId, testCinema, testTheatre, testMovie, startTime);

        return testSession;
    }

    private Cinema createTestCinema() {
        CinemaManageAction cinemaAction = new CinemaManageAction(Admin.getInstance());
        Cinema testCinema = cinemaAction.createCinemaRecord("test", "test", "12345678", new ArrayList<>());

        return testCinema;
    }


    /////////////////
    /* BEFORE EACH */
    @BeforeEach
    // restore database data before each testing
    private void restore() {
        ArrayList<MovieSession> sessionList = getAction.getMovieSession();
        ArrayList<Cinema> cinemaList = new getCinemaAction().getCinemaList();
        ArrayList<Movie> movieList = new getMovieAction().getMovieList();

        cinemaList.clear();
        Cinema cinema = new Cinema(1, "loc A", "Cinema A", "12345678");
        cinema.addTheatre(new Theatre(1, 5, 5));
        cinemaList.add(cinema);

        movieList.clear();
        ArrayList<String> actorList1 = new ArrayList<String>();
        actorList1.add("Actor A");
        ArrayList<String> actorList2 = new ArrayList<String>();
        actorList2.add("Actor B");
        ArrayList<String> actorList3 = new ArrayList<String>();
        actorList3.add("Actor C");
        actorList3.add("Actor D");
        movieList.add(new Movie(1, "Movie A", new DateTime(2020, 11, 30, 9, 30), 2.0, actorList1));
        movieList.add(new Movie(2, "Movie B", new DateTime(2020, 11, 30, 9, 30), 2.0, actorList2));
        movieList.add(new Movie(3, "Movie C", new DateTime(2020, 11, 30, 9, 30), 3.0, actorList3));

        sessionList.clear();
        sessionList.add(
            new MovieSession(1, cinemaList.get(0), cinemaList.get(0).getTheatre(1), movieList.get(0), new DateTime(2021, 6, 30, 9, 30))
        );
    }

    @BeforeEach 
    private void getSessionList() {
        this.sessionList = getAction.getMovieSession();
    }


    //////////
    /* TEST */
    @Test
    public void testAddSession() {
        // store the orgin list
        ArrayList<MovieSession> originList = (ArrayList<MovieSession>) sessionList.clone();

        // create and add a session
        MovieSession newSession = createTestSession(manageAction.getNextSessionID());
        manageAction.addMovieSession(newSession);

        // check if other session still the same
        boolean isOtherSessionSame = true;
        for(int idx = 0; idx < originList.size(); idx++) {
            if(originList.get(idx) != sessionList.get(idx)) {
                isOtherSessionSame = false;
                break;
            }
        }

        // check if the new added session is in the last place
        boolean isSessionAddedCorrectly = (sessionList.get(sessionList.size()-1) == newSession);
        
        // check test res
        assertEquals(true, isOtherSessionSame && isSessionAddedCorrectly);
    }

    @Test
    /* check if 1 is return when session list is empty */
    public void testGetNextSessionID1() {
        sessionList.clear();
        assertEquals(1, manageAction.getNextSessionID());
    }


    @Test 
    /* check if the returned id == last id+1 */
    public void testGetNextSessionID2() {
        int lastSessionId = sessionList.get(sessionList.size()-1).getSessionID();

        int actual = manageAction.getNextSessionID();

        assertEquals(lastSessionId+1, actual);
    }


    /* -- REMOVE ACTION -- */
    /* ensure other session no change and the session is removed */

    /* remove by id */
    @Test
    // the session going to be removed is exist
    public void testRemoveSessionById1() {
        // add a session for checking other session no change
        sessionList.add(createTestSession(manageAction.getNextSessionID()));

        // store the orgin list
        ArrayList<MovieSession> originList = (ArrayList<MovieSession>) sessionList.clone();
        // store the removed session
        MovieSession removedSession = sessionList.get(0);

        // remove the session
        manageAction.removeMovieSessionById(removedSession.getSessionID());


        /* checking */
        ArrayList<MovieSession> curList = getAction.getMovieSession();

        // check the session is removed
        boolean sessionRemoved = !curList.contains(removedSession);

        // check if other session no change
        boolean otherSessionSame = true;
        for(int idx = 0; idx < curList.size(); idx++) {
            if(curList.get(idx) != originList.get(idx+1)) {
                otherSessionSame = false;
                break;
            }
        }

        assertEquals(true, sessionRemoved && otherSessionSame);
    }

    @Test
    // the session going to be removed is not exist
    public void testRemoveSessionById2() {
        // get a session id that is not exist
        int notExistId = manageAction.getNextSessionID();

        // store the orgin list
        ArrayList<MovieSession> originList = (ArrayList<MovieSession>) sessionList.clone();

        // remove the not exist session
        manageAction.removeMovieSessionById(notExistId);


        /* checking */
        ArrayList<MovieSession> curList = getAction.getMovieSession();

        // check if other session no change
        boolean otherSessionSame = true;
        for(int idx = 0; idx < curList.size(); idx++) {
            if(curList.get(idx) != originList.get(idx)) {
                otherSessionSame = false;
                break;
            }
        }

        assertEquals(true, otherSessionSame);
    }


    /* remove by cinema */
    @Test
    // the session going to be removed is exist
    public void testRemoveSessionInCinema() {
        /* add a new cinema record */
        Cinema newCinema = createTestCinema();

        /* add a new session with the new cinema */
        MovieSession newSession = createTestSessionWithCinema(manageAction.getNextSessionID(), newCinema);
        manageAction.addMovieSession(newSession);

        // store the list before remove
        ArrayList<MovieSession> originList = (ArrayList<MovieSession>) sessionList.clone();

        // remove the new cinema
        manageAction.removeMovieSessionInCinema(newCinema.getCinemaID());


        /* checking */
        ArrayList<MovieSession> curList = getAction.getMovieSession();

        // check the session is removed
        boolean sessionRemoved = !curList.contains(newSession);

        // check if other session no change
        boolean otherSessionSame = true;
        for(int idx = 0; idx < curList.size(); idx++) {
            if(curList.get(idx) != originList.get(idx)) {
                otherSessionSame = false;
                break;
            }
        }

        assertEquals(true, sessionRemoved && otherSessionSame);
    }

    @Test
    // the session going to be removed is not exist
    public void testRemoveSessionInCinema2() {
        /* add a new cinema record */
        Cinema newCinema = createTestCinema();

        // store the list before remove
        ArrayList<MovieSession> originList = (ArrayList<MovieSession>) sessionList.clone();

        // remove the new cinema
        manageAction.removeMovieSessionInCinema(newCinema.getCinemaID());


        /* checking */
        ArrayList<MovieSession> curList = getAction.getMovieSession();

        // check if other session no change
        boolean otherSessionSame = true;
        for(int idx = 0; idx < curList.size(); idx++) {
            if(curList.get(idx) != originList.get(idx)) {
                otherSessionSame = false;
                break;
            }
        }

        assertEquals(true, otherSessionSame);
    }

    /* -- REMOVE ACTION END -- */


    /* -- GET SESSION BY THEATRE -- */
    @Test
    // get session with a exist theatre and a exist cinema
    public void testGetSessionByTheatre1() {
        ArrayList<MovieSession> res = manageAction.getSessionByTheatre(1, 1);

        /* checking */
        // all session in the testing data are in the searching theatre and cinema
        // so the returned arraylist and the "sessionList" should be the same
        boolean getCorrectly = true;
        for(int idx = 0; idx < res.size(); idx++) {
            if(res.get(idx) != sessionList.get(idx)) {
                getCorrectly = false;
                break;
            }
        }

        assertEquals(true, getCorrectly);
    }

    @Test
    // get session with a exist theatre and a not exist cinema
    public void testGetSessionByTheatre2() {
        // add a new cinema record
        Cinema newCinema = createTestCinema();

        ArrayList<MovieSession> res = manageAction.getSessionByTheatre(newCinema.getCinemaID(), 1);

        assertEquals(0, res.size());
    }

    @Test
    // get session with a not exist theatre and a exist cinema
    public void testGetSessionByTheatre3() {
        // add a new theatre in a exist cinema
        CinemaManageAction cinemaManageAction = new CinemaManageAction(Admin.getInstance());
        cinemaManageAction.addTheatre(1, new Theatre(2, 1, 1));

        ArrayList<MovieSession> res = manageAction.getSessionByTheatre(1, 2);

        assertEquals(0, res.size());
    }

    /* -- GET SESSION BY THEATRE END -- */


    /* -- IS SESSION AVAILABLE */
    /* only one session in the testing data, theatre 1, start time 2021-6-30 9:30, duration 2 */
    @Test
    // check with a session overlap with another
    public void testIsSessionAvailable1() {
        // create a startTime that start in the existing session
        DateTime startTime = new DateTime(2021, 6, 30, 10, 30);

        // create the session
        MovieSession overlapSession = createSessionWithTime(manageAction.getNextSessionID(), startTime);

        boolean actual = manageAction.isSessionAvailable(overlapSession);

        assertEquals(false, actual);
    }

    @Test
    // check with a session play in same theatre and time not overlap
    public void testIsSessionAvailable2() {
        // create a startTime that start in the existing session
        DateTime startTime = new DateTime(2021, 8, 30, 10, 30);

        // create the session
        MovieSession overlapSession = createSessionWithTime(manageAction.getNextSessionID(), startTime);


        boolean actual = manageAction.isSessionAvailable(overlapSession);

        assertEquals(true, actual);
    }

    @Test
    // check with a session that time overlap with a session but play in different theatre
    public void testIsSessionAvailable3() {
        Theatre theatre = new Theatre(2, 1, 1);
        DateTime startTime = new DateTime(2021, 6, 30, 10, 30);

        // create the session
        MovieSession overlapSession = createSessionWithTheatreAndTime(
            manageAction.getNextSessionID(), theatre, startTime
        );

        boolean actual = manageAction.isSessionAvailable(overlapSession);

        assertEquals(true, actual);
    }
}
