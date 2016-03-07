<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Регистрация</title>

    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <script src="//code.jquery.com/jquery-1.9.1.js"></script>
    <link rel="stylesheet" href="<c:url value='/resources/stylesheet/common.css' />"/>
    <link rel="stylesheet" href="<c:url value='/resources/stylesheet/registration.css' />"/>
    <script src="//ajax.aspnetcdn.com/ajax/jquery.validate/1.9/jquery.validate.min.js"></script>
    <script type="text/javascript" src="<c:url value='/resources/js/validators/registrationValidator.js' />"></script>

</head>

<body>
<div id="main">

    <%--header for each page--%>
    <%@include file="jspf/header.jspf" %>

    <div id="content">

        <div id="registrationBlock">
            <h1> РЕГИСТРАЦИЯ </h1>
            <%--validate message (errors)--%>
            <%@include file="jspf/errors.jspf" %>

            <form:form id='register-form' name='registrationForm' action='registration' method='post'
                       commandName="registrationForm">

                <table id='tableForRegistration'>
                    <tr>
                        <td>Ваш ник* -</td>
                        <td><form:input id="login" type='text' name='login' path="login"
                                        value="${requestScope.registrationForm.login}"/></td>
                    </tr>

                    <tr>
                        <td>Ваше имя -</td>
                        <td><form:input id="name" type='text' name='name' path="name"
                                        value="${requestScope.registrationForm.name}"/></td>
                    </tr>

                    <tr>
                        <td>Электронная почта* -</td>
                        <td><form:input id="email" type='email' name='email' path="email"
                                        value="${requestScope.registrationForm.email}"/></td>
                    </tr>
                    <tr>
                        <td>Пароль* -</td>
                        <td><form:input id="password" path="password" type='password' name='password'/></td>
                    </tr>

                    <tr>
                        <td>Подтверждение пароля* -</td>
                        <td><form:input id="secondaryPassword" path="secondaryPassword" type='password'
                                        name='secondaryPassword'/></td>
                    </tr>

                    <tr>
                        <td><br/>
                            <br/>
                            <input type='submit' value='Зарегистрироваться'/></td>
                    </tr>

                </table>

            </form:form>
        </div>
    </div>

    <%@include file="jspf/footer.jspf" %>

</div>

</body>
</html>