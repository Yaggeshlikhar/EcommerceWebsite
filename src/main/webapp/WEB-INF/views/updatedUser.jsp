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
</style>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Added City</title>
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
</head>
<body>
<c:choose>
<c:when test="${!empty sessionScope.loggedUser}">
    <div class="container-fluid">
        <div class="row-fluid">
            <div class="span12">
                <fieldset>
                <legend>User Updated Successfully!</legend>
                    <table class="table table-striped">
                        <tr>
                            <td>Updated User</td>
                        </tr>
                        <tr>
                        	<td>${user.username}</td>
                    	</tr>           
                    </table>
                </fieldset>
            </div>
        </div>
    </div>
     </c:when>
     <a href="viewSellerProducts.htm" target="contents">List All Products</a><br>
		<a href="searchProduct.htm" target="contents">Search Products</a><br>
		<a href="inbox.htm" target="contents">Inbox</a><br>
		<a href="updateUser.htm">Update Profile</a><br><br>
		<a href="logout.htm">Logout</a>
	<c:otherwise>
	Please Login <a href="UserLogin.htm"><b>here</b></a></div> first!
	</c:otherwise>
	</c:choose>     
</body>
</html>