package obj;

import java.util.ArrayList;


public class SessionManagingPage extends Page {

    Catalog<MovieSession> sessionCatalog;
    MovieSessionManageAction action;

    public SessionManagingPage(AdminConsole console) {
        super(console);

        ArrayList<MovieSession> sessionList = new getMovieSessionAction().getMovieSession();
        this.sessionCatalog = new Catalog<>(sessionList);

        this.action = new MovieSessionManageAction(console.getAdmin());
    }

    @Override
    public void display() {
        System.out.println("\n====Movie Session Managing====");   
        printSessionCatalog();

        String input = "";
        do {

            input = getNextLine();

            if(input.equals("A")) { 
                addSession(); 
                printSessionCatalog();
            }
            else if(input.equals("R")) { 
                removeSession(); 
                printSessionCatalog();
            }
            else if(!input.equals("-1")) { 
                System.out.println("Wrong Input"); 
            }

        } while(!input.equals("-1"));
    }
    

    private void printSessionCatalog() {
        System.out.println("\n---Movie Session Catalog---");
        sessionCatalog.show();
        System.out.println("-----------------------------");
        System.out.println("(A-add session, R-remove session, -1-exit page)");
    }

    private void addSession() {
        Movie movie;
        Cinema cinema;
        Theatre theatre;
        DateTime startTime;
        double duration;

        System.out.println("---Add session---");
        System.out.println("(Enter -1 to go back)");

        // ask for movie
        System.out.println("\n--[Select a Movie]--");
        movie = selectMovie();
        if(movie == null) { return; }

        // ask for cinema
        System.out.println("\n--[Select a Cinema]--");
        cinema = selectCinema();
        if(cinema == null) { return; }
        
        // ask for theatre
        System.out.println("\n--[Select a Theatra]--");
        theatre = selectTheatra(cinema);
        if(theatre == null) { return; }


        // ask for the start time
        System.out.println("\n[Enter Start Time]");
        startTime = enterStartTime();
        if(startTime == null) { return; }


        // create a movie session record
        action.createSessionRecord(movie, cinema, theatre, startTime);

        System.out.println("\n> Create session success");
    }

    private void removeSession() {
        int input = 0;

        System.out.println("---Remove Session---");
        
        System.out.println("(Enter -1 to go back)");
        do {
            System.out.printf("Enter the id of the session you want to remove: ");

            input = getNextInt();

            if(input == -1) { break; }

            MovieSession selectedSession = sessionCatalog.getItem(input-1);

            // wrong index
            if(selectedSession == null) { 
                System.out.println("Wrong number"); 
            }
            else {
                int sessionId = selectedSession.getSessionID();

                // call the db action to remove the cinema
                action.removeMovieSessionById(sessionId);
                
                System.out.println("Delete Success");

                // go back
                break;
            }
        } while (true);
    }



    private Movie selectMovie() {
        Catalog<Movie> movieList = new Catalog<>(new getMovieAction().getMovieList());
        Movie selectedMovie = null;

        System.out.println("--Movie List--");
        movieList.show();
        System.out.println("--------------");

        int input;
        do{
            System.out.printf("Enter the movie index: ");

            input = getNextInt();

            if(input == -1) { break; }

            selectedMovie = movieList.getItem(input-1);

        } while(selectedMovie == null);

        return selectedMovie;
    }

    private Cinema selectCinema() {
        Catalog<Cinema> cinemaList = new Catalog<>(new getCinemaAction().getCinemaList());
        Cinema selectedCinema = null;

        System.out.println("--Cinema List--");
        cinemaList.show();
        System.out.println("--------------");

        int input;
        do{
            System.out.printf("Enter the cinema index: ");

            input = getNextInt();

            if(input == -1) { break; }

            selectedCinema = cinemaList.getItem(input-1);

        } while(selectedCinema == null);

        return selectedCinema;
    }

    private Theatre selectTheatra(Cinema cinema) {
        Catalog<Theatre> theatraList = new Catalog<>(cinema.getTheatraList());
        Theatre selectedTheatra = null;

        System.out.println("--Theatra List--");
        theatraList.show();
        System.out.println("--------------");

        int input;
        do{
            System.out.printf("Enter the theatra index: ");

            input = getNextInt();

            if(input == -1) { break; }

            selectedTheatra = theatraList.getItem(input-1);

        } while(selectedTheatra == null);

        return selectedTheatra;
    }

    private DateTime enterStartTime() {
        int year, month, day, hour, minute;

        year = enterInt("Enter year: ");
        if(year == -1) { return null; }

        month = enterInt("Enter month: ");
        if(month == -1) { return null; }

        day = enterInt("Enter day: ");
        if(day == -1) { return null; }

        hour = enterInt("Enter hour: ");
        if(hour == -1) { return null; }

        minute = enterInt("Enter minute: ");
        if(minute == -1) { return null; }

        return new DateTime(year, month, day, hour, minute);
    }

}
