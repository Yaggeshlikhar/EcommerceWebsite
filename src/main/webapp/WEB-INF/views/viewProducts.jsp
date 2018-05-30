<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<style>
.topright {
    position: absolute;
    top: 8px;
    right: 16px;
    font-size: 18px;
}

.right {
    position: absolute;
    top: 36px;
    right: 16px;
    font-size: 18px;
}
</style>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Property List</title>
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
</head>
<body>
<c:choose>
<c:when test="${!empty sessionScope.loggedUser}">
<div class="right"><a href="Logout.htm"><b>Logout</b></a></div>
<div class="topright"><a href="BuyerHome.htm"><b>Home</b></a></div>
    <div class="container-fluid">
        <div class="row-fluid">
            <div class="span12">
                <fieldset>
                <legend>List of all Properties</legend>
                    <table class="table table-striped">
                        <tr>
                        	<td><b>Product ID</b></td>
                            <td><b>Brand Name</b></td>
                            <td><b>Product Name</b></td>
                            <td><b>Price</b></td>
                            <td><b>Description</b></td>
                            <td><b>Seller</b></td>
                        </tr>
                    <c:forEach var="prod" items="${ products }">
                        <tr>
                            <td><a href = "productDetails.htm?id=${ prod.productId }"> ${ prod.productId } Get Details</a></td>
                            <td>${prod.brand}</td>
                            <td>${prod.productName}</td>
                            <td>${prod.price}</td>
                            <td>${prod.description}</td>
                            <td><a href = "contactSeller.htm?email=${prod.user.postedBy}"> ${prod.user.postedBy}  ${prod.user.username}</a></td>
                        </tr>
                    </c:forEach>           
                    </table>
                    
                        <%--For displaying Previous link except for the 1st page --%>
    <c:if test="${currentPage != 1}">
         <td><a href="listproperties.htm?page=${currentPage - 1}">Previous</a></td>
    </c:if>
    <%--For displaying Page numbers. The when condition does not display a link for the current page--%>
    <table border="1" cellpadding="5" cellspacing="5">
       <tr>
           <c:forEach begin="1" end="${noOfPages}" var="i">
           <c:choose>
              <c:when test="${currentPage eq i}">
                <td>${i}</td>
                 </c:when>
                 <c:otherwise>
                      <td width="20%"><a href="listproperties.htm?page=${i}">${i}</a></td>
                 </c:otherwise>
               </c:choose>
           </c:forEach>
       </tr>
    </table>
    <%--For displaying Next link --%>
       <c:if test="${currentPage lt noOfPages}">
           <td><a href="listproperties.htm?page=${currentPage + 1}">Next</a></td>
       </c:if>
                    
                    
                </fieldset>
            </div>
        </div>
    </div>
   		 <a href="BuyerHome.htm">Home</a><br>
		<a href="inbox.htm" target="contents">Inbox</a><br>
		<a href="updateUser.htm">Update Profile</a><br><br>
		<a href="logout.htm">Logout</a>
    
    </c:when>
	<c:otherwise>
	Please Login <a href="UserLogin.htm"><b>here</b></a></div> first!
	</c:otherwise>
	</c:choose>     
</body>
</html>