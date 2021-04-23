package org.diploma.dao;

import org.diploma.entity.Patient;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SignupDAO {

    Patient getById(Long id){

        return null;

    }

    void createAccount(Patient patient){

        PreparedStatement preparedStatement = null;
        String sql = "INSERT INTO patient (" +
                "name, " +
                "birthday, " +
                "weight, " +
                "height, " +
                "gender, " +
                "blood_type, " +
                "email, " +
                "password) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection connection = ConnectionDB.getConnection()) {

            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, patient.getNamePatient());
            preparedStatement.setObject(2, patient.getBirthday());
            preparedStatement.setInt(3, patient.getWeight());
            preparedStatement.setInt(4, patient.getHeight());
            preparedStatement.setString(5, patient.getGender());
            preparedStatement.setString(6, patient.getBloodType());
            preparedStatement.setString(7, patient.getEmail());
            preparedStatement.setString(8, patient.getPassword());

            preparedStatement.executeUpdate();

        } catch (SQLException e){
            e.printStackTrace();
        }

    }

    void update(Patient patient){



    }

    public static boolean validate(String email) {

        boolean status = false;

        try (Connection con = ConnectionDB.getConnection()) {

            PreparedStatement ps = con.prepareStatement("SELECT * FROM patient WHERE email=?");
            ps.setString(1, email);

            ResultSet rs = ps.executeQuery();
            status = rs.next();

        } catch (Exception e){
            System.out.println(e);
        }

        return status;

    }

}
