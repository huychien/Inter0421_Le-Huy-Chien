<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: huythang
  Date: 30/04/2021
  Time: 20:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <style>
      h1 {
        color: darkcyan;
      }

      form {
        width: 285px;
      }

      input {
        margin: 10px 0px;
        padding: 5px;
      }

      .sys, .sys1{
        float: right;
      }

      .sys1 {
        margin-right: 83px;
      }

      #submit {
        width: 191px;
        border: 1px solid blue;
      }

      br, p{
        clear: both;
      }

      .list {
        clear: both;
        display: flex;
      }

      div {
        margin-right: 10px;
      }

      i {
        color: red;
      }
    </style>
</head>
<body>
  <form action="/LoginServlet" method="post">
    <input type="hidden" name="action" value="login">
    <i>${failed}</i>
    <div class="sys">
      <label>Username: </label>
      <input type="text" name="username" value="${cookie.cUsername.value}" ><br>
    </div>
    <div class="sys">
      <label>Password: </label>
      <input type="password" name="password" value="${cookie.cPassword.value}" ><br>
    </div>
    <div class="sys1">
      <input type="checkbox" name="remember" <c:if test="${cookie.checkbox.value != null}">checked</c:if> /> Remember me?
    </div>
    <div class="sys">
      <input type="submit" id="submit" value="Login">
    </div>
  </form>
  <c:if test="${cookie.checkbox.value == null}">
    <%
      Cookie[] cookies = request.getCookies();
      if (cookies != null) {
        for (Cookie cookie: cookies) {
          if ("cUsername".equals(cookie.getName())) {
            cookie.setValue(null);
            cookie.setMaxAge(0);
            response.addCookie(cookie);
          }
          if ("cPassword".equals(cookie.getName())) {
            cookie.setValue(null);
            cookie.setMaxAge(0);
            response.addCookie(cookie);
          }
          if ("checkbox".equals(cookie.getName())) {
            cookie.setValue(null);
            cookie.setMaxAge(0);
            response.addCookie(cookie);
          }
        }
      }
    %>
  </c:if>
</body>
<script>
  (function()
  {
    if( window.localStorage )
    {
      if( !localStorage.getItem('firstLoad') )
      {
        localStorage['firstLoad'] = true;
        window.location.href = "/login.jsp";
      }
      else
        localStorage.removeItem('firstLoad');
    }
  })();
</script>
</html>
