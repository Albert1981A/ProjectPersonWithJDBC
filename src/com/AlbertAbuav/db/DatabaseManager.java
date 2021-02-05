package com.AlbertAbuav.db;

import com.AlbertAbuav.utils.DBUtils;

import java.sql.Connection;

public class DatabaseManager {
    /**
     * This class holds the database "Url" "Username" and "Password".
     */
    public static final String url = "jdbc:mysql://localhost:3306?createDatabaseIfNotExist=FALSE&useTimezone=TRUE&serverTimezone=UTC";
    public static final String username = "root";
    public static final String password = "1234";

    /**
     * This class implement DDL query's (the creation and dropping of "Schemas" and "Tables" in the database SQL).
     */
    private static final String CREATE_SCHEMA = "create schema `person_project`";
    private static final String DROP_SCHEMA = "drop schema `person_project`";

//    private static final String CREATE_TABLE_PERSON = "CREATE TABLE `person_project`.`persons` (\n" +
//            "      `id` INT NOT NULL AUTO_INCREMENT,\n" +
//            "      `name` VARCHAR(30) NOT NULL,\n" +
//            "      `city` VARCHAR(45) NOT NULL,\n" +
//            "      `birthday` DATETIME NOT NULL,\n" +
//            "      `hobby` VARCHAR(45) NULL,\n" +
//            "      PRIMARY KEY (`id`))";

    private static final String CREATE_TABLE_PERSON = "CREATE TABLE `person_project`.`persons` (\n" +
            "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
            "  `name` VARCHAR(30) NOT NULL,\n" +
            "  `city` VARCHAR(45) NOT NULL,\n" +
            "  `birthday` DATE NOT NULL,\n" +
            "  `hobby` VARCHAR(45) NOT NULL,\n" +
            "  PRIMARY KEY (`id`));";
    private static final String DROP_TABLE_PERSON = "DROP TABLE `person_project`.`persons`";

    public static void createSchema() {
        DBUtils.runQuery(CREATE_SCHEMA);
    }

    public static void dropSchema() {
        DBUtils.runQuery(DROP_SCHEMA);
    }

    public static void createTablePerson() {
        DBUtils.runQuery(CREATE_TABLE_PERSON);
    }

    public static void dropTablePerson() {
        DBUtils.runQuery(DROP_TABLE_PERSON);
    }
}
