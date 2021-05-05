package ru.job4j.grabber.utils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class SqlRuDateTimeParser implements DateTimeParser {

    @Override
    public LocalDateTime parse(String parse56) {
        String[] s = parse56.replaceAll("[,]", "")
        .replaceAll("[:]", " ").split(" ");

        if (s[0].contains("сегодня")) {
            return LocalDate.now().atTime(Integer.parseInt(s[1]), Integer.parseInt(s[2]));
        } else if (s[0].contains("вчера")) {
            return LocalDate.now().atTime(Integer.parseInt(s[1]), Integer.parseInt(s[2])).minusDays(1);
        } else if (s[1].contains("дек")) {
            s[1] = "12";
        } else if (s[1].contains("ноя")) {
            s[1] = "11";
        } else if (s[1].contains("окт")) {
            s[1] = "10";
        } else if (s[1].contains("сент")) {
            s[1] = "09";
        } else if (s[1].contains("авг")) {
            s[1] = "08";
        } else if (s[1].contains("июл")) {
            s[1] = "07";
        } else if (s[1].contains("июн")) {
            s[1] = "06";
        } else if (s[1].contains("май")) {
            s[1] = "05";
        } else if (s[1].contains("апр")) {
            s[1] = "04";
        } else if (s[1].contains("мар")) {
            s[1] = "03";
        } else if (s[1].contains("фев")) {
            s[1] = "02";
        } else if (s[1].contains("янв")) {
            s[1] = "01";
        }

        String s1 = String.format(
                "20%s-%s-%s %s:%s", s[2], s[1], s[0], s[3], s[4]);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-d HH:mm");
        return LocalDateTime.parse(s1, formatter);
    }
}
