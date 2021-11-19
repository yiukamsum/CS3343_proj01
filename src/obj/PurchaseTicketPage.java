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

            if(selectSession != null) {
                ArrayList<String> selectedSeatList = selectSeat(selectSession);
            }

        } while(input != -1);
    }


    private ArrayList<String> selectSeat(MovieSession session) {
        ArrayList<String> seatSelected = new ArrayList<String>();
        int seatNum         = 0; // number of seats user want to book

        // print out the seat plan
        System.out.println("---Seat Plan---");
        session.printSeat();

        // ask how many seat user want to book
        System.out.println("Enter the number of seat you want to book: ");
        seatNum = getInputStream().nextInt();

        getInputStream().nextLine();

        // select seats
        while(seatSelected.size() < seatNum) {
            String inputSeat = new String();

            // ask user to enter a seat
            System.out.printf("Enter seat %d: ", seatSelected.size()+1);
            inputSeat = getInputStream().nextLine();

            if(session.isSeatEmpty(inputSeat)) { 
                seatSelected.add(inputSeat);
            }
            else {
                System.out.println("This seat is booked!");
            }
        }

        return seatSelected;
    }
}
