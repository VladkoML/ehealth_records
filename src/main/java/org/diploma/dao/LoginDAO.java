package org.diploma.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginDAO {

    public static boolean validate(String email,String pass){

        boolean status = false;

        try (Connection con = ConnectionDB.getConnection()){

            PreparedStatement ps = con.prepareStatement("SELECT * FROM patient WHERE email=? and password=?");
            ps.setString(1,email);
            ps.setString(2,pass);

            ResultSet rs = ps.executeQuery();
            status = rs.next();

        }catch(Exception e){
            System.out.println(e);
        }

        return status;

    }
}
