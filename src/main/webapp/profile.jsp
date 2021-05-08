<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Профіль</title>
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

    <h2>${patient.fullName}</h2>
    <h3>Дата народження: ${patient.birthday}</h3>
    <h4>Стать: ${patient.sex}</h4>
    <h4>Група крові: ${patient.bloodType}</h4>
    <h4>Зріст: ${patient.height} кг</h4>
    <h4>Вага: ${patient.weight} кг</h4>
    <h4>Адреса проживання: ${patient.addressOfResidence}</h4>
    <h4>Адреса роботи: ${patient.addressOfWork}</h4>
    <h4>Професія: ${patient.profession}</h4>

</body>
</html>