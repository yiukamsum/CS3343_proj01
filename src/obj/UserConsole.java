package obj;

import java.util.Scanner;

public class UserConsole {

    // the scanner for accpet user input
    private final Scanner userInputStream = new Scanner(System.in);

    public Scanner getInputStream() {
        return userInputStream;
    };

    public void start() {
        int input = 0;
        do {
            System.out.printf(
                "\n===Start Page===\n"+
                "Login As:\n"+    
                "(1) Member\n"+    
                "(2) Admin\n"+
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

    public void clearConsole() {}
}
