<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" name="viewport" content="width=device-width, initial-scale=1">
    <title>Вакцинація</title>
    <link rel="stylesheet" href="ui/css/menu_style.css">
</head>
<body>

    <header>

            <h1 id="logo">Медична картка амбулаторного хворого</h1>

            <input type="checkbox" id="hmt" class="hidden-menu-ticker">
                <label class="btn-menu" for="hmt">
                    <span class="first"></span>
                    <span class="second"></span>
                    <span class="third"></span>
                </label>
                <ul class="hidden-menu">
                    <li style="display: flex; flex-direction: column;">
                        <a href="profile.jsp">Профіль</a>
                        <a href="recordsServlet">Вакцинація</a>
                        <a href="vaccinationServlet">Записи</a>
                        <a href="resultsServlet">Результати</a>
                        <a href="logoutServlet" id="logout">Вихід</a>
                    </li>
                </ul>

        </header>



</body>
</html>