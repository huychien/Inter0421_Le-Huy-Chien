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
    <div class="col-xl-2 col-lg-2 col-md-2 col-sm-2" style="border-right: 1px black solid; text-align: center;">
        <p style="color: red">${massage}</p>
    </div>
    <div class="col-xl-10 col-lg-10 col-md-10 col-sm-10">
        <form style="margin-top: 15px;" action="/Service" method="post">
            <input type="hidden" name="action" value="create">
            <div class="row mb-3">
                <label for="name" class="col-sm-2 col-form-label">Name</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="name" name="service_name" required>
                </div>
            </div>
            <div class="row mb-3">
                <label for="service_area" class="col-sm-2 col-form-label">Area</label>
                <div class="col-sm-10">
                    <input type="number" id="service_area" class="form-control" name="service_area" required>
                </div>
            </div>
            <div class="row mb-3">
                <label for="service_cost" class="col-sm-2 col-form-label">Cost</label>
                <div class="col-sm-10">
                    <input type="number" class="form-control" id="service_cost" name="service_cost" required>
                </div>
            </div>
            <div class="row mb-3">
                <label for="service_max_people" class="col-sm-2 col-form-label">Max_people</label>
                <div class="col-sm-10">
                    <input type="number" class="form-control" id="service_max_people" name="service_max_people" required>
                </div>
            </div>
            <div class="row mb-3">
                <label for="rent_type" class="col-sm-2 col-form-label">Rent_type</label>
                <div class="col-sm-10">
                    <select class="form-select" aria-label="Default select example" id="rent_type" name="rent_type_id">
                        <c:forEach items="${rent_types}" var="rent_type">
                            <option value="${rent_type.rent_type_id}">Name: ${rent_type.rent_type_name} _ Cost: ${rent_type.rent_type_cost}</option>
                        </c:forEach>
                    </select>
                </div>
            </div>
            <div class="row mb-3">
                <label for="service_type" class="col-sm-2 col-form-label">Service_type</label>
                <div class="col-sm-10">
                    <select class="form-select" aria-label="Default select example" id="service_type" name="service_type_id">
                        <c:forEach items="${service_types}" var="service_type">
                            <option value="${service_type.service_type_id}">${service_type.service_type_name}</option>
                        </c:forEach>
                    </select>
                </div>
            </div>
            <div class="row mb-3">
                <label for="standard_room" class="col-sm-2 col-form-label">Standard_room</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="standard_room" name="standard_room" required>
                </div>
            </div>
            <div class="row mb-3">
                <label for="description_other_convenience" class="col-sm-2 col-form-label">Description</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="description_other_convenience" name="description_other_convenience" required>
                </div>
            </div>
            <div class="row mb-3">
                <label for="pool_area" class="col-sm-2 col-form-label">Pool_area</label>
                <div class="col-sm-10">
                    <input type="number" class="form-control" id="pool_area" name="pool_area" required>
                </div>
            </div>
            <div class="row mb-3">
                <label for="number_of_floors" class="col-sm-2 col-form-label">Floors</label>
                <div class="col-sm-10">
                    <input type="number" class="form-control" id="number_of_floors" name="number_of_floors" required>
                </div>
            </div>
            <button type="submit" class="view-btn color-2 mt-20 w-100 btn btn-success" id="btn" style="margin-bottom: 20px"><span>Create</span></button>
        </form>
    </div>
</div>
<div class="row" style="border: 2px #343a40 solid; height: 80px;">

</div>
</div>
</body>
</html>
