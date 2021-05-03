<%--
  Created by IntelliJ IDEA.
  User: huythang
  Date: 28/04/2021
  Time: 15:44
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        <div class="col-xl-12 col-lg-12 col-md-12 col-sm-12">
            <p style="color: green; margin: 10px;">${massage}</p>
            <button class="btn btn-success" onclick="location.href = '<c:url value="/Employee?action=create"></c:url>'" style="margin-bottom: 10px;">Add Employee</button>
            <table class="table table-hover display" id="example">
                <thead>
                <tr>
                    <th scope="col">ID</th>
                    <th scope="col">Name</th>
                    <th scope="col">Birthday</th>
                    <th scope="col">Id_card</th>
                    <th scope="col">Salary</th>
                    <th scope="col">Phone</th>
                    <th scope="col">Email</th>
                    <th scope="col">Address</th>
                    <th scope="col">Position</th>
                    <th scope="col">Education</th>
                    <th scope="col">Division</th>
                    <th scope="col"></th>
                    <th scope="col"></th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${employees}" var="employee">
                    <tr id="${employee.employee_id}">
                        <th scope="row">${employee.employee_id}</th>
                        <td>${employee.employee_name}</td>
                        <td>${employee.employee_birthday}</td>
                        <td>${employee.employee_id_card}</td>
                        <td>${employee.employee_salary}</td>
                        <td>${employee.employee_phone}</td>
                        <td>${employee.employee_email}</td>
                        <td>${employee.employee_address}</td>
                        <td>${employee.position.position_name}</td>
                        <td>${employee.education_degree.education_name}</td>
                        <td>${employee.division.division_name}</td>
                        <td>
                            <button class="btn btn-success" onclick="location.href = '<c:url value="/Employee?action=update&employee_id=${employee.employee_id}"></c:url>'" style="margin-top: 15px;">
                                update</button>
                        </td>
<%--                        onclick="location.href = '<c:url value="/Employee?action=delete&employee_id=${employee.employee_id}"></c:url>'"--%>
                        <td>
                            <button type="button" value="${employee.employee_id}" class="delete btn btn-danger" data-bs-toggle="modal" data-bs-target="#exampleModal" style="margin-top: 15px;">delete</button>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
        <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel">Confirm</h5>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <div class="modal-body">
                        Are you sure you want to delete it?
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">No</button>
                        <button type="button" class="yes btn btn-primary" data-bs-dismiss="modal">Yes</button>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="row" style="border: 2px #343a40 solid; height: 80px;">

    </div>
</div>
</body>
<script>
    $(document).ready( function () {
        $('#example').DataTable();
    } );
</script>
<script>
    var id;
    $('.delete').click(function () {
        id = this.getAttribute("value");
    });
    $('.yes').click(function () {
        $('#'+id).hide();
    });
</script>
</html>
