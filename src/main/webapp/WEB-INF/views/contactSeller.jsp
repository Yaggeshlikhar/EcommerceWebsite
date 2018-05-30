<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@page import="com.me.yaggesh.dao.SellerDAO"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Contact Seller</title>
</head>
<body>
<c:choose>
<c:when test="${!empty sessionScope.loggedUser}">
<div class="right"><a href="logout.htm"><b>Logout</b></a></div>
<div class="topright"><a href="BuyerHome.htm"><b>Home</b></a></div>
<h1>Contact Seller: </h1>

<form:form class="form-horizontal" action="sendMessage.htm" method="post">
<h3>From: ${sessionScope.loggedUser.username}</h3>

<h3>To: ${user.email}</h3><br><br>

Subject: <input type="text" name="subject"><br><br>

Message: <input type="text" name="message"><br/><br>

<button type="submit" class="btn btn-success">Submit</button>
<button type="button" class="btn">Cancel</button>
<input type="hidden" name="to" value="${requestScope.email}"/>
</form:form>

</c:when>
	<c:otherwise>
	Please Login <a href="UserLogin.htm"><b>here</b></a></div> first!
	</c:otherwise>
	</c:choose>    
</body>
</html>