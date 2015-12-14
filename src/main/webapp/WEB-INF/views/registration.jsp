<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
<html>
 
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Tenant Registration Form</title>
 
<style>
 
    .error {
        color: #ff0000;
    }
</style>
 
</head>
 
<body>
 
    <h2>Registration Form</h2>
  
    <form:form method="POST" modelAttribute="tenant">
        <form:input type="hidden" path="id" id="id"/>
        <table>
            <tr>
                <td><label for="firstName">First Name: </label> </td>
                <td><form:input path="firstName" id="firstName"/></td>
                <td><form:errors path="firstName" cssClass="error"/></td>
            </tr>
         
            <tr>
                <td><label for="lastName">Last Name: </label> </td>
                <td><form:input path="lastName" id="lastName"/></td>
                <td><form:errors path="lastName" cssClass="error"/></td>
            </tr>
     
            <tr>
                <td><label for="phone">Phone: </label> </td>
                <td><form:input path="phone" id="phone"/></td>
                <td><form:errors path="phone" cssClass="error"/></td>
            </tr>
     
            <tr>
                <td><label for="email">Email: </label> </td>
                <td><form:input path="email" id="email"/></td>
                <td><form:errors path="email" cssClass="error"/></td>
            </tr>
     
            <tr>
                <td colspan="3">
                    <c:choose>
                        <c:when test="${edit}">
                            <input type="submit" value="Update"/>
                        </c:when>
                        <c:otherwise>
                            <input type="submit" value="Register"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
        </table>
    </form:form>
    <br/>
    <br/>
    Go back to <a href="<c:url value='/list' />">List of All Tenants</a>
</body>
</html>