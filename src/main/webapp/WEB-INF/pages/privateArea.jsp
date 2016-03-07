<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Личный кабинет</title>
    <script src="//yandex.st/jquery/1.8.0/jquery.min.js" type="text/javascript"></script>

    <script src="//code.jquery.com/jquery-1.9.1.js"></script>
    <script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>

    <link rel="stylesheet" href="<c:url value='/resources/stylesheet/common.css' />"/>
    <link rel="stylesheet" href="<c:url value='/resources/stylesheet/privateArea.css' />"/>
    <link rel="stylesheet" href="<c:url value="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css"/>">
    <script src="//ajax.aspnetcdn.com/ajax/jquery.validate/1.9/jquery.validate.min.js"></script>
    <script type="text/javascript" src="<c:url value='/resources/js/validators/newPasswordValidator.js' />"></script>
    <script type="text/javascript" src="<c:url value='/resources/js/validators/newEmailValidator.js' />"></script>

    <script type="text/javascript">
        $(document).ready(function() {
            $("#tabs").tabs();
        });
    </script>
</head>
<body>
<div id="content">

    <%@include file="jspf/header.jspf" %>
    <%--validate message (errors)--%>
    <%@include file="jspf/errors.jspf" %>
    <div id="tabs" style="font-family:'aquarion',Sans-Serif !important;">
        <ul>
            <li><a href="#tabs-1">Изменить пароль</a></li>
            <li><a href="#tabs-2">Изменить email</a></li>
            <li><a href="#tabs-3">Изменить личные данные</a></li>
        </ul>
        <div id="tabs-1">
            <form:form id="newPasswordSave" name="newPasswordSave" method="POST"
                       action="changePassword"
                       commandName="passwordForm"
                       modelAttribute="passwordForm">

                <table id="changePassword">

                    <tr>
                        <td>Старый пароль -</td>
                        <td><input id="oldPassword" type="text" name="oldPassword"/></td>
                    </tr>

                    <tr>
                        <td>Новый пароль -</td>
                        <td><input id="password" type="password" name="password"/></td>
                    </tr>

                    <tr>
                        <td>Новый пароль повторно -</td>
                        <td><input id="secondaryPassword" type="password" name="secondaryPassword"/></td>
                    </tr>

                    <tr>
                        <td><br/>
                            <br/>
                            <input type='submit' value='Сохранить'/></td>
                    </tr>

                </table>
            </form:form>
        </div>

        <div id="tabs-2">
            <form:form id ="emailChange" name="emailChange" method="POST"
                       action="changeEmail"
                       commandName="changeEmail"
                       modelAttribute="email">

                <table id="savePrivateInfo">

                    <tr>
                        <td>Ваш текущий email: -</td>
                        <td>${sessionScope.client.email}</td>
                    </tr>

                    <tr>
                        <td>Ввести новый email: -</td>
                        <td><input type="text" name="email"/></td>
                    </tr>

                    <tr>
                        <td><br/>
                            <br/>
                            <input type='submit' value='Сохранить email'/></td>
                    </tr>

                </table>
            </form:form>

        </div>
        <div id="tabs-3">
            <form:form name="savePersonSettings" method="POST"
                       action="savePersonSettings"
                       commandName="privateInfoForm"
                       modelAttribute="privateInfoForm">

                <table id="savePrivateInfo">

                    <tr>
                        <td>Имя -</td>
                        <td><input type="text" name="name" value="${sessionScope.client.name}"/></td>
                    </tr>

                    <tr>
                        <td><br/>
                            <br/>
                            <input type='submit' value='Сохранить'/></td>
                    </tr>

                </table>
            </form:form>
        </div>

    </div>
</div>
</body>
</html>
