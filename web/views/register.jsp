<%--
  Created by IntelliJ IDEA.
  User: erlan
  Date: 20.10.2019
  Time: 23:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="../css/header.css" rel="stylesheet">
    <link href="../css/register.css" rel="stylesheet">
    <title>Title</title>
</head>
<body>
<div class="login-back">
    <div class="login-box">
        <form method="post" >
            <h1>Login</h1>
            <div class="textbox">
                <label>
                    <input type="text" placeholder="Username" name="login">
                </label>
            </div>

            <div class="textbox">
                <label>
                    <input type="password" placeholder="Password" name="password">
                </label>
            </div>

            <button type="submit" onclick="showDiv(pata)" class="login-btn">Sign in</button>
        </form>
    </div>
</div>
</body>
</html>
