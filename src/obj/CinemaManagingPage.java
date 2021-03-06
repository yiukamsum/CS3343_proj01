package obj;

import java.util.ArrayList;

public class CinemaManagingPage extends Page {

    Catalog<Cinema> cinemaCatalog;
    CinemaManageAction action;

    public CinemaManagingPage(AdminConsole console) {
        super(console);

        cinemaCatalog = new Catalog<>(new getCinemaAction().getCinemaList());
        action = new CinemaManageAction(console.getAdmin());
    }

    @Override
    public void display() {        
        int input = 0;
        do {
            System.out.printf(
                "\n===Manage Cinema===\n"+
                "(1) Show Cinema List\n"+          
                "(2) Add Cinema\n"+          
                "(3) Remove Cinema\n"+
                "(-1) Leave this page\n");
            input = enterInt("");

            switch(input) {
                case 1:
                    printCinemaCatalog();
                    break;
                case 2:
                    addCinema(); 
                    printCinemaCatalog();
                    break;
                case 3:
                    removeCinema(); 
                    printCinemaCatalog();
                    break;
                case -1:
                    break;
                default:
                    System.out.println("Invalid Input"); 
            }

        } while(input != -1);
    }
    
    private void printCinemaCatalog() {
        System.out.println("\n---Cinema Catalog---");
        cinemaCatalog.show();
        System.out.println("--------------------");
    }

    private void addCinema() {
        String cinemaName;
        String cinemaLoc;
        String cinemaPhoneNo;
        ArrayList<Theatre> theatreList;


        System.out.println("---Add Cinema---");
        System.out.println("(Enter -1 to go back)");

        // ask for name 
        System.out.printf("\nEnter the cinema name: ");
        cinemaName = getInputStream().nextLine();
        if(cinemaName.equals("-1")) { return; }

        // ask for location
        System.out.printf("Enter the cinema location: ");
        cinemaLoc = getInputStream().nextLine();
        if(cinemaLoc.equals("-1")) { return; }

        // ask for phone number
        System.out.printf("Enter the cinema phone number: ");
        cinemaPhoneNo = getInputStream().nextLine();
        if(cinemaPhoneNo.equals("-1")) { return; }

        // ask for theatra
        theatreList = getTheatraList();
        // null will be returned if -1 is entered while adding theatra
        if(theatreList == null) { return; }

        /* store the new cinema record */
        action.createCinemaRecord(cinemaName, cinemaLoc, cinemaPhoneNo, theatreList);
    }

    private ArrayList<Theatre> getTheatraList() {
        ArrayList<Theatre> list = new ArrayList<>();
        int theatraNum;

        // ask for theatra num
        System.out.printf("Enter the Number of theatra this cinema has: ");
        theatraNum = getInputStream().nextInt();
        getInputStream().nextLine();
        if(theatraNum == -1) { return null; }

        // ask for theatra detail for each theatra
        for(int i = 0; i < theatraNum; i++) {
            int rowNum;
            int colNum;

            System.out.printf("[Theatra %d]\n", i+1);

            // ask for row Num
            System.out.printf("Enter the row number: ");
            rowNum = getInputStream().nextInt();
            getInputStream().nextLine();
            if(rowNum == -1) { return null; }


            // ask for col Num            
            System.out.printf("Enter the column number: ");
            colNum = getInputStream().nextInt();
            getInputStream().nextLine();
            if(colNum == -1) { return null; }

    
            // create theatra record
            list.add(new Theatre(i+1, colNum, rowNum));
        }

        return list;
    }

    private void removeCinema() {
        int input = 0;

        System.out.println("---Remove Cinema---");
        
        System.out.println("(Enter -1 to go back)");
        do {
            System.out.printf("Enter the item number of the cinema you want to remove: ");

            input = getInputStream().nextInt();
            getInputStream().nextLine();

            if(input == -1) { break; }

            Cinema selectedCinema = cinemaCatalog.getItem(input-1);

            // wrong index
            if(selectedCinema == null) { 
                System.out.println("Wrong number"); 
            }
            else {
                int cinemaID = selectedCinema.getCinemaID();

                // call the db action to remove the cinema
                action.removeCinema(cinemaID);
                
                // remove all movie session in the cinema
                MovieSessionManageAction sessionAction = new MovieSessionManageAction(((AdminConsole)getConsole()).getAdmin());
                sessionAction.removeMovieSessionInCinema(cinemaID);

                System.out.println("Delete Success");

                // go back
                break;
            }
        } while (true);
    }
}
