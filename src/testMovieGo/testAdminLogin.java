package testMovieGo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayInputStream;

import org.junit.jupiter.api.Test;

import obj.Admin;
import obj.AdminLogin;
import obj.UserConsole;

public class testAdminLogin {
    @Test
    public void testAdminLogin() {
        String input="Jack\n123\n";
		System.setIn(new ByteArrayInputStream(input.getBytes()));

        UserConsole console = new UserConsole();
        AdminLogin adminLogin = new AdminLogin();
        
        Admin actual = (Admin)adminLogin.login(console);

        assertEquals("Jack", actual.getAccountName());
    }
}
