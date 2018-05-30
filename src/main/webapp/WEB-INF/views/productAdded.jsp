<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:choose>
<c:when test="${!empty sessionScope.loggedUser}">
<h1>Product Added Successfully</h1>
<a href="inbox.htm">Inbox</a><br><br>
<a href="SellerHome.htm">Home</a><br><br>
  <a href="addBrands.htm">Add Brands</a><br><br>
  <a href="addProducts.htm">Add Products</a><br><br>
  <a href="viewSellerProducts.htm">View Your Products</a><br><br>
  <a href="#">Update Profile</a><br><br>
  <a href="logout.htm">Logout</a>
</c:when>
<c:otherwise>
Please login<a href="login.htm">Here</a>
</c:otherwise>
</c:choose>
</body>
</html>