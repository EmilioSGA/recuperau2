
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>Añadir profesor</title>
  <jsp:include page="/templates/import-head.jsp" />

<body>


<%--
<jsp:include page="/templates/menu.jsp" />
--%>
<div class="container mt-3">

  <h1 class="text-center">Añadir profesor</h1>

  <div class="row justify-content-center">
    <div class="col-4">

      <form action="save-profesor" method="post" enctype="multipart/form-data">

        <div class="mb-3">
          <label  class="form-label">Nombre: </label>
          <input type="text" class="form-control" name="name">
        </div>

        <div class="mb-3">
          <label  class="form-label">Apellidos: </label>
          <input type="text" class="form-control"  name="apellidos">
        </div>

        <div class="mb-3">
          <label  class="form-label">Fecha de nacimiento: </label>
          <input type="date" class="form-control"  name="fecha">
        </div>

        <div class="mb-3">
          <label  class="form-label">Curp: </label>
          <input type="text" class="form-control"  name="curp">
        </div>

        <div class="mb-3">
          <label  class="form-label">Número de empleado: </label>
          <input type="text" class="form-control"  name="n_empleado">
        </div>

        <button type="submit" class="btn btn-primary">Registrar</button>
        <button type="reset" class="btn btn-danger">Cancelar</button>

      </form>


    </div>
  </div>
</div>

<jsp:include page="/templates/import-script.jsp" />
</body>
</html>
