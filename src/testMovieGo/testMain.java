package testMovieGo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Array;

import org.junit.jupiter.api.Test;

import obj.Main;

public class testMain {
    @Test
    public void testMain() {
        String input="-1\n";
		System.setIn(new ByteArrayInputStream(input.getBytes()));

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));

        Main main = new Main();
        main.main(null);

        String expected = String.format(
            "\n===Start Page===\n"+
            "Login As:\n"+    
            "(1) Member\n"+    
            "(2) Admin\n"+
            "-------------\n"+
            "Enter -1 to exit\n"
        );

        assertEquals(expected, outContent.toString());
    }
}
