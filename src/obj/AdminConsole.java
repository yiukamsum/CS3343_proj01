package obj;

public class AdminConsole extends UserConsole {
    private Admin admin;

    public AdminConsole() {
        this.admin = null;
    }

    public Admin getAdmin() {
        return this.admin;
    }

    @Override
    public void start() {
        // ask member to login
        admin = (Admin) new AdminLogin().login(this);
        // user cancel login
        if(admin == null) { return; }


        /* Welcome Msg */
        System.out.printf("Welcome %s\n", admin.getName());


        /* Display admin menu */
        AdminMenuPage adminMenu = new AdminMenuPage(this);
        adminMenu.display();
    }
}
