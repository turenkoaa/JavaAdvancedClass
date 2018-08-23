package com.db.jsr310;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.TextStyle;
import java.util.Locale;

public class Main {

    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.CHINESE));
        System.out.println(now.getDayOfWeek().getDisplayName(TextStyle.SHORT, Locale.JAPAN));
        System.out.println(now.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.JAPAN));
        System.out.println(now.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.CANADA_FRENCH));
        now.withDayOfMonth(29);
        LocalDate.of(1978, 12, 3);
    }
}
