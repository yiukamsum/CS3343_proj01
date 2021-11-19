package obj;

import java.util.ArrayList;

public class PurchaseTicketPage extends Page {

    private Catalog<MovieSession> sessionCatalog;

    public PurchaseTicketPage(MemberConsole console) {
        super(console);

        ArrayList<MovieSession> sessionList = new getMovieSessionAction().getMovieSession();
        sessionCatalog = new Catalog<MovieSession>(sessionList);
    }

    @Override
    public void display() {
        // show the session catalog
        // and then ask user to select a session
        int input = 0;

        System.out.printf("\n===Movie Sessions===\n");
        sessionCatalog.show();
        System.out.printf("--------------------\n");
        
        do {
            System.out.printf("Enter the session number to purchase its ticket (-1 to leave)\n");
            input = getInputStream().nextInt();

            if(input == -1) { break; }

            MovieSession selectSession = sessionCatalog.getItem(input-1);
            selectSession.printSeat();
        } while(input != -1);
    }    
}
