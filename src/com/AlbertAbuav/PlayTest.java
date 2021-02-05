package com.AlbertAbuav;

import com.AlbertAbuav.beans.Hobby;
import com.AlbertAbuav.beans.Person;
import com.AlbertAbuav.utils.DateUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class PlayTest {

    public static void main(String[] args) {
        try {
            // Setter Injection
            Person p1 = new Person();
            p1.setId(111);
            p1.setName("Ido");
            p1.setCity("TLV");
            p1.setBirthday(new SimpleDateFormat("dd/MM/yyyy - HH:mm:ss").parse("20/01/2001 - 15:30:45"));
            p1.setHobby(Hobby.PLAY_TENNIS);

            // CTOR Injection
            Person p2 = new Person("Ronny", "HLN", new SimpleDateFormat("dd/MM/yyyy - HH:mm:ss").parse("26/07/1986 - 22:15:13"), Hobby.GO_TO_THE_BEACH);

            Person p3 = new Person("Moshe", "RMG", DateUtils.getDate(25, 3, 2003, 22, 2, 23), Hobby.READ_BOOKS);

            System.out.println(p1);
            System.out.println(p2);
            System.out.println(p3);

        } catch (ParseException e) {
            System.out.println(e.getMessage());
        }

        // printing a contemporary system time
        System.out.println(DateUtils.beautifyDate(DateUtils.contemporaryDate()));

    }
}
