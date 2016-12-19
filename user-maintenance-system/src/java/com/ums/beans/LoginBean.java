/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ums.beans;

public class LoginBean {
    
            private String userNameOrEmail;
            private String password;
          
            
           public String getUserNameOrEmail() {
             return userNameOrEmail;
            }
           
           public void setUserNameOrEmail(String userNameOrEmail) {
                this.userNameOrEmail = userNameOrEmail;
            }
           
            public String getPassword() {
             return password;
            }
            
            public void setPassword(String password) {
                this.password = password;
            }
             
          
            
}
