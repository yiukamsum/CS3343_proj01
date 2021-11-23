package obj;

import java.util.ArrayList;

public class viewMovieCatalogPage extends Page {

    private Catalog<Movie> movieCatalog;

    public viewMovieCatalogPage(MemberConsole console) {
        super(console);

        ArrayList<Movie> movieList = new getMovieAction().getMovieList();
        movieCatalog = new Catalog<Movie>(movieList);

    }
    
    @Override
    public void display() {

        System.out.printf("\n====View Movie====\n");

        int input = 0;
        String movieName;

        do {
             System.out.printf(
                "(1) Show Movie list\n"+          
                "(2) Search Movie by movie ID\n"+
                "(3) Search Movie by movie name\n"+
                "(-1) Leave this page\n");
            input = getInputStream().nextInt();

            if(input == -1) { break;}
            else if(input == 1){showMovieList();}
            else if(input == 2){
                    System.out.printf("Please enter movie ID: \n" );
                    input = getInputStream().nextInt();
                    searchMovieByID(input);}
            else if(input == 3){
                    System.out.printf("Please enter movie name: \n" );
                    getInputStream().nextLine();
                    movieName = getInputStream().nextLine();
                    searchMovieByName(movieName);
            }else{System.out.println("invalid input!" );}

        }while(input != -1);
    }

    public void showMovieList(){

        int i = 0;
        Movie m;

        System.out.printf("\n---Movie List---\n");
        while(movieCatalog.getItem(i) != null){
            m = movieCatalog.getItem(i);
            System.out.printf("%d. Movie ID: %d, Movie name: %s \n", i, m.getMovieID(), m.getName());
            i++;
        }
        System.out.printf("\n--------------\n");
    }


    public void searchMovieByID(int movieID){

        int i = 0;

        while(movieCatalog.getItem(i) != null){
            if(movieCatalog.getItem(i).getMovieID() == movieID){
            	System.out.println("===Movie Catalog===");
            	System.out.print("1." + movieCatalog.getItem(i).toCatalogItemString());
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
            	System.out.println("===Movie Catalog===");
            	System.out.print("1." + movieCatalog.getItem(i).toCatalogItemString());
                return;
            }

            i++;             
        }

        System.out.println("Cannot find the movie!");
    }

}
