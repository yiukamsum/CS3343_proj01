package obj;

import java.util.ArrayList;

public class MovieSessionManageAction extends DbAction {
    ArrayList<MovieSession> sessionList;

    MovieSessionManageAction(Admin admin) {
        this.sessionList = getDatabase().getMovieSessionList();
    }

    public void addMovieSession(MovieSession session) {
        sessionList.add(session);
    }

    public int getNextSessionID() {
        if(sessionList.size() == 0) { return 1; }
        return sessionList.get(sessionList.size()-1).getSessionID()+1;
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

    public ArrayList<MovieSession> getSessionByTheatre(int cinemaID, int theatreID) {
        ArrayList<MovieSession> res = new ArrayList<>();
        for(MovieSession session : sessionList) {
            if(session.getCinemaID() != cinemaID) { continue; }
            if(session.getTheatreID() != theatreID) { continue; }
            res.add(session);
        }   
        return res;
    }

    // check if the theatre is available in 
    public boolean isSessionAvailable(MovieSession checkingSession) {
        ArrayList<MovieSession> theatreSession_list = getSessionByTheatre(checkingSession.getCinemaID(), checkingSession.getTheatreID());
        for(MovieSession session : theatreSession_list) {
            if(session.doTimeOverlap(checkingSession)){
                return false;
            }
        }
        return true;
    }
}
