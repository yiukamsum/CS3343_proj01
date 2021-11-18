package obj;

import java.util.Scanner;

abstract class Page {
    private UserConsole console;

    public Page(UserConsole console) {
        this.console = console;
    }

    public Scanner getInputStream() {
        return this.console.getInputStream();
    }

    // entry of a page
    abstract public void display();
}
