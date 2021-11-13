package obj;

import java.util.Scanner;

public abstract class UserConsole {

    ///////////////
    /* Attribute */
    // the scanner for accpet user input
    protected static Scanner userInputStream = new Scanner(System.in);

    /////////////////////
    /* Abstract Method */
    abstract void start();
    abstract Account login();

    ///////////////////
    /* Static Method */
    public static UserConsole getConsole() {
        System.out.printf(
            "Login As:\n"+    
            "Member\t(1)\n"+    
            "Admin\t(2)\n"    
        );

        // TODO: handle non Number input
        int userType = userInputStream.nextInt();

        while(userType != 1 && userType != 2) {
            System.out.printf("Please enter 1 or 2 to select the type: ");
            userType = userInputStream.nextInt();
        }

        // userInputStream.nextLine();

        // return user console base on the entered number
        if(userType == 1)   { return new MemberConsole(); }
        else/* must be 2 */ { return new AdminConsole();  }
    }
}
