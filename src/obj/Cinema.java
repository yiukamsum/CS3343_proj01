package obj;

import java.util.*;

public class Cinema implements Comparable<Cinema>, CatalogItem{
	private int cinemaID;
	private String location;
	private String name;
	private String phoneNo;
	private ArrayList<Theatre> theatreList = new ArrayList<Theatre>();
	
	public Cinema(int cinemaID, String location, String name, String phoneNo) {
		this.cinemaID = cinemaID;
		this.location = location;
		this.name = name;
		this.phoneNo = phoneNo;
	}

	public String getName() {
		return this.name;
	}
	
        public int getCinemaID() {
		return this.cinemaID;
	}
	
	public int getTheatreSize() {
               return this.theatreList.size();
        }

	public void addTheatre(Theatre theatre) {
	    if(!theatreList.isEmpty()){
	        for(Theatre t: theatreList){
				if(t == theatre){
					return;
				}
			}
	    }

	    theatreList.add(theatre);	
	    Collections.sort(theatreList);
	}

	public void removeTheatre(Theatre theatre){
		if(!theatreList.isEmpty()){
	            for(Theatre t: theatreList){					
	        	if(t.equals(theatre)){
			    	theatreList.remove(t);
	        		System.out.println("Remove a theatre.");	    
	        		return;
		         }
	             }
	        }

		System.out.println("Cannot Find the theatre!");

	}

	public Theatre getTheatre(int theatreID) {
		if(!theatreList.isEmpty()){
		    for(Theatre t: theatreList){
			if(t.getTheatreID() == theatreID)	     
			    return t;	
                
                     }
	         }
			
		 return null;
	}
		
	@Override
	public int compareTo(Cinema cinema){
	    return this.cinemaID - cinema.cinemaID;
	}
	
	@Override
        public String toCatalogItemString(){
		return String.format(
			"\tCinema ID: \t%d\n"+
			"\tCinema Name: \t%s\n"+
			"\tLocation: \t%s\n"+
			"\tPhone Number: \t%s\n"
		, cinemaID, name, location, phoneNo);
	}	
}
