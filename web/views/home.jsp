
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
      <div style="padding-top: 60px">
    <div class = "MainBlock">
        <jsp:include page="/views/topHeader.jsp"/>

        <div style="display: flex;">
            <div class="LeftBlock">
                <div style="padding: 0 0 0 10px;">
                    <div class="item short">
                        <a class="img-pos" href="./home/anime?page=${MainImageLink1}&chapter=embed/${MainAddressLink1}/&season=1&seria=1"><img src="${link1}" width="210" height="300"></a>
                        <div class="short-text">
                            <a class="short-t" style="text-decoration: none; outline: none" href="./home/anime?page=${MainImageLink1}&chapter=embed/${MainAddressLink1}/&season=1&seria=1">${MainImageLink1}</a>
                            <div class="short-c">${GenreLink1}</div>
                        </div>
                    </div>
                    <div class="item short">
                            <a class="img-pos" href="./home/anime?page=${MainImageLink2}&chapter=embed/${MainAddressLink2}/&season=1&seria=1"><img src="${link2}" width="210" height="300"></a>
                            <div class="short-text">
                                <a class="short-t" style="text-decoration: none; outline: none" href="./home/anime?page=${MainImageLink2}&chapter=embed/${MainAddressLink2}/&season=1&seria=1">${MainImageLink2}</a>
                                <div class="short-c">${GenreLink2}</div>
                            </div>
                    </div>
                    <div class="item short">
                            <a class="img-pos" href="./home/anime?page=${MainImageLink3}&chapter=embed/${MainAddressLink3}/&season=1&seria=1"><img src="${link3}" width="210" height="300"></a>
                            <div class="short-text">
                                <a class="short-t" style="text-decoration: none; outline: none" href="./home/anime?page=${MainImageLink3}&chapter=embed/${MainAddressLink3}/&season=1&seria=1">${MainImageLink3}</a>
                                <div class="short-c">${GenreLink3}</div>
                            </div>
                    </div>
                    <div class="item short">
                        <a class="img-pos" href="./home/anime?page=${MainImageLink4}&chapter=embed/${MainAddressLink4}/&season=1&seria=1"><img src="${link4}" width="210" height="300"></a>
                            <div class="short-text">
                                <a class="short-t" style="text-decoration: none; outline: none" href="./home/anime?page=${MainImageLink4}&chapter=embed/${MainAddressLink4}/&season=1&seria=1">${MainImageLink4}</a>
                                <div class="short-c">${GenreLink4}</div>
                            </div>
                    </div>
                    <div class="item short">
                        <a class="img-pos" href="./home/anime?page=${MainImageLink5}&chapter=embed/${MainAddressLink5}/&season=1&seria=1"><img src="${link5}" width="210" height="300"></a>
                            <div class="short-text">
                                <a class="short-t" style="text-decoration: none; outline: none" href="./home/anime?page=${MainImageLink5}&chapter=embed/${MainAddressLink5}/&season=1&seria=1">${MainImageLink5}</a>
                                <div class="short-c">${GenreLink5}</div>
                            </div>
                    </div>
                    <div class="item short">
                        <a class="img-pos" href="./home/anime?page=${MainImageLink6}&chapter=embed/${MainAddressLink6}/&season=1&seria=1"><img src="${link6}" width="210" height="300"></a>
                            <div class="short-text">
                                <a class="short-t" style="text-decoration: none; outline: none" href="./home/anime?page=${MainImageLink6}&chapter=embed/${MainAddressLink6}/&season=1&seria=1">${MainImageLink6}</a>
                                <div class="short-c">${GenreLink6}</div>
                            </div>
                    </div>
                    <div class="item short">
                        <a class="img-pos" href="./home/anime?page=${MainImageLink7}&chapter=embed/${MainAddressLink7}/&season=1&seria=1"><img src="${link7}" width="210" height="300"></a>
                            <div class="short-text">
                                <a class="short-t" style="text-decoration: none; outline: none" href="./home/anime?page=${MainImageLink7}&chapter=embed/${MainAddressLink7}/&season=1&seria=1">${MainImageLink7}</a>
                                <div class="short-c">${GenreLink7}</div>
                            </div>
                    </div>
                    <div class="item short">
                            <a class="img-pos" href="./home/anime?page=${MainImageLink8}&chapter=embed/${MainAddressLink8}/&season=1&seria=1"><img src="${link8}" width="210" height="300"></a>
                            <div class="short-text">
                                <a class="short-t" style="text-decoration: none; outline: none" href="./home/anime?page=${MainImageLink8}&chapter=embed/${MainAddressLink8}/&season=1&seria=1">${MainImageLink8}</a>
                                <div class="short-c">${GenreLink8}</div>
                            </div>
                    </div>
                    <div class="item short">
                            <a class="img-pos" href="./home/anime?page=${MainImageLink9}&chapter=embed/${MainAddressLink9}/&season=1&seria=1"><img src="${link9}" width="210" height="300"></a>
                            <div class="short-text">
                                <a class="short-t" style="text-decoration: none; outline: none" href="./home/anime?page=${MainImageLink9}&chapter=embed/${MainAddressLink9}/&season=1&seria=1">${MainImageLink9}</a>
                                <div class="short-c">${GenreLink9}</div>
                            </div>
                    </div>
                </div>
            </div>
            <div class="RightBlock"> </div>
        </div>
    </div>
    </div>
  </body>
</html>
