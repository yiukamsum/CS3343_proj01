package obj;

import java.util.ArrayList;

public class getCinemaAction extends DbAction {

    ArrayList<Cinema> cinemaList;
    
    public getCinemaAction() {
        cinemaList = getDatabase().getCinemaList();
    }

    public ArrayList<Cinema> getCinemaList() {
        return this.cinemaList;
    }
}
