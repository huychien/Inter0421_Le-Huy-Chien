<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: huythang
  Date: 28/04/2021
  Time: 14:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<jsp:include page="../include/head.jsp"/>
<form class="d-flex" style="margin: 0;" action="#" method="get">
  <input type="hidden" name="action" value="search">
  <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search" required>
  <button class="btn btn-outline-success" type="submit">Search</button>
</form>
</div>
</div>
</nav>
</div>
<div class="row" style="border: 2px #343a40 solid;">
  <div class="col-xl-12 col-lg-12 col-md-12 col-sm-12">
    <p style="color: green; margin: 10px;">${massage}</p>
    <button class="btn btn-success" onclick="location.href = '<c:url value="/Service?action=create"></c:url>'" style="margin-bottom: 10px;">Add Service</button>
    <table id="example" class="table table-hover display">
      <thead>
      <tr>
        <th scope="col">ID</th>
        <th scope="col">Name</th>
        <th scope="col">Area</th>
        <th scope="col">Cost</th>
        <th scope="col">Max_people</th>
        <th scope="col">Rent_type_name</th>
        <th scope="col">Service_type_name</th>
        <th scope="col">Standard_room</th>
        <th scope="col">Description</th>
        <th scope="col">Pool_area</th>
        <th scope="col">Floors</th>
      </tr>
      </thead>
      <tbody>
      <c:forEach items="${services}" var="service">
        <tr id="${service.service_id}">
          <th scope="row">${service.service_id}</th>
          <td>${service.service_name}</td>
          <td>${service.service_area}</td>
          <td>${service.service_cost}</td>
          <td>${service.service_max_people}</td>
          <td>${service.rent_type.rent_type_name}</td>
          <td>${service.service_type.service_type_name}</td>
          <td>${service.standard_room}</td>
          <td>${service.description_other_convenience}</td>
          <td>${service.pool_area}</td>
          <td>${service.number_of_floors}</td>
        </tr>
      </c:forEach>
      </tbody>
    </table>
  </div>
</div>
<div class="row" style="border: 2px #343a40 solid; height: 80px;"></div>
</div>
</body>
<script>
  $(document).ready( function () {
    $('#example').DataTable();
  } );
</script>
</html>
