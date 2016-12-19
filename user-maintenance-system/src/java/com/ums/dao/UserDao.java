/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ums.dao;


import com.ums.beans.UserBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.ums.util.DBConnection;


public class UserDao {
 private Connection connection;
    
    public UserDao() {
        connection = DBConnection.createConnection();
    }
    
     public void addUser(UserBean user) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("insert into users(firs_tname,last_name,dob,email) values (?, ?, ?, ? )");
            // Parameters start with 1
            preparedStatement.setString(1, user.getFirstName());
            preparedStatement.setString(2, user.getLastName());
            preparedStatement.setString(3, user.getDob());
            preparedStatement.setString(4, user.getEmail());
            preparedStatement.executeUpdate();
             preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteUser(int userId) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("delete from users where uid=?");
            // Parameters start with 1
            preparedStatement.setInt(1, userId);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateUser(UserBean user) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("update users set first_name=?, last_name=?, email=?, address=?, phoneno=?, dob=?, aboutMe=?" +
                            "where uid=?");
            // Parameters start with 1
            preparedStatement.setString(1, user.getFirstName());
            preparedStatement.setString(2, user.getLastName());
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.setString(4, user.getAddress());
            preparedStatement.setString(5, user.getPhoneno());
            preparedStatement.setString(6,user.getDob());
            preparedStatement.setString(7, user.getAboutMe());
            preparedStatement.setInt(8, user.getUserId());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<UserBean> getAllUsers() {
        List<UserBean> users = new ArrayList<UserBean>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from users");
            while (rs.next()) {
                UserBean user = new UserBean();
                user.setUserId(rs.getInt("uid"));
                user.setFirstName(rs.getString("first_name"));
                user.setLastName(rs.getString("last_name"));
                user.setDob(rs.getString("dob"));
                user.setUserName(rs.getString("uname"));
                user.setEmail(rs.getString("email"));
                user.setGender(rs.getString("gender"));
                user.setAddress(rs.getString("address"));
                user.setPhoneno(rs.getString("phoneno"));
                user.setUserProfileImage(rs.getString("profileImage"));
                user.setJoinDate(rs.getDate("regdate"));
                user.setAboutMe(rs.getString("aboutMe"));
                user.setLastLoginDate(rs.getDate("lastLoginDate"));
                user.setRole(rs.getString("role"));
                users.add(user);
            }
             rs.close();
             statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    public UserBean getUserById(int userId) {
        UserBean user = new UserBean();
        try {
            PreparedStatement preparedStatement = connection.
                    prepareStatement("select * from users where uid=?");
            preparedStatement.setInt(1, userId);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
               user.setUserId(rs.getInt("uid"));
                user.setFirstName(rs.getString("first_name"));
                user.setLastName(rs.getString("last_name"));
                user.setDob(rs.getString("dob"));
                user.setUserName(rs.getString("uname"));
                user.setEmail(rs.getString("email"));
                user.setGender(rs.getString("gender"));
                user.setAddress(rs.getString("address"));
                user.setPhoneno(rs.getString("phoneno"));
                user.setUserProfileImage(rs.getString("profileImage"));
                user.setJoinDate(rs.getDate("regdate"));
                user.setAboutMe(rs.getString("aboutMe"));
                user.setLastLoginDate(rs.getDate("lastLoginDate"));
                user.setRole(rs.getString("role"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }
}
