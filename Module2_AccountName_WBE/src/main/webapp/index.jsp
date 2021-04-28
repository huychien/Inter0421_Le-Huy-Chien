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
  <head>
    <title>Home</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js" integrity="sha384-JEW9xMcG8R+pH31jmWH6WWP0WintQrMb4s7ZOdauHnUtxwoG2vI5DkLtS3qm9Ekf" crossorigin="anonymous"></script>
  </head>
  <body>
    <div class="container">
      <div class="row" style="border: 2px #343a40 solid">
        <div class="col-xl-6 col-lg-6 col-md-6 col-sm-6" style="padding-left: 105px;">
          <img src="<c:url value="images/timthumb.jpeg"/>" width="80px" style="margin-top: 10px;">
          <h4 style="margin-left: 13px;">Logo</h4>
        </div>
        <div class="col-xl-6 col-lg-6 col-md-6 col-sm-6">
          <h4 style="text-align: center; line-height: 116px; margin-left: 150px;">Nguyen Van A</h4>
        </div>
      </div>
      <div class="row">
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
          <div class="container-fluid">
            <a class="navbar-brand" href="/">Home</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
              <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
              <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                  <a class="nav-link active" aria-current="page" href="/Employee">Employee</a>
                </li>
                <li class="nav-item">
                  <a class="nav-link" href="/Customer">Customer</a>
                </li>
                <li class="nav-item">
                  <a class="nav-link" href="#">Services</a>
                </li>
                <li class="nav-item">
                  <a class="nav-link" href="#">Contract</a>
                </li>
              </ul>
              <form class="d-flex" style="margin: 0;">
                <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
                <button class="btn btn-outline-success" type="submit">Search</button>
              </form>
            </div>
          </div>
        </nav>
      </div>
      <div class="row" style="border: 2px #343a40 solid; height: 500px;">
        <div class="col-xl-3 col-lg-3 col-md-3 col-sm-3" style="border-right: 1px black solid"></div>
        <div class="col-xl-9 col-lg-9 col-md-9 col-sm-9"></div>
      </div>
      <div class="row" style="border: 2px #343a40 solid; height: 80px;">

      </div>
    </div>
  </body>
</html>
