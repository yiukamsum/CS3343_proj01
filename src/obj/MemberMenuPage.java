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
