package obj;

public class AdminConsole extends UserConsole {
    private Admin admin;

    @Override
    public void start() {
        int action = 0;

        System.out.printf("\n=====Admin=====\n");

        admin = (Admin)login();
        if(admin != null) { 
            // Welcome msg
            System.out.printf("Welcome %s\n", admin.getName());
        }

        while(admin != null && action != -1) {
            System.out.printf(
                "\n====Menu====\n"+
                "Enter -1 to logout\n"
            );
            
            action = userInputStream.nextInt();

            switch(action) {
                case -1:
                    break;
                default:
                    System.out.printf("Invalid Input\n");
            }
        }

        System.out.printf("\nBye Bye\n");
    }

    @Override
    public Account login() {
        return new AdminLogin().login(userInputStream);
    }
}
