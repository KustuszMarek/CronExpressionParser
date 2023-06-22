package pl.mk.shift4.utils;


import java.util.regex.Matcher;
import java.util.regex.Pattern;
import pl.mk.shift4.ValidationException;
import pl.mk.shift4.config.ExpressionFieldProperties.DayOfMonth;
import pl.mk.shift4.config.ExpressionFieldProperties.DayOfWeek;
import pl.mk.shift4.config.ExpressionFieldProperties.Hour;
import pl.mk.shift4.config.ExpressionFieldProperties.Minute;
import pl.mk.shift4.config.ExpressionFieldProperties.Month;

public class ValidationUtil {

    public static void validateInput(String[] args) throws ValidationException {
        if (args == null || args.length != 1) {
            throw new ValidationException();
        }

        String[] inputs = args[0].split(" ");

        if (inputs.length != 6) {
            throw new ValidationException();
        }

        validateField(inputs[0], Minute.VALIDATION_REGEX);
        validateField(inputs[1], Hour.VALIDATION_REGEX);
        validateField(inputs[2], DayOfMonth.VALIDATION_REGEX);
        validateField(inputs[3], Month.VALIDATION_REGEX);
        validateField(inputs[4], DayOfWeek.VALIDATION_REGEX);
    }

    private static void validateField(String field, String regex) throws ValidationException {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(field);
        if (!matcher.find()) {
            throw new ValidationException();
        }
    }
}
