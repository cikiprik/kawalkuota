/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kawalkuota.app;

import com.kawalkuota.dao.AppService;
//import com.kawalkuota.entity.Produksi;
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
@WebServlet(name = "ProduksiAdd", urlPatterns = {"/produksiadd"})
public class ProduksiAdd extends HttpServlet {

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
            view.setActiveForm("produksiAdd");
            view.cleansPlaceholder();
            out.print(view.getCompressedForm());
        } else if ("update".equals(p)) {
            view.setActiveForm("produksiUpdate");
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
                String produksi = HTMLString.nullString(request.getParameter("c"));
                        System.out.println("aaa:"+tahun);
                String string = tahun;
                DateFormat format = new SimpleDateFormat("yyyy");
                Date date = format.parse(string);
//                Produksi rek = new Produksi();
//                rek.setTahun(date);
//                rek.setKomoditi(komoditi);
//                rek.setProduksi(produksi);
//                 crud.Simpan(rek);
                out.print("Sukses");
            } catch (Exception ex) {
                Logger.getLogger(ProduksiAdd.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
