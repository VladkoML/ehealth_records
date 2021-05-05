package org.diploma.dao;

import org.diploma.entity.Patient;

import java.sql.*;
import java.time.LocalDate;

public class SignUpDAO {

    Connection connection;

    void createAccount(Patient patient){

        connection = ConnectionDB.getConnection();
        PreparedStatement preparedStatement = null;
        String sql = "INSERT INTO patients (" +
                "email, " +
                "password, " +
                "full_name, " +
                "birthday, " +
                "weight, " +
                "height, " +
                "sex, " +
                "address_of_residence, " +
                "blood_type, " +
                "profession) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try{

            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, patient.getEmail());
            preparedStatement.setString(2, patient.getPassword());
            preparedStatement.setString(3, patient.getFullName());
            preparedStatement.setObject(4, patient.getBirthday());
            preparedStatement.setInt(5, patient.getWeight());
            preparedStatement.setInt(6, patient.getHeight());
            preparedStatement.setString(7, patient.getSex());
            preparedStatement.setString(8, patient.getAddressOfResidence());
            preparedStatement.setString(9, patient.getBloodType());
            preparedStatement.setString(10, patient.getProfession());

            preparedStatement.executeUpdate();

        } catch (SQLException e){
            e.printStackTrace();
        }finally{

            try{

                if(preparedStatement != null)
                        preparedStatement.close();
                if(connection != null)
                    connection.close();

            } catch (SQLException e){
                e.printStackTrace();
            }

        }

    }

    public static boolean validate(String email) {

        boolean status = false;

        try (Connection con = ConnectionDB.getConnection()) {

            PreparedStatement ps = con.prepareStatement("SELECT * FROM patients WHERE email=?");
            ps.setString(1, email);

            ResultSet rs = ps.executeQuery();
            status = rs.next();

        } catch (Exception e){
            System.out.println(e);
        }

        return status;

    }

}
