package servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ControllerServlet", value = "/main")
public class ControllerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page = request.getParameter("page");
        String jspPage = "home";
        if (page!=null){
            if (page.equals("home")){
                jspPage = "home";
            } else if (page.equals("AboutUs")){
                jspPage = "AboutUs";
            }
        }
        request.getRequestDispatcher("/" + jspPage + ".jsp").forward(request, response);
    }
}
