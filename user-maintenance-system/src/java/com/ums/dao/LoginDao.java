/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ums.dao;

import java.sql.Connection;
 import java.sql.ResultSet;
 import java.sql.SQLException;
 import com.ums.beans.LoginBean;
 import com.ums.beans.UserBean;
 import com.ums.util.DBConnection;
import com.ums.util.helper;
import java.sql.PreparedStatement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


 public class LoginDao 
 {
   private Connection connection;
    public LoginDao() {
        connection = DBConnection.createConnection();
    }
   
    public UserBean authenticateUser(LoginBean loginBean)
    {
        //preparing some objects for connection 
         PreparedStatement preparedStatement = null;
        
        String userName = loginBean.getUserNameOrEmail(); //Keeping user entered values in temporary variables.
         String password = loginBean.getPassword();
         
         String searchQuery = "SELECT * FROM users WHERE uname=? and pass=?"; 
         boolean isEmail=helper.isValidEmailAddress(userName);
           if(isEmail){
               searchQuery = "SELECT * FROM users WHERE email=? and pass=?"; 
           }
       // "System.out.println" prints in the console; Normally used to trace the process 
       System.out.println("Your user name is " + userName);
       System.out.println("Your password is " + password); 
       System.out.println("Query: "+searchQuery);
       
        UserBean userBean=new UserBean();
        try
         {
            preparedStatement = connection.prepareStatement( searchQuery );
            preparedStatement.setString(1, userName);
            preparedStatement.setString(2, password);
            ResultSet rs  = preparedStatement.executeQuery(); //Here table name is users and userName,password are columns. fetching all the records and storing in a resultSet.
            boolean more = rs.next();
            
            // if user does not exist set the isValid variable to false
             if (!more) {
                  System.out.println("Sorry, you are not a registered user! Please sign up first");
                   userBean.setValid(false);
             }
             else if(more)
             {
                 userBean.setValid(true);
                 userBean.setGender(rs.getString("gender"));                
                 userBean.setUserProfileImage(rs.getString("profileImage"));
                 userBean.setFirstName(rs.getString("first_name"));
                 userBean.setLastName(rs.getString("last_name"));
                 userBean.setEmail(rs.getString("email"));
                 userBean.setUserId(rs.getInt("uid"));
                 userBean.setUserName(userName);
             }
             rs.close();
             preparedStatement.close();
         }
         catch(SQLException e)
         {
             e.printStackTrace();
         }
      
         return userBean;
     }
     public void updateLastLoginTimestamp(int userId) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("update users set lastLoginDate=?" +
                            "where uid=?");
             DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            Date date = new Date();
            preparedStatement.setString(1,dateFormat.format(date) );
            preparedStatement.setInt(2, userId);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
 }
 
