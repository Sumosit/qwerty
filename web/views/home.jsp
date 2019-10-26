
<%--
  Created by IntelliJ IDEA.
  User: erlan
  Date: 21.09.2019
  Time: 19:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="db.AnimeName" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
      <link href="./css/home.css" rel="stylesheet">
      <link href="./css/header.css" rel="stylesheet">

      <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
      <title>Title</title>
  </head>
  <body>
      <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
      <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
      <script>
          $(document).ready(function(){
              $('[data-toggle="tooltip"]').tooltip();
          });
      </script>
    <jsp:include page="/views/header.jsp"/>
      <div style="padding-top: 60px; background-color: rgba(0,0,0,0.4)">
    <div class = "MainBlock">
<%--        <jsp:include page="/views/topHeader.jsp"/>--%>
        <form style="margin: 19px 0 0 18px" action="/home" method="post">
            <div class="md-form mt-0 sr-menu" style="padding-top: 10px; margin-left: 13px">
                <input name="search" style="width: 300px; display: inline-block" class="form-control" type="text" placeholder="Search" aria-label="Search">
                <button style="margin-left: 10px" value="search" name="action" type="submit" class="sr-btn">Search</button>
            </div>
        </form>
        <div style="display: flex;">
            <div class="LeftBlock">
                <div class="grid-container">
                    <%
                        ArrayList<AnimeName> animeNames = (ArrayList<AnimeName>) request.getAttribute("AnimeName");
                        if (animeNames!=null) {
                            for (AnimeName c : animeNames) {
                                out.print("<div class=\"grid-item\" style=\"margin-left: 10px\">");
                                out.print("<div class=\"card\" style=\"background-color: rgba(0,0,0,0)\">");
                                out.print("<div class=\"front\">");
                                out.print("<div class=\"views-f\">");
                                out.print("<span>Views: "+c.getViews()+"</span>");
                                out.print("</div>");
                                out.print("<img src=\""+c.getImage()+"\" width=\"260\" height=\"350\">");
                                out.print("</div>");
                                out.print("<div class=\"back\">");
                                out.print("<div class=\"back-content\">");
                                out.print("<a style=\"text-decoration: none; outline: none\" href=\"/home/anime?page="+c.getName()+"&chapter=embed/"+c.getAddress()+"}/&season=1&seria=1\">");
                                out.print("<h4 style=\"text-decoration: none; outline: none; color: #2c3e50;\">"+c.getName()+"</h4>");
                                out.print("<div class=\"sm\">\n" +
                                        "                                            <span>"+c.getHistory()+"</span>\n" +
                                        "                                        </div>\n" +
                                        "                                    </a>\n" +
                                        "                                </div>\n" +
                                        "                            </div>\n" +
                                        "                        </div>\n" +
                                        "                    </div>");
                            }
                        }
                    %>
        </div>
    </div>
    </div>
  </body>
</html>
