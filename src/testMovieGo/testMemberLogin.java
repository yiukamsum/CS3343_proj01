package testMovieGo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayInputStream;

import org.junit.jupiter.api.Test;

import obj.MemberLogin;
import obj.UserConsole;
import obj.Member;

public class testMemberLogin {
    @Test
    public void testMemberLogin() {
        String input="Peter\n123\n";
		System.setIn(new ByteArrayInputStream(input.getBytes()));

        UserConsole console = new UserConsole();
        MemberLogin memberLogin = new MemberLogin();
        
        Member actual = (Member)memberLogin.login(console);

        assertEquals("Peter", actual.getAccountName());
    }
}
