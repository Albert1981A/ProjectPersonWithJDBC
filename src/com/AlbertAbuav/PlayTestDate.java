package com.AlbertAbuav;

import com.AlbertAbuav.beans.Hobby;
import com.AlbertAbuav.beans.Person;
import com.AlbertAbuav.utils.DateUtils;

import java.time.LocalDate;
import java.util.Date;

public class PlayTestDate {

    public static void main(String[] args) {

        // Hardcoded date
        Date date1 = DateUtils.getDate(25, 3, 2003, 22, 2, 23);
        System.out.println(DateUtils.beautifyDate(date1));

        Person person = new Person("avi", "TLV", DateUtils.getDate(25, 3, 2003, 22, 2, 23), Hobby.GO_TO_THE_BEACH);
        System.out.println(person);

        // getting the local date and it will be reset every time the program will turn on
        Date date2 = DateUtils.javaDateFromLocalDate(LocalDate.now());
        System.out.println(DateUtils.beautifyDate(date2));

        // getting the local date plus a week and it will be reset every time the program will turn on
        Date date3 = DateUtils.javaDateFromLocalDate(LocalDate.now().plusWeeks(1));
        System.out.println(DateUtils.beautifyDate(date3));
    }
}
