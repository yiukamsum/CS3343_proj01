package obj;

import java.util.ArrayList;

// Singleton
public class Database {
    private final static Database DBinstance = new Database();

    private ArrayList<MovieSession>     sessionList;
    private ArrayList<Member>           memberList;
    private ArrayList<Cinema>           cinemaList;
    private ArrayList<Movie>            movieList;
    private ArrayList<PurchaseHistory>  historyList;
    private Admin                       admin;

    private Database() {
        admin = Admin.getInstance();

        memberList = new ArrayList<Member>();
        memberList.add(new Member(1, "Peter", "123@gmail.com", "123"));

        cinemaList = new ArrayList<Cinema>();
        Cinema cinema = new Cinema(1, "loc A", "Cinema A", "12345678");
        cinema.addTheatre(new Theatre(1, 5, 5));
        cinemaList.add(cinema);

        movieList = new ArrayList<Movie>();
        ArrayList<String> actorList1 = new ArrayList<String>();
        actorList1.add("Actor A");
        ArrayList<String> actorList2 = new ArrayList<String>();
        actorList2.add("Actor B");
        ArrayList<String> actorList3 = new ArrayList<String>();
        actorList3.add("Actor C");
        actorList3.add("Actor D");
        movieList.add(new Movie(1, "Movie A", DateTime.today(), 2.0, actorList1));
        movieList.add(new Movie(2, "Movie B", DateTime.today(), 2.0, actorList2));
        movieList.add(new Movie(3, "Movie C", DateTime.today(), 3.0, actorList3));

        sessionList = new ArrayList<MovieSession>();
        sessionList.add(
            new MovieSession(1, cinemaList.get(0), cinemaList.get(0).getTheatre(1), movieList.get(0), DateTime.now())
        );

        historyList = new ArrayList<PurchaseHistory>();
    }

    public static Database connectDB(DbAction action) { 
        return DBinstance;
    }

    public ArrayList<Cinema> getCinemaList() {
        return this.cinemaList;
    }
    
    public ArrayList<Movie> getMovieList() {
        return this.movieList;
    }

    public ArrayList<MovieSession> getMovieSessionList() {
        return this.sessionList;
    }
    
    public ArrayList<PurchaseHistory> getPurchaseHistoryList() {
        return this.historyList;
    }

    public Member getMember(String accountName, String password) {
        for(Member member : memberList) {
            // check if the username and password is match with the parameter
            if(member.checkAccount(accountName, password)) {
                return member;
            }
        }

        // member not found
        return null;
    }
    public Admin getAdmin(String accountName, String password) { 
        if(admin.checkAccount(accountName, password)) { return admin; }
        return null; 
    }
}
