<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@page import="com.me.yaggesh.dao.SellerDAO"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<c:choose>
<c:when test="${!empty sessionScope.loggedUser}">
<form:form action="searchProduct.htm" method="post">

Enter Price:  <input type="text" name="priceRange"/><br><br>
Enter brand:  <input type="text" name="brand"/><br><br>
Description:  <input type="text" name="description"/><br><br>

<button type="submit">Submit</button>
                        <button type="button">Cancel</button>
                        <input type="hidden" name="to" value="${requestScope.email}"/>
</form:form>
</c:when>
<c:otherwise></c:otherwise>
</c:choose>

</body>
</html>