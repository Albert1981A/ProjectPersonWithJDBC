package com.AlbertAbuav;

import com.AlbertAbuav.beans.Hobby;
import com.AlbertAbuav.beans.Person;
import com.AlbertAbuav.dao.PersonDAO;
import com.AlbertAbuav.db.ConnectionPool;
import com.AlbertAbuav.db.DatabaseManager;
import com.AlbertAbuav.dbdao.PersonDBDAO;
import com.AlbertAbuav.utils.ArtUtils;
import com.AlbertAbuav.utils.DateUtils;

public class Test1 {

    public static void main(String[] args) {
        /**
         * JDBC - Java Database Connectivity
         * Their are five steps to perform an operation from the code to the database
         * 1. Setup to MySql Driver
         * 2. Open connection to Database
         * 3. Prepared Statement (fox example: select * from... / insert into...)
         * 4. ResultSet (Optional) - Get from DB results into ResultSet
         * 5. Close connection to Database
         */

        System.out.println("START");

        /**
         * Step 1 - Setup to MySql Driver using Reflection API
         */
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }

        /**
         * creating 10 connections loaded in "Stuck" in "ConnectionPool" class.
         */
        ConnectionPool.getInstance();

        /**
         * using the "DatabaseManager" query's to create and drop "Schemas" and "Tables".
         */
        DatabaseManager.dropSchema();
        DatabaseManager.createSchema();
        DatabaseManager.createTablePerson();
        // DatabaseManager.dropTablePerson();

        Person p1 = new Person("Sami", "RMG", DateUtils.getDate(22, 3, 2005, 13, 42, 33), Hobby.PLAY_BASKETBALL);
        Person p2 = new Person("Aviva", "TLV", DateUtils.getDate(11, 12, 2001, 11, 4, 3), Hobby.WATCH_MOVIES);
        Person p3 = new Person("Johny", "RLZ", DateUtils.getDate(7, 1, 1993, 2, 52, 50), Hobby.SURF_THE_INTERNET);

        System.out.println(ArtUtils.PERSON_DAO);

        /**
         * Interface equals to implementation.
         */
        PersonDAO personDAO = new PersonDBDAO();

        /**
         * using the PersonDBDAO query's.
         */
        System.out.println("-------------------------- QUERY ADD PERSON ---------------------------");
        personDAO.addPerson(p1);
        personDAO.addPerson(p2);
        personDAO.addPerson(p3);
        System.out.println();

        System.out.println("------------------------ QUERY GET ALL PERSON -------------------------");
        personDAO.getAllPersons().forEach(System.out::println);
        System.out.println();

        System.out.println("------------------------- QUERY UPDATE PERSON --------------------------");
        Person toUpdate = personDAO.getSinglePerson(1);
        toUpdate.setHobby(Hobby.WATCH_MOVIES);
        personDAO.updatePerson(toUpdate);
        personDAO.getAllPersons().forEach(System.out::println);
        System.out.println();

        System.out.println("----------------------- QUERY GET SINGLE PERSON ------------------------");
        System.out.println(personDAO.getSinglePerson(3));
        System.out.println();

        System.out.println("------------------------- QUERY DELETE PERSON --------------------------");
        Person toDelete = personDAO.getSinglePerson(1);
        personDAO.deletePerson(toDelete);
        personDAO.getAllPersons().forEach(System.out::println);
        System.out.println();

        /**
         * closing all connections.
         */
        ConnectionPool.getInstance().closeAllConnections();
        System.out.println("END");
    }
}
