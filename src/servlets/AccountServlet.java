package servlets;

import db.Account;
import db.Bookmarks;
import db.DBManager;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "AccountServlet", value = "/account")
public class AccountServlet extends HttpServlet {
    private DBManager dbManager;

    public void init(){
        dbManager = new DBManager();
        dbManager.connect();
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession(false) != null) {
            Account account = (Account) request.getSession().getAttribute("user_data");
            if (account != null){
                request.setAttribute("AcName", account.getName());
                ArrayList<Bookmarks> bk = dbManager.bookmarks(account.getName());
                request.setAttribute("bookmarks", bk);
            }
        }
        RequestDispatcher rd = request.getRequestDispatcher("/views/account.jsp");
        rd.forward(request, response);
    }
}
