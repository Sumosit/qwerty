package servlets;

import db.Comments;
import db.DBManager;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;

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
        String acname = dbManager.getAcName();
        dbManager.setComment(id, acname, text);
        response.sendRedirect("/goa_v1_war_exploded/home/paper?id="+id);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("AcName", dbManager.getAcName());
        ArrayList<Comments> comments = dbManager.getComments(Integer.parseInt(request.getParameter("id")));
        request.setAttribute("comments", comments);
        if (dbManager.getAcName() == null) {
            RequestDispatcher rd = request.getRequestDispatcher("/views/paperYes.jsp");
            rd.forward(request, response);
        } else {
            RequestDispatcher rd = request.getRequestDispatcher("/views/paper.jsp");
            rd.forward(request, response);
        }


    }
}
