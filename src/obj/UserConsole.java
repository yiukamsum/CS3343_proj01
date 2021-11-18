package obj;

import java.util.Scanner;

public class UserConsole implements Console {

    // the scanner for accpet user input
    private final static Scanner userInputStream = new Scanner(System.in);

    @Override
    public Scanner getInputStream() {
        return userInputStream;
    };

    @Override
    public void start() {
        int input = 0;
        do {
            System.out.printf(
                "\n===Start Page===\n"+
                "Login As:\n"+    
                "Member\t(1)\n"+    
                "Admin\t(2)\n"+
                "-------------\n"+
                "Enter -1 to exit\n"
            );

            input = userInputStream.nextInt();

            switch(input) {
                case 1:
                    new MemberConsole().start();
                    break;
                case 2:
                    new AdminConsole().start();
                    break;
                case -1:
                    break;
                default:
                    System.out.println("Invalid Input\n");
            }
        } while(input != -1);        
    }
}
