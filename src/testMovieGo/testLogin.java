package testMovieGo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.Test;

import obj.MemberLogin;
import obj.UserConsole;

public class testLogin {
    @Test
    public void testCancelLogin() {
        String input="-1\n-1\n";
		System.setIn(new ByteArrayInputStream(input.getBytes()));
		
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));

        UserConsole console = new UserConsole();
        MemberLogin memberLogin = new MemberLogin();

        memberLogin.login(console);

        String expected = String.format(
            "\n====Login====\n"+
            "(Enter -1 on both username and password to leave)\n"+
            "Account Name: "+
            "Password: "
        );

        assertEquals(expected, outContent.toString());
    }

    @Test
    public void testInvalidInput() {
        String input="-1\n321\n-1\n-1\n";
		System.setIn(new ByteArrayInputStream(input.getBytes()));
		
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));

        UserConsole console = new UserConsole();
        MemberLogin memberLogin = new MemberLogin();

        memberLogin.login(console);

        String expected = String.format(
            "\n====Login====\n"+
            "(Enter -1 on both username and password to leave)\n"+
            "Account Name: "+
            "Password: "+
            "Wrong Account Name or Password\n\r\n"+
            "(Enter -1 on both username and password to leave)\n"+
            "Account Name: "+
            "Password: "
        );

        assertEquals(expected, outContent.toString());
    }

    @Test
    public void testInvalidInput2() {
        String input="Peter\n321\n-1\n-1\n";
		System.setIn(new ByteArrayInputStream(input.getBytes()));
		
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));

        UserConsole console = new UserConsole();
        MemberLogin memberLogin = new MemberLogin();

        memberLogin.login(console);

        String expected = String.format(
            "\n====Login====\n"+
            "(Enter -1 on both username and password to leave)\n"+
            "Account Name: "+
            "Password: "+
            "Wrong Account Name or Password\n\r\n"+
            "(Enter -1 on both username and password to leave)\n"+
            "Account Name: "+
            "Password: "
        );

        assertEquals(expected, outContent.toString());
    }
}
