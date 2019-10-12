<%@ page import="db.Forum" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: erlan
  Date: 08.10.2019
  Time: 16:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="../css/forum.css" rel="stylesheet">
    <link href="../css/header.css" rel="stylesheet">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <title>Title</title>
</head>
<body>
    <jsp:include page="header.jsp"/>
    <div style="padding-top: 60px;">
        <div style="z-index: 1041; height: 100%" class = "MainBlock">
            <div class="full-desc">
                <header class="full-title">
                    <div class="">
                        <div class="">
                            <div class="full-text" style="padding-left: 30px">
                                <table class="table table-striped tablesorter d-inline-block text-truncate">
                                    <thead>
                                    <th width="1200 px" scope="col">Forum</th>
                                    </thead>
                                    <tbody>
                                    <%
                                        ArrayList<Forum> bk = (ArrayList<Forum>) request.getAttribute("forums");
                                        String acname = (String) request.getAttribute("AcName");
                                        if (bk!=null) {
                                            for (Forum c : bk) {
                                                out.print("<tr class='table-i'>");
                                                out.print("<td style='max-width: 100%;'><a class='nolink' style=' text-decoration: none; outline: none;' href='/goa_v1_war_exploded/home/paper?id="+ c.getId() +"'><div><strong><p class='title'>"+c.getTitle()+"</p></strong><p class='sinfo'>"+c.getSinfo()+"</p></div></a></td>");
                                                out.print("</tr>");
                                            }
                                        }
                                    %>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </header>
            </div>
        </div>
    </div>
</body>
</html>
