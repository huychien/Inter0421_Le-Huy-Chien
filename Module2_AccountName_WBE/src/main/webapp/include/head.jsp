<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: huythang
  Date: 30/04/2021
  Time: 09:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
  <title>Furama</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js" integrity="sha384-JEW9xMcG8R+pH31jmWH6WWP0WintQrMb4s7ZOdauHnUtxwoG2vI5DkLtS3qm9Ekf" crossorigin="anonymous"></script>
  <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.24/css/jquery.dataTables.min.css">
  <script type="text/javascript" charset="utf8" src="https://code.jquery.com/jquery-3.5.1.js"></script>
  <script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.10.24/js/jquery.dataTables.min.js"></script>
  <link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
  <script>
    $( function() {
      $( "#datepicker" ).datepicker();
    } );
    $( function() {
      $( "#datepicker1" ).datepicker();
    } );
  </script>
</head>
<body>
<div class="container">
  <div class="row" style="border: 2px #343a40 solid">
    <div class="col-xl-6 col-lg-6 col-md-6 col-sm-6" style="padding-left: 105px;">
      <img src="<c:url value="../images/timthumb.jpeg"/>" width="80px" style="margin-top: 10px;">
      <h4 style="margin-left: 13px;">Logo</h4>
    </div>
    <div class="col-xl-6 col-lg-6 col-md-6 col-sm-6">
      <h4 style="text-align: center; line-height: 116px; margin-left: 150px;">${current_user}</h4>
    </div>
  </div>
  <div class="row">
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
      <div class="container-fluid">
        <a class="navbar-brand" href="/home">Home</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
          <ul class="navbar-nav me-auto mb-2 mb-lg-0">
            <c:if test="${role == 'admin'}">
              <li class="nav-item">
                <a class="nav-link active" aria-current="page" href="/Employee">Employee</a>
              </li>
            </c:if>
            <li class="nav-item">
              <a class="nav-link" href="/Customer">Customer</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="/Service">Services</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="/Contract">Contract</a>
            </li>
          </ul>
