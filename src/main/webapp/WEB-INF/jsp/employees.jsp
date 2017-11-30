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

<table border="1" cellpadding="5" cellspacing="5">
    <tr>
        <c:forEach begin="1" end="${noOfPages}" var="i">
            <c:choose>
                <c:when test="${currentPage eq i}">
                    <td>${i}</td>
                </c:when>
                <c:otherwise>
                    <td><a href="/frontController?page=${i}">${i}</a></td>
                </c:otherwise>
            </c:choose>
        </c:forEach>
    </tr>
</table>

Text
<br>
<c:set var="count" value="${0}" scope="page" />
<c:set var="start" value="${0}" scope="page" />
<c:set var="startcount" value="${param.start}" scope="page" />

<c:set var="endcount" value="${param.end}" scope="page" />
<c:set var="allend" value="${72}" scope="page" />
<c:set var="stepcount" value="${1}" scope="page" />

<c:if test="${endcount>allend}">
    <c:set var="endcount" value="${allend}" scope="page" />
</c:if>
<c:forEach var="counter" begin="${startcount}" end="${endcount}" step="${stepcount}">
    <c:if test="${count < 24}">
        ${counter}<br/>
        <c:set var="count" value="${count + 1}" scope="page" />
        <c:set var="end" value="${counter+count-1}" scope="page" />
        <c:set var="start" value="${counter}" scope="page" />
    </c:if>
</c:forEach>
<c:if test="${endcount>allend}">
    <c:set var="start" value="${1}" scope="page" />
    <c:set var="end" value="${allend}" scope="page" />
</c:if>


<c:if test="${endcount!=allend}">
    <a href="pagination.jsp?start=${(count==1)?1:start}&end=${end}">NEXT</a>&nbsp;&nbsp;&nbsp;
</c:if>
<c:if test="${startcount>24-1}">
    <a href="pagination.jsp?start=${startcount-24+1}&end=${startcount}">PREVIOUS</a>
</c:if>



</body>
</html>
