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
        <div class = "MainBlock">
            <div style="display: flex;">
                <form method="post">
                    <div class="form-group">
                        <label for="formGroupExampleInput1"></label>
                        <input type="text" class="form-control" name="in1" id="formGroupExampleInput1" placeholder="Name">
                    </div>

                    <form action="addAnime.jsp" method="post" enctype="multipart/form-data">
                        <input name="data" type="file"><br>
                        <input type="submit"><br>

                    <script>
                        // Add the following code if you want the name of the file appear on select
                        $(".custom-file-input").on("change", function() {
                            var fileName = $(this).val().split("\\").pop();
                            $(this).siblings(".custom-file-label").addClass("selected").html(fileName);
                        });1
                    </script>
                    <div class="form-group">
                        <label for="formGroupExampleInput4"></label>
                        <input type="text" style="width: 320px; height: 200px" name="in4" class="form-control" id="formGroupExampleInput4" placeholder="Text">
                    </div>
                    <div class="form-group">
                        <label for="formGroupExampleInput5"></label>
                        <input type="text" class="form-control" name="in5" id="formGroupExampleInput5" placeholder="Producer">
                    </div>
                    <div class="form-group">
                        <label for="formGroupExampleInput6"></label>
                        <input type="text" class="form-control" name="in6" id="formGroupExampleInput6" placeholder="Season">
                    </div>
                    <div class="form-group">
                        <label for="formGroupExampleInput7"></label>
                        <input type="text" class="form-control" name="in7" id="formGroupExampleInput7" placeholder="How much series?">
                    </div>
                    <div class="form-group">
                        <label for="formGroupExampleInput8"></label>
                        <input type="text" class="form-control" name="in8" id="formGroupExampleInput8" placeholder="Year-month-day">
                    </div>
                    <button type="submit" class="btn btn-primary">Submit</button>
                </form>
            </div>
        </div>

    </div>
</body>
</html>
