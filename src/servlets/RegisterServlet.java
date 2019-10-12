package servlets;

import db.AnimeName;
import db.DBManager;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "RegisterServlet", value = "/register")
public class RegisterServlet extends HttpServlet {
    private DBManager dbManager;

    public void init(){
        dbManager = new DBManager();
        dbManager.connect();
    }
    private String dispatcher = "/views/register.jsp";
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email, pass, name;
        if (dbManager.getAcName().equals("")){
            email = request.getParameter("email");
            name = request.getParameter("name");
            pass = request.getParameter("pass");
            dbManager.setAccount(email, name, pass);
            response.sendRedirect("/goa_v1_war_exploded/home");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String acname = dbManager.getAcName();
        request.setAttribute("AcName", acname);
        RequestDispatcher rd = request.getRequestDispatcher(dispatcher);
        rd.forward(request, response);
    }
}
