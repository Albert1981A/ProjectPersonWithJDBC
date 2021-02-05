package com.AlbertAbuav;

import com.AlbertAbuav.utils.DateUtils;

import java.time.LocalDate;
import java.util.Date;

public class PlayTestDate {

    public static void main(String[] args) {

        // Hardcoded date
        Date date1 = DateUtils.getDate(23, 3, 2002, 12, 20, 23);
        System.out.println(date1);

        // getting the local date and it will be reset every time the program will turn on
        Date date2 = DateUtils.javaDateFromLocalDate(LocalDate.now());
        System.out.println(date2);

        // getting the local date plus a week and it will be reset every time the program will turn on
        Date date3 = DateUtils.javaDateFromLocalDate(LocalDate.now().plusWeeks(1));
        System.out.println(date3);
    }
}
