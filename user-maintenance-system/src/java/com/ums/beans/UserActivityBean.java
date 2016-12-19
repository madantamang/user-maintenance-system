/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ums.beans;

import java.util.Date;

public class UserActivityBean {
    
    private int userActivityId;  
    private int userId;
    private String activityType;
    private String action;
    private Date activityTimeStamp;
    
    
    public int getUserActivityId() {
        return userActivityId;
    }

    public void setUserActivityId(int userActivityId) {
        this.userActivityId = userActivityId;
    }



    public int getuserId() {
        return userId;
    }

    public void setuserId(int userId) {
        this.userId = userId;
    }


    public String getActivityType() {
        return activityType;
    }

    public void setActivityType(String activityType) {
        this.activityType = activityType;
    }


    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }



    public Date getActivityTimeStamp() {
        return activityTimeStamp;
    }

    public void setActivityTimeStamp(Date activityTimeStamp) {
        this.activityTimeStamp = activityTimeStamp;
    }

}
