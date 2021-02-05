package com.AlbertAbuav.dbdao;

import com.AlbertAbuav.beans.Hobby;
import com.AlbertAbuav.beans.Person;
import com.AlbertAbuav.dao.PersonDAO;
import com.AlbertAbuav.db.ConnectionPool;
import com.AlbertAbuav.utils.DateUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class PersonDBDAO implements PersonDAO {

    private static final String QUERY_ADD_PERSON = "INSERT INTO `person_project`.`persons` (`name`, `city`, `birthday`, `hobby`) VALUES (?, ?, ?, ?)";
    private static final String QUERY_UPDATE_PERSON = "UPDATE `person_project`.`persons` SET `name` = ?, `city` = ?, `birthday` = ?, `hobby` = ? WHERE (`id` = ?)";
    private static final String QUERY_DELETE_PERSON = "DELETE FROM `person_project`.`persons` WHERE (`id` = ?)";
    private static final String QUERY_GET_SINGLE_PERSON = "SELECT * FROM `person_project`.`persons` WHERE (`id` = ?)";
    private static final String QUERY_GET_ALL_PERSON = "SELECT * FROM `person_project`.`persons`";

    //QUERY_ADD_PERSON
    //QUERY_UPDATE_PERSON
    //QUERY_DELETE_PERSON
    //QUERY_GET_SINGLE_PERSON
    //QUERY_GET_ALL_PERSON
    /**
     * To perform an operation from the code to the database there are five steps.
     * This methods use the steps below.
     * Step 2 - Taking a connection from the ConnectionPool class.
     * Step 3 - Preparing the instruction for the SQL end execute it.
     * Step 4 - ResultSet (Optional) - Get from the database results into "ResultSet".
     * Step 5 - Returning the connection to the ConnectionPool.
     */
    @Override
    public void addPerson(Person person) {
        Connection connection = null;
        try {
            // Step 2
            connection = ConnectionPool.getInstance().getConnection();
            // Step 3
            PreparedStatement statement = connection.prepareStatement(QUERY_ADD_PERSON);
            statement.setString(1, person.getName());
            statement.setString(2, person.getCity());
            statement.setDate(3, DateUtils.convertJavaDateToSqlDate(person.getBirthday()));
            statement.setString(4, person.getHobby().name());
            statement.execute();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            // Step 5
            ConnectionPool.getInstance().returnConnection(connection);
        }
        //statement.setTimestamp(3, Timestamp.valueOf(LocalDateTime));
    }

    @Override
    public void updatePerson(Person person) {
        Connection connection = null;
        try {
            // Step 2
            connection = ConnectionPool.getInstance().getConnection();
            // Step 3
            PreparedStatement statement = connection.prepareStatement(QUERY_UPDATE_PERSON);
            statement.setString(1, person.getName());
            statement.setString(2, person.getCity());
            statement.setDate(3, DateUtils.convertJavaDateToSqlDate(person.getBirthday()));
            statement.setString(4, person.getHobby().name());
            statement.setInt(5, person.getId());
            statement.execute();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            // Step 5
            ConnectionPool.getInstance().returnConnection(connection);
        }
    }

    @Override
    public void deletePerson(Person person) {
        Connection connection = null;
        try {
            // Step 2
            connection = ConnectionPool.getInstance().getConnection();
            // Step 3
            PreparedStatement statement = connection.prepareStatement(QUERY_DELETE_PERSON);
            statement.setInt(1, person.getId());
            statement.execute();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            // Step 5
            ConnectionPool.getInstance().returnConnection(connection);
        }
    }

    @Override
    public Person getSinglePerson(int id) {
        Person result = null;
        Connection connection = null;
        try {
            // Step 2
            connection = ConnectionPool.getInstance().getConnection();
            // Step 3
            PreparedStatement statement = connection.prepareStatement(QUERY_GET_SINGLE_PERSON);
            statement.setInt(1, id);
            // Step 4
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            int idPerson = resultSet.getInt(1);
            String name = resultSet.getString(2);
            String city = resultSet.getString(3);
            Date birthday = resultSet.getDate(4);
            Hobby hobby = Hobby.valueOf(resultSet.getString(5));
            result = new Person(idPerson, name, city, birthday, hobby);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            // Step 5
            ConnectionPool.getInstance().returnConnection(connection);
        }
        return result;
    }

    @Override
    public List<Person> getAllPersons() {
        List<Person> results = new ArrayList<>();
        Connection connection = null;
        try {
            // Step 2
            connection = ConnectionPool.getInstance().getConnection();
            // Step 3
            PreparedStatement statement = connection.prepareStatement(QUERY_GET_ALL_PERSON);
            // Step 4
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                String city = resultSet.getString(3);
                Date birthday = resultSet.getDate(4);
                Hobby hobby = Hobby.valueOf(resultSet.getString(5));
                Person tmp = new Person(id, name, city, birthday, hobby);
                results.add(tmp);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            // Step 5
            ConnectionPool.getInstance().returnConnection(connection);
        }
        return results;
    }
}
