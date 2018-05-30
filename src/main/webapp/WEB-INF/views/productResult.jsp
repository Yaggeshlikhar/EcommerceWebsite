<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Shopping Cart</title>
</head>
<body>
<h1>Search Results</h1>

<table>
                        <tr>
                        	<td><b>Product ID</b></td>
                            <td><b>Brand Name</b></td>
                            <td><b>Product Name</b></td>
                            <td><b>Price</b></td>
                            <td><b>Description</b></td>
                            <td><b>Seller</b></td>
                        </tr>
                    <c:forEach var="prod" items="${ productResult }">
                        <tr>
                            <td><a href = "productDetails.htm?id=${ prod.productId }"> ${ prod.productId } Get Details</a></td>
                            <td>${prod.brand}</td>
                            <td>${prod.productName}</td>
                            <td>${prod.price}</td>
                            <td>${prod.description}</td>
                            <td><a href = "contactSeller.htm?email=${prod.user.email}"> ${prod.user.email} Contact Seller ${prod.user.username}</a></td>
                        </tr>
                    </c:forEach>
                    </table><br>
                    <br>  
        <a href="BuyerHome.htm" target="contents">Home</a><br>            
		<a href="viewSellerProducts.htm" target="contents">List All Products</a><br>
		<a href="searchProduct.htm" target="contents">Search Products</a><br>
		<a href="inbox.htm" target="contents">Inbox</a><br>
		<a href="updateUser.htm">Update Profile</a><br><br>
		<a href="logout.htm">Logout</a>           
                    
</body>
</html>