package obj;

public class Admin extends Account {
	private final static Admin instance = new Admin("Jack", "123");
	
	private Admin(String accountName, String password) {
		super(accountName, password);
	}

	public static Admin getInstance() {
		return instance;
	}

	public String getName() { 
		return getAccountName();
	}
}
