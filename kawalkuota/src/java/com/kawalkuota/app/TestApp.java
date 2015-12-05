/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kawalkuota.app;

import com.kawalkuota.dao.AppService;
import com.kawalkuota.dao.SuperCtr;
import com.kawalkuota.entity.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Yusrul <yusrul@kemenkeu.go.id>
 */
@WebServlet(name = "TestApp", urlPatterns = {"/TestApp"})
public class TestApp extends HttpServlet {
    @EJB
    private AppService appService;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            
            User user = appService.GetUser(2);
//            user.setEmail("a");
//            user.setLevel(1);
//            user.setUsername("dea");
//            user.setPassword("aja");
//            user.setAktif(1);
//            user.setPhoto("lalaladate(.jpg");
//            user = (User) appService.Simpan(user);
            out.println("user:"+user);
//            user.setIdUser(8);
            String x = appService.Hapus(user);
            
            out.println(""+x);
//            SuperCtr dao = new SuperCtr();
//            List<User> list = dao.getData("User");
//            for (Iterator<User> it = list.iterator(); it.hasNext();) {
//                User users = it.next();
//                out.println("" + users.getUsername());
//            }

        } finally {
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
