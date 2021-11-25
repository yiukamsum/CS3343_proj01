package testMovieGo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;

import obj.Account;
import obj.Member;
public class testAccount {
	@Test
	public void testGetAccountName() {
		Member memberAccount =new Member(1,"amy123","amy123@gmail.com","123456") ;
		String resString=memberAccount.getAccountName();
		assertEquals("amy123", resString);
		
	}
	@Test
	public void testCheckAccount() {
		Member memberAccount =new Member(1,"amy123","amy123@gmail.com","123456") ;
		Boolean resBoolean=memberAccount.checkAccount("amy123", "123456");
		assertEquals(true, resBoolean);
		
	}
	@Test
	public void testCheckAccount2() {
		Member memberAccount =new Member(1,"amy123","amy123@gmail.com","123456") ;
		Boolean resBoolean=memberAccount.checkAccount("amy123", "123436");
		assertEquals(false, resBoolean);
		
	}
	@Test
	public void testCheckAccount3() {
		Member memberAccount =new Member(1,"amy123","amy123@gmail.com","123456") ;
		Boolean resBoolean=memberAccount.checkAccount("ken1223", "123436");
		assertEquals(false, resBoolean);
		
	}

}
