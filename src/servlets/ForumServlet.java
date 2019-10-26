package servlets;

import db.Account;
import db.Forum;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import db.DBManager;

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
        response.sendRedirect("/home/forum");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Forum> forums = dbManager.getForum();
        request.setAttribute("forums", forums);

        if (request.getSession().getAttribute("user_data") == null) {
            RequestDispatcher rd = request.getRequestDispatcher("/views/forumYes.jsp");
            rd.forward(request, response);
        } else {
            Account account = (Account) request.getSession().getAttribute("user_data");
            request.setAttribute("AcName", account.getName());
            RequestDispatcher rd = request.getRequestDispatcher("/views/forum.jsp");
            rd.forward(request, response);
        }
    }
}
