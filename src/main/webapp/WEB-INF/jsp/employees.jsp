<%@ page import="java.util.List" %>
<%@ page import="java.util.Arrays" %>
<%@ page import="by.tc.jwd.task3_3.kizin.entity.Employee" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <title>Title</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>


<div id = "ordersBody">
    <table class="table" border="1">
        <thead class="thead-inverse">
        <tr>
            <th>Name</th>
            <th>Second Name</th>
            <th>Hire dater</th>
            <th></th>
            <c:forEach items ="${employeeList}" var="employee">
        <tr>
            <td>${employee.getFirstName()}</td>
            <td>${employee.getSecondName()}</td>
            <td>${employee.getHireDate()}</td>
        </tr>
        </c:forEach>
        </tbody>
    </table>


</div>

<c:if test="${currentPage != 1}">
    <td><a href="/frontController?command=sax&page=${currentPage - 1}">Previous</a></td>
</c:if>

<%--For displaying Page numbers.
The when condition does not display a link for the current page--%>
<table border="1" cellpadding="5" cellspacing="5">
    <tr>
        <c:forEach begin="1" end="${noOfPages}" var="i">
            <c:choose>
                <c:when test="${currentPage eq i}">
                    <td>${i}</td>
                </c:when>
                <c:otherwise>
                    <td><a href="/frontController?command=sax&page=${i}">${i}</a></td>
                </c:otherwise>
            </c:choose>
        </c:forEach>
    </tr>
</table>

<%--For displaying Next link --%>
<c:if test="${currentPage lt noOfPages}">
    <td><a href="/frontController?command=sax&page=${currentPage + 1}">Next</a></td>
</c:if>





</body>
</html>
