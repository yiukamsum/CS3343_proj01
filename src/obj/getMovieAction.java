package obj;

import java.util.ArrayList;

public class getMovieAction extends DbAction {
    public ArrayList<Movie> getMovieList() {
        return getDatabase().getMovieList();
    }
}
