package obj;

import java.util.ArrayList;

public class getMovieSessionAction extends DbAction {
    public ArrayList<MovieSession> getMovieSession() {
        return getDatabase().getMovieSessionList();
    }
}
