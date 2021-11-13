package obj;

import javax.crypto.AEADBadTagException;

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
        if(member != null) { 
            // Welcome msg
            System.out.printf("Welcome %s\n", member.getAccountName());
        }

        while(member != null && action != -1) {
            System.out.printf(
                "\n====Menu====\n"+
                "1. Movie List\n"+
                "2. View Past Ticketing Records\n"+
                "3. View Member State\n"+
                "Enter -1 to logout\n"
            );
            
            action = userInputStream.nextInt();

            switch(action) {
                case 1:
                    movieList();
                    break;
                case 2:
                    viewTicketRecord();
                    break;
                case 3:
                    viewState();
                    break;
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


    ////////////////////
    /* Private Method */
    private void movieList() {
        System.out.println("movieList");
    }

    private void viewTicketRecord() {
        System.out.println("viewTicketRecord");
    }

    private void viewState() {
        System.out.println("viewState");
    }

    
}
