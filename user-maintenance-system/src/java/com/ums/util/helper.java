/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ums.util;

import com.ums.beans.UserBean;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class helper {
    
       private static final String ATT_NAME_USER_NAME = "ATTRIBUTE_FOR_STORE_USER_NAME_IN_COOKIE";
    
        public static boolean isValidEmailAddress(String email) {
            boolean result = true;
            try {
               InternetAddress emailAddr = new InternetAddress(email);
               emailAddr.validate();
            } catch (AddressException ex) {
               result = false;
            }
            return result;
         }
         // Store user info in Session.
        public static void storeLoginedUser(HttpSession session, UserBean loginedUser) {

            // On the JSP can access ${loginedUser}
            session.setAttribute("loginedUser", loginedUser);
        }

         // Get the user information stored in the session.
       public static UserBean getLoginedUser(HttpSession session) {
           UserBean loginedUser = (UserBean) session.getAttribute("loginedUser");
           return loginedUser;
       }

          // Store info in Cookie
       public static void storeUserCookie(HttpServletResponse response, UserBean user) {
           System.out.println("Store user cookie");
           Cookie cookieUserName = new Cookie(ATT_NAME_USER_NAME, user.getUserName());
           // 1 day (Convert to seconds)
           cookieUserName.setMaxAge(24 * 60 * 60);
           response.addCookie(cookieUserName);
       }

       public static String getUserNameInCookie(HttpServletRequest request) {
           Cookie[] cookies = request.getCookies();
           if (cookies != null) {
               for (Cookie cookie : cookies) {
                   if (ATT_NAME_USER_NAME.equals(cookie.getName())) {
                       return cookie.getValue();
                   }
               }
           }
           return null;
       }


       // Delete cookie.
       public static void deleteUserCookie(HttpServletResponse response) {
           Cookie cookieUserName = new Cookie(ATT_NAME_USER_NAME, null);
           // 0 seconds (Expires immediately)
           cookieUserName.setMaxAge(0);
           response.addCookie(cookieUserName);
       }
}
