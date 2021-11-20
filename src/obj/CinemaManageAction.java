package obj;

import java.util.ArrayList;

public class CinemaManageAction extends DbAction{

    private ArrayList<Cinema> cinemaList;

    public CinemaManageAction(Admin admin) {
        cinemaList = getDatabase().getCinemaList();
    }

    public Cinema createCinemaRecord(String name, String location, String phoneNo, ArrayList<Theatre> theatreList) {
        int cinemaID = cinemaList.size()+1;
        Cinema cinema = new Cinema(cinemaID, location, name, phoneNo);
        for(Theatre theatre : theatreList) {
            cinema.addTheatre(theatre);
        }
        cinemaList.add(cinema);
        return cinema;
    }

    public void removeCinema(int cinemaID){
        for(Cinema c: cinemaList){
            if(c.getCinemaID() == cinemaID){
                cinemaList.remove(c);
                return;
            }
        }        
    }

    public void addTheatre(int cinemaID, Theatre theatre){
        for(Cinema c: cinemaList){
            if(c.getCinemaID() == cinemaID){
                c.addTheatre(theatre);
                return;
            }          
        }
            
        System.out.println("Cannot find the cinema!");
        
    }

    public void removeTheatre(int cinemaID, Theatre theatre){
        for(Cinema c: cinemaList){
            if(c.getCinemaID() == cinemaID){
                c.removeTheatre(theatre);
                return;
            }          
        }
            
        System.out.println("Cannot find the cinema!");
    }
}
