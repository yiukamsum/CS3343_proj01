package obj;

public class AdminMenuPage extends Page {
    // admin only page
    public AdminMenuPage(AdminConsole console) {
        super(console);
    }

    @Override
    public void display() {
        int action = 0;

        while(action != -1) {
            System.out.printf(
                "\n====Admin Menu====\n"+
                "(1) Manage Cinema\n"+
                "(2) Manage Movie\n"+
                "(3) Manage Movie Session\n"+
                "------------------\n"+
                "Enter -1 to logout\n"
            );
            
            action = getInputStream().nextInt();
            getInputStream().nextLine();

            switch(action) {
                case 1:
                    new CinemaManagingPage((AdminConsole)getConsole()).display();
                    break;
                case 2:
                    new MovieManagingPage((AdminConsole)getConsole()).display();
                    break;
                case 3:
                    new SessionManagingPage((AdminConsole)getConsole()).display();
                    break;
                case -1:
                    break;
                default:
                    System.out.printf("Invalid Input\n");
            }
        }
    }
}
