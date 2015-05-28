<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<html>
    <head>
        <jsp:include page="/head.jsp" />
        <style>
            form {
                max-width: 150px;
                margin-bottom: 0px!important;
            }
        </style>
    </head>
    <body>
        <jsp:include page="/top.jsp" />
        <div class="container">
            <div class="jumbotron">
                <h2>Lista de provincias almacenadas</h2>
                <p>pulse sobre el nombre de la provincia para ver las poblaciones</p>
                <table class="table table-striped">
                    <thead>
                        <tr>
                            <th>Nombre</th>
                            <th>Nº Poblaciones</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${listaProvincias.provincias}" var="provincia">
                        <tr>
                            <td><a href="/Poblaciones?provincia=${provincia.nombre}">${provincia.nombre}</a></td>
                            <td>${provincia.poblaciones}</td>
                        </tr>
                        </c:forEach>
                    </tbody>
                </table>
                <c:if test="${not empty listaPoblaciones.provincia}">
                <h2>Lista de poblaciones para la provincia de ${listaPoblaciones.provincia}</h2>
                </c:if>
                <c:if test="${fn:length(listaPoblaciones.poblaciones) gt 0}">
                <table class="table table-striped">
                    <thead>
                        <tr>
                            <th>Provincia</th>
                            <th>Población</th>
                            <th>Habitantes</th>
                            <th>Código</th>
                            <th></th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${listaPoblaciones.poblaciones}" var="poblacion">
                        <tr>
                            <td>${poblacion.provincia}</td>
                            <td>${poblacion.nombre}</td>
                            <td>${poblacion.habitantes}</td>
                            <td>${poblacion.codigoAEMET}</td>
                            <td>
                                <form action="/Poblaciones/delete" method="POST">
                                    <button class="btn btn-default btn-sm" type="submit">
                                        <span class="glyphicon glyphicon-trash" aria-hidden="true"></span>
                                        Borrar población
                                    </button>
                                    <input type="hidden" value="${poblacion.provincia}" name="provincia"/>
                                    <input type="hidden" value="${poblacion.nombre}" name="poblacion"/>
                                </form>
                            </td>
                        </tr>
                        </c:forEach>
                    </tbody>
                </table>
                </c:if>
                <c:if test="${fn:length(listaPoblaciones.poblaciones) eq 0 && not empty listaPoblaciones.provincia}">
                <p>No hay poblaciones para la provincia de ${listaPoblaciones.provincia}</p>
                </c:if>
                <form action="/Poblaciones/add" method="GET">
                    <div class="btn-toolbar" role="toolbar">
                        <button id="add" class="btn btn-default" type="submit">
                            <span class="glyphicon glyphicon-plus" aria-hidden="true"></span>
                            Añadir población
                        </button>
                    </div>
                    <input type="hidden" value="${listaPoblaciones.provincia}" name="provincia"/>
                </form>
                <c:if test="${fn:length(listaPoblaciones.poblaciones) gt 0}">
                <form action="/Poblaciones/deleteAll" method="POST">
                    <div class="btn-toolbar" role="toolbar">
                        <button id="deleteAll" class="btn btn-default" type="submit">
                            <span class="glyphicon glyphicon-trash" aria-hidden="true"></span>
                            Borrar todas la poblaciones
                        </button>
                    </div>
                    <input type="hidden" value="${listaPoblaciones.provincia}" name="provincia"/>
                </form>
                </c:if>
            </div>
            <jsp:include page="/bot.jsp" />
        </div>
    </body>
</html>
