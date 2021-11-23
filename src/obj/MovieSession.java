package obj;

import java.util.DuplicateFormatFlagsException;

public class MovieSession implements Comparable<MovieSession>, CatalogItem{

    private int sessionID;
    private Cinema cinema;
    private Theatre theatre;
    private Movie movie;
    private DateTime startTime;
    private boolean vancacy[][];

    public MovieSession(int sessionID, Cinema cinema, Theatre theatre, Movie movie, DateTime startTime){
        this.sessionID = sessionID;
        this.cinema = cinema;
        this.theatre = theatre;
        this.movie = movie;
        this.startTime = startTime;
        this.vancacy = new boolean[theatre.getRowNum()][theatre.getColNum()];
    }

    public Movie getMovie() {
        return this.movie;
    }

    public int getMovieID() {
        return this.movie.getMovieID();
    }

    public Theatre getTheatre() {
        return this.theatre;
    }

    public int getSessionID() {
        return this.sessionID;
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

    public int getCinemaID() {
        return this.cinema.getCinemaID();
    }

    public DateTime getEndTime() {
        double duration = this.movie.getDuration();
        int hourAdd = (int)(duration);
        int minuteAdd = (int)(duration-hourAdd)*60;
        DateTime endTime = DateTime.clone(this.startTime);
        endTime.addMinute(minuteAdd);
        endTime.addHour(hourAdd);
        
        return endTime;
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
        for(int i = 0; i < this.theatre.getRowNum(); i++){
            for(int j = 0; j < this.theatre.getColNum(); j++){
                if (vancacy[i][j] == false){
                    return false;
                }
            }
        }

        return true;
    }

    public void printSeat(){
        System.out.println("[Screen Here]");
        for(int i = 0; i < this.theatre.getRowNum(); i++){       
            for(int j = 0; j < this.theatre.getColNum(); j++){
                if(vancacy[i][j] == false){
                    System.out.printf("%c%d ", 65 + i, j);
                }else{
                    System.out.printf("## ");
                }
            }
            System.out.println("");
        }
    }

    public boolean doTimeOverlap(MovieSession session) {
        DateTime thisEndTime = this.getEndTime();
        DateTime thatEndTime = session.getEndTime();

        int startTimeCompare = this.startTime.compareTo(session.startTime);
        int endTimeCompare  = thisEndTime.compareTo(thatEndTime);


        // if whole of time section of this session is in that of other session
        if(startTimeCompare >= 0 && endTimeCompare <= 0) { return true; }

        // reverse of the pervious
        if(startTimeCompare <= 0 && endTimeCompare >= 0) { return true; }

        // if the start of other session is in the time section of this session
        if(startTimeCompare <= 0 && thisEndTime.compareTo(session.startTime) > 0) { return true; }

        // reverse of the pervious
        if(startTimeCompare >= 0 && thatEndTime.compareTo(this.startTime) < 0) { return true; }

        return false;
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
            "\tDuration: \t%.2f"
        , movie.getName(), cinema.getName(), theatre.getTheatreID(), startTime.toString(), movie.getDuration());
    }
}
