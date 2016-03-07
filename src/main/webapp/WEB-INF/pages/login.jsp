<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
  <title>Title</title>

  <link rel="stylesheet" href="<c:url value='/resources/stylesheet/common.css' />"/>
  <link rel="stylesheet" href="<c:url value='/resources/stylesheet/login.css' />"/>
  <script src="//code.jquery.com/jquery-1.9.1.js"></script>
  <script src="//ajax.aspnetcdn.com/ajax/jquery.validate/1.9/jquery.validate.min.js"></script>

  <script type="text/javascript" src="resources/js/validators/loginValidator.js"></script>
</head>
<body>
<div id="content">

<%--header for each page--%>
<%@include file="jspf/header.jspf" %>

  <div id="loginBlock">

    <h1> ВХОД </h1>

    <%--validate message (errors)--%>
    <%@include file="jspf/errors.jspf" %>

    <form:form name='loginForm' action="login" method='post' id='loginForm' commandName='loginForm'>

      <fieldset>
        <legend> E-mail или Ник:</legend>
        <input type='text' name='loginOrEmail' id="loginOrEmail"/><br/>
      </fieldset>
      <br/>
      <fieldset>
        <legend> Пароль</legend>
        <input type='password' name='password' id="password"/>
      </fieldset>
      <br/> <input type='submit' value='Войти'>
    </form:form>
  </div>

<%@include file="jspf/footer.jspf" %>
</div>

</body>
</html>
