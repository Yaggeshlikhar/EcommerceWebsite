
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@page import="com.me.yaggesh.dao.SellerDAO"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Shopping Cart</title>
</head>
<body>

<c:choose>
<c:when test="${!empty sessionScope.loggedUser}">
		<h1>Hi ${user.username}</h1>
		
		<form:form action="searchProduct.htm" method="get">
		
		<!-- Enter price: <input type="text" name="priceRange"/> -->
		
		Search By: <input type="text" name="values"/><br>
		<input type="radio" name="searchBy" value="price">Price<br>
			<input type="radio" name="searchBy" value="brand">Brand<br>
			<input type="radio" name="searchBy" value="productName">Product Name<br>
			<input type="radio" name="searchBy" value="description">Description<br>
			<button type="submit">Submit</button>
			<button type="button" >Cancel</button>
            <input type="hidden" name="to" value="${requestScope.email}"/>
		</form:form><br><br>
		<a href="listproducts.htm" target="contents">List All Products</a><br>
		<a href="inbox.htm" target="contents">Inbox</a><br>
		<a href="updateUser.htm">Update Profile</a><br><br>
		<a href="logout.htm">Logout</a>
		<a href="mailto:likhar.yaggesh@gmail.com"  class="btn btn-success btn-lg" >Support</a>
</c:when>
<c:otherwise>
Please<div><a href="login.htm"><b>Login</b></a></div>
</c:otherwise>
</c:choose>



</body>
</html>