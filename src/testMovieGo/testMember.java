package testMovieGo;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;

import obj.Member;
public class testMember {
	@Test
	public void testGetMemberId() {
		Member member=new Member(1, "Kitty", "kittycheung@gmail.com", "123456");
		assertEquals(1, member.getMemberId());
	}
	@Test
	public void testGetEmail() {
		Member member=new Member(1, "Kitty", "kittycheung@gmail.com", "123456");
		assertEquals("kittycheung@gmail.com", member.getEmail());
	}
	@Test
	public void testSetEmail() {
		Member member=new Member(1, "Kitty", "kittycheung@gmail.com", "123456");
		member.setEmail("kittycheung@yahoo.com.hk");
		assertEquals("kittycheung@yahoo.com.hk", member.getEmail());
	}
	
}
