package servlets;

import db.Account;
import db.DBManager;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AboutUsServlet", value = "/about")
public class AboutUsServlet extends HttpServlet {
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
            }
        }

        RequestDispatcher rd = request.getRequestDispatcher("/views/AboutUs.jsp");
        rd.forward(request, response);
    }
}
