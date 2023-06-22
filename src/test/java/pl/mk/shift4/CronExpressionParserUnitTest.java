package pl.mk.shift4;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import junit.framework.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pl.mk.shift4.config.Messages;

public class CronExpressionParserUnitTest {

    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }

    @Test
    @DisplayName("Should display error for invalid input")
    void displayError() {
        String input[] = {};
        CronExpressionParser.main(input);
        Assert.assertEquals(Messages.INVALID_CRON_MESSAGE, outputStreamCaptor.toString()
            .trim());
    }

    @Test
    @DisplayName("Should display proper output")
    void displayProperOutput() {
        String input[] = {"*/15 0 1,15 * 1-5 /usr/bin/find"};
        String output = "minute         0 15 30 45\n"
            + "hour           0\n"
            + "day of month   1 15\n"
            + "month          1 2 3 4 5 6 7 8 9 10 11 12\n"
            + "day of week    1 2 3 4 5\n"
            + "command        /usr/bin/find";
        CronExpressionParser.main(input);
        Assert.assertEquals(output, outputStreamCaptor.toString()
            .trim());
    }

    @Test
    @DisplayName("Should display proper output for text values")
    void displayProperOutputForText() {
        String input[] = {"*/15 0 1,15 DEC MON-WED /usr/bin/find"};
        String output = "minute         0 15 30 45\n"
            + "hour           0\n"
            + "day of month   1 15\n"
            + "month          12\n"
            + "day of week    1 2 3\n"
            + "command        /usr/bin/find";
        CronExpressionParser.main(input);
        Assert.assertEquals(output, outputStreamCaptor.toString()
            .trim());
    }
}
