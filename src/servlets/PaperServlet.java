package servlets;
import db.Account;
import db.DBManager;

import db.Comments;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "PaperServlet", value = "/home/paper")
public class PaperServlet extends HttpServlet {
    private DBManager dbManager;

    public void init(){
        dbManager = new DBManager();
        dbManager.connect();
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String text = request.getParameter("comment"),
                id = request.getParameter("id");
        Account account = (Account) request.getSession().getAttribute("user_data");
        dbManager.setComment(id, account.getName(), text);
        response.sendRedirect("/home/paper?id="+id);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("user_data") != null) {
            Account account = (Account) request.getSession().getAttribute("user_data");
            request.setAttribute("AcName", account.getName());
            ArrayList<Comments> comments = dbManager.getComments(Integer.parseInt(request.getParameter("id")));
            request.setAttribute("comments", comments);
            RequestDispatcher rd = request.getRequestDispatcher("/views/paper.jsp");
            rd.forward(request, response);
        } else {
            RequestDispatcher rd = request.getRequestDispatcher("/views/paperYes.jsp");
            rd.forward(request, response);
        }
    }
}
