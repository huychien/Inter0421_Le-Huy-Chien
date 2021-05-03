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
          <input type="hidden" name="action" value="create">
          <div class="row mb-3">
            <label for="name" class="col-sm-2 col-form-label">Name</label>
            <div class="col-sm-10">
              <input type="text" class="form-control" id="name" name="employee_name" required>
            </div>
          </div>
          <div class="row mb-3">
            <label for="d" class="col-sm-2 col-form-label">Birthday</label>
            <div class="col-sm-10">
              <input type="date" id="d" class="form-control" name="employee_birthday" required>
            </div>
          </div>
          <div class="row mb-3">
            <label for="phone" class="col-sm-2 col-form-label">Phone</label>
            <div class="col-sm-10">
              <input type="number" class="form-control" id="phone" name="employee_phone" required>
            </div>
          </div>
          <div class="row mb-3">
            <label for="email" class="col-sm-2 col-form-label">Email</label>
            <div class="col-sm-10">
              <input type="email" class="form-control" id="email" name="employee_email" required>
            </div>
          </div>
          <div class="row mb-3">
            <label for="address" class="col-sm-2 col-form-label">Address</label>
            <div class="col-sm-10">
              <input type="text" class="form-control" id="address" name="employee_address" required>
            </div>
          </div>
          <div class="row mb-3">
            <label for="id_card" class="col-sm-2 col-form-label">Id_card</label>
            <div class="col-sm-10">
              <input type="number" class="form-control" id="id_card" name="employee_id_card" required>
            </div>
          </div>
          <div class="row mb-3">
            <label for="salary" class="col-sm-2 col-form-label">Salary</label>
            <div class="col-sm-10">
              <input type="number" class="form-control" id="salary" name="employee_salary" required>
            </div>
          </div>
          <div class="row mb-3">
            <label for="position" class="col-sm-2 col-form-label">Position</label>
            <div class="col-sm-10">
              <select class="form-select" aria-label="Default select example" id="position" name="position">
                <c:forEach items="${positions}" var="position">
                    <option value="${position.position_id}">${position.position_name}</option>
                </c:forEach>
              </select>
            </div>
          </div>
          <div class="row mb-3">
            <label for="education_degree" class="col-sm-2 col-form-label">Education_degree</label>
            <div class="col-sm-10">
              <select class="form-select" aria-label="Default select example" id="education_degree" name="education_degree">
                <c:forEach items="${education_degrees}" var="education_degree">
                    <option value="${education_degree.education_id}">${education_degree.education_name}</option>
                </c:forEach>
              </select>
            </div>
          </div>
          <div class="row mb-3">
            <label for="division" class="col-sm-2 col-form-label">Division</label>
            <div class="col-sm-10">
              <select class="form-select" aria-label="Default select example" id="division" name="division">
                <c:forEach items="${divisions}" var="division">
                    <option value="${division.division_id}">${division.division_name}</option>
                </c:forEach>
              </select>
            </div>
          </div>
          <div class="row mb-3">
            <label for="username" class="col-sm-2 col-form-label">Username</label>
            <div class="col-sm-10">
              <input type="text" class="form-control" id="username" name="username">
            </div>
          </div>
          <div class="row mb-3">
            <label for="password" class="col-sm-2 col-form-label">Password</label>
            <div class="col-sm-10">
              <input type="text" class="form-control" id="password" name="password">
            </div>
          </div>
          <div class="row mb-3">
            <label for="role" class="col-sm-2 col-form-label">Role</label>
            <div class="col-sm-10">
              <select class="form-select" aria-label="Default select example" id="role" name="role">
                <option>No role</option>
                <c:forEach items="${roles}" var="role">
                  <option value="${role.role_id}">${role.role_name}</option>
                </c:forEach>
              </select>
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
