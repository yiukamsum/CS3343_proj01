package obj;

public class MemberConsole extends UserConsole {

    ////////////////////
    /* Private Method */
    private Member member;


    ///////////////////
    /* Public Method */
    @Override
    public void start() {
        int action = 0;

        System.out.printf("\n=====Member=====\n");

        member = (Member)login();
        // it will be null if user cancel login
        if(member != null) { 
            // Welcome msg
            System.out.printf("Welcome %s\n", member.getAccountName());
        }

        while(member != null && action != -1) {
            System.out.printf(
                "\n====Menu====\n"+
                "Enter -1 to exit system\n"
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
        return new MemberLogin().login(userInputStream);
    }
}
