package com.company;

import com.company.models.Passenger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Queries {

    final String DB_DATABASE = "titanicmanifest";
    final String DB_URL = "jdbc:mysql://localhost:3306/" + DB_DATABASE;
    final String DB_USER = "root";
    final String DB_PASSWORD = "ah447Sladl!";

    private PreparedStatement getPeopleByName, getPeopleByGender, getPeopleByAge, getPeopleGenAndAge;

    public Queries() {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            String sqlQuery = "select name, gender, age from titanic WHERE name like ?";
            getPeopleByGender = con.prepareStatement(sqlQuery);



        } catch(SQLException e) {

        } catch (Exception e) {

        }

    }

    public List<Passenger> getPassengersByName(String name) {
        ResultSet resultSet = null;
        List<Passenger> results = null;

        try {
            getPeopleByName.setString(1, "%" + name + "%");

            resultSet = getPeopleByName.executeQuery();

            results = new ArrayList<Passenger>();

            while (resultSet.next()) {
                Passenger newPassenger = new Passenger();
                newPassenger.name = resultSet.getString("name");
                newPassenger.gender = resultSet.getString("gender");
                newPassenger.age = resultSet.getInt("age");
                results.add(newPassenger);

            }

        } catch (SQLException e) {

        } catch (Exception e) {

        }

        return results;

    }

    public List<Passenger> getPassengersByGender(String gender) {
        ResultSet resultSet = null;
        List<Passenger> results = null;
        try {
            getPeopleByGender.setString(1, "%" + gender + "%");

            resultSet = getPeopleByGender.executeQuery();

            results = new ArrayList<Passenger>();

            while (resultSet.next()) {
                Passenger newPassenger = new Passenger();
                newPassenger.name = resultSet.getString("name");
                newPassenger.gender = resultSet.getString("gender");
                newPassenger.age = resultSet.getInt("age");
                results.add(newPassenger);

            }

        } catch (SQLException e) {

        } catch (Exception e) {

        }

        return results;

    }

    public List<Passenger> getPassengersByAge(String age) {
        ResultSet resultSet = null;
        List<Passenger> results = null;
        try {
            getPeopleByAge.setString(1, "%" + age + "%");

            resultSet = getPeopleByAge.executeQuery();

            results = new ArrayList<Passenger>();

            while (resultSet.next()) {
                Passenger newPassenger = new Passenger();
                newPassenger.name = resultSet.getString("name");
                newPassenger.gender = resultSet.getString("gender");
                newPassenger.age = resultSet.getInt("age");
                results.add(newPassenger);

            }

        } catch (SQLException e) {

        } catch (Exception e) {

        }

        return results;

    }

    public List<Passenger> getPassengersByGenAndAge(String gender, String age) {
        ResultSet resultSet = null;
        List<Passenger> results = null;
        try {
            getPeopleGenAndAge.setString(1, "%" + gender + "%");
            getPeopleGenAndAge.setString(2, "%" + age + "%");


            resultSet = getPeopleGenAndAge.executeQuery();

            results = new ArrayList<Passenger>();

            while (resultSet.next()) {
                Passenger newPassenger = new Passenger();
                newPassenger.name = resultSet.getString("name");
                newPassenger.gender = resultSet.getString("gender");
                newPassenger.age = resultSet.getInt("age");
                results.add(newPassenger);

            }

        } catch (SQLException e) {

        } catch (Exception e) {

        }

        return results;

    }
}
