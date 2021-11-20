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
                //print seat plan
                System.out.println("---Seat Plan---");
                selectSession.printSeat();

                // ask how many ticket
                int ticketNum   = enterTicketNum();
                
                // ask to select ticket type
                ArrayList<TicketType> selectedTicketType    = selectTicketType(ticketNum);

                // ask to select seat
                ArrayList<String> selectedSeatList          = selectSeat(ticketNum, selectSession);

                // create ticket list
                ArrayList<Ticket> ticketList                = createTickets(selectSession, ticketNum, selectedTicketType, selectedSeatList);

                // confirm msg
                boolean isConfirm = confirmSelection(selectSession, ticketList);

                if(isConfirm) {
                    PurchaseTicket purchaseTicket = new PurchaseTicket((MemberConsole)getConsole());

                    // process payment
                    boolean isPurchaseSuccess = purchaseTicket.purchase(selectSession, ticketList);

                    /* pay success */
                    if(isPurchaseSuccess) {
                        // take seats
                        takeSeats(selectSession, selectedSeatList);
                        // ask for printing ticket
                        askPrintTicket(ticketList);
                    }

                    break; // leave the page
                }
            }
        } while(input != -1);
    }


    private int enterTicketNum() {
        // ask how many seat user want to book
        System.out.printf("\nEnter the number of seat you want to book:");
        int num = getInputStream().nextInt();
        getInputStream().nextLine();

        return num;
    }

    private ArrayList<TicketType> selectTicketType(int ticketNum) {
        ArrayList<TicketType> typeList = new ArrayList<>();

        while(typeList.size() < ticketNum) {
            int inputType = 0;

            // ask user to select a ticket type of seat
            System.out.printf("Enter type of ticket %d (1-Adult, 2-Student, 3-Elderly, 4-Child): ", typeList.size()+1);
            inputType = getInputStream().nextInt();
            getInputStream().nextLine();

            switch(inputType) {
                case 1:
                    typeList.add(new Adult());
                    break;
                case 2:
                    typeList.add(new Student());
                    break;
                case 3:
                    typeList.add(new Elderly());
                    break;
                case 4:
                    typeList.add(new Child());
                    break;                
                default:
                    System.out.println("Wrong input");
            }
        }

        return typeList;
    }

    private ArrayList<String> selectSeat(int ticketNum, MovieSession session) {
        ArrayList<String> seatSelected  = new ArrayList<String>();

        // select seats
        while(seatSelected.size() < ticketNum) {
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

    private ArrayList<Ticket> createTickets(MovieSession session, int ticketNum, ArrayList<TicketType> ticketTypeList, ArrayList<String> seatList) {
        ArrayList<Ticket> res = new ArrayList<>();
        for(int ticketIdx = 0; ticketIdx < ticketNum; ticketIdx++) {
            res.add(new Ticket(ticketTypeList.get(ticketIdx), session, seatList.get(ticketIdx)));
        }
        return res;
    }

    private boolean confirmSelection(MovieSession selectSession, ArrayList<Ticket> ticketList){
        // movie info
        System.out.printf(
            "\n"+
            "--------------------------\n"+
            "You are buying ticket for:\n"+
            "Movie:\t\t%s\n"+
            "Cinema:\t\t%s\n"+
            "Theatra:\t%d\n"+
            "Start time:\t%s\n"+
            "\n"
        , selectSession.getMovieName(), selectSession.getCinemaName(), selectSession.getTheatreID(), selectSession.getStartTime());

        // ticket info
        for(int ticketIdx = 0; ticketIdx < ticketList.size(); ticketIdx++) {
            Ticket curTicket = ticketList.get(ticketIdx);
            System.out.printf(
                "Ticket %d:\n"+
                "Seat:\t%s\n"+
                "Type:\t%s\n"+
                "Price:\t%s\n"+
                "\n"
            , ticketIdx+1, curTicket.getSeat(), curTicket.getType(), curTicket.getPrice());
        }

        // ask for confirming tickets
        System.out.printf("Confirm Ticket? (Y-Yes, N-No)");
        String input = "";

        while(true) {
            input = getInputStream().nextLine();
            if(input.equals("Y")) {
                return true;
            }
            else if(input.equals("N")) {
                return false;
            }
        }
    }

    private void takeSeats(MovieSession session, ArrayList<String> seatList) {
        for(String seat : seatList) {
            session.takeSeat(seat);
        }
    }

    private void askPrintTicket(ArrayList<Ticket> paidTickets) {
        System.out.printf("\nPrint Ticket? (Y-Yes, N-No)");
        String input = "";

        while(true) {
            input = getInputStream().nextLine();
            if(input.equals("Y")) {
                PrintTicket printTicket = new PrintTicket();
                for(Ticket ticket : paidTickets) {
                    printTicket.print(ticket);
                }
                return;
            }
            else if(input.equals("N")) {
                return;
            }
        }
    }
}
