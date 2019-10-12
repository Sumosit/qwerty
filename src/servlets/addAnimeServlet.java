package servlets;

import db.DBManager;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.Collection;
import javax.servlet.http.Part;
@WebServlet(name = "AddServlet", value = "/home/addAnime")
@MultipartConfig(fileSizeThreshold=600*600*2, // 2MB
        maxFileSize=600*600*10,      // 10MB
        maxRequestSize=600*600*50)
public class addAnimeServlet extends HttpServlet {
    private DBManager dbManager;
    private static final String SAVE_DIR="images";
    public void init(){
        dbManager = new DBManager();
        dbManager.connect();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Collection<Part> parts = request.getParts();

        System.out.println("Request content type: " + request.getContentType());
        System.out.println("Is multipart: "
                + request.getContentType().startsWith("multipart/form-data"));
        System.out.println("# of parts: " + parts.size());

        int i = 0;
        for (Part part : parts) {
            System.out.println("Part #" + ++i + ":");
            System.out.println(part.getName());
            System.out.println(part.getSize());
            System.out.println(part.getContentType());
        }

        Part image = request.getPart("data");
        System.out.println(image.getSize());
        System.out.println(image.getContentType());
        RequestDispatcher rd = request.getRequestDispatcher("/views/addAnime.jsp");
        rd.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        RequestDispatcher rd = request.getRequestDispatcher("/views/addAnime.jsp");
        rd.forward(request, response);
    }

    private String extractFileName(Part part) {
        String contentDisp = part.getHeader("content-disposition");
        String[] items = contentDisp.split(";");
        for (String s : items) {
            if (s.trim().startsWith("filename")) {
                return s.substring(s.indexOf("=") + 2, s.length()-1);
            }
        }
        return "";
    }
}

