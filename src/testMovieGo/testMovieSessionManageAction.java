package testMovieGo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import obj.Admin;
import obj.Movie;
import obj.Cinema;
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


    /////////////////
    /* BEFORE EACH */
    @BeforeEach
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
        movieList.add(new Movie(1, "Movie A", DateTime.today(), 2.0, actorList1));
        movieList.add(new Movie(2, "Movie B", DateTime.today(), 2.0, actorList2));
        movieList.add(new Movie(3, "Movie C", DateTime.today(), 3.0, actorList3));

        sessionList.clear();
        sessionList.add(
            new MovieSession(1, cinemaList.get(0), cinemaList.get(0).getTheatre(1), movieList.get(0), DateTime.now())
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


    /* remove action */
    /* ensure other session no change and the session is removed */
    @Test
    /* the session going to be removed is exist */
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
    /* the session going to be removed is not exist */
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


    @Test
    public void testRemoveSessionInCinema() {
        
    }
}
