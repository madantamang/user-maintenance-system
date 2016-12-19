/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ums.controller;

import com.ums.beans.UserBean;
import com.ums.dao.UserDao;
import com.ums.dao.UserRNAGroupDao;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class ProfileController extends HttpServlet 
{
       private static final long serialVersionUID = 1L;
     private UserDao dao;
     private UserRNAGroupDao userRNAGroupDao;
    public ProfileController() {
        dao = new UserDao();
        userRNAGroupDao=new UserRNAGroupDao();
    }
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            String forward="";
            HttpSession session=request.getSession(true); 
            UserBean currentUser=(UserBean)session.getAttribute("currentSessionUser"); 
            if(currentUser!=null){  
                request.setAttribute("profileDetails", dao.getUserById(currentUser.getUserId()));
               request.setAttribute("currentUserRNAGroup", userRNAGroupDao.getUserRNAByUserId(currentUser.getUserId()));
              // request.setAttribute("currentUserActivity", userRNAGroupDao.getUserRNAByUserId(currentUser.getUserId()));               
                forward="/profile.jsp";
            }  
            else{  
                forward="/login.jsp";  
            }  
          RequestDispatcher dispatcher  = this.getServletContext().getRequestDispatcher(forward);
          dispatcher .forward(request, response);
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
          String errorString = null;
        HttpSession session=request.getSession(false);  
        if(session!=null)
        {  
            UserBean user = (UserBean)session.getAttribute("currentSessionUser");
            user.setFirstName(request.getParameter("firstname"));
            user.setLastName(request.getParameter("lastname"));
            user.setEmail(request.getParameter("email"));
            user.setAddress(request.getParameter("address"));
            user.setPhoneno(request.getParameter("phoneno"));
            user.setDob(request.getParameter("dob"));        
            user.setAboutMe(request.getParameter("aboutme"));
            dao.updateUser(user);
             response.sendRedirect(request.getContextPath() + "/profile");
         }
        else{
             RequestDispatcher view = request.getRequestDispatcher("/profile.jsp");
             view.forward(request, response);
        }
        
    }

}
