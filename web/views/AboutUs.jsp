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

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<jsp:include page="header.jsp"/>
<div style="padding-top: 60px;">
    <div style="z-index: 1041; height: 100%" class = "MainBlock">
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
                                        <p>Уважаемые правообладатели!</p>

                                        <p>Если какой-нибудь материал представленный на нашем сайте нарушает Ваши авторские права, или же дискредитирует Вашу компанию предоставляя неверную или искаженную информацию, пожалуйста свяжитесь с нами для решения этого вопроса.</p>

                                        <p>Для этого необходимо отправить e-mail с вашего корпоративного почтового ящика содержащий:</p>
                                        <p>- полные реквизиты вашей компании, а также телефон и другие контактные данные</p>
                                        <p>- прямую ссылку(ссылки) на спорный материал</p>
                                        <p>- сканированные копии документов подтверждающие эксклюзивное право владения материалом</p>
                                        <p>- в случае представления интересов другой компании копии документов на посреднические услуги.</p>
                                        <p>На адрес abuse@animevost.org</p>

                                        <p>Данная информация будет проверена и администрация ресурса свяжется с Вами для дальнейшего урегулирования спорного вопроса.</p>

                                        <p>Наш проект является некомерческим и не преследует "торговлю" контрафактным материалом ради наживы. Мы даем людям то, что пока не могут сделать крупные медиахолдинги - предоставляем самую полную и свежую коллекцию аниме в рускоязычном сегменте интернета.</p>

                                        <p>Мы всегда идем навстречу правообладателям и их представителям в случае заключения обоюдовыгодных соглашений и готовы предложить различные варианты сотрудничества.</p>

                                        <p>С уважением Администрация AnimeVost.org</p>
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
