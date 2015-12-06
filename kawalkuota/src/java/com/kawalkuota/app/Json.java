/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kawalkuota.app;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.kawalkuota.dao.AppService;
import com.kawalkuota.dto.KebutuhanJson;
import com.kawalkuota.dto.KuotaJson;
import com.kawalkuota.dto.ProduksiJson;
import com.kawalkuota.dto.RekomendasiJson;
import com.kawalkuota.entity.Ijin;
import com.kawalkuota.entity.Kebutuhan;
import com.kawalkuota.entity.Produksi;
import com.kawalkuota.entity.Pib;
import com.kawalkuota.entity.Produksi;
import com.kawalkuota.entity.Rekomendasi;
import com.kawalkuota.entity.Rekomendasidetil;
import com.kawalkuota.entity.User;
import com.kawalkuota.entity.Vkuota;
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
        int i;
        try {

            String p = HTMLString.nullString(request.getParameter("content"));
            HttpSession hs = request.getSession();
            if ("rekomendasi".equals(p)) {
                List<RekomendasiJson> jso = new ArrayList<RekomendasiJson>();
                i = 0;

                List<Rekomendasi> td = appService.GetAllData("Rekomendasi");
                for (Iterator<Rekomendasi> it = td.iterator(); it.hasNext();) {
                    RekomendasiJson js = new RekomendasiJson();
                    Rekomendasi rek = it.next();
                    js.setIdRekomendasi(rek.getIdRekomendasi());
                    js.setNoSurat(rek.getNoSurat());
                    js.setNpwp(rek.getNpwp());
                    js.setStatus(rek.getStatus());
                    js.setTglakhir(rek.getTglakhir());
                    js.setTglawal(rek.getTglawal());
                    js.setTipe(rek.getTipe());
                    js.setAksi(
                            "<button class='btn btn-warning btn-xs btn-fill' "
                            + "onclick='edit(" + rek.getIdRekomendasi() + ")'>"
                            + "<i class='fa fa-pencil-square-o'></i></button> "
                            + "<button class='btn btn-danger btn-xs btn-fill' onclick='hapus(" + rek.getIdRekomendasi() + ")'><i class='fa fa-trash-o'></i></button>"
                            + "<button class='btn btn-success btn-xs btn-fill' onclick='detil(" + rek.getIdRekomendasi() + ")'><i class='fa fa-search'></i></button>");
                    jso.add(js);
                }

                Gson gson = new Gson();
                Type type = new TypeToken<List<RekomendasiJson>>() {
                }.getType();
                String json = gson.toJson(jso, type);
                out.println("{\"data\":" + json + "}");


            }
            if ("rekomendasidetil".equals(p)) {

                List<Rekomendasidetil> td = appService.GetAllData("Rekomendasidetil");

                for (Iterator<Rekomendasidetil> it = td.iterator(); it.hasNext();) {
                    Rekomendasidetil rek = it.next();
                    rek.setFlag(
                            "<button class='btn btn-warning btn-xs btn-fill' "
                            + "onclick='edit(" + rek.getIdDetilRekomendasi() + ")'>"
                            + "<i class='fa fa-pencil-square-o'></i></button> "
                            + "<button class='btn btn-danger btn-xs btn-fill' onclick='delete(" + rek.getIdDetilRekomendasi() + ")'><i class='fa fa-trash-o'></i></button>");
                }
                Gson gson = new Gson();
                Type type = new TypeToken<List<Rekomendasi>>() {
                }.getType();
                String json = gson.toJson(td, type);
                out.println("{\"data\":" + json + "}");
            }
            if ("produksi".equals(p)) {
                List<ProduksiJson> jso = new ArrayList<ProduksiJson>();
                i = 0;

                List<Produksi> td = appService.GetAllData("Produksi");
                for (Iterator<Produksi> it = td.iterator(); it.hasNext();) {
                    Produksi produksi = it.next();
                    ProduksiJson js = new ProduksiJson();
                    i++;
                    js.setIdProduksi(i);
                    js.setJmlProduksi(produksi.getJmlProduksi());
                    js.setKomoditi(produksi.getKomoditi());
                    js.setTahun(produksi.getTahun());
                    js.setAksi("<button class='btn btn-warning btn-xs btn-fill' "
                            + "onclick='edit(" + produksi.getIdProduksi() + ")'>"
                            + "<i class='fa fa-pencil-square-o'></i></button> "
                            + "<button class='btn btn-danger btn-xs btn-fill' onclick='hapus(" + produksi.getIdProduksi() + ")'><i class='fa fa-trash-o'></i></button>");
                    jso.add(js);
                }

                Gson gson = new Gson();
                Type type = new TypeToken<List<ProduksiJson>>() {
                }.getType();
                String json = gson.toJson(jso, type);
                out.println("{\"data\":" + json + "}");

            }
            if ("kebutuhan".equals(p)) {
                List<KebutuhanJson> jso = new ArrayList<KebutuhanJson>();
                i = 0;

                List<Kebutuhan> td = appService.GetAllData("Kebutuhan");
                for (Iterator<Kebutuhan> it = td.iterator(); it.hasNext();) {
                    Kebutuhan kebutuhan = it.next();
                    KebutuhanJson js = new KebutuhanJson();
                    i++;
                    js.setIdKebutuhan(i);
                    js.setJmlKebutuhan(kebutuhan.getJmlKebutuhan());
                    js.setKomoditi(kebutuhan.getKomoditi());
                    js.setTahun(kebutuhan.getTahun());
                    js.setAksi("<button class='btn btn-warning btn-xs btn-fill' "
                            + "onclick='edit(" + kebutuhan.getIdKebutuhan() + ")'>"
                            + "<i class='fa fa-pencil-square-o'></i></button> "
                            + "<button class='btn btn-danger btn-xs btn-fill' onclick='hapus(" + kebutuhan.getIdKebutuhan() + ")'><i class='fa fa-trash-o'></i></button>");
                    jso.add(js);
                }

                Gson gson = new Gson();
                Type type = new TypeToken<List<KebutuhanJson>>() {
                }.getType();
                String json = gson.toJson(jso, type);
                out.println("{\"data\":" + json + "}");

            }
            if ("user".equals(p)) {
                List<User> td = appService.GetAllData("User");
                for (Iterator<User> it = td.iterator(); it.hasNext();) {
                    User rek = it.next();
                    rek.setPassword(
                            "<button class='btn btn-warning btn-xs btn-fill' "
                            + "onclick='edit(" + rek.getIdUser() + ")'>"
                            + "<i class='fa fa-pencil-square-o'></i></button> "
                            + "<button class='btn btn-danger btn-xs btn-fill' onclick='delete(" + rek.getIdUser() + ")'><i class='fa fa-trash-o'></i></button>");
                }
                Gson gson = new Gson();
                Type type = new TypeToken<List<Rekomendasi>>() {
                }.getType();
                String json = gson.toJson(td, type);
                out.println("{\"data\":" + json + "}");

            }
            if ("datapib".equals(p)) {
                try {
                    List<Pib> td = appService.GetAllData("Pib");
                    for (Iterator<Pib> it = td.iterator(); it.hasNext();) {
                        Pib pib = it.next();
                        pib.setUraian(pib.getUraian().replace("\"", " "));
                    }
                    Gson gson = new Gson();
                    Type type = new TypeToken<List<Pib>>() {
                    }.getType();
                    String json = gson.toJson(td, type);
                    out.println("{\"data\":" + json + "}");
//                    System.out.println("" + json);
                } catch (Exception e) {
                }


            }
            if ("izininsw".equals(p)) {
                try {
                    List<Ijin> td = appService.GetAllData("Ijin");
//                    for (Iterator<Ijin> it = td.iterator(); it.hasNext();) {
//                        Ijin ijin = it.next();
////                        ijin.setUraian(pib.getUraian().replace("\"", " "));
//                    }
                    Gson gson = new Gson();
                    Type type = new TypeToken<List<Ijin>>() {
                    }.getType();
                    String json = gson.toJson(td, type);
                    out.println("{\"data\":" + json + "}");
//                    System.out.println("" + json);
                } catch (Exception e) {
                }
            }
            if ("viewkuota".equals(p)) {
                List<KuotaJson> jso = new ArrayList<KuotaJson>();
                i = 0;
                List<Vkuota> td = appService.GetAllData("Vkuota");
                for (Iterator<Vkuota> it = td.iterator(); it.hasNext();) {
                    Vkuota v = it.next();
                    KuotaJson j = new KuotaJson();
                    j.setIdIjin(v.getIdIjin());
                    j.setNum(i);
                    j.setNegara(v.getNegara());
                    j.setPelBongkar(v.getPelBongkar());
                    j.setTglIjin(v.getTglIjin());
                    j.setNoIjin(v.getNoIjin());
                    j.setAksi("<button class='btn btn-success btn-xs btn-fill' onclick='detil(" + v.getIdIjin() + ")'><i class='fa fa-search'></i></button>");
                    jso.add(j);
                }
                

                Gson gson = new Gson();
                Type type = new TypeToken<List<Vkuota>>() {
                }.getType();
                String json = gson.toJson(jso, type);
                out.println("{\"data\":" + json + "}");
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
