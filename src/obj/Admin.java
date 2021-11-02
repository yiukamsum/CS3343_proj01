package obj;

public class Admin {
	private String adminId;
	private String name;
	
	public Admin() {
		this.adminId = "";
		this.name = "";
	}
	
	public void releaseDiscount(Discount discount) {
		String ds = discount.getDiscountCode();
	}
}
