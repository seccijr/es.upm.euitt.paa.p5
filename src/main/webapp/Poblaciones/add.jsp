<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<html>
    <head>
        <jsp:include page="/head.jsp" />
        <style>
            .form-add {
                max-width: 430px;
                padding: 15px;
                margin: 0 auto;
            }
            .form-add .form-add-heading {
                margin-bottom: 10px;
            }
            .form-add .form-control {
                position: relative;
                height: auto;
                -webkit-box-sizing: border-box;
                -moz-box-sizing: border-box;
                box-sizing: border-box;
                padding: 10px;
                font-size: 16px;
            }
            .form-add .form-control:focus {
                z-index: 2;
            }
            .form-add input {
                margin-bottom: 10px;
                border-bottom-right-radius: 0;
                border-bottom-left-radius: 0;
            }
        </style>
    </head>
    <body>
        <jsp:include page="/top.jsp" />
        <div class="container">
            <div class="jumbotron">
                <form class="form-add" action="/Poblaciones/add" method="POST">
                    <h2 class="form-add-heading">Nueva población para ${provincia}</h2>
                    <c:if test="${not empty errorNombre}">
                    <div class="has-error">
                    </c:if>
                    <c:if test="${empty errorNombre}">
                    <div>
                    </c:if>
                        <label for="nombre" class="sr-only">Nombre problación</label>
                        <input type="text" id="nombre" class="form-control" name="nombre" placeholder="Nombre población" required autofocus>
                    </div>
                    <c:if test="${not empty errorHabitantes}">
                    <div class="has-error">
                    </c:if>
                    <c:if test="${empty errorHabitantes}">
                    <div>
                    </c:if>
                        <label for="habitantes" class="sr-only">Habitantes</label>
                        <input type="habitantes" id="habitantes" name="habitantes" class="form-control" placeholder="Habitantes" required>
                    </div>
                    <c:if test="${not empty errorCodigo}">
                    <div class="has-error">
                    </c:if>
                    <c:if test="${empty errorCodigo}">
                    <div>
                    </c:if>
                        <label for="codigo" class="sr-only">Código AEMET</label>
                        <input type="codigo" id="codigo" name="codigo" class="form-control" placeholder="Código AEMET" required>
                    </div>
                    <c:if test="${not empty error}">
                    <div class="has-error">
                        <strong class="text-danger">${error}</strong>
                    </div>
                    </c:if>
                    <div class="btn-toolbar" role="toolbar">
                        <button class="btn btn-lg btn-primary" type="submit" name="add">Añadir</button>
                        <button class="btn btn-lg btn-danger" type="button" name="cancel" id="cancel">Cancelar</button>
                    </div>
                    <script>
                    $('#cancel').on('click', function (e) {
                        document.location = '/Poblaciones?provincia=${provincia}';
                    });
                    </script>
                    <input type="hidden" value="${provincia}" name="provincia"/>
                </form>
            </div>
            <jsp:include page="/bot.jsp" />
        </div>
    </body>
</html>
