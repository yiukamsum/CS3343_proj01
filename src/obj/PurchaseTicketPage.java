package obj;

import java.util.ArrayList;

public class PurchaseTicketPage extends Page {

    private MovieSessionCatalog sessionCatalog;

    public PurchaseTicketPage(MemberConsole console) {
        super(console);

        ArrayList<MovieSession> sessionList = new getMovieSessionAction().getMovieSession();
        sessionCatalog = new MovieSessionCatalog(sessionList);
    }

    @Override
    public void display() {
        // show the session catalog
        // and then ask user to select a session
        int input = 0;

        do {
            System.out.printf(
                "\n===Purchase Ticket===\n"+
                "(1) Show Movie Session List\n"+          
                "(2) Search session by movie name\n"+
                "(3) Search session by cinema name\n"+
                "(4) Purchase ticket\n"+
                "(-1) Leave this page\n");
            input = enterInt("");

            switch(input) {
                case 1:
                    sessionCatalog.removeFilter();
                    showSessionList();
                    break;
                case 2:
                    searchByMovieName();
                    showSessionList();
                    break;
                case 3:
                    searchByCinemaName();
                    showSessionList();
                    break;
                case 4:
                    purchaseTicket();
                    break;
                case -1:
                    break;
                default:
                    System.out.println("> Invalid Input\n");
            }

        } while (input != -1);
    }

    private void showSessionList() {
        System.out.printf("\n---Movie Session List---\n");
        sessionCatalog.show();
        System.out.printf("------------------------\n");
    }

    private void searchByMovieName() {
        String name = enterString("Enter movie name: ");
        sessionCatalog.filterByMovieName(name);
    }

    private void searchByCinemaName() {
        String name = enterString("Enter cinema name: ");
        sessionCatalog.filterByCinemaName(name);
    }

    private void purchaseTicket() {
        int input = 0;

        MovieSession selectSession = null;

        do {
            System.out.printf("Enter the session number to purchase its ticket (-1 to leave)\n");
            input = enterInt("");

            if(input == -1) { return; }

            selectSession = sessionCatalog.getItem(input-1);

            /* wrong index */
            if(selectSession == null) { 
                System.out.println("Wrong number"); 
            }
        } while(selectSession == null);



        ///////////////////////
        /* enter the session */
        //print seat plan
        System.out.println("---Seat Plan---");
        selectSession.printSeat();

        // ask how many ticket
        int ticketNum   = enterTicketNum();
        if(ticketNum == -1) { return; }
        
        // ask to select ticket type
        ArrayList<TicketType> selectedTicketType    = selectTicketType(ticketNum);
        if(selectedTicketType == null) { return; }

        // ask to select seat
        ArrayList<String> selectedSeatList          = selectSeat(ticketNum, selectSession);
        if(selectedSeatList == null) { return; }

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
        }
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
                    typeList.add(Adult.getInstance());
                    break;
                case 2:
                    typeList.add(Student.getInstance());
                    break;
                case 3:
                    typeList.add(Elderly.getInstance());
                    break;
                case 4:
                    typeList.add(Child.getInstance());
                    break;  
                case -1:
                    return null;              
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

            if(inputSeat.equals("-1")) { return null; }

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
            else if(input.equals("N") || input.equals("-1")) {
                return;
            }
        }
    }
}
