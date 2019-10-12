<%@ page import="db.Forum" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="db.Comments" %><%--
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
                            <table class="table">
                                <thead>
                                    <tr>
                                        <th scope="col">Comments</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <%
                                        ArrayList<Comments> bk = (ArrayList<Comments>) request.getAttribute("comments");
                                        int i = 0;
                                        if (bk!=null) {
                                            for (Comments c : bk) {
                                                i++;
                                                out.print("<tr name='"+i+"'>");
                                                out.print("<th><div class='div-a'>"+c.getAcname()+"</div><div class='div-t'>"+c.getComment()+"</div></th>");
                                                out.print("</tr>");
                                            }
                                        }
                                    %>
                                </tbody>
                            </table>
                            <jsp:include page='formComment.jsp'/>
                        </div id="sb">
                    </div>
                </div>
            </header>
        </div>
    </div>
</div>
</body>
</html>
