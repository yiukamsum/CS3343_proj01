package obj;

import java.util.ArrayList;

public class CinemaManageAction extends DbAction{

    private ArrayList<Cinema> cinemaList;

    public CinemaManagerAction(Admin admin) {

        try{
            if(admin.equals(Admin.getInstance())){
                cinemaList = getDatabase().getCinemaList();
            }else{
                throw new SecurityException("You are not authorized to do!");
            }
        }catch (SecurityException e){
            System.out.println(e.getMessage());            
        }

    }

    public void addCinema(Cinema cinema){
        if(!cinemaList.contains(cinema)){
            cinemaList.add(cinema);
            System.out.println("Added a cinema.");
        }else{
            System.out.println("The cinema is already existed!");
        }

    }

    public void removeCinema(int cinemaID){
        for(Cinema c: cinemaList){
            if(c.getCinemaID() == cinemaID){
                cinemaList.remove(c);
                System.out.println("Removed the cinema.");
                return;
            }
        }

        System.out.println("Cinema does not exist!");
        
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
