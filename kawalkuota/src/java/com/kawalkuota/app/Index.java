package com.kawalkuota.app;

import com.kawalkuota.dao.AppService;
import com.kawalkuota.entity.DataLokasi;
import com.kawalkuota.util.AppConfig;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.ahsanfile.html.form.FormLoader;

/**
 *
 * @author Yusrul <yusrul@kemenkeu.go.id>
 */
@WebServlet(name = "Index", urlPatterns = {"/index.html"})
public class Index extends HttpServlet {
    @EJB
    AppService appServ;
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
        response.setContentType("text");
        PrintWriter out = response.getWriter();
        FormLoader view = new FormLoader(getServletContext().getRealPath("WEB-INF/frontend"));
        view.setActiveForm("index");
        view.assignField("Title", AppConfig.getAppsProperty(getServletContext(), "title"));
        
        List<DataLokasi> dataLokasi = appServ.GetAllData("DataLokasi");
        view.assignRepeat(dataLokasi, DataLokasi.class, "listLokasi");
        
        
        
        view.cleansPlaceholder();
        out.print(view.getActiveForm());
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
  
    }

 
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
