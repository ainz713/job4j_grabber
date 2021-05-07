package ru.job4j.grabber.utils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;
import java.util.HashMap;
import java.util.Map;

public class SqlRuDateTimeParser implements DateTimeParser {
    Map<Long, String> monthName = new HashMap<>();

    @Override
    public LocalDateTime parse(String parse56) {
        monthName.put(1L, "янв");
        monthName.put(2L, "фев");
        monthName.put(3L, "мар");
        monthName.put(4L, "апр");
        monthName.put(5L, "май");
        monthName.put(6L, "июн");
        monthName.put(7L, "июл");
        monthName.put(8L, "авг");
        monthName.put(9L, "сен");
        monthName.put(10L, "окт");
        monthName.put(11L, "ноя");
        monthName.put(12L, "дек");

        String[] s = parse56.replaceAll("[,]", "")
        .replaceAll("[:]", " ").split(" ");

        if (s[0].contains("сегодня")) {
            return LocalDate.now().atTime(Integer.parseInt(s[1]), Integer.parseInt(s[2]));
        } else if (s[0].contains("вчера")) {
            return LocalDate.now().atTime(Integer.parseInt(s[1]), Integer.parseInt(s[2])).minusDays(1);
        }

        DateTimeFormatter fmt = new DateTimeFormatterBuilder()
                .appendPattern("d ")
                .appendText(ChronoField.MONTH_OF_YEAR, monthName)
                .appendPattern(" yy, ")
                .appendPattern("HH:mm")
                .toFormatter();

        return LocalDateTime.parse(parse56, fmt);
    }
}
