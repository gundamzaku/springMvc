<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%@ taglib prefix="s" uri="http://java.sun.com/jstl/core" %>

<html>
<head>
    <title>Spitter</title>
    <link rel="stylesheet" type="text/css"
               href="<s:url value="/resources/style.css" />" >
</head>
<body>
<h1>Register</h1>
<sf:form method="post" commandName="spitter">

    <sf:label path="firstName" cssErrorClass="error">First Name</sf:label>
    <sf:input path="firstName" cssErrorClass="error"></sf:input>
    <sf:errors path="firstName"></sf:errors><br>

    <sf:label path="lastName" cssErrorClass="error">Last Name</sf:label>
    <sf:input path="lastName" cssErrorClass="error"></sf:input>
    <sf:errors path="lastName"></sf:errors><br>

    <sf:label path="email" cssErrorClass="error">email</sf:label>
    <sf:input path="email" cssErrorClass="error"></sf:input>
    <sf:errors path="email"></sf:errors><br>

    <sf:label path="username" cssErrorClass="error">username</sf:label>
    <sf:input path="username" cssErrorClass="error"></sf:input>
    <sf:errors path="username"></sf:errors><br>

    <sf:label path="password" cssErrorClass="error">password</sf:label>
    <sf:input path="password" cssErrorClass="error"></sf:input>
    <sf:errors path="password"></sf:errors><br>

    <input type="submit" value="register">
</sf:form>
<!--
<form id="spitter" action="/spitter/register" method="POST">
    First Name: <input id="firstName" type="text" name="firstName" value="J"/><br/>
    Last Name: <input type="text" id="lastName" name="lastName" value="B"/><br/>
    Email: <input type="email" id="email" name="email" value="jack"/><br/>
    Username: <input type="text" id="username" name="username" value="jack"/><br/>
    Password: <input type="password" id="password" name="password" value=""/><br/>
    <input type="submit" value="Register" />
</form>-->
</body>
</html>
