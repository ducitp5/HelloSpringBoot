<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE HTML>
<html>
<head>
    <meta charset="UTF-8" />
    <title>Add Person</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css"/>
</head>
<body>

<h2><c:out value="${errorMessage}" escapeXml="false"/></h2>

<h1>Create a Person:</h1>

<%-- @elvariable id="personForm" type="org.o7planning.sbjsp.model.PersonForm" --%>
<form:form method="POST"
           modelAttribute="personForm"
           action="${pageContext.request.contextPath}/addPerson">

    First Name:
    <form:input path="firstName"/>
    <br/>
    Last Name:
    <form:input path="lastName"/>
    <br/>
    <input type="submit" value="Create"/>
</form:form>

<br/>

<c:if test="${not empty errorMessage}">
    <div style="color:red;font-style:italic;">
        <c:out value="${errorMessage}" />
    </div>
</c:if>

</body>
</html>
