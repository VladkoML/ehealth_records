<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" name="viewport" content="width=device-width, initial-scale=1">
    <title>Записи</title>
    <link rel="stylesheet" href="ui/css/records_style.css">
</head>
<body>

    <div style="display: flex; justify-content: flex-end;">
        <a style="padding: 10px; background: rgb(255, 255, 255); border-radius: 5px; border: 1px solid #000; margin: 10px; text-decoration: none; font-weight: bold; color: #000;" href="#openModal">
            Новий запис
        </a>
    </div>

    <c:if test="${not empty records}">
        <c:forEach var="record" items="${records}">

            <span class="records">

                    <h4 class="records-id">
                        ID: <c:out value="${record.recordId}" />
                    </h4>

                    <div class="content">
                        <div class="records-content">

                            <span class="records-content-item">
                                <h4>Діагноз:</h2>
                                <p><c:out value="${record.disease}" /></p>
                            </span>

                            <span class="records-content-item">
                                <h4>Скарги:</h2>
                                <p><c:out value="${record.complains}" /></p>
                            </span>

                            <span class="records-content-item">
                                <h4>Призначення лікування:</h2>
                                <p><c:out value="${record.medicalTreatment}" /></p>
                            </span>



                        </div>

                        <div class="records-info">
                            <h4><c:out value="${record.nameOfDoctor}" /></h4>
                            <p><c:out value="${record.addressOfHospital}" /></p>
                            <p><c:out value="${record.nameOfHospital}" /></p>
                        </div>
                    </div>

                    <p class="created-in">Створено: <span>2021-02-15</span></p>
                </span>

        </c:forEach>
    </c:if>

    <span id="openModal">

        <form action="recordsServlet" method="POST">

                        <h2>Новий запис</h2>


                        <content>

                            <span class="part-form">

                                <label for="">
                                    <h4>ПІБ лікаря:</h4>
                                    <input type="text" name="doctor">
                                </label>

                                <label for="">
                                    <h4>Діагноз:</h4>
                                    <input type="text" name="disease">
                                </label>

                            </span>

                            <span class="part-form">

                                <label for="">
                                    <h4>Назва лікувального закладу:</h4>
                                    <input type="text" name="hospital">
                                </label>

                                <label for="">
                                    <h4>Скарги хворого:</h4>
                                    <textarea rows="5" cols="30" name="complains"></textarea>
                                </label>

                            </span>

                            <span class="part-form">

                                <label for="">
                                    <h4>Адреса лікувального закладу:</h4>
                                    <input type="text" name="address">
                                </label>

                                <label for="">
                                    <h4>Призначення лікування:</h4>
                                    <textarea rows="5" cols="30" name="treatment"></textarea>
                                </label>

                            </span>

                        </content>

                        <button type="submit">Створити запис</button>

        </form>
    </span>

</body>
</html>