<%@ page import="java.util.ArrayList" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Incident</title>
</head>
<body>
    <select>

        <c:forEach var = "item" items = "${requestScope.arrTypeIncident}" >
            <option> <c:out value = "${item.getName()}"/></option>
        </c:forEach>
    </select>
</body>
</html>
