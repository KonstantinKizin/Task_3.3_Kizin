
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<html>
<head>
    <title>Title</title>
</head>
<body>

<div id = "ordersBody">
    <table class="table">
        <thead class="thead-inverse">
        <tr>
            <th>Name</th>
            <th>Second Name</th>
            <th>Hire dater</th>
            <th></th>
            <c:forEach items = "${employeeList}" var = "employee">
        <tr>
            <td>${employee.getFirstName()} </td>
            <td>${employee.getSecondName()} </td>
            <td>${employee.getHireDate()} </td>
        </tr>
        </c:forEach>
        </tbody>
    </table>
</div>


</body>
</html>
