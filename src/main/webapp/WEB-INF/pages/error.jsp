<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Ошибка - повторите запрос!</title>
</head>
<body>

<div id="main">
    <%@include file="jspf/header.jspf" %>
    <div id="jspError">
        <h1>Извините, но к сожалению, что-то пошло не так и произошла ошибка. Вы можете вернуться на <a href="<c:url value='/' />">Главную страницу</a></h1>
    </div>
</div>
<%@include file="jspf/footer.jspf" %>
</body>

</html>

