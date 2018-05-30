<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Details</title>
</head>
<body>

<c:choose>
<c:when test="${!empty sessionScope.loggedUser}">
Product Details
<table>
<tr>
                            <td><b>Brand Name</b></td>
                            <td><b>Product Name</b></td>
                            <td><b>Price</b></td>
                            <td><b>Description</b></td>
                        </tr>
                        <tr>
                            <td><b>${details.brand}</b></td>
                            <td><b>${details.productName}</b></td>
                            <td><b>${details.price}</b></td>
                            <td><b>${details.description}</b></td>
                        </tr>          
                    </table>

<a href="viewSellerProducts.htm" target="contents">All Products</a><br>
		<a href="searchProduct.htm" target="contents">Search Products</a><br>
		<a href="inbox.htm" target="contents">Inbox</a><br>
		<a href="updateUser.htm">Update Profile</a><br><br>
		<a href="logout.htm">Logout</a>

</c:when>
<c:otherwise>
Please Login <a href="login.htm"><b>here</b></a>

</c:otherwise>
</c:choose>

</body>
</html>