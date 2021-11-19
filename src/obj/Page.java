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

    // entry of a page
    abstract public void display();
}
