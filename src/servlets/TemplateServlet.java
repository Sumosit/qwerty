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

@WebServlet(name = "TemplateServlet", value = "/home/anime")
public class TemplateServlet extends HttpServlet {
    private DBManager dbManager;
    static String s;
    public void init(){
        dbManager = new DBManager();
        dbManager.connect();
    }
    // ad - add/delete
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String ad="", anime, chapter, season, seria, link; // acname = dbManager.getAcName()
        ad = request.getParameter("action");
        anime = request.getParameter("page");
        chapter = request.getParameter("chapter");
        season = request.getParameter("season");
        seria = s;
        String par;
        String ppage = request.getParameter("page"), pchap = request.getParameter("chapter");
        par = "http://localhost:8080/home/anime?page=".concat(ppage).concat("&chapter=")
                .concat(pchap).concat("&season=").concat(season).concat("&seria=").concat(seria);
        link = par;
//        if ("Add bookmark".equals(ad)) {
//            dbManager.setBookMark(acname, anime, link, season, seria);
//        } else if ("Delete bookmark".equals(ad)) {
//            dbManager.delBookMark(acname, anime, season, seria);
//        } else if ("Delete anime".equals(ad)) {
//            dbManager.delAnime(anime);
//        }

        response.sendRedirect(par);
    }
// http://localhost:8080/goa_v1_war_exploded/home/anime?page=OnePiece&chapter=embed/9649/&season=1&seria=1
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String anime, chapter, season, seria, link;
        anime = request.getParameter("page");
        chapter = request.getParameter("chapter");
        season = request.getParameter("season");
        seria = request.getParameter("seria");
        link = chapter+season+"/"+seria;
        ArrayList<AnimeName> animeNames = dbManager.FindAnime(anime);
        dbManager.setViews(animeNames.get(1).getViews() + 1, animeNames.get(1).getName());
        s = seria;
        request.setAttribute("AnimeName", animeNames.get(1).getName());
        request.setAttribute("AnimeText", animeNames.get(1).getHistory());
        request.setAttribute("AnimeDate", animeNames.get(1).getDate());
        request.setAttribute("AnimeProducer", animeNames.get(1).getProducer());
        request.setAttribute("AnimeImage", animeNames.get(1).getImage());
        request.setAttribute("AnimeLinks", animeNames.get(1).getLinks());
        request.setAttribute("AnimeChapter", link);
        request.setAttribute("AnimeSeria1", seria);
        request.setAttribute("Chapter", request.getParameter("chapter"));
        if (request.getSession(false) != null) {
            Account account = (Account) request.getSession().getAttribute("user_data");
            if (account != null){
                request.setAttribute("AcName", account.getName());
            }
        }
        RequestDispatcher rd = request.getRequestDispatcher("/views/template.jsp");
        rd.forward(request, response);
    }
}
