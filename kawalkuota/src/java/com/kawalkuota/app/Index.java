package com.kawalkuota.app;

import com.kawalkuota.util.AppConfig;
import java.io.IOException;
import java.io.PrintWriter;
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
        FormLoader view = new FormLoader(getServletContext().getRealPath("WEB-INF/frontend"));
        view.setActiveForm("index");
        
        view.assignField("Title", AppConfig.getAppsProperty(getServletContext(), "title"));
        
        
        
        view.cleansPlaceholder();
        out.print(view.getCompressedForm());
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
