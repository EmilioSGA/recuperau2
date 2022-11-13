<%--
  Created by IntelliJ IDEA.
  User: CA2-PC-
  Date: 28/06/2022
  Time: 12:43 p. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!doctype html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>List person</title>
    <jsp:include page="/templates/import-head.jsp" />

</head>
<body>
<%--
<jsp:include page="/templates/menu.jsp" />
--%>
<div class="container mt-3">

    <h1 class="text-center">Lista de alumnos</h1>

    <div class="row justify-content-center mb-2">
        <div class="col-10">
            <div class="row justify-content-end">
                <div class="col-10">

                    <c:if test="${param['result-save']!=null}">
                        <c:if test="${param['result-save']=='ok'}">
                            <div class="alert alert-success" role="alert">
                                Alumno añadido con éxito!
                            </div>
                        </c:if>

                        <c:if test="${param['result-save']=='error'}">
                            <div class="alert alert-danger" role="alert">
                                Ouuups, ocurrió un error al Añadir alumno
                            </div>
                        </c:if>
                    </c:if>

                    <c:if test="${param['result-update']!=null}">
                        <c:if test="${param['result-update']=='ok'}">
                            <div class="alert alert-success" role="alert">
                                Alumno atualizado con éxito!
                            </div>
                        </c:if>

                        <c:if test="${param['result-update']=='error'}">
                            <div class="alert alert-danger" role="alert">
                                Ouuups, ocurrió un error al actualizar alumno
                            </div>
                        </c:if>
                    </c:if>

                    <c:if test="${param['result-delete']!=null}">
                        <c:if test="${param['result-delete']=='ok'}">
                            <div class="alert alert-success" role="alert">
                                Alumno eliminado con éxito!
                            </div>
                        </c:if>

                        <c:if test="${param['result-delete']=='error'}">
                            <div class="alert alert-danger" role="alert">
                                Ouuups, ocurrió un error al eliminar alumno
                            </div>
                        </c:if>
                    </c:if>

                </div>

                <div class="col-2 text-end">
                    <a href="create-alumno" class="btn btn-primary">Añadir alumno</a>
                </div>

            </div>
        </div>
    </div>


    <div class="row justify-content-center">
        <div class="col-10">
            <table class="table table-hover table-bordered table-striped">
                <thead>
                <tr>
                    <th>Nombre</th>
                    <th>Apellidos</th>
                    <th>Fecha de nacimiento</th>
                    <th>Curp</th>
                    <th>Matrícula</th>
                    <th>Materia</th>
                    <th>Calificacion</th>
                    <th>Acciones</th>

                </tr>
                </thead>
                <tbody>
                <c:forEach items="${list}" var="alumno">
                    <tr>
                        <td><c:out value="${alumno.id}"/></td>
                        <td><c:out value="${alumno.name}"/></td>
                        <td><c:out value="${alumno.apellidos}"/></td>
                        <td><c:out value="${alumno.fecha}"/></td>
                        <td><c:out value="${alumno.curp}"/></td>
                        <td><c:out value="${alumno.matricula}"/></td>
                        <td><c:out value="${alumno.materia}"/></td>
                        <td><c:out value="${alumno.calificacion}"/></td>

                        <td>

                            <div class="row justify-content-center">
                                <div class="col-12 mb-2">
                                    <a href="get-alumno" class="btn btn-info">
                                        <i class="fa-solid fa-magnifying-glass"></i>Actualizar
                                    </a>
                                </div>

                                <div class="col-12">
                                    <form action="delete-alumno" method="post" class="d-inline">

                                        <input type="hidden" name="id" value="${alumno.id}">

                                        <button type="submit" class="btn btn-danger">
                                            <i class="fa-solid fa-trash"></i> Eliminar
                                        </button>
                                    </form>
                                </div>

                            </div>


                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>

<!-- Modal -->
<c:forEach items="${list}" var="alumno">

</c:forEach>

<jsp:include page="/templates/import-script.jsp" />

</body>
</html>
