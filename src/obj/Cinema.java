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

	public void addTheatre(Theatre theatre) {
	    if(!theatreList.isEmpty()){
	        for(Theatre t: theatreList){
		    if(t == theatre){
		         System.out.println("The theatre is already existed!");
		         return;
		    }
	        }
	    }

	    theatreList.add(theatre);	
	    Collections.sort(theatreList);
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
	    String output = "Cinema ID: " + cinemaID + "\n";
	    output = output + "Name: " + name + "\n";
	    output = output + "Location: " + location + "\n";
	    output = output + "Phone number: " + phoneNo + "\n";
		
	    return output;
       }
		
}
