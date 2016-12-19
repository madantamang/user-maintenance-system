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
import com.ums.beans.RegisterBean;
import com.ums.dao.RegisterDao;
import javax.servlet.RequestDispatcher;


public class RegisterController extends HttpServlet {

    
        @Override
   protected void doGet(HttpServletRequest request, HttpServletResponse response)
           throws ServletException, IOException {
       // Forward to /login.jsp
       // (Users can not access directly into JSP pages placed in WEB-INF)
       RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/register.jsp");
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
            //Copying all the input parameters in to local variables
            String firstName = request.getParameter("fname");
            String lastName = request.getParameter("lname");
            String email = request.getParameter("email");
            String userName = request.getParameter("username");
            String password = request.getParameter("password");
            String gender=request.getParameter("gender");

            RegisterBean registerBean = new RegisterBean();
           //Using Java Beans - An easiest way to play with group of related data
            registerBean.setFirstName(firstName);
             registerBean.setLastName(lastName);
            registerBean.setEmail(email);
            registerBean.setUserName(userName);
            registerBean.setPassword(password); 
            registerBean.setGender(gender);

            RegisterDao registerDao = new RegisterDao();

           //The core Logic of the Registration application is present here. We are going to insert user data in to the database.
            String userRegistered = registerDao.registerUser(registerBean);

            if(userRegistered.equals("SUCCESS"))   //On success, you can display a message to user on Home page
            {
            request.getRequestDispatcher("/registrationsuccess.jsp").forward(request, response);
            }
            else   //On Failure, display a meaningful message to the User.
            {
            request.setAttribute("errMessage", userRegistered);
            request.getRequestDispatcher("/register.jsp").forward(request, response);
            }
    }


}
