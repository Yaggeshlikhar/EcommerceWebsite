<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Inbox</title>
</head>
<body>
<c:choose>
<c:when test="${!empty sessionScope.loggedUser}">
<h1>Inbox</h1>

<table>
                        <tr>
                            <td><b>FROM</b></td>
                            <td><b>DATE</b></td>
                            <td><b>SUBJECT</b></td>
                            <td><b>MESSAGE</b></td>
                            <td><b>REPLY</b></td>
                        </tr>
                        <tr>
                        <c:forEach var="msg" items="${messageList}">
                        <tr>
                            <td>${msg.fromName}</td>
                            <td>${msg.date}</td>
                            <td>${msg.subject}</td>
                            <td>${msg.messageData}</td>
                            <td><a href="reply.htm?replyTo=${msg.fromName}">Reply</a></td>
                        </tr>
                        </c:forEach>
                        </tr>          
                    </table>
                    </c:when>
	<c:otherwise>
	Please Login <a href="login.htm"><b>here</b></a></div> first!
	</c:otherwise>
	</c:choose>
</body>
</html>