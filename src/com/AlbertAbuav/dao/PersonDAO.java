package com.AlbertAbuav.dao;

import com.AlbertAbuav.beans.Person;
import java.util.List;

public interface PersonDAO {
    /**
     * This interface defines what actions can be applied from the personDBDAO class
     * DAO - Data Access Object
     */
    void addPerson(Person person);

    void updatePerson(Person person);

    void deletePerson(Person person);

    Person getSinglePerson(int id);

    List<Person> getAllPersons();
}
