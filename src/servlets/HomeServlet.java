package servlets;

import db.AnimeName;
import db.DBManager;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;

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
            String sr = request.getParameter("sr");
            ArrayList<AnimeName> result = dbManager.FindAnime(sr);
            String em = result.get(1).getAddress();
            response.sendRedirect("/goa_v1_war_exploded/home/anime?page="+sr+"&chapter=embed/"+em+"/&season=1&seria=1");
        }
    }
//http://localhost:8080/goa_v1_war_exploded/home/anime?page=Attack%20On%20Titan&chapter=embed/9302/&season=1&seria=1
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<AnimeName> animeNames = dbManager.getAllAnimeDate();
        String link = "", name = "", topImageLink = "", MainImageLink = "", MaimImageTitle = "", MainImageGenre = "", GenreLink = "";
        String MainAnimeAddress = "", MainAddressLink = "", text = "", ltext = "", acname = dbManager.getAcName();
        for (int i = 1; i < 10; i++){
            link = "link".concat(String.valueOf(i));
            topImageLink = "topImageLink".concat(String.valueOf(i));
            MainImageLink = "MainImageLink".concat(String.valueOf(i));
            GenreLink = "GenreLink".concat(String.valueOf(i));
            MainAddressLink = "MainAddressLink".concat(String.valueOf(i));
            ltext = "ltext".concat(String.valueOf(i));
            name = animeNames.get(i).getImage();
            MainImageGenre = animeNames.get(i).getGenre();
            MaimImageTitle = animeNames.get(i).getName();
            MainAnimeAddress = animeNames.get(i).getAddress();
            text = animeNames.get(i).getHistory();
            request.setAttribute(link, name);
            request.setAttribute(topImageLink, name);
            request.setAttribute(MainImageLink, MaimImageTitle);
            request.setAttribute(GenreLink, MainImageGenre);
            request.setAttribute(MainAddressLink, MainAnimeAddress);
            request.setAttribute(ltext, text);
        }
        String link1 = "", name1 = "", topImageLink1 = "", MainImageLink1 = "", MaimImageTitle1 = "", MainImageGenre1 = "", GenreLink1 = "";
        String MainAnimeAddress1 = "", MainAddressLink1 = "", text1 = "", ltext1 = "";
        request.setAttribute("AcName", acname);
        ArrayList<AnimeName> animedate = dbManager.getAllAnime();
        for (int i = 1; i < 10; i++){
            link1 = "link".concat(String.valueOf(i)).concat(String.valueOf(i));
            topImageLink1 = "topImageLink".concat(String.valueOf(i)).concat(String.valueOf(i));
            MainImageLink1 = "MainImageLink".concat(String.valueOf(i)).concat(String.valueOf(i));
            GenreLink1 = "GenreLink".concat(String.valueOf(i)).concat(String.valueOf(i));
            MainAddressLink1 = "MainAddressLink".concat(String.valueOf(i)).concat(String.valueOf(i));
            ltext1 = "ltext".concat(String.valueOf(i)).concat(String.valueOf(i));
            name1 = animedate.get(i).getImage();
            MainImageGenre1 = animedate.get(i).getGenre();
            MaimImageTitle1 = animedate.get(i).getName();
            MainAnimeAddress1 = animedate.get(i).getAddress();
            text1 = animedate.get(i).getHistory();
            request.setAttribute(link1, name1);
            request.setAttribute(topImageLink1, name1);
            request.setAttribute(MainImageLink1, MaimImageTitle1);
            request.setAttribute(GenreLink1, MainImageGenre1);
            request.setAttribute(MainAddressLink1, MainAnimeAddress1);
            request.setAttribute(ltext1, text1);
        }
        String exit = request.getParameter("exit");
        if (exit.equals("1")) {
            dbManager.exitAccount();
        }


        RequestDispatcher rd = request.getRequestDispatcher("/views/home.jsp");
        rd.forward(request, response);

    }
}
