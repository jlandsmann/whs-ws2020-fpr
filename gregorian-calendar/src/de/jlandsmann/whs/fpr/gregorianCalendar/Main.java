package de.jlandsmann.whs.fpr.gregorianCalendar;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.time.temporal.WeekFields;
import java.util.Locale;

public class Main {

    private static final int DAYS_OF_WEEK = 7;
    private static final Locale LOCALE = Locale.getDefault();
    private static final DayOfWeek FIRST_DAY_OF_WEEK = WeekFields.of(LOCALE).getFirstDayOfWeek();


    public static void main(String[] args) {
        int year = Integer.parseInt(args[0]);
        int month = Integer.parseInt(args[1]);
        int day = Integer.parseInt(args[2]);
        System.out.printf("%4d-%2d-%2d%n", year, month, day);
        LocalDate date = LocalDate.of(year, month, day);
        printMonth(date);
    }

    private static void printMonth(LocalDate date) {
        boolean isLeapYear = date.getYear() % 4 == 0;
        int daysOfMonth = date.getMonth().length(isLeapYear);
        int selectedDay = date.getDayOfMonth();
        LocalDate firstDay = date.withDayOfMonth(1);        
        int pre = (DAYS_OF_WEEK + firstDay.getDayOfWeek().getValue() - FIRST_DAY_OF_WEEK.getValue()) % DAYS_OF_WEEK;
        int neededRows = (int) Math.ceil((daysOfMonth + pre) / DAYS_OF_WEEK);
        int currentDayOfMonth = -pre;
        printWeekdays();
        for (int row = 0; row <= neededRows; row++) {
            for (int col = 0; col < DAYS_OF_WEEK; col++) {
                currentDayOfMonth++;
                if (currentDayOfMonth > daysOfMonth) {
                    break;
                }
                printCell(currentDayOfMonth, currentDayOfMonth == selectedDay);
            }
            printLineBreak();
        }
    }

    private static void printWeekdays() {
        var firstDayOfWeek = FIRST_DAY_OF_WEEK.getValue() - 1;
        var days = DayOfWeek.values();
        for (int i = 0; i < days.length; i++) {
            var day = days[(firstDayOfWeek + i) % days.length];
            System.out.printf("%4s ", day.getDisplayName(TextStyle.SHORT_STANDALONE, LOCALE));
        }
        printLineBreak();
    }

    private static void printLineBreak() {
        System.out.print("\n");
    }

    private static void printCell(int day, boolean selected) {
        if (day <= 0) {
            printEmptyCell();
        } else if (selected) {
            System.out.printf("%4d*", day);
        } else {
            System.out.printf("%4d ", day);
        }
    }

    private static void printEmptyCell() {
        System.out.printf("%4s ", "");
    }
}
