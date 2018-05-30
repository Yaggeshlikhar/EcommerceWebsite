<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Your Products</title>
</head>
<body>
<c:choose>
<c:when test="${!empty sessionScope.loggedUser}">
<h1>Products posted by You.</h1>
<table>
                        <tr>
                        	<td><b><font size="5">ID</font></b></td>
                            <td><b><font size="5">Brand</font></b></td>
                            <td><b><font size="5">Product Name</font></td>
                            <td><font size="5">Description</font></td>
                            <td><font size="5">Price</font></td>
                            <td><font size="5">Posted Date</font></td>
                            
                        </tr>
                    <c:forEach var="prod" items="${products}">
                        <tr>
                            <td><a href = "productDetails.htm?id=${ prod.productId }"> ${ prod.productId } Get Details</a></td>
                            <td><font size="5">${prod.brand}</font></td>
                            <td><font size="5">${prod.productName}</font></td>
                            <td><font size="5">${prod.description}</font></td>
                            <td><font size="5">${prod.price}</font></td>
                            <td><font size="5">${prod.postedDate}</font></td>
                        </tr>
                    </c:forEach>           
                    </table>
                    
                    <c:if test="${currentPage != 1}">
         <td><a href="viewSellerProducts.htm?page=${currentPage - 1}">Previous</a></td>
    </c:if>
    <%--For displaying Page numbers. The when condition does not display a link for the current page--%>
    <table>
       <tr>
           <c:forEach begin="1" end="${noOfPages}" var="i">
           <c:choose>
              <c:when test="${currentPage eq i}">
                <td>${i}</td>
                 </c:when>
                 <c:otherwise>
                      <td><a href="viewSellerProducts.htm?page=${i}">${i}</a></td>
                 </c:otherwise>
               </c:choose>
           </c:forEach>
       </tr>
    </table>
    <%--For displaying Next link --%>
       <c:if test="${currentPage lt noOfPages}">
           <td><a href="viewSellerProducts.htm?page=${currentPage + 1}">Next</a></td>
       </c:if>
       <br><br>
       <a href="inbox.htm">Inbox</a><br><br>
  <a href="addBrands.htm">Add Brands</a><br><br>
  <a href="addProducts.htm">Add Products</a><br><br>
  <a href="viewSellerProducts.htm">View Your Products</a><br><br>
  <a href="updateUser.htm">Update Profile</a><br><br>
  <a href="logout.htm">Logout</a>
</c:when>
<c:otherwise>
<div>Please Login <a href="UserLogin.htm"><b>here</b></a></div> first!
</c:otherwise>
</c:choose>
</body>
</html>