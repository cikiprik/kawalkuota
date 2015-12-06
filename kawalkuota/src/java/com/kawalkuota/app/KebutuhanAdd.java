/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kawalkuota.app;

import com.kawalkuota.dao.AppService;
import com.kawalkuota.entity.Kebutuhan;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
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
@WebServlet(name = "KebutuhanAdd", urlPatterns = {"/kebutuhanadd"})
public class KebutuhanAdd extends HttpServlet {

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
            view.setActiveForm("kebutuhanAdd");
            view.cleansPlaceholder();
            out.print(view.getCompressedForm());
        } else if ("update".equals(p)) {
            view.setActiveForm("kebutuhanUpdate");
            view.cleansPlaceholder();
            out.print(view.getCompressedForm());
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        SimpleDateFormat tanggal = new SimpleDateFormat("yyyy-MM-dd");

        String p = HTMLString.nullString(request.getParameter("p"));
        if ("save".equals(p)) {
            try {
                String tahun = HTMLString.nullString(request.getParameter("a"));
                String komoditi = HTMLString.nullString(request.getParameter("b"));
//                String test = HTMLString.nullString(request.getParameter("c"));
                int keb = Integer.parseInt(request.getParameter("c").toString());
                        System.out.println("kebutuhab "+tahun);
                String string = tahun;
                DateFormat format = new SimpleDateFormat("yyyy");
                Date date = format.parse(string);
               
                Kebutuhan rek = new Kebutuhan();
                rek.setTahun(date);
                rek.setKomoditi(komoditi);
                rek.setJmlKebutuhan(keb);
                crud.Simpan(rek);
                out.print("Sukses");
            } catch (Exception ex) {
                Logger.getLogger(KebutuhanAdd.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if ("hapus".equals(p)) {
            String id = HTMLString.nullString(request.getParameter("a"));
            Kebutuhan k = (Kebutuhan) crud.GetById("Kebutuhan", Integer.parseInt(id));
            crud.Hapus(k);
            out.print("Sukses");
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
