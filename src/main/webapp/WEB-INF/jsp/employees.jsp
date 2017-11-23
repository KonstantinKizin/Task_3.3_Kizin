<%@ page import="by.tc.jwd.task3_3.kizin.entity.Employee" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%

    for(Employee employee : (List<Employee>)request.getAttribute("employeeList")){

        System.out.println(employee);
    }


%>

</body>
</html>
