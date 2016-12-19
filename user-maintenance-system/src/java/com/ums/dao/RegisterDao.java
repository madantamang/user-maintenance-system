/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ums.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.ums.beans.RegisterBean;
import com.ums.util.DBConnection;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


public class RegisterDao {
     public String registerUser(RegisterBean registerBean)
         {
            String firstName = registerBean.getFirstName();
            String lastName = registerBean.getLastName();
            String email = registerBean.getEmail();
            String userName = registerBean.getUserName();
            String password = registerBean.getPassword();
            String gender=registerBean.getGender();
            //added registration date
            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            Date date = new Date();
            Connection con = null;
            PreparedStatement preparedStatement = null;

            try
            {
                con = DBConnection.createConnection();
                String query = "insert into users(first_name,last_name,email,uname,pass,regdate,role,gender) values (?,?,?,?,?,?,'user',?)"; //Insert user details into the table 'USERS'
                preparedStatement = con.prepareStatement(query); //Making use of prepared statements here to insert bunch of data
                preparedStatement.setString(1, firstName);
                preparedStatement.setString(2, lastName);
                preparedStatement.setString(3, email);
                preparedStatement.setString(4, userName);
                preparedStatement.setString(5, password);
                preparedStatement.setString(6, dateFormat.format(date));
                preparedStatement.setString(7, gender);

                int i= preparedStatement.executeUpdate();

                if (i!=0)  //Just to ensure data has been inserted into the database
                 return "SUCCESS"; 
            }
            catch(SQLException e)
            {
                 e.printStackTrace();
            }
            return "Oops.. Something went wrong there..!";  // On failure, send a message from here.
        }
}
