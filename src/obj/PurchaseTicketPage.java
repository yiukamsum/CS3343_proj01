package obj;

import java.util.ArrayList;

public class PurchaseTicketPage extends Page {

    private Catalog sessionCatalog;

    public PurchaseTicketPage(MemberConsole console) {
        super(console);

        ArrayList<MovieSession> sessionList = new getMovieSessionAction().getMovieSession();
        sessionCatalog = new Catalog(sessionList);
    }

    @Override
    public void display() {
        // show the session catalog
        // and then ask user to select a session

        System.out.printf("\n===Movie Sessions===\n");
        sessionCatalog.show();
    }
    
}
