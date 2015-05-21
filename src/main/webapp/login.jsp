<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<html>
    <head>
        <jsp:include page="/head.jsp" />
        <style>
            body {
                padding-top: 40px;
                padding-bottom: 40px;
            }
            .form-signin {
                max-width: 430px;
                padding: 15px;
                margin: 0 auto;
            }
            .form-signin .form-signin-heading,
            .form-signin .checkbox {
                margin-bottom: 10px;
            }
            .form-signin .checkbox {
                font-weight: normal;
            }
            .form-signin .form-control {
                position: relative;
                height: auto;
                -webkit-box-sizing: border-box;
                -moz-box-sizing: border-box;
                box-sizing: border-box;
                padding: 10px;
                font-size: 16px;
            }
            .form-signin .form-control:focus {
                z-index: 2;
            }
            .form-signin input[type="email"] {
                margin-bottom: -1px;
                border-bottom-right-radius: 0;
                border-bottom-left-radius: 0;
            }
            .form-signin input[type="password"] {
                margin-bottom: 10px;
                border-top-left-radius: 0;
                border-top-right-radius: 0;
            }
        </style>
    </head>
    <body class="container">
        <form class="form-signin" action="/Login" method="POST">
            <h2 class="form-signin-heading">Autenticación de usuario</h2>
            <c:if test="${not empty error}">
            <div class="has-error">
            </c:if>
            <c:if test="${empty error}">
            <div>
            </c:if>
                <label for="login" class="sr-only">Login</label>
                <input type="text" id="login" class="form-control" name="login" placeholder="Login" required autofocus>
            </div>
            <c:if test="${not empty error}">
            <div class="has-error">
            </c:if>
            <c:if test="${empty error}">
            <div>
            </c:if>
                <label for="password" class="sr-only">Password</label>
                <input type="password" id="password" name="password" class="form-control" placeholder="Password" required>
            </div>
            <c:if test="${not empty error}">
            <div class="has-error">
            </c:if>
                <strong class="text-danger">${error}</strong>
            </div>
            <button class="btn btn-lg btn-primary btn-block" type="submit">Autenticarse</button>
        </form>
        <jsp:include page="/bot.jsp" />
    </body>
</html>
