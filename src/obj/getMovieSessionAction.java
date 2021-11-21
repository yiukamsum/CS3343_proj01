package obj;

import java.util.ArrayList;

public class getMovieSessionAction extends DbAction {
    public getMovieSessionAction() {}

    public ArrayList<MovieSession> getMovieSession() {
        return getDatabase().getMovieSessionList();
    }
}
