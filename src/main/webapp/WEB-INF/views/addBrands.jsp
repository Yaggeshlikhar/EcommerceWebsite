<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@page import="com.me.yaggesh.dao.SellerDAO"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%

        SellerDAO sellerDao = new SellerDAO();
        java.util.List brandList = sellerDao.list();
        pageContext.setAttribute("sellers", brandList);
%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add a Brand</title>
</head>
<body>
<c:choose>
<c:when test="${!empty sessionScope.loggedUser}">

Add Brands
<form:form action="addBrands.htm" commandName="brand" method="post">
<form:input path="brand"/><form:errors path="brand"></form:errors>

<button type="submit">Submit</button>
<button type="button">Cancel</button>

<a href="#">Inbox</a> <br><br>
  <a href="addProducts.htm">Add Products</a><br><br>
  <a href="viewSellerProducts.htm">View Your Products</a><br><br>
  <a href="#">Update Profile</a><br><br>
  <a href="logout.htm">Logout</a>


</form:form>
</c:when>
<c:otherwise>
Please Login <a href="login.htm"><b>here</b></a></div> first!
</c:otherwise>
</c:choose>
</body>
</html>