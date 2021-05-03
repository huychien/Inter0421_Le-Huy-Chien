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
      <button class="btn btn-success" onclick="location.href = '<c:url value="/Contract?action=create"></c:url>'" style="margin-bottom: 10px;">Add Customer</button>
      <table id="example" class="table table-hover display">
        <thead>
        <tr>
          <th scope="col">ID</th>
          <th scope="col">Start_date</th>
          <th scope="col">End_date</th>
          <th scope="col">Deposit</th>
          <th scope="col">Total_money</th>
          <th scope="col">Customer_name</th>
          <th scope="col">Employee_name</th>
          <th scope="col">Service_name</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${contracts}" var="contract">
          <tr id="${contract.contract_id}">
            <th scope="row">${contract.contract_id}</th>
            <td>${contract.contract_start_date}</td>
            <td>${contract.contract_end_date}</td>
            <td>${contract.contract_deposit}</td>
            <td>${contract.contract_total_money}</td>
            <td>${contract.customer.customer_name}</td>
            <td>${contract.employee.employee_name}</td>
            <td>${contract.service.service_name}</td>
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
