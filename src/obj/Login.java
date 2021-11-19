package obj;

public abstract class Login extends DbAction {

    /////////////////////
    /* Abstract Method */
    // Define how to get the account obj with the ac name and pw
    abstract protected Account getAccount(String accountName, String password);

    ///////////////////
    /* Public Method */
    // RETURN account object if login success, else return null
    public Account login(UserConsole console) {
        String accountName;
        String password;

        Account loginAccount = null;

        // for skipping the \n in the buffer
        console.getInputStream().nextLine();

        System.out.printf("\n====Login====\n");

        do{
            System.out.printf("(Enter -1 on both username and password to leave)\n");

            System.out.printf("Account Name: ");
            accountName = console.getInputStream().nextLine();
            System.out.printf("Password: ");
            password    = console.getInputStream().nextLine();

            /* check if -1 -1 is entered */
            if(accountName.equals("-1") && password.equals("-1")) { 
                // this means user cancel login
                break; 
            }

            // get the account obj with same ac name and password
            loginAccount = getAccount(accountName, password);

            // loginAccount will be null if user enter wrong name or pw
            if(loginAccount == null) {
                System.out.println("Wrong Account Name or Password\n");
            }

        }while(loginAccount == null);
        // repeat requiring username and pw while login fail and user doest cancel login

        return loginAccount;
    };
}
