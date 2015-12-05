/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kawalkuota.app;

import com.kawalkuota.dao.AppService;
import com.kawalkuota.entity.Rekomendasi;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.ahsanfile.html.form.FormLoader;
import net.ahsanfile.html.helper.HTMLString;

/**
 *
 * @author Yusrul <yusrul@kemenkeu.go.id>
 */
@WebServlet(name = "RekomendasiAdd", urlPatterns = {"/rekomendasiadd"})
public class RekomendasiAdd extends HttpServlet {
    @EJB
    private AppService crud;
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
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        FormLoader view = new FormLoader(getServletContext().getRealPath("WEB-INF/backend"));
        String p = HTMLString.nullString(request.getParameter("p"));
        if ("add".equals(p)) {
            view.setActiveForm("rekomendasiAdd");
            view.cleansPlaceholder();
            out.print(view.getCompressedForm());
        } else if ("update".equals(p)) {
            view.setActiveForm("rekomendasiUpdate");
            view.cleansPlaceholder();
            out.print(view.getCompressedForm());
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String p = HTMLString.nullString(request.getParameter("p"));
         if ("save".equals(p)) {
            String noSurat = HTMLString.nullString(request.getParameter("a")); 
            String npwp = HTMLString.nullString(request.getParameter("b")); 
            String tipe = HTMLString.nullString(request.getParameter("c")); 
            String tglawal = HTMLString.nullString(request.getParameter("d")); 
            String tglakhir = HTMLString.nullString(request.getParameter("e")); 
            String kdijin = HTMLString.nullString(request.getParameter("f")); 

            Rekomendasi rek = new Rekomendasi();
            rek.setKdIjin("1");
            rek.setNoSurat(noSurat);
            rek.setNpwp(npwp);
            rek.setTipe(tipe);
            rek.setTglawal(null);
            rek.setTglakhir(null);
            crud.Simpan(rek);
            out.print("Sukses");
         }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
