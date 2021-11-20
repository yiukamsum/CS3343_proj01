package obj;

import java.util.ArrayList;

public class viewMovieCatalogPage extends page {

    private Catalog<Movie> movieCatalog;

    public viewMovieCatalogPage(MemberConsole console) {
        super(console);

        ArrayList<PurchaseHistory> movieList = new getMovieAction().getMovieList();
        movieCatalog = new Catalog<PurchaseHistory>(movieList);

    }
    
    @Override
    public void display() {

        System.out.printf("\n====View Movie====\n");

        int input = 0;
        String movieName;
        showHistoryIDList();

        do {
             System.out.printf(
                "(1) Show Movie list\n"+          
                "(2) Search Movie by movie ID\n"+
                "(3) Search Movie by movie name\n"+
                "(-1) Leave this page\n");
            input = getInputStream().nextInt();

            if(input == -1) { break;}
            else if(input == 1){showHistoryIDList();}
            else if(input == 2){
                    System.out.printf("Please enter movie ID: \n" );
                    input = getInputStream().nextInt();
                    searchMovieByID(input);}
            else if(input == 3){
                    System.out.printf("Please enter movie name: \n" );
                    movieName = getInputStream().nextLine();
                    searchMovieByName(movieName);
            }else{System.out.println("invalid input!" );}

        }while(input != -1);
    }

    public void showMovieList(){

        int i = 0;
        while(movieCatalog.getItem(i) != null){
            System.out.printf("%d. Cinema ID: %d, Cinema name: %s \n", i, m.getMovieID(), m.getName());
            i++;
        }

    }


    public void searchMovieByID(int movieID){

        int i = 0;
        while(m.getItem(i) != null){
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
        while(m.getItem(i) != null){
            if(m.getMovieName().equals(movieName)){
                m.toCatalogItemString();
                return;
            }

            i++;             
        }

        System.out.println("Cannot find the movie!");
    }

}
