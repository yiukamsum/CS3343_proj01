package obj;

public class Member extends Account {
	private int memberId;
	private String email;
	
	public Member(int memberId, String memberName, String email, String password) {
		super(memberName, password);
		this.memberId = memberId;
		this.email = email;
	}

	public int getMemberId() {
		return this.memberId;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
