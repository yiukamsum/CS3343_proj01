package obj;

import java.util.ArrayList;

public class MovieSessionManageAction extends DbAction {
    ArrayList<MovieSession> sessionList;

    MovieSessionManageAction(Admin admin) {
        this.sessionList = getDatabase().getMovieSessionList();
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
