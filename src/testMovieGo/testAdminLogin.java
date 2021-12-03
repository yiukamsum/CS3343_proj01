package testMovieGo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayInputStream;

import org.junit.jupiter.api.Test;

import obj.Admin;
import obj.AdminLogin;
import obj.DbAction;
import obj.UserConsole;

public class testAdminLogin {
    @Test
    public void testAdminLogin() {
        class getAdminAction extends DbAction {
            public Admin getAdmin() {
                return getDatabase().getAdmin("Jack", "123");
            }
        }

        String input="Jack\n123\n";
		System.setIn(new ByteArrayInputStream(input.getBytes()));

        UserConsole console = new UserConsole();
        AdminLogin adminLogin = new AdminLogin();
        
        Admin actual = (Admin)adminLogin.login(console);
        Admin expected = new getAdminAction().getAdmin();

        assertEquals(expected, actual);
    }
}
