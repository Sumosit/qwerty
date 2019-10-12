<%--
  Created by IntelliJ IDEA.
  User: erlan
  Date: 03.10.2019
  Time: 0:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <link href="../css/home.css" rel="stylesheet">
    <link href="../css/header.css" rel="stylesheet">
    <link href="../css/upload.css" rel="stylesheet">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
    <script src="../upload.js"></script>

</head>
<body>
<jsp:include page="header.jsp"/>
<div style="padding-top: 60px">
    <div class = "MainBlock" style="height: 865px">
        <div style="display: flex;">
            <form method="post">
                <div class="form-group">
                    <label for="formGroupExampleInput1"></label>
                    <input type="text" class="form-control" name="in1" id="formGroupExampleInput1" placeholder="Title">
                </div>
                <div class="form-group">
                    <label for="formGroupExampleInput2"></label>
                    <input type="text" class="form-control" name="in2" id="formGroupExampleInput2" placeholder="Short info">
                </div>
                <button type="submit" class="btn btn-primary">Submit</button>
            </form>
        </div>
    </div>

</div>
</body>
</html>
