package servlets;

import db.Account;
import db.AnimeName;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import db.DBManager;

@WebServlet(name = "HomeServlet", value = "/home")
public class HomeServlet extends HttpServlet {
    private DBManager dbManager;

    public void init(){
        dbManager = new DBManager();
        dbManager.connect();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ad = request.getParameter("action");
        if ("search".equals(ad)) {
            String search = request.getParameter("search");
            search = search.toUpperCase();
            search = search.replace(" ", "");
            response.sendRedirect("/search?name=" + search);
        }
    }
//http://localhost:8080/goa_v1_war_exploded/home/anime?page=Attack%20On%20Titan&chapter=embed/9302/&season=1&seria=1
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<AnimeName> animeNames = dbManager.getAllAnime();
        request.setAttribute("AnimeName", animeNames);

        if (request.getSession(false) != null) {
            Account account = (Account) request.getSession().getAttribute("user_data");
            if (account != null){
                request.setAttribute("AcName", account.getName());
            }
        }

        RequestDispatcher rd = request.getRequestDispatcher("/views/home.jsp");
        rd.forward(request, response);

    }
}
