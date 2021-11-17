package obj;

import java.util.*;

public class Cinema implements Comparable<Cinema>{
	private String cinemaID;
	private String location;
	private String name;
	private String phoneNo;
	private ArrayList<Theatre> theatreList = new ArrayList<Theatre>();
	
	public Cinema(String cinemaID, String location, String name, String phoneNo) {
		this.cinemaID = cinemaID;
		this.location = location;
		this.name = name;
		this.phoneNo = phoneNo;
	}

	public void addTheatre(Theatre theatre) {
	    if(!theatreList.empty()){
	        for(theatre t: theatreList){
		    if(t == theatre){
		         System.out.println("The theatre is already existed!");
		         return;
		    }
	        }
	    }

	    theatreList.add(theatre);	
	    collection.sort(theatreList);
	}

	public Theatre getTheatre(String theatreID) {
		if(!theatreList.empty()){
		    for(theatre t: theatreList){
			if(t.getTheatreID().equals(theatreID))	     
			    return t;			
		 }
			
		return NULL;
	}
		
	@Override
	public int compareTo(Cinema cinema){
	    return this.cinemaID.compareTo(cinema.cinemaID);
	}
				
        public String toCatalogItemString(){
	    
        }
		
}
