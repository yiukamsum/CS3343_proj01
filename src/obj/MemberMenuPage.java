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
                "------------------\n"+
                "Enter -1 to logout\n"
            );
            
            action = getInputStream().nextInt();
            getInputStream().nextLine();

            switch(action) {
                case 1:
                    new PurchaseTicketPage((MemberConsole)getConsole()).display();
                case -1:
                    break;
                default:
                    System.out.printf("Invalid Input\n");
            }
        }
    }
}
