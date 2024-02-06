package org.example;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TimeConverterServiceTest {


    private static TimeConverterService timeConverterService;

    @BeforeAll
    static void init() {
        timeConverterService = new TimeConverterService();
    }

    @Test
    void convertSecondsToNormalTimeTest() {
        assertEquals("0 hour(s) : 0 min(s)", timeConverterService.convertSecondsToNormalTime(0));
    }

    @Test
    void convertSecondsToNormalTimeTestFailure() {
        assertNotEquals("0 hour(s) : 27 min(s)", timeConverterService.convertSecondsToNormalTime(28));
    }

    @Test
    void getDifferenceBetweenTimes() {
        assertEquals(60L, timeConverterService.getDifferenceBetweenTimes("22:30", "22:29"));
    }

    @Test
    void getDifferenceBetweenTimesFailure() {
        assertNotEquals(61L, timeConverterService.getDifferenceBetweenTimes("22:30", "22:29"));
    }


}
