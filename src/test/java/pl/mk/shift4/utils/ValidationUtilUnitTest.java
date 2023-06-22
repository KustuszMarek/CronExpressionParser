package pl.mk.shift4.utils;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pl.mk.shift4.ValidationException;


public class ValidationUtilUnitTest {

    @Test
    @DisplayName("Should throw exception for null input")
    void testNullInput() {
        assertThrows(
            ValidationException.class,
            () -> ValidationUtil.validateInput(null)
        );
    }

    @Test
    @DisplayName("Should throw exception for empty input")
    void testEmptyInput() {
        String input[] = {};
        assertThrows(
            ValidationException.class,
            () -> ValidationUtil.validateInput(input)
        );
    }

    @Test
    @DisplayName("Should throw exception for too short input")
    void testToShortInput() {
        String input[] = {"* * *"};
        assertThrows(
            ValidationException.class,
            () -> ValidationUtil.validateInput(input)
        );
    }

    @Test
    @DisplayName("Should throw exception for too long input")
    void testToLongInput() {
        String input[] = {"* * * * * * *"};
        assertThrows(
            ValidationException.class,
            () -> ValidationUtil.validateInput(input)
        );
    }

    @Test
    @DisplayName("Should throw exception for minutes outside of range input")
    void testMinutesOutsideOfInput() {
        String input[] = {"91 * * * * *"};
        assertThrows(
            ValidationException.class,
            () -> ValidationUtil.validateInput(input)
        );
    }

    @Test
    @DisplayName("Should throw exception for hours outside of range input")
    void testHoursOutsideOfInput() {
        String input[] = {"* 25 * * * *"};
        assertThrows(
            ValidationException.class,
            () -> ValidationUtil.validateInput(input)
        );
    }

    @Test
    @DisplayName("Should throw exception for doy of month outside of range input")
    void testDOMOutsideOfInput() {
        String input[] = {"* * 32 * * *"};
        assertThrows(
            ValidationException.class,
            () -> ValidationUtil.validateInput(input)
        );
    }

    @Test
    @DisplayName("Should throw exception for month outside of range input")
    void testMonthOutsideOfInput() {
        String input[] = {"* * * 13 * *"};
        assertThrows(
            ValidationException.class,
            () -> ValidationUtil.validateInput(input)
        );
    }

    @Test
    @DisplayName("Should throw exception for day of week outside of range input")
    void testDOWOutsideOfInput() {
        String input[] = {"* * * * 7 *"};
        assertThrows(
            ValidationException.class,
            () -> ValidationUtil.validateInput(input)
        );
    }

    @Test
    @DisplayName("Should throw exception for invalid month input")
    void testInvalidMonthInput() {
        String input[] = {"* * * BLAH * *"};
        assertThrows(
            ValidationException.class,
            () -> ValidationUtil.validateInput(input)
        );
    }

    @Test
    @DisplayName("Should throw exception for invalid day of week input")
    void testInvalidDOWInput() {
        String input[] = {"* * * * BLAH *"};
        assertThrows(
            ValidationException.class,
            () -> ValidationUtil.validateInput(input)
        );
    }

    @Test
    @DisplayName("Should validate asterisks as proper input")
    void testAsterisks() {
        String input[] = {"* * * * * test/path"};
        assertDoesNotThrow(
            () -> ValidationUtil.validateInput(input)
        );
    }

    @Test
    @DisplayName("Should validate single values as proper input")
    void testSingleValues() {
        String input[] = {"1 3 4 4 2 test/path"};
        assertDoesNotThrow(
            () -> ValidationUtil.validateInput(input)
        );
    }

    @Test
    @DisplayName("Should validate ranges values as proper input")
    void testRangesValues() {
        String input[] = {"1-3 1-3 3-5 1-2 3-5 test/path"};
        assertDoesNotThrow(
            () -> ValidationUtil.validateInput(input)
        );
    }

    @Test
    @DisplayName("Should validate comma separated values as proper input")
    void testCommasValues() {
        String input[] = {"1,3 1,3 3,5 1,2 3,5 test/path"};
        assertDoesNotThrow(
            () -> ValidationUtil.validateInput(input)
        );
    }

    @Test
    @DisplayName("Should validate slashes as proper input")
    void testSlashesValues() {
        String input[] = {"*/3 */3 */3 */3 */3 test/path"};
        assertDoesNotThrow(
            () -> ValidationUtil.validateInput(input)
        );
    }

    @Test
    @DisplayName("Should validate text values as proper input")
    void testTextValues() {
        String input[] = {"1 1 1 JAN SUN test/path"};
        assertDoesNotThrow(
            () -> ValidationUtil.validateInput(input)
        );
    }
}
