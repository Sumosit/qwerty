<%--
  Created by IntelliJ IDEA.
  User: erlan
  Date: 02.10.2019
  Time: 15:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="./css/template.css" rel="stylesheet">
    <link href="./css/header.css" rel="stylesheet">
    <link href="./css/register.css" rel="stylesheet">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
    <jsp:include page="header.jsp"/>
    <div style="padding-top: 60px;">
        <div style="z-index: 1041;" class = "MainBlock">
            <div style="padding-top: 10px;">
        <div class="menus"><ul><li><a href="/goa_v1_war_exploded/home" class="menu-q" style="text-decoration: none; outline: none;">Home</a></li></ul></div>
        <div class="cols" style="display: flex">
            <div class="cont">
                <div style="z-index: 200">
                    <article style="z-index: 200">
                        <div class="full-desc">
                            <header class="full-title">
                                <div><h1>${AnimeName}</h1></div>
                                <div class = short-t-or><h2><%--2ndName--%></h2></div>
                            </header>
                            <div class="full-text">
                                <form method="post">
                                    <div class="form-group">
                                        <label for="exampleInputEmail1">Email address</label>
                                        <input name="email" type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter email">
                                        <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
                                    </div>
                                    <div class="form-group">
                                        <label for="formGroupExampleInput">Nickname</label>
                                        <input name="name" type="text" class="form-control" id="formGroupExampleInput" placeholder="Name">
                                    </div>
                                    <div class="form-group">
                                        <label for="exampleInputPassword1">Password</label>
                                        <input name="pass" type="password" class="form-control" id="exampleInputPassword1" placeholder="Password">
                                    </div>
                                    <div class="form-group form-check">
                                        <input type="checkbox" class="form-check-input" id="exampleCheck1">
                                        <label class="form-check-label" for="exampleCheck1">Check me out</label>
                                    </div>
                                    <button type="submit" onclick="showDiv(pata)" class="btn btn-primary">Submit</button>
                                </form>
                            </div>
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
