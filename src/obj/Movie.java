package obj;

import java.util.*;

public class Movie implements Comparable<Movie>, CatalogItem{

    private int movieID;
    private String name;
    private DateTime releaseDate;
    private double duration;
    private ArrayList<String> actorList = new ArrayList<String>();

    public Movie(int movieID, String name, DateTime releaseDate, double duration, ArrayList<String> actorList){
        this.movieID = movieID;
        this.name = name;
        this.releaseDate = releaseDate;
        this.duration = duration;
        this.actorList.addAll(actorList);
    }

    public String getName() {
        return this.name;
    }
    
    public int getMovieID(){
        return this.movieID;
    }

    @Override
    public int compareTo(Movie movie){
        return this.movieID - movie.movieID;
    }
    
    @Override
    public String toCatalogItemString(){
        String output = "";
        output = output + "\tMovie ID: " + movieID + "\n";
        output = output + "\tName: " + name + "\n";
        output = output + "\tRelease Date " + releaseDate.toString() + "\n";
        output = output + "\tActor List: ";
        
        for(String s: actorList){
            output = output + s + " ";
        }
        
        output = output + "\n";
        output = output + "\tDuration: " + duration + "\n";



        return output;
    }

    public double getDuration() {
        return this.duration;
    }
}

