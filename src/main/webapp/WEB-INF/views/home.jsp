
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ page session="false" %>
<html>
<head>
    <title>Spitter</title>
    <link rel="stylesheet"
          type="text/css"
          href="<s:url value="/resources/style.css" />" >
</head>
<body>
<h1><s:message code="spittr.welcome"></s:message></h1>

<s:url value="/spitter/register" var="registerUrl" scope="request"></s:url>
<s:url value="/spittles" var="spittlesUrl">
    <s:param name="max" value="60"></s:param>
    <s:param name="count" value="20"></s:param>
</s:url>
<a href="${spittlesUrl}">Spittles</a>|
<a href="${registerUrl}">Register</a>

</body>
</html>
