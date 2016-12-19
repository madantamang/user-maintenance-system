/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ums.beans;

import java.util.Date;

public class UserBean  {
    
        private int userId;
        private String firstName;
        private String lastName;
        private String email;
        private String userName;
        private String dob;
        private String address;
        private String gender;
        private String phoneno;
        private String UserImage;
        private Date joinDate;
        private String role;
        private String aboutMe;
        private Date lastLoginDate;
          
        public boolean valid;
        
        public int getUserId() {
            return userId;
        }
        
        public void setUserId(int userId) {
         this.userId = userId;
        }
        
        public String getUserName() {
         return userName;
        }
        
        public void setUserName(String userName) {
         this.userName = userName;
        }
        
        public void setFirstName(String firstName) {
         this.firstName = firstName;
        }
        public String getFirstName() {
            return firstName;
        }
        
        public void setLastName(String lastName) {
            this.lastName = lastName;
        }
        
        public String getLastName() {
         return lastName;
        }
        
        public void setEmail(String email) {
            this.email = email;
        }
        
        public String getEmail() {
         return email;
        }
    
         public String  getDob() {
            return dob;
         }

         public void setDob(String  dob) {
            this.dob = dob;
         }

          public String getAddress() {
             return address;
         }
         public void setAddress(String address) {
            this.address = address;
         }

          public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }
        
       
            public String getPhoneno() {
                return phoneno;
            }

            public void setPhoneno(String phoneno) {
                this.phoneno = phoneno;
            }
            
            public String getUserProfileImage() {
                return UserImage;
            }

            public void setUserProfileImage(String profileImage) {
                this.UserImage = profileImage;
            }

 
            public Date getJoinDate() {
                return joinDate;
            }
            
          public void setJoinDate(Date joinDate) {
                this.joinDate = joinDate;
            }
            public String getRole() {
                return role;
            }

            public void setRole(String role) {
                this.role = role;
            }

            public String getAboutMe() {
                return aboutMe;
            }

            public void setAboutMe(String aboutMe) {
                this.aboutMe = aboutMe;
            }

            public Date getLastLoginDate() {
                return lastLoginDate;
            }

            public void setLastLoginDate(Date lastLoginDate) {
                this.lastLoginDate = lastLoginDate;
            }

          public boolean isValid() { 
                return valid;
            }
            
            public void setValid(boolean newValid) { 
                this.valid = newValid; 
            } 
}
