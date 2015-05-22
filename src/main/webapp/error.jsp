<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<html>
    <head>
        <jsp:include page="/head.jsp" />
        <style>
            .form-error {
                max-width: 450px;
                padding: 15px;
                margin: 0 auto;
            }
            .form-error .form-error-heading {
                margin-bottom: 10px;
            }
        </style>
    </head>
    <body>
        <div class="container">
            <div class="jumbotron">
                <form class="form-error" action="/Login" method="GET">
                    <h2 class="form-error-heading">Ha ocurrido un error</h2>
                    <p>
                        <div class="has-error">
                            <strong class="text-danger">La aplicación ha sufrido un error. Por favor, vuelva a autenticarse para entrar al sistema. Muchas gracias.</strong>
                        </div>
                    </p>
                    <button class="btn btn-lg btn-primary btn-block" type="submit">Login</button>
                </form>
            </div>
            <jsp:include page="/bot.jsp" />
        </div>
    </body>
</html>
