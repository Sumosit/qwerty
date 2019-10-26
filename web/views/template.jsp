<%--
  Created by IntelliJ IDEA.
  User: erlan
  Date: 29.09.2019
  Time: 12:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="../css/template.css" rel="stylesheet">
    <link href="../css/header.css" rel="stylesheet">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
    <jsp:include page="header.jsp"/>
    <div style="padding-top: 60px;">
        <div style="z-index: 1041;" hei class = "MainBlock">
            <div style="padding-top: 10px;">
                <div class="menus"><ul><li><a href="/home?exit=0" class="menu-q" style="text-decoration: none; outline: none;">Home</a></li></ul></div>
                <div class="cols" style="display: flex">
                    <div class="cont">
                        <div style="z-index: 200">
                            <article style="z-index: 200">
                                <div class="full-desc">
                                    <header class="full-title">
                                        <div><h1>${AnimeName}</h1></div>
                                        <div class = short-t-or><h2><%--2ndName--%></h2></div>
                                    </header>
                                    <div class="full-text">${AnimeText}</div>
                                    <div class="full-info">
                                        <div class="fi-col">
                                            <div class="fi-col-item">
                                                <h4>Date: </h4><h6>${AnimeDate}</h6>
                                            </div>
                                            <div class="fi-col-item">
                                                <h4>Producer: </h4><h6>${AnimeProducer}</h6>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="full-taglist">
                                        <div class="full-taglist-t">
                                            <h4>Tags: </h4>
                                        </div>
                                        ${AnimeTags}
                                    </div>
                                    <div class="screens" style="padding-top: 15px; border-top: 1px solid #eee">
                                        <div class="screens-t"><h5 style="font-size: 30px">Screenshots for anime ${AnimeName}</h5></div>
                                        <div class="screens-c flex-row">
                                            <ul class="temp-li" style="display: flex;">
                                                <li>
                                                    <a href="../image/${AnimeName}/screen1.jpg" onclick="return hs.expand(this, { slideshowGroup: 'xf_197_screens' })" target="_blank" class="highslide-active-anchor">
                                                        <img src="../image/${AnimeName}/screen1.jpg" alt>
                                                    </a>
                                                </li>
                                                <li><a href="../image/${AnimeName}/screen2.jpg" onclick="return hs.expand(this, { slideshowGroup: 'xf_197_screens' })" target="_blank" class="highslide-active-anchor">
                                                    <img src="../image/${AnimeName}/screen2.jpg" alt>
                                                </a></li>
                                                <li><a href="../image/${AnimeName}/screen3.jpg" onclick="return hs.expand(this, { slideshowGroup: 'xf_197_screens' })" target="_blank" class="highslide-active-anchor">
                                                    <img src="../image/${AnimeName}/screen3.jpg" alt>
                                                </a></li>
                                                <li><a href="../image/${AnimeName}/screen4.jpg" onclick="return hs.expand(this, { slideshowGroup: 'xf_197_screens' })" target="_blank" class="highslide-active-anchor">
                                                    <img src="../image/${AnimeName}/screen4.jpg" alt>
                                                </a></li>
                                            </ul>
                                        </div>
                                    </div>
                                </div>
                                <div class="full-desc" style="background-image: linear-gradient(to bottom right,#323a4b,#7d0400);padding: 8px;">
                                    <div class="flex-row"></div>
                                    <div id="videoPlayer" class="tabs-box">
                                        <div class="embed-responsive embed-responsive-16by9" style="width: 100%; height: 540px;">
                                            <iframe width="100%" height="520px" style="padding-top: 17px" class="embed-responsive-item" src="https://online.animedia.tv/${AnimeChapter}" allowfullscreen></iframe>
                                        </div>
                                    </div>
                                </div>
                                <div class="button-player" id="style-4" style="display: flex;">
                                    <ul class="temp-li">${AnimeLinks}</ul>
                                </div>
                            </article>
                        </div>
                    </div>
                    <aside class="side">
                        <div class="f-poster">
                            <img src = "../${AnimeImage}" width="216px" height="297px">
                            <div class="temp-menu">
                                <form action="/home/anime?page=${AnimeName}&chapter=${Chapter}&season=1&seria=1" method="post">
                                    <input type="submit" name="action" value="Add bookmark">
                                    <input style="padding-right: 10px" type="submit" name="action" value="Delete bookmark">
                                    <input type="submit" name="action" value="Delete anime">
                                </form>
                            </div>
                        </div>
                    </aside>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
