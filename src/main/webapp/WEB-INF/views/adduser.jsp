<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="spring" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add User Form</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css" href="assets/css/bootstrap.css">

<!-- Website CSS style -->
<link rel="stylesheet" type="text/css" href="assets/css/main.css">

<!-- Website Font style -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.1/css/font-awesome.min.css">
		
<!-- Google Fonts -->
<link href='https://fonts.googleapis.com/css?family=Passion+One' rel='stylesheet' type='text/css'>
<link href='https://fonts.googleapis.com/css?family=Oxygen' rel='stylesheet' type='text/css'>

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

<style type="text/css">
body, html{
     height: 100%;
 	background-repeat: no-repeat;
 	background-color: #d3d3d3;
 	font-family: 'Oxygen', sans-serif;
}

.main{
 	margin-top: 70px;
}

h1.title { 
	font-size: 50px;
	font-family: 'Passion One', cursive; 
	font-weight: 400; 
}

hr{
	width: 10%;
	color: #fff;
}

.form-group{
	margin-bottom: 15px;
}

label{
	margin-bottom: 15px;
}

input,
input::-webkit-input-placeholder {
    font-size: 11px;
    padding-top: 3px;
}

.main-login{
 	background-color: #fff;
    /* shadows and rounded borders */
    -moz-border-radius: 2px;
    -webkit-border-radius: 2px;
    border-radius: 2px;
    -moz-box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
    -webkit-box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
    box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);

}

.main-center{
 	margin-top: 30px;
 	margin: 0 auto;
 	max-width: 330px;
    padding: 40px 40px;

}

.login-button{
	margin-top: 5px;
}

.login-register{
	font-size: 11px;
	text-align: center;
}

</style>
<body>
<script type="text/javascript" src="assets/js/bootstrap.js"></script>
<div class="container">
			<div class="row main">
				<div class="panel-heading">
	               <div class="panel-title text-center">
	               		<h1 class="title">Register Here !</h1>
	               		<hr/>
	               </div>
	            </div>
	  	<div class="main-login main-center">
		<form:form class="form-horizontal" id="name" action="adduser.htm" method="post" commandName="user"><br>
		
		<div class="form-group">
							<label for="name" class="cols-sm-2 control-label">First Name</label>
							<div class="cols-sm-10">
								<div class="input-group">
									<span class="input-group-addon"><i class="fa fa-user fa" aria-hidden="true"></i></span>
									<form:input path="fname" class="form-control" id="fame" required="required"/><form:errors path="lname"/>
								</div>
							</div>
						</div>
		
		
		<div class="form-group">
							<label for="name" class="cols-sm-2 control-label">Last Name</label>
							<div class="cols-sm-10">
								<div class="input-group">
									<span class="input-group-addon"><i class="fa fa-user fa" aria-hidden="true"></i></span>
									<form:input path="lname" class="form-control" id="name" required="required"/><form:errors path="lname"/>
								</div>
							</div>
						</div>
						
						
		<div class="form-group">
							<label for="email" class="cols-sm-2 control-label">Your Email</label>
							<div class="cols-sm-10">
								<div class="input-group">
									<span class="input-group-addon"><i class="fa fa-envelope fa" aria-hidden="true"></i></span>
									<form:input path="email" class="form-control" id="email" required="required"/><form:errors path="email"/>
								</div>
							</div>
						</div>
						
		
		<div class="form-group">
							<label for="username" class="cols-sm-2 control-label">Username</label>
							<div class="cols-sm-10">
								<div class="input-group">
									<span class="input-group-addon"><i class="fa fa-users fa" aria-hidden="true"></i></span>
									<form:input path="username" onkeyup="return checkUsername()" required="required" class="form-control" id="name"/><form:errors path="username"/>
								</div>
							</div>
						</div>
		
		
		<div class="form-group">
							<label for="password" class="cols-sm-2 control-label">Password</label>
							<div class="cols-sm-10">
								<div class="input-group">
									<span class="input-group-addon"><i class="fa fa-lock fa-lg" aria-hidden="true"></i></span>
									<form:input type="password" onkeyup="validate()" path="password"  required="required" class="form-control" id="mylocation"/>Strength: <span class="span6" id="mylocation"><strong>No Strength</strong></span> <font color="red"></font><form:errors path="password"/>
								</div>
							</div>
						</div>
						
						
		<div class="form-group">
							<label for="username" class="cols-sm-2 control-label">Street</label>
							<div class="cols-sm-10">
								<div class="input-group">
									<span class="input-group-addon"><i class="fa fa-users fa" aria-hidden="true"></i></span>
									<form:input path="street" class="form-control" id="street" required="required"/><form:errors path="street"/>
								</div>
							</div>
						</div>
						
		<div class="form-group">
							<label for="username" class="cols-sm-2 control-label">City</label>
							<div class="cols-sm-10">
								<div class="input-group">
									<span class="input-group-addon"><i class="fa fa-users fa" aria-hidden="true"></i></span>
									<form:input path="city" class="form-control" id="city" required="required"/><form:errors path="city"/>
								</div>
							</div>
						</div>
						
		<div class="form-group">
							<label for="username" class="cols-sm-2 control-label">State</label>
							<div class="cols-sm-10">
								<div class="input-group">
									<span class="input-group-addon"><i class="fa fa-users fa" aria-hidden="true"></i></span>
									<form:input path="state" class="form-control" id="state" required="required"/><form:errors path="state"/>
								</div>
							</div>
						</div>
						
		<div class="form-group">
							<label for="username" class="cols-sm-2 control-label">Zip</label>
							<div class="cols-sm-10">
								<div class="input-group">
									<span class="input-group-addon"><i class="fa fa-users fa" aria-hidden="true"></i></span>
									<form:input path="zip" class="form-control" id="zip" required="required"/><form:errors path="zip"/>
								</div>
							</div>
						</div>
						
		<div class="form-group">
							<label for="username" class="cols-sm-2 control-label">User Type</label>
							<div class="cols-sm-10">
								<div class="input-group">
									<span class="input-group-addon"><i class="fa fa-users fa" aria-hidden="true"></i></span>
									<form:radiobutton path="userType" class="form-control" id="userType" value="Buyer"/><form:errors path="userType"/>Buyer<br>
									<form:radiobutton path="userType" class="form-control" id="userType" value="Seller"/><form:errors path="userType"/>Seller
								</div>
							</div>
						</div>				
		
			<div class="form-group ">
							<button type="submit" class="btn btn-primary btn-lg btn-block login-button">Register</button>
						</div>
						
			<div class="login-register">
				            <a href="login.htm">Login</a>
				         </div>
		</form:form>
			</div>
			</div>
		</div>
		
</body>
</html>