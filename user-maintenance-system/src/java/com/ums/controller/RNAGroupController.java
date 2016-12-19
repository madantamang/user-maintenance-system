/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ums.controller;

import com.ums.beans.UserBean;
import com.ums.beans.UserRNAGroupBean;
import com.ums.dao.RNADao;
import com.ums.dao.UserRNAGroupDao;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class RNAGroupController extends HttpServlet {
     private static final long serialVersionUID = 1L;
     private static final String INSERT_OR_EDIT = "/rna-group-create.jsp";
     private static final String LIST_RNA_Group = "/manage-rna-group.jsp";
     private RNADao rnaDao;
     private UserRNAGroupDao userRnaDao;
     public RNAGroupController() {
        rnaDao=new RNADao();
        userRnaDao=new UserRNAGroupDao();
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
        String action = request.getParameter("action");

        if (action.equalsIgnoreCase("delete")){
            int userRnaId = Integer.parseInt(request.getParameter("userRnaGroupId"));
            userRnaDao.deleteUserRNA(userRnaId);
            forward = LIST_RNA_Group;
            request.setAttribute("userRnaGroupList", userRnaDao.getAllUserRNA());    
        } else if (action.equalsIgnoreCase("edit")){
            forward = INSERT_OR_EDIT;
            int userRnaId = Integer.parseInt(request.getParameter("userRnaGroupId"));
            request.setAttribute("rnaList", rnaDao.getAllRNas());
            request.setAttribute("userRnaGroup", userRnaDao.getUserRNAById(userRnaId));
        } else if (action.equalsIgnoreCase("insert")){
            request.setAttribute("rnaList", rnaDao.getAllRNas());
             forward = INSERT_OR_EDIT;
        } else {
            forward = LIST_RNA_Group;
            request.setAttribute("userRnaGroupList", userRnaDao.getAllUserRNA());
        }
        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
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
        UserRNAGroupBean userRNA = new UserRNAGroupBean();
         userRNA.setGroupName(request.getParameter("groupname"));
         
         String[] rnaIds =request.getParameterValues("to[]");
         userRNA.setRnaIds(String.join(",", rnaIds));
          
          HttpSession session=request.getSession(false);  
         UserBean currentUser=(UserBean)session.getAttribute("currentSessionUser");

            if(currentUser!=null){  
               userRNA.setUserId(currentUser.getUserId());
               userRnaDao.addUserRNAGroup(userRNA);
            }  
            else{    
            } 
         response.sendRedirect(request.getContextPath() + "/rnagroup?action=list");
    }

    

}
