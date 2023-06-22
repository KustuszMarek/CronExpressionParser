package pl.mk.shift4;

import static pl.mk.shift4.config.Messages.COMMAND_OUTPUT_MESSAGE;
import static pl.mk.shift4.config.Messages.INVALID_CRON_MESSAGE;
import static pl.mk.shift4.config.Messages.OUTPUT_FORMAT;
import static pl.mk.shift4.utils.DatesUtil.getDayOfWeekName;
import static pl.mk.shift4.utils.DatesUtil.getMonthName;
import static pl.mk.shift4.utils.ValidationUtil.validateInput;

import pl.mk.shift4.config.ExpressionFieldProperties.DayOfMonth;
import pl.mk.shift4.config.ExpressionFieldProperties.DayOfWeek;
import pl.mk.shift4.config.ExpressionFieldProperties.Hour;
import pl.mk.shift4.config.ExpressionFieldProperties.Minute;
import pl.mk.shift4.config.ExpressionFieldProperties.Month;

/**
 * Hello world!
 *
 */
public class CronExpressionParser
{
    public static void main(String[] args) {
        try {
            validateInput(args);
        } catch (ValidationException e) {
            System.out.println(INVALID_CRON_MESSAGE);
            return;
        }

        String[] inputs = args[0].split(" ");
        normaliseExpression(inputs);
        generateOutput(inputs[0], Minute.MIN_VALUE, Minute.MAX_VALUE, Minute.OUTPUT_TEXT);
        generateOutput(inputs[1], Hour.MIN_VALUE, Hour.MAX_VALUE, Hour.OUTPUT_TEXT);
        generateOutput(inputs[2], DayOfMonth.MIN_VALUE, DayOfMonth.MAX_VALUE, DayOfMonth.OUTPUT_TEXT);
        generateOutput(inputs[3], Month.MIN_VALUE, Month.MAX_VALUE, Month.OUTPUT_TEXT);
        generateOutput(inputs[4], DayOfWeek.MIN_VALUE, DayOfWeek.MAX_VALUE, DayOfWeek.OUTPUT_TEXT);
        System.out.printf(OUTPUT_FORMAT, COMMAND_OUTPUT_MESSAGE, inputs[5]);
    }

    public static boolean isNumeric(String str) {
        return str.matches("-?\\d+(\\.\\d+)?");  //match a number with optional '-' and decimal.
    }

    private static void normaliseExpression(String[] expressionParts) {
        if(!isNumeric(expressionParts[4])) {
            for (int i = 0; i <= 6; i++) {
                expressionParts[4] = expressionParts[4].replace(getDayOfWeekName(i), String.valueOf(i));
            }
        }

        if(!isNumeric(expressionParts[3])) {
            for (int i = 1; i <= 12; i++) {
                expressionParts[3] = expressionParts[3].replace(getMonthName(i), String.valueOf(i));
            }
        }
    }

    private static void generateOutput(String expressionPart, int min, int max, String message) {
        StringBuilder sb = new StringBuilder();
        if (expressionPart.contains("-")) {
            String[] rangeParts = expressionPart.split("-");
            for (int i = Integer.parseInt(rangeParts[0]); i <= Integer.parseInt(rangeParts[1]); i++) {
                sb.append(i).append(" ");
            }
        } else if (expressionPart.contains("*/")) {
            int step = Integer.parseInt(expressionPart.replace("*/", ""));
            for (int i = min; i < max; i += step) {
                sb.append(i).append(" ");
            }
        } else if (expressionPart.contains(",")) {
            sb.append(expressionPart.replace(",", " "));
        } else if (expressionPart.contains("*")) {
            for (int i = min; i < max; i++) {
                sb.append(i).append(" ");
            }
        } else {
            sb.append(expressionPart);
        }
        System.out.printf(OUTPUT_FORMAT, message, sb.toString().trim());
    }
}
