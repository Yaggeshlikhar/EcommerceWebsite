<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Brand Successfully added</title>
</head>
<body>
<c:choose>
<c:when test="${!empty sessionScope.loggedUser}">
<h1>Brand Successfully added</h1>


  <a href="inbox.htm">Inbox</a><br><br>
  <a href="addBrands.htm">Add Brands</a><br><br>
  <a href="addProducts.htm">Add Products</a><br><br>
  <a href="viewSellerProducts.htm">View Your Products</a><br><br>
  <a href="updateUserForm">Update Profile</a><br><br>
  <a href="logout.htm">Logout</a>
</c:when>
<c:otherwise>
</c:otherwise>
</c:choose>
</body>
</html>