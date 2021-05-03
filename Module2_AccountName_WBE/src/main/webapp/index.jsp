<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: huythang
  Date: 27/04/2021
  Time: 13:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<jsp:include page="include/head.jsp"/>
              <form class="d-flex" style="margin: 0;" action="/Customer" method="get">
                <input type="hidden" name="action" value="search">
                <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search" name="customer_name" required>
                <button class="btn btn-outline-success" type="submit">Search</button>
              </form>
            </div>
          </div>
        </nav>
      </div>
      <div class="row" style="border: 2px #343a40 solid; height: 500px;">
        <div class="col-xl-2 col-lg-2 col-md-2 col-sm-2" style="border-right: 1px black solid; text-align: center;"></div>
        <div class="col-xl-10 col-lg-10 col-md-10 col-sm-10"></div>
      </div>
      <div class="row" style="border: 2px #343a40 solid; height: 80px;">

      </div>
    </div>
  </body>
</html>
