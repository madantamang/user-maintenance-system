/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ums.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.ums.beans.LoginBean;
import com.ums.beans.UserBean;
import com.ums.dao.LoginDao;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;

public class LoginController extends HttpServlet 
{
    
      @Override
   protected void doGet(HttpServletRequest request, HttpServletResponse response)
           throws ServletException, IOException {
       // Forward to /login.jsp
       // (Users can not access directly into JSP pages placed in WEB-INF)
       RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/login.jsp");
       dispatcher.forward(request, response);
        
   }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //Here username and password are the names which I have given in the input box in Login.jsp page. Here I am retrieving the values entered by the user and keeping in instance variables for further use.
         try
         {
            String userName = request.getParameter("username");
             String password = request.getParameter("password");

            LoginBean loginBean = new LoginBean(); //creating object for LoginBean class, which is a normal java class, contains just setters and getters. Bean classes are efficiently used in java to access user information wherever required in the application.

             loginBean.setUserNameOrEmail(userName); //setting the username and password through the loginBean object then only you can get it in future.
             loginBean.setPassword(password);

            LoginDao loginDao = new LoginDao(); //creating object for LoginDao. This class contains main logic of the application.

            UserBean currentUser = loginDao.authenticateUser(loginBean); //Calling authenticateUser function

            if(currentUser.isValid()) //If function returns success string then user will be rooted to Home page
             {
                //update last login timestamp 
                loginDao.updateLastLoginTimestamp(currentUser.getUserId());
                HttpSession session = request.getSession(true); 
                session.setAttribute("currentSessionUser",currentUser); 
                 response.sendRedirect(request.getContextPath() + "/profile");
             }
             else
             {
                request.setAttribute("errMessage", "Sorry, you are not a registered user! Please sign up first"); //If authenticateUser() function returnsother than SUCCESS string it will be sent to Login page again. Here the error message returned from function has been stored in a errMessage key.
                RequestDispatcher errorDispatcher = this.getServletContext().getRequestDispatcher("/login.jsp");
                errorDispatcher.forward(request, response);
             }
         }
         catch (Throwable theException)
         { 
            System.out.println(theException); 
            request.setAttribute("errMessage", "Server exception.Please try again later.");
            RequestDispatcher exceptiondispatcher = this.getServletContext().getRequestDispatcher("/login.jsp");
             exceptiondispatcher.forward(request, response);

         }
    }

}
