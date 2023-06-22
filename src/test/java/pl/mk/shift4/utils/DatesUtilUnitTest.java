package pl.mk.shift4.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class DatesUtilUnitTest {

    @Test
    @DisplayName("Should map to proper day names")
    void testDays() {
        assertEquals(DatesUtil.getDayOfWeekName(0), "SUN");
        assertEquals(DatesUtil.getDayOfWeekName(1), "MON");
        assertEquals(DatesUtil.getDayOfWeekName(2), "TUE");
        assertEquals(DatesUtil.getDayOfWeekName(3), "WED");
        assertEquals(DatesUtil.getDayOfWeekName(4), "THU");
        assertEquals(DatesUtil.getDayOfWeekName(5), "FRI");
        assertEquals(DatesUtil.getDayOfWeekName(6), "SAT");
    }

    @Test
    @DisplayName("Should map to proper months names")
    void testMonths() {
        assertEquals(DatesUtil.getMonthName(1), "JAN");
        assertEquals(DatesUtil.getMonthName(2), "FEB");
        assertEquals(DatesUtil.getMonthName(3), "MAR");
        assertEquals(DatesUtil.getMonthName(4), "APR");
        assertEquals(DatesUtil.getMonthName(5), "MAY");
        assertEquals(DatesUtil.getMonthName(6), "JUN");
        assertEquals(DatesUtil.getMonthName(7), "JUL");
        assertEquals(DatesUtil.getMonthName(8), "AUG");
        assertEquals(DatesUtil.getMonthName(9), "SEP");
        assertEquals(DatesUtil.getMonthName(10), "OCT");
        assertEquals(DatesUtil.getMonthName(11), "NOV");
        assertEquals(DatesUtil.getMonthName(12), "DEC");
    }
}
