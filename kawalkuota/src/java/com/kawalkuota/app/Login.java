
package com.kawalkuota.app;

import com.kawalkuota.dao.AppService;
import com.kawalkuota.util.AppConfig;
import com.kawalkuota.util.Encript;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import net.ahsanfile.html.form.FormLoader;
import net.ahsanfile.html.helper.HTMLString;

@WebServlet(name = "Login", urlPatterns = {"/login.html"})
public class Login extends HttpServlet {
    
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
        FormLoader view = new FormLoader(getServletContext().getRealPath("WEB-INF/frontend"));
        String p = HTMLString.nullString(request.getParameter("p"));
        view.setActiveForm("login");
        view.assignField("Title", AppConfig.getAppsProperty(getServletContext(), "title"));
        view.cleansPlaceholder();
        out.print(view.getCompressedForm());
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String user = new Encript().decriptCode(request.getParameter("a"));
        String password = new Encript().decriptCode(request.getParameter("b"));
        HttpSession hs = request.getSession();
        try{
            String x = crud.CekLogin(user, password);
            hs.getAttribute("");
            out.print(x);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
