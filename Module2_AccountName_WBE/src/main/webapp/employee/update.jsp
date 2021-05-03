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
          <form class="d-flex" style="margin: 0;" action="/Employee" method="get">
            <input type="hidden" name="action" value="search">
            <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search" name="employee_name" required>
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
      <form style="margin-top: 15px;" action="/Employee" method="post">
        <input type="hidden" name="action" value="update">
        <input type="hidden" name="employee_id" value="${employee.employee_id}">
        <div class="row mb-3">
          <label for="name" class="col-sm-2 col-form-label">Name</label>
          <div class="col-sm-10">
            <input type="text" class="form-control" id="name" name="employee_name" required value="${employee.employee_name}">
          </div>
        </div>
        <div class="row mb-3">
          <label for="birthday" class="col-sm-2 col-form-label">Birthday</label>
          <div class="col-sm-10">
            <input type="date" class="form-control" id="birthday" name="employee_birthday" required value="${employee.employee_birthday}">
          </div>
        </div>
        <div class="row mb-3">
          <label for="phone" class="col-sm-2 col-form-label">Phone</label>
          <div class="col-sm-10">
            <input type="number" class="form-control" id="phone" name="employee_phone" required value="${employee.employee_phone}">
          </div>
        </div>
        <div class="row mb-3">
          <label for="email" class="col-sm-2 col-form-label">Email</label>
          <div class="col-sm-10">
            <input type="email" class="form-control" id="email" name="employee_email" required value="${employee.employee_email}">
          </div>
        </div>
        <div class="row mb-3">
          <label for="address" class="col-sm-2 col-form-label">Address</label>
          <div class="col-sm-10">
            <input type="text" class="form-control" id="address" name="employee_address" required value="${employee.employee_address}">
          </div>
        </div>
        <div class="row mb-3">
          <label for="id_card" class="col-sm-2 col-form-label">Id_card</label>
          <div class="col-sm-10">
            <input type="number" class="form-control" id="id_card" name="employee_id_card" required value="${employee.employee_id_card}">
          </div>
        </div>
        <div class="row mb-3">
          <label for="salary" class="col-sm-2 col-form-label">Salary</label>
          <div class="col-sm-10">
            <input type="number" class="form-control" id="salary" name="employee_salary" required value="${employee.employee_salary}">
          </div>
        </div>
        <div class="row mb-3">
          <label for="position" class="col-sm-2 col-form-label">Position</label>
          <div class="col-sm-10">
            <select class="form-select" aria-label="Default select example" id="position" name="position">
              <c:forEach items="${positions}" var="position">
                <c:if test="${position.position_id == employee.position.position_id}">
                  <option selected value="${position.position_id}">${position.position_name}</option>
                </c:if>
                <c:if test="${position.position_id != employee.position.position_id}">
                  <option value="${position.position_id}">${position.position_name}</option>
                </c:if>
              </c:forEach>
            </select>
          </div>
        </div>
        <div class="row mb-3">
          <label for="education_degree" class="col-sm-2 col-form-label">Education_degree</label>
          <div class="col-sm-10">
            <select class="form-select" aria-label="Default select example" id="education_degree" name="education_degree">
              <c:forEach items="${education_degrees}" var="education_degree">
                <c:if test="${education_degree.education_id == employee.education_degree.education_id}">
                  <option selected value="${education_degree.education_id}">${education_degree.education_name}</option>
                </c:if>
                <c:if test="${education_degree.education_id != employee.education_degree.education_id}">
                  <option value="${education_degree.education_id}">${education_degree.education_name}</option>
                </c:if>
              </c:forEach>
            </select>
          </div>
        </div>
        <div class="row mb-3">
          <label for="division" class="col-sm-2 col-form-label">Division</label>
          <div class="col-sm-10">
            <select class="form-select" aria-label="Default select example" id="division" name="division">
              <c:forEach items="${divisions}" var="division">
                <c:if test="${division.division_id == employee.division.division_id}">
                  <option selected value="${division.division_id}">${division.division_name}</option>
                </c:if>
                <c:if test="${division.division_id != employee.division.division_id}">
                  <option value="${division.division_id}">${division.division_name}</option>
                </c:if>
              </c:forEach>
            </select>
          </div>
        </div>
        <button type="submit" class="view-btn color-2 mt-20 w-100 btn btn-success" id="btn" style="margin-bottom: 20px"><span>Update</span></button>
      </form>
    </div>
  </div>
  <div class="row" style="border: 2px #343a40 solid; height: 80px;">

  </div>
</div>
</body>
</html>
