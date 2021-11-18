package obj;

public class MemberLogin extends Login {

    // get the member from db
    @Override
    protected Account getAccount(String accountName, String password) {
        Database db = Database.connectDB();
        return db.getMember(accountName, password);
    }

}
