package obj;

public abstract class Account {
    private String accountName;
    private String password;

    public Account(String accountName, String password) {
        this.accountName = accountName;
        this.password = password;
    }

    public String getAccountName() {
        return this.accountName;
    }

    public String getPassword() {
        return this.password;
    }

    // check the input username and pw are equal to those in this obj
    public boolean checkAccount(String accountName, String password) {
        return this.accountName.equals(accountName) && this.password.equals(password);
    }
}
