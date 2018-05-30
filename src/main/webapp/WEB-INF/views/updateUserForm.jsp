<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update user</title>
</head>
<script type="text/javascript">
function validate()
{
    var msg;
    if(document.myForm.password.value.length > 5)
        {
            msg = "good";
        }
    else
        {
            msg = "poor";
        }
    document.getElementById('mylocation').innerText = msg;
}


var xmlHttp;
xmlHttp = GetXmlHttpObject();

function checkUsername()
{
    
    if(xmlHttp == null)
        {
            alert("Your browser does not support AJAX!");
            return;
        }
    
    var name = document.getElementById("name").value;
    
    var query = "action=checkusername&name=" + name;
    
    xmlHttp.onreadystatechange = function stateChanged()
    {
        if(xmlHttp.readyState >= 2 && xmlHttp.readyState < 4)
            {
                
            }
        if(xmlHttp.readyState == 4 )
            {
                var json = JSON.parse(xmlHttp.responseText);
                document.getElementById("success").innerHTML = json.Message;
            }
    };
    
    xmlHttp.open("POST", "checkusername.htm", true);
    xmlHttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    xmlHttp.send(query);
    
    return false;
}

function GetXmlHttpObject()
{
    var xmlHttp = null;
    try
    {
        // Firefox, Opera 8.0+, Safari
        xmlHttp = new XMLHttpRequest();
    } catch (e)
    {
        // Internet Explorer
        try
        {
            xmlHttp = new ActiveXObject("Msxml2.XMLHTTP");
        } catch (e)
        {
            xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
        }
    }
    return xmlHttp;
}
</script>
<body>
<c:choose>
<c:when test="${!empty sessionScope.loggedUser}">
<h1>Update User</h1>
<form:form class="form-horizontal" action="updateUser.htm" commandName="user" method="post" name="myForm">

First Name

<form:input path="fname" size="30" /> <font color="red"><form:errors path="fname"/></font><br><br>

Last Name

<form:input path="lname" size="30" /> <font color="red"><form:errors path="lname"/></font><br><br>

Email

<form:input path="email" size="30" /> <font color="red"><form:errors path="email"/></font><br><br>

Username:

<form:input path="username" id="username" size="30" onkeyup="return checkUsername()"/> <span id="success"></span> <font color="red"><form:errors path="username"/></font><br><br>


Password:

<form:password path="password" size="30" name="userPass" onkeyup="validate()"/>Strength: <span id="mylocation"><strong>No Strength</strong></span> <font color="red"><form:errors path="password"/></font><br><br>


User Type:

<form:radiobutton path="userType" value="buyer" label="Buyer" /> 
<form:radiobutton path="userType" value="seller" label="Seller" /><br><br>


Street:

<form:input path="street" size="30" /> <font color="red"><form:errors path="street"/></font><br><br>


City:

<form:input path="city" size="30" /> <font color="red"><form:errors path="city"/></font><br><br>

State:

<form:input path="state" size="30" /> <font color="red"><form:errors path="state"/></font><br><br>


ZIP:

<form:input path="zip" size="30" /> <font color="red"><form:errors path="zip"/></font><br><br><br><br>


<button type="submit" class="btn btn-success">Submit</button>
                        <button type="button" class="btn">Cancel</button>
                        
</form:form>                        
            
          </c:when>
	<c:otherwise>
	Please Login <a href="login.htm"><b>here</b></a></div> first!
	</c:otherwise>
	</c:choose>   
	<a href="BuyerHome.htm" target="contents">Home</a><br>
	<a href="viewSellerProducts.htm" target="contents">List All Products</a><br>
		<a href="searchProduct.htm" target="contents">Search Products</a><br>
		<a href="inbox.htm" target="contents">Inbox</a><br>
		<a href="logout.htm">Logout</a>
	
                        
</body>
</html>