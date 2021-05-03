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
        <form style="margin-top: 15px;" action="/Contract" method="post">
          <input type="hidden" name="action" value="create">
          <div class="row mb-3">
            <label for="d1" class="col-sm-2 col-form-label">Start_date</label>
            <div class="col-sm-10">
              <input type="date" id="d1" class="form-control" name="contract_start_date" required>
            </div>
          </div>
          <div class="row mb-3">
            <label for="d" class="col-sm-2 col-form-label">End_date</label>
            <div class="col-sm-10">
              <input type="date" id="d" class="form-control" name="contract_end_date" required>
            </div>
          </div>
          <div class="row mb-3">
            <label for="contract_deposit" class="col-sm-2 col-form-label">Deposit</label>
            <div class="col-sm-10">
              <input type="number" class="form-control" id="contract_deposit" name="contract_deposit" required>
            </div>
          </div>
          <div class="row mb-3">
            <label for="contract_total_money" class="col-sm-2 col-form-label">Total_money</label>
            <div class="col-sm-10">
              <input type="number" class="form-control" id="contract_total_money" name="contract_total_money" required>
            </div>
          </div>
          <div class="row mb-3">
            <label for="customer_id" class="col-sm-2 col-form-label">Customer_id</label>
            <div class="col-sm-10">
              <input type="number" class="form-control" id="customer_id" name="customer_id" required>
            </div>
          </div>
          <div class="row mb-3">
            <label for="employee_id" class="col-sm-2 col-form-label">Employee_id</label>
            <div class="col-sm-10">
              <input type="number" class="form-control" id="employee_id" name="employee_id" required>
            </div>
          </div>
          <div class="row mb-3">
            <label for="service_id" class="col-sm-2 col-form-label">Service</label>
            <div class="col-sm-10">
              <select class="form-select" aria-label="Default select example" id="service_id" name="service_id">
                <c:forEach items="${services}" var="service">
                  <option value="${service.service_id}">${service.service_name}</option>
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
