package obj;

public class Admin extends Account {
	private String adminId;
	private String name;
	
	public Admin(String accountName, String password) {
		super(accountName, password);
		this.adminId = "";
		this.name = "";
	}
	
	public void releaseDiscount(Discount discount) {
		String ds = discount.getDiscountCode();
	}

	public String getName() { 
		return this.name; 
	}
}
