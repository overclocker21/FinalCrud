<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Booking Site</title>
 
    <style>
        tr:first-child{
            font-weight: bold;
            background-color: #C6C9C4;
        }
    </style>
 
</head>
 
 
<body>
    <h2>List of Tenants</h2>  
    <table>
        <tr>
            <td>ID</td><td>First Name</td><td>Last Name</td><td>Phone</td><td>Email</td><td></td>
        </tr>
        <c:forEach items="${tenants}" var="tenant">
            <tr>
            <td><a href="<c:url value='/edit-${tenant.id}-tenant' />">${tenant.id}</a></td>
            <td>${tenant.firstName}</td>
            <td>${tenant.lastName}</td>
            <td>${tenant.phone}</td>
            <td>${tenant.email}</td>
            <td><a href="<c:url value='/delete-${tenant.id}-tenant' />">delete</a></td>
            </tr>
        </c:forEach>
    </table>
    <br/>
    <a href="<c:url value='/new' />">Add New Tenant</a>
</body>
</html>