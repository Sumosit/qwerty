package servlets;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import db.Account;
import db.DBManager;

@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {
    private DBManager dbManager;

    public void init(){
        dbManager = new DBManager();
        dbManager.connect();
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name, pass;
        name = request.getParameter("login");
        pass = request.getParameter("password");
        Account account = dbManager.checkAccount(name, pass);
        if (account.getName() == null) {
            response.sendRedirect("/login");
        } else {
            request.getSession().setAttribute("user_data", account);
            response.sendRedirect("/home");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher("/views/login.jsp");
        rd.forward(request, response);
    }
}
