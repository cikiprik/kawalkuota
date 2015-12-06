package com.kawalkuota.app;

import com.kawalkuota.dao.AppService;
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
@WebServlet(name = "RegistrasiUser", urlPatterns = {"/registrasiuser.html"})
public class RegistrasiUser extends HttpServlet {
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
   
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        FormLoader view = new FormLoader(getServletContext().getRealPath("WEB-INF/backend"));
        String p = HTMLString.nullString(request.getParameter("p"));
        if ("list".equals(p)) {
            view.setActiveForm("userList");
            view.cleansPlaceholder();
            out.print(view.getCompressedForm());
        } else if ("add".equals(p)) {
            view.setActiveForm("userAdd");
            view.cleansPlaceholder();
            out.print(view.getCompressedForm());
        }
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
   
         response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        String level = HTMLString.nullString(request.getParameter("level"));
        String status = HTMLString.nullString(request.getParameter("status"));
        try{
            String x = appService.CekLogin("","");
            out.print(x);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
