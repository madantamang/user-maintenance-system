/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ums.controller;

import com.ums.beans.RNABean;
import com.ums.beans.UserActivityBean;
import com.ums.beans.UserBean;
import com.ums.dao.RNADao;
import com.ums.dao.UserActivityDao;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class RNAController extends HttpServlet 
{
 private static final long serialVersionUID = 1L;
    private static final String INSERT_OR_EDIT = "/rna-create.jsp";
    private static final String LIST_RNA = "/manage-rna.jsp";
    private RNADao dao;
    private UserActivityDao userActivityDao;
    public RNAController() {
        dao = new RNADao();
        userActivityDao=new UserActivityDao();
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
            int rnaId = Integer.parseInt(request.getParameter("rnaId"));
            dao.deleteRNA(rnaId);
            forward = LIST_RNA;
            request.setAttribute("rnaList", dao.getAllRNas());    
        } else if (action.equalsIgnoreCase("edit")){
            forward = INSERT_OR_EDIT;
            int rnaId = Integer.parseInt(request.getParameter("rnaId"));
            RNABean rna = dao.getRNAById(rnaId);
            request.setAttribute("rna", rna);
        } else if (action.equalsIgnoreCase("insert")){
             forward = INSERT_OR_EDIT;
        } else {
            forward = LIST_RNA;
            request.setAttribute("rnaList", dao.getAllRNas());
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
       String errorString = null;
                   String forward="";
        RNABean newRNA = new RNABean();
        newRNA.setTypeName(request.getParameter("typename"));
        newRNA.setDescription(request.getParameter("description"));
        //newRNA.setRnaImage(request.getParameter("image"));
        String rnaId = request.getParameter("rnaId");
        if(rnaId == null || rnaId.isEmpty())
        {
            dao.addRNA(newRNA);
            HttpSession session=request.getSession(false); 
            UserBean currentUser=(UserBean)session.getAttribute("currentSessionUser"); 
            
            UserActivityBean newActivity=new UserActivityBean();
            newActivity.setAction("Created new RNA: " + newRNA.getTypeName());
            newActivity.setActivityType("New RNA");
            newActivity.setuserId(currentUser.getUserId());
            userActivityDao.addUserActivity(newActivity);
        }
        else
        {
              
            newRNA.setRnaId(Integer.parseInt(rnaId));
            dao.updateRNA(newRNA);
        }
        RequestDispatcher view = request.getRequestDispatcher(LIST_RNA);
        request.setAttribute("rnaList", dao.getAllRNas());
        view.forward(request, response);
    }

  
}
