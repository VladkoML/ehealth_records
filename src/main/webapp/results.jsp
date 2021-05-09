<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" name="viewport" content="width=device-width, initial-scale=1">
    <title>Результати</title>
    <link rel="stylesheet" href="ui/css/records_style.css">
    <link rel="stylesheet" href="ui/css/menu_style.css">
</head>
<body>

    <div id="bg-image"></div>

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
                                            <a href="profileServlet">Профіль</a>
                                            <a href="recordsServlet">Записи</a>
                                            <a href="vaccinationServlet">Вакцинація</a>
                                            <a href="resultsServlet">Результати</a>
                                            <a href="logoutServlet" id="logout">Вихід</a>
                                        </li>
                </ul>

        </header>



</body>
</html>