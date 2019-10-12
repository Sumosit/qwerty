package servlets;

import db.DBManager;
import db.Forum;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

@WebServlet(name = "ForumServlet", value = "/home/forum")
public class ForumServlet extends HttpServlet {
    private DBManager dbManager;
    public void init(){
        dbManager = new DBManager();
        dbManager.connect();
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String del = request.getParameter("del");
        if (del!=null) {
            dbManager.delForum(Integer.parseInt(del));
        }
        response.sendRedirect("/goa_v1_war_exploded/home/forum");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Forum> forums = dbManager.getForum();
        request.setAttribute("AcName", dbManager.getAcName());
        request.setAttribute("forums", forums);

        if (dbManager.getAcName() == null) {
            RequestDispatcher rd = request.getRequestDispatcher("/views/forumYes.jsp");
            rd.forward(request, response);
        } else {
            RequestDispatcher rd = request.getRequestDispatcher("/views/forum.jsp");
            rd.forward(request, response);
        }
    }
}
