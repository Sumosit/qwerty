<%@ page import="java.util.ArrayList" %>
<%@ page import="db.Bookmarks" %><%--
  Created by IntelliJ IDEA.
  User: erlan
  Date: 06.10.2019
  Time: 16:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="./css/template.css" rel="stylesheet">
    <link href="./css/header.css" rel="stylesheet">

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com
        /bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<jsp:include page="header.jsp"/>
<div style="padding-top: 60px;">
    <div style="z-index: 1041; height: 865" class = "MainBlock">
        <div style="padding-top: 10px;">
            <div class="menus"><ul><li><a href="/goa_v1_war_exploded/home" class="menu-q" style="text-decoration: none; outline: none;">Home</a></li></ul></div>
            <div class="cols" style="display: flex">
                <div class="cont">
                    <div style="z-index: 200">
                        <article style="z-index: 200">
                            <div class="full-desc">
                                <header class="full-title">
                                    <div><h1>${AnimeName}</h1></div>
                                    <div class="full-text" style="padding-left: 30px">
                                        <p>Student id: 23003</p>
                                        <p>Erlan Isaev, CSSE-1708R</p>
                                        <p>erlan99isaev@gmail.com</p>
                                        </tbody>
                                        </table>
                                    </div>
                                </header>
                            </div>
                        </article>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
