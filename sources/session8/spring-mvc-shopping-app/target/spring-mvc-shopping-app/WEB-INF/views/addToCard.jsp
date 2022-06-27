<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">

  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

  <title>View ShoppingCard</title>
</head>
<body>
<div class="container">
<h1>View ShoppingCard</h1>

<form:form method="post" action="${contextPath}/addToCard" modelAttribute="invoiceDetail">

  <form:hidden path="productId" />

  <div class="mb-3">

    <h2><c:out value="${product.name}" /></h2>

    <form:label path="quantity">Quantity</form:label>
    <form:input path="quantity" cssClass="form-control"/>
  </div>

  <div class="mb-3">
    <input type="submit" value="save" class="btn btn-primary">
  </div>
</form:form>

</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
</body>
</html>