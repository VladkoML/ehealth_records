package org.diploma.dao.old;

import org.diploma.dao.ConnectionDB;
import org.diploma.entity.Specialization;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SpecializationDAO extends ConnectionDB {

     public static Specialization getById(Long id){

         return null;

     }

    public static List<Specialization> getAll(){

        Connection connection = ConnectionDB.getConnection();
        List<Specialization> specializations = new ArrayList<>();
        Statement statement = null;
        String sql = "SELECT * FROM specialization";

        try{
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

        while(resultSet.next()){
            Specialization spec = new Specialization();
            spec.setSpecializationId(resultSet.getLong("specialization_id"));
            spec.setNameSpecialization(resultSet.getString("name"));

            specializations.add(spec);
        }
        }catch(SQLException e){
            e.printStackTrace();
        }finally {

        try{

            if(statement != null)
                statement.close();
            if(connection != null)
                connection.close();

        }catch (SQLException e){
            e.printStackTrace();
        }

        }

        return specializations;

     }

}
