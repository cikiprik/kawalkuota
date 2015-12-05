/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kawalkuota.app;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.kawalkuota.dao.AppService;
import com.kawalkuota.entity.Rekomendasi;
import com.kawalkuota.entity.Rekomendasidetil;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import net.ahsanfile.html.helper.HTMLString;

/**
 *
 * @author Yusrul <yusrul@kemenkeu.go.id>
 */
@WebServlet(name = "Json", urlPatterns = {"/json"})
public class Json extends HttpServlet {
    @EJB
    private AppService appService;
   
   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
        } finally {
            out.close();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();

        try {

            String p = HTMLString.nullString(request.getParameter("content"));
            HttpSession hs = request.getSession();
                if ("rekomendasi".equals(p)) {
                    
                    List<Rekomendasi> td = appService.GetAllData("Rekomendasi");
                    for (Iterator<Rekomendasi> it = td.iterator(); it.hasNext();) {
                        Rekomendasi rek= it.next();
                        rek.setKdIjin(
                                "<button class='btn btn-warning btn-xs btn-fill' "
                                + "onclick='edit("+rek.getId()+")'>"
                                + "<i class='fa fa-pencil-square-o'></i></button> "
                                + "<button class='btn btn-danger btn-xs btn-fill' onclick='hapus("+rek.getId()+")'><i class='fa fa-trash-o'></i></button>");
                        }
                                        
                    Gson gson = new Gson();
                    Type type = new TypeToken<List<Rekomendasi>>() {
                    }.getType();
                    String json = gson.toJson(td, type);
                    out.println("{\"data\":"+json+"}");
                   
                }
                if ("rekomendasidetil".equals(p)) {
                    
                    List<Rekomendasidetil> td = appService.GetAllData("Rekomendasidetil");
                    
                    for (Iterator<Rekomendasidetil> it = td.iterator(); it.hasNext();) {
                        Rekomendasidetil rek= it.next();
                        rek.setFlag(
                                "<button class='btn btn-warning btn-xs btn-fill' "
                                + "onclick='edit("+rek.getId()+")'>"
                                + "<i class='fa fa-pencil-square-o'></i></button> "
                                + "<button class='btn btn-danger btn-xs btn-fill' onclick='delete("+rek.getId()+")'><i class='fa fa-trash-o'></i></button>");
                        }
                    Gson gson = new Gson();
                    Type type = new TypeToken<List<Rekomendasi>>() {
                    }.getType();
                    String json = gson.toJson(td, type);
                    out.println("{\"data\":"+json+"}");
                    
                }
                
           
        } catch (Exception ex) {
            Logger.getLogger(Json.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            out.close();
        }

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
