<%@page import="com.me.yaggesh.dao.SellerDAO"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<%

        SellerDAO sellerDao = new SellerDAO();
        java.util.List brandList = sellerDao.list();
        pageContext.setAttribute("sellers", brandList);
%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Product</title>
</head>
<body>
<c:choose>
<c:when test="${!empty sessionScope.loggedUser}">

<h1>Add a New Product</h1>

<form:form action="addProducts.htm" commandName="product" method="post">

Brand: <form:select path="brand">
                                    <c:forEach var="bd" items="${sellers}">
                                        <form:option value="${bd.brand}"/>
                                    </c:forEach>
                                </form:select><br>
Product Name: <form:input type="text" path="productName"/><form:errors path="productName"/><br><br>
Price: <form:input type="text" path="price"/><form:errors path="price"/><br><br>
Description: <form:input type="text" path="description"/><form:errors path="description"/><br><br>
Posted By: <form:input type="text" path="postedBy"/><form:errors path="postedBy"/><br><br>

<button type="submit">Submit</button><br><br>
<button type="button">Cancel</button><br><br>


  <a href="inbox.htm">Inbox</a><br><br>
  <a href="addBrands.htm">Add Brands</a><br><br>
  <a href="addProducts.htm">Add Products</a><br><br>
  <a href="viewSellerProducts.htm">View Your Products</a><br><br>
  <a href="#">Update Profile</a><br><br>
  <a href="logout.htm">Logout</a>

</form:form>
</c:when>
<c:otherwise>
Please login<a href="login.htm">Here</a>
</c:otherwise>
</c:choose>


</body>
</html>