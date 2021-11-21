package obj;

import java.util.Scanner;

abstract class Page {
    private UserConsole console;

    public Page(UserConsole console) {
        this.console = console;

        //clear the console, not work now
        console.clearConsole();
    }

    public Scanner getInputStream() {
        return this.console.getInputStream();
    }

    public UserConsole getConsole() {
        return this.console;
    }

    protected String getNextLine() {
        return console.getInputStream().nextLine();
    }

    protected int getNextInt() {
        int res = console.getInputStream().nextInt();
        console.getInputStream().nextLine();
        return res;
    }

    protected String enterString(String msg) {
        System.out.printf(msg);
        return console.getInputStream().nextLine();
    }

    protected int enterInt(String msg) {
        System.out.printf(msg);
        int res = console.getInputStream().nextInt();
        console.getInputStream().nextLine();
        return res;     
    }

    // entry of a page
    abstract public void display();
}
