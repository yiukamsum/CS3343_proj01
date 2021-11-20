package obj;

public class MemberMenuPage extends Page {

    // member only page
    public MemberMenuPage(MemberConsole console) {
        super(console);
    }

    @Override
    public void display() {
        int action = 0;

        while(action != -1) {
            System.out.printf(
                "\n====Member Menu====\n"+
                "(1)Purchase Ticket\n"+
                "(2)View Purchase History\n"+
                "(3)View Movie\n"+
                "------------------\n"+
                "Enter -1 to logout\n"
            );
            
            action = getInputStream().nextInt();

            switch(action) {
                case 1:
                    new PurchaseTicketPage((MemberConsole)getConsole()).display();
                    break;
                case 2:
                    new viewHistoryCatalogPage((MemberConsole)getConsole()).display();
                    break;
                case 3:
                    new viewMovieCatalogPage((MemberConsole)getConsole()).display();
                    break;
                default:
                    System.out.printf("Invalid Input\n");
            }
        }
    }
}
