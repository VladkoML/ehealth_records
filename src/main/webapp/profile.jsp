<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Профіль</title>
</head>
<body>

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