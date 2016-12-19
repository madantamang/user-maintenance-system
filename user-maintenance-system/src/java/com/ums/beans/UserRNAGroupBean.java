/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ums.beans;

public class UserRNAGroupBean {
    
    private int userGroupId;
    private int userId;
    private String groupName;
    private String rnaIds;
    
    
    public int getUserGroupId() {
        return userGroupId;
    }

    public void setUserGroupId(int userGroupId) {
        this.userGroupId = userGroupId;
    }

 
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

  
    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }



    /**
     * Get the comma separated value of rna Id
     *
     * @return the comma separated value of rna Id
     */
    public String getRnaIds() {
        return rnaIds;
    }

    /**
     * Set the comma separated value of rna Id
     *
     * @param rnaIds new  comma separated value of rna Id
     */
    public void setRnaIds(String rnaIds) {
        this.rnaIds = rnaIds;
    }

}
