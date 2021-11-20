package obj;

import java.util.ArrayList;

public class MovieManageAction extends DbAction{
    ArrayList<Movie> movieList;

    public MovieManageAction(Admin admin) {
        this.movieList = getDatabase().getMovieList();
    }

	public ArrayList<Movie> getMovieList() {
		return movieList;
	}

  public void addMovie(String movieName, DateTime releaseDate, ArrayList<String> actorList) {
    int movieID = movieList.size() + 1;
    for(Movie m: movieList) {
      if(m.getName().equals(movieName)) {
        System.out.println("The movie is already existed!");
        return;
      }
    }

    Movie movie = new Movie(movieID, movieName, releaseDate, actorList);

    System.out.println("Added a movie.");
  }

  public void removeMovieByID(int movieID) {
        if(movieID > movieList.size()) {
          System.out.println("The movie does not exist!");
        }else {
          movieList.remove(movieID - 1);
          System.out.println("Remove the movie.");
        }		
  }

  public void removeMovieByName(String movieName) {
    for(int i = 0; i < movieList.size(); i++) {
      if(movieList.get(i).getName().equals(movieName)) {
        movieList.remove(i);
        System.out.println("Remove the movie.");
        return;
      }
    }

      System.out.println("The movie does not exist!");

  }

}
