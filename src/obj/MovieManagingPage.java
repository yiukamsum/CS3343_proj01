package obj;

import java.util.ArrayList;

public class MovieManagingPage extends Page {

    private Catalog<Movie> movieCatalog;
    private MovieManageAction action;

    public MovieManagingPage(AdminConsole console) {
        super(console);
        action = new MovieManageAction(console.getAdmin());

        ArrayList<Movie> movieList = action.getMovieList();
        movieCatalog = new Catalog<Movie>(movieList);

    }
    
    @Override
    public void display() {

        System.out.printf("\n====Manage Movie====\n");

        int input = 0;
        String movieName;

        do {
             System.out.printf(
                "(1) Show Movie list\n"+          
                "(2) Search Movie by movie ID\n"+
                "(3) Search Movie by movie name\n"+
                "(4) Add movie\n"+
                "(5) Remove movie\n"+
                "(-1) Leave this page\n");
            input = enterInt("");

            if(input == -1) { break;}
            else if(input == 1){showMovieList();}
            else if(input == 2){
                    System.out.printf("Please enter movie ID: \n" );
                    input = getInputStream().nextInt();
                    searchMovieByID(input);
            }
            else if(input == 3){
                    System.out.printf("Please enter movie name: \n" );
                    movieName = getInputStream().nextLine();
                    searchMovieByName(movieName);
            }
            else if(input == 4){addMovie();}
            else if(input == 5){removeMovie();}
            else{System.out.println("invalid input!" );}
            
         }while(input != -1);
    }

    public void showMovieList(){

          int i = 0;
          Movie m;
          while(movieCatalog.getItem(i) != null){
              m = movieCatalog.getItem(i);
              System.out.printf("%d. Cinema ID: %d, Cinema name: %s, Duration: %.2f \n", i, m.getMovieID(), m.getName(), m.getDuration());
              i++;
          }

    }


    public void searchMovieByID(int movieID){

        int i = 0;
        Movie m;
        
        while(movieCatalog.getItem(i) != null){
            m = movieCatalog.getItem(i);
            if(m.getMovieID() == movieID){
                m.toCatalogItemString();
                return;
            }
            i++;
               
        }

        System.out.println("Cannot find the movie!");
    }

    public void searchMovieByName(String movieName){

        int i = 0;
        Movie m;
        
        while(movieCatalog.getItem(i) != null){
            m = movieCatalog.getItem(i);
            if(m.getName().equals(movieName)){
                m.toCatalogItemString();
                return;
            }

            i++;             
        }

        System.out.println("Cannot find the movie!");
    }
    
    private void addMovie() {
         String input = "", movieName;
         DateTime releaseDate;
         int year, month, day;
         double duration;
         ArrayList<String> actorList = new ArrayList<String>();
         
         System.out.println("\n====Add Movie====\n");
         System.out.println("Enter -1 to quit this session");
         
         movieName = enterString("Enter the movie name: ");
         if(movieName.equals("-1")) {return;}
         
         year = enterInt("Enter the year of the release date: ");
         if(year == -1) {return;}

         month = enterInt("Enter the month of the release date: ");
         if(month == -1) {return;}

         day = enterInt("Enter the day of the release date: ");
         if(day == -1) {return;}
         
         releaseDate = new DateTime(year, month, day);

         duration = enterDouble("Enter duration of the movie(in hour): ");
         if(duration == -1.0) { return; }
         
         System.out.println("Enter the actor name. Enter Done to end the action.");
         while(!input.equals("Done")) {
             input = enterString("");
        	 actorList.add(input);
         }
         
         action.addMovie(movieName, releaseDate, duration, actorList);
	}

	private void removeMovie() {
		int input = 0;
        System.out.println("\n====Remove Movie====\n");   
        System.out.println("Enter 1 to remove movie by Id and 2 to remove movie by name");          
        input = enterInt("");
    
        if(input == 1) {
        	int movieID = enterInt("Enter movie ID (Enter -1 to end this session): ");
            action.removeMovieByID(movieID);
        }else {
        	String movieName = enterString("Enter movie Name (Enter Exit to end this session): ");
        	if(movieName.equals("Exit")) { return; }
            action.removeMovieByName(movieName);
        }
	}
}
