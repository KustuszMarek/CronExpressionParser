package pl.mk.shift4.config;

public class ExpressionFieldProperties {

  public static class Minute {
    public static final int MIN_VALUE = 0;
    public static final int MAX_VALUE = 60;
    public static final String OUTPUT_TEXT = "minute";
    public static final String VALIDATION_REGEX = "^(\\*|\\*(?:\\/[0-9]|\\/(?:[1-5][0-9]))|(?:[0-9]|(?:[1-5][0-9]))(?:(?:\\-[0-9]|\\-(?:[1-5][0-9]))?|(?:\\,(?:[0-9]|(?:[1-5][0-9])))*))$";
  }

  public static class Hour {
    public static final int MIN_VALUE = 0;
    public static final int MAX_VALUE = 24;
    public static final String OUTPUT_TEXT = "hour";

    public static final String VALIDATION_REGEX = "^(\\*|\\*(?:\\/(?:[0-9]|1[0-9]|2[0-3]))?|(?:[0-9]|1[0-9]|2[0-3])(?:(?:\\-(?:[0-9]|1[0-9]|2[0-3]))?|(?:\\,(?:[0-9]|1[0-9]|2[0-3]))*))$";
  }

  public static class DayOfMonth {
    public static final int MIN_VALUE = 1;
    public static final int MAX_VALUE = 32;
    public static final String OUTPUT_TEXT = "day of month";

    public static final String VALIDATION_REGEX = "^(\\*|\\*(?:\\/(?:[1-9]|(?:[12][0-9])|3[01]))?|(?:[1-9]|(?:[12][0-9])|3[01])(?:(?:\\-(?:[1-9]|(?:[12][0-9])|3[01]))?|(?:\\,(?:[1-9]|(?:[12][0-9])|3[01]))*))$";

  }

  public static class Month {
    public static final int MIN_VALUE = 1;
    public static final int MAX_VALUE = 13;
    public static final String OUTPUT_TEXT = "month";
    public static final String VALIDATION_REGEX = "^(\\*|\\*(?:\\/(?:[1-9]|1[012]|JAN|FEB|MAR|APR|MAY|JUN|JUL|AUG|SEP|OCT|NOV|DEC))?|(?:[1-9]|1[012]|JAN|FEB|MAR|APR|MAY|JUN|JUL|AUG|SEP|OCT|NOV|DEC)(?:(?:\\-(?:[1-9]|1[012]|JAN|FEB|MAR|APR|MAY|JUN|JUL|AUG|SEP|OCT|NOV|DEC))?|(?:\\,(?:[1-9]|1[012]|JAN|FEB|MAR|APR|MAY|JUN|JUL|AUG|SEP|OCT|NOV|DEC))*))$";

  }

  public static class DayOfWeek {
    public static final int MIN_VALUE = 0;
    public static final int MAX_VALUE = 7;
    public static final String OUTPUT_TEXT = "day of week";
    public static final String VALIDATION_REGEX = "^(\\*|\\*(?:\\/(?:[0-6]|SUN|MON|TUE|WED|THU|FRI|SAT))?|(?:[0-6]|SUN|MON|TUE|WED|THU|FRI|SAT)(?:(?:\\-(?:[0-6]|SUN|MON|TUE|WED|THU|FRI|SAT))?|(?:\\,(?:[0-6]|SUN|MON|TUE|WED|THU|FRI|SAT))*))$";

  }
}
