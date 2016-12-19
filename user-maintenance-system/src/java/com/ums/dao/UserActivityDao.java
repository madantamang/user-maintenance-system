/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ums.dao;

import com.ums.beans.UserActivityBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.ums.util.DBConnection;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


public class UserActivityDao {
     private Connection connection;
    
    public UserActivityDao() {
        connection = DBConnection.createConnection();
    }
    
     public void addUserActivity(UserActivityBean activity) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("insert into userActivity(uId,activityType,action,activityDate) values (?, ?, ?,?)");
            // Parameters start with 1
            preparedStatement.setInt(1, activity.getuserId());
            preparedStatement.setString(2, activity.getActivityType());
            preparedStatement.setString(3, activity.getAction());
             DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            Date date = new Date();
            preparedStatement.setString(4,dateFormat.format(date) );
             
            preparedStatement.executeUpdate();
             preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteUserActivity(int activityId) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("delete from userActivity where userActivityId=?");
            // Parameters start with 1
            preparedStatement.setInt(1, activityId);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<UserActivityBean> getAllUserActivity() {
        List<UserActivityBean> userActivityList = new ArrayList<UserActivityBean>();
        try 
        {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from userActivity");
            while (rs.next()) {
                UserActivityBean act = new UserActivityBean();
                act.setUserActivityId(rs.getInt("userActivityId"));
                act.setuserId(rs.getInt("uId"));
                act.setActivityType(rs.getString("activityType"));
                act.setAction(rs.getString("action"));
                act.setActivityTimeStamp(rs.getDate("activityDate"));
                userActivityList.add(act);
            }
             rs.close();
             statement.close();
        }
        catch (SQLException e) 
        {
            e.printStackTrace();
        }
        return userActivityList;
    }

    public UserActivityBean getUserActivityById(int activityId) {
        UserActivityBean activity = new UserActivityBean();
        try {
            PreparedStatement preparedStatement = connection.
                    prepareStatement("select * from userActivity where rnaId=?");
            preparedStatement.setInt(1, activityId);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                activity.setUserActivityId(rs.getInt("userActivityId"));
                activity.setuserId(rs.getInt("uId"));
                activity.setActivityType(rs.getString("activityType"));
                activity.setAction(rs.getString("action"));
                activity.setActivityTimeStamp(rs.getDate("activityDate"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return activity;
    }
}
