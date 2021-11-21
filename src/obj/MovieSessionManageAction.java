package obj;

import java.util.ArrayList;

public class MovieSessionManageAction extends DbAction {
    ArrayList<MovieSession> sessionList;

    MovieSessionManageAction(Admin admin) {
        this.sessionList = getDatabase().getMovieSessionList();
    }

    public MovieSession createSessionRecord(Movie movie, Cinema cinema, Theatre theatre, DateTime startTime) {
        int sessionID = sessionList.size()+1;
        MovieSession session = new MovieSession(sessionID, cinema, theatre, movie, startTime);
        sessionList.add(session);
        return session;
    }

    public void removeMovieSessionById(int sessionId) {
        for(int i = 0; i < sessionList.size(); i++) {
            MovieSession session = sessionList.get(i);
            if(session.getSessionID() == sessionId) {
                sessionList.remove(session);
                i--;
            }
        }        
    }

    public void removeMovieSessionInCinema(int cinemaId) {
        for(int i = 0; i < sessionList.size(); i++) {
            MovieSession session = sessionList.get(i);
            if(session.getCinemaID() == cinemaId) {
                sessionList.remove(session);
                i--;
            }
        }
    }
}
