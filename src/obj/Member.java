package obj;

import java.util.ArrayList;

public class Member extends Account {
	private String memberId;
	private String email;
	
	public Member(String memberId, String memberName, String email, String password) {
		super(memberName, password);
		this.memberId = memberId;
		this.email = email;
	}

	public String getMemberId() {
		return this.memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public ArrayList<Discount> getDiscountCode(){
		return null;
	}
}
