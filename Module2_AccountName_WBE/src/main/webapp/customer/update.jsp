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
          <form class="d-flex" style="margin: 0;" action="/Customer" method="get">
            <input type="hidden" name="action" value="search">
            <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search" name="customer_name" required>
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
      <form style="margin-top: 15px;" action="/Customer" method="post">
        <input type="hidden" name="action" value="update">
        <input type="hidden" name="customer_id" value="${customer.customer_id}">
        <div class="row mb-3">
          <label for="name" class="col-sm-2 col-form-label">Name</label>
          <div class="col-sm-10">
            <input type="text" class="form-control" id="name" name="customer_name" required value="${customer.customer_name}">
          </div>
        </div>
        <div class="row mb-3">
          <label for="birthday" class="col-sm-2 col-form-label">Birthday</label>
          <div class="col-sm-10">
            <input type="date" class="form-control" id="birthday" name="customer_birthday" required value="${customer.customer_birthday}">
          </div>
        </div>
        <div class="row mb-3">
          <label for="phone" class="col-sm-2 col-form-label">Phone</label>
          <div class="col-sm-10">
            <input type="number" class="form-control" id="phone" name="customer_phone" required value="${customer.customer_phone}">
          </div>
        </div>
        <div class="row mb-3">
          <label for="email" class="col-sm-2 col-form-label">Email</label>
          <div class="col-sm-10">
            <input type="email" class="form-control" id="email" name="customer_email" required value="${customer.customer_email}">
          </div>
        </div>
        <div class="row mb-3">
          <label for="address" class="col-sm-2 col-form-label">Address</label>
          <div class="col-sm-10">
            <input type="text" class="form-control" id="address" name="customer_address" required value="${customer.customer_address}">
          </div>
        </div>
        <div class="row mb-3">
          <label for="id_card" class="col-sm-2 col-form-label">Id_card</label>
          <div class="col-sm-10">
            <input type="number" class="form-control" id="id_card" name="customer_id_card" required value="${customer.customer_id_card}">
          </div>
        </div>
        <div class="row mb-3">
          <label for="gender" class="col-sm-2 col-form-label">Gender</label>
          <div class="col-sm-10">
            <select class="form-select" aria-label="Default select example" id="gender" name="customer_gender">
              <c:if test="${customer.customer_gender == 1}">
                <option selected value="1">Male</option>
                <option value="0">Female</option>
              </c:if>
              <c:if test="${customer.customer_gender == 0}">
                <option selected value="0">Female</option>
                <option value="1">Male</option>
              </c:if>
            </select>
          </div>
        </div>
        <div class="row mb-3">
          <label for="customer_type" class="col-sm-2 col-form-label">Customer_type</label>
          <div class="col-sm-10">
            <select class="form-select" aria-label="Default select example" id="customer_type" name="customer_type">
              <c:forEach items="${customer_types}" var="customer_type">
                <c:if test="${customer.customer_type.customer_type_id == customer_type.customer_type_id}">
                  <option selected value="${customer_type.customer_type_id}">${customer_type.customer_type_name}</option>
                </c:if>
                <c:if test="${customer.customer_type.customer_type_id != customer_type.customer_type_id}">
                  <option value="${customer_type.customer_type_id}">${customer_type.customer_type_name}</option>
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
