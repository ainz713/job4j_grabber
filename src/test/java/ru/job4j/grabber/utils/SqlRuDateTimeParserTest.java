package ru.job4j.grabber.utils;

import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import static org.junit.Assert.*;

public class SqlRuDateTimeParserTest {

    @Test
    public void parseDate1() {
        LocalDateTime date = LocalDateTime.of(2021, 2, 8, 23, 30);
        assertEquals(date, new SqlRuDateTimeParser().parse("8 фев 21, 23:30"));
    }

    @Test
    public void parseDate2() {
        LocalDateTime date = LocalDateTime.of(2021, 2, 28, 23, 30);
        assertEquals(date, new SqlRuDateTimeParser().parse("28 фев 21, 23:30"));
    }

    @Test
    public void parseDateToday() {
        LocalDateTime date = LocalDate.now().atTime(22, 29);
        assertEquals(date, new SqlRuDateTimeParser().parse("сегодня, 22:29"));
    }

    @Test
    public void parseDateYesterday() {
        LocalDateTime date = LocalDate.now().atTime(22, 29).minusDays(1);
        assertEquals(date, new SqlRuDateTimeParser().parse("вчера, 22:29"));
    }
}