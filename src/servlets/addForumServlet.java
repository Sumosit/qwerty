package servlets;

import db.DBManager;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "addForumServlet", value = "/home/addForum")
public class addForumServlet extends HttpServlet {
    private DBManager dbManager;
    public void init(){
        dbManager = new DBManager();
        dbManager.connect();
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title = request.getParameter("in1"),
        sinfo = request.getParameter("in2");
        dbManager.setForum(title, sinfo);
        response.sendRedirect("/goa_v1_war_exploded/home/forum");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (dbManager.getAcName() == null) {
            response.sendRedirect("/goa_v1_war_exploded/home/forum");
        } else {
            RequestDispatcher rd = request.getRequestDispatcher("/views/addForum.jsp");
            rd.forward(request, response);
        }
    }
}
