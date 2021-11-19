package obj;

public class MovieSession implements Comparable<MovieSession>, CatalogItem{

    private int sessionID;
    private Cinema cinema;
    private Theatre theatre;
    private Movie movie;
    private DateTime startTime;
    private DateTime endTime;
    private boolean vancacy [][] = new boolean[10][10];

    public MovieSession(int sessionID, Cinema cinema, Theatre theatre, Movie movie, DateTime startTime, DateTime endTime ){
        this.sessionID = sessionID;
        this.cinema = cinema;
        this.theatre = theatre;
        this.movie = movie;
        this.startTime = startTime;
        this.endTime = endTime;     
    }

    public Cinema getCinema() {
        return this.cinema;
    }

    public Movie getMovie() {
        return this.movie;
    }

    public Theatre getTheatre() {
        return this.theatre;
    }

    public void takeSeat(String seat){
        int row = (int)seat.charAt(0)-65;
        int col = (int)seat.charAt(1)-(int)('0');

        if(vancacy[row][col] == false){
            vancacy[row][col] = true;
            // System.out.println("Book the seat successfully!");
        }else{
            // System.out.println("The seat is already booked!");
        }

    }

    public boolean isSeatEmpty(String seat) {
        int row = (int)seat.charAt(0)-65;
        int col = (int)seat.charAt(1)-(int)('0');
        return !vancacy[row][col];
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
                    System.out.printf("## ");
                }
            }
            System.out.println("");
        }
    }



    @Override 
    public int compareTo(MovieSession session){
        return this.sessionID - session.sessionID;
    }

    @Override 
    public String toCatalogItemString(){
        return String.format(
            "\tMovie: \t\t%s\n"+
            "\tCinema: \t%s\n"+
            "\tTheatre: \t%s\n"+
            "\tStart time: \t%s\n"+
            "\tEnd time: \t%s\n"
        , movie.getName(), cinema.getName(), theatre.getTheatreID(), startTime.toString(), endTime.toString());
    }

    public String getMovieName() {
        return this.movie.getName();
    }

    public String getCinemaName() {
        return this.cinema.getName();
    }

    public int getTheatreID() {
        return this.theatre.getTheatreID();
    }

    public String getStartTime() {
        return this.startTime.toString();
    }
   
}
