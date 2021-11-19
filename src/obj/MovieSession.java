package obj;

public class MovieSession implements Comparable<MovieSession>, CatalogItem{

    private String sessionID;
    private Cinema cinema;
    private Theatre theatre;
    private Movie movie;
    private DateTime startTime;
    private DateTime endTime;
    private boolean vancacy [][] = new boolean[10][10];

    public MovieSession(String sessionID, Cinema cinema, Theatre theatre, Movie movie, DateTime startTime, DateTime endTime ){
        this.sessionID = sessionID;
        this.cinema = cinema;
        this.theatre = theatre;
        this.movie = movie;
        this.startTime = startTime;
        this.endTime = endTime;     
    }

    public void takeSeat(int row, int col){
        if(vancacy[row][col] == false){
            vancacy[row][col] = true;
            System.out.println("Book the seat successfully!");
        }else{
            System.out.println("The seat is already booked!");
        }

    }

    public boolean isFull(){
        for(int i = 0; i < 10; i++){
            for(int j = 0; j < 10; j++){
                if (vancacy[i][j] == false){
                    return false;
                }
            }
        }

        return true;
    }

    public void printSeat(){
        for(int i = 0; i < 10; i++){       
            for(int j = 0; j < 10; j++){
                if(vancacy[i][j] == false){
                    System.out.printf("%c%d ", 65 + i, j);
                }else{
                    System.out.printf("   ");
                }
            }
            System.out.println("");
       
        }
    }



    @Override 
    public int compareTo(MovieSession session){
        return this.sessionID.compareTo(session.sessionID);
    }

    @Override 
    public String toCatalogItemString(){
        String output = "";
        output = output + "Cinema: " + cinema.getName() + "\n";
        output = output + "Theatre ID: " + theatre.getTheatreID() + "\n";
        output = output + "Movie: " + movie.getName() + "\n";
        output = output + "Start Time: " + startTime.toCatalogItemString() + "\n";
        output = output + "End Time: " + endTime.toCatalogItemString() + "\n";
    
        return output;

    }
   
}

}
