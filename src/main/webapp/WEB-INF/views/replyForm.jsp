<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@page import="com.me.yaggesh.dao.SellerDAO"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
    <title>Reply Seller</title>
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
</head>
<body>
<c:choose>
<c:when test="${!empty sessionScope.loggedUser}">
<div class="topright"><a href="Logout.htm"><b>Logout</b></a></div>
    <div class="container-fluid">
        <div class="row-fluid">
            <div class="span12">
                <fieldset>
                <legend>Reply</legend>
                <form:form class="form-horizontal" action="sendMessage.htm" method="post">
                    <div class="control-group">
                        
                        <div class="controls">
                            <h3>From: ${sessionScope.loggedUser.name}</h3>
                        </div>
                    </div>
                    <div class="control-group">
                       
                        <div class="controls">
                            <h3>To: ${receiver.email}</h3>
                        </div>
                    </div>
                    <div class="control-group">
                        
                        <div class="controls">
                            Subject: <input type="text" name="subject"><br><br>
                        </div>
                    </div>
                    <div class="control-group">
                        
                        <div class="controls">
                            Message: <input type="text" name="message"><br/><br>
                        </div>
                    </div>
                    
                    <div class="form-actions">
                        <button type="submit" class="btn btn-success">Submit</button>
                        <button type="button" class="btn">Cancel</button>
                        <input type="hidden" name="to" value="${receiver.email}"/>
                    </div>
                </form:form>
                </fieldset>
            </div>
        </div>
    </div>
     </c:when>
	<c:otherwise>
	Please Login <a href="UserLogin.htm"><b>here</b></a></div> first!
	</c:otherwise>
	</c:choose>     
</body>
</html>