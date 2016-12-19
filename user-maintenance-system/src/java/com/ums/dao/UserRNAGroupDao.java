/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ums.dao;

import com.ums.beans.UserRNAGroupBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.ums.util.DBConnection;


public class UserRNAGroupDao {
       private Connection connection;
    
    public UserRNAGroupDao() {
        connection = DBConnection.createConnection();
    }
    
     public void addUserRNAGroup(UserRNAGroupBean rna) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("insert into userRNAGroup(uId,groupName,rnaIds) values (?, ?, ?)");
            // Parameters start with 1
            preparedStatement.setInt(1, rna.getUserId());
              preparedStatement.setString(2, rna.getGroupName());
                preparedStatement.setString(3, rna.getRnaIds());
            preparedStatement.executeUpdate();
             preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteUserRNA(int rnaId) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("delete from userRNAGroup where usergroupId=?");
            // Parameters start with 1
            preparedStatement.setInt(1, rnaId);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateUserRNA(UserRNAGroupBean userRNA) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("update userRNAGroup set uId=?, groupName=?, rnaIds=?" +
                            "where usergroupId=?");
            preparedStatement.setString(1, userRNA.getGroupName());
            preparedStatement.setString(2, userRNA.getRnaIds());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<UserRNAGroupBean> getAllUserRNA() {
        List<UserRNAGroupBean> userRNAList = new ArrayList<UserRNAGroupBean>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from userRNAGroup");
            while (rs.next()) {
                UserRNAGroupBean userRNA = new UserRNAGroupBean();
                userRNA.setUserGroupId(rs.getInt("usergroupId"));
                userRNA.setUserId(rs.getInt("uId"));
                userRNA.setGroupName(rs.getString("groupName"));
                userRNA.setRnaIds(rs.getString("rnaIds"));
                userRNAList.add(userRNA);
            }
             rs.close();
             statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userRNAList;
    }

    public UserRNAGroupBean getUserRNAById(int userRNAId) {
        UserRNAGroupBean userRNA = new UserRNAGroupBean();
        try {
            PreparedStatement preparedStatement = connection.
                    prepareStatement("select * from userRNAGroup where usergroupId=?");
            preparedStatement.setInt(1, userRNAId);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                userRNA.setUserGroupId(rs.getInt("usergroupId"));
                userRNA.setUserId(rs.getInt("uId"));
                userRNA.setGroupName(rs.getString("groupName"));
                userRNA.setRnaIds(rs.getString("rnaIds"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return userRNA;
    }
    
     public List<UserRNAGroupBean> getUserRNAByUserId(int userId) {
        List<UserRNAGroupBean> userRNAList = new ArrayList<UserRNAGroupBean>();
        try {
            PreparedStatement preparedStatement = connection.
                    prepareStatement("select * from userRNAGroup where uId=?");
            preparedStatement.setInt(1, userId);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                UserRNAGroupBean userRNA = new UserRNAGroupBean();
                userRNA.setUserGroupId(rs.getInt("usergroupId"));
                userRNA.setUserId(rs.getInt("uId"));
                userRNA.setGroupName(rs.getString("groupName"));
                userRNA.setRnaIds(rs.getString("rnaIds"));
                userRNAList.add(userRNA);
            }
            rs.close();
             preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return userRNAList;
    }
}
