package obj;

public class AdminLogin extends Login {
    
    // get the admin from db
    @Override
    protected Account getAccount(String accountName, String password) {
        return getDatabase().getAdmin(accountName, password);
    }

}
