package obj;

public class AdminLogin extends Login {
    
    // get the admin from db
    @Override
    protected Account getAccount(String accountName, String password) {
        Database db = Database.connectDB();
        return db.getAdmin(accountName, password);
    }

}
