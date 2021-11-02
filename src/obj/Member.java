package obj;

import java.util.ArrayList;

public class Member {
	private String memberId;
	private String memberName;
	private String email;
	private String password;
	
	public Member(String memberId, String memberName, String email, String password) {
		this.memberId = memberId;
		this.memberName = memberName;
		this.email = email;
	}

	public String getMemberId() {
		return this.memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getMemberName() {
		return this.memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public boolean checkPassword(String password) {
		return password.equals(this.password);
	}

	public ArrayList<Discount> getDiscountCode(){
		return null;
	}
}
