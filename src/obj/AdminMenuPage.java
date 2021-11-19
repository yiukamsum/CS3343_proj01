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
                "Enter -1 to logout\n"
            );
            
            action = getInputStream().nextInt();

            switch(action) {
                case -1:
                    break;
                default:
                    System.out.printf("Invalid Input\n");
            }
        }
    }
}
