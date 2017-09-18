<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>



<html>
<head>
    <title>Title</title>
    <%@ include file="includeCssJs.jsp"%>
</head>

<body>
        <form name="test" method="GET" action="algor">
            <p><b>Ваша фамилия:</b><br>
                <input type="text" size="40" name = "username">
            </p>
            <p><b>Вид інцидента</b><Br>
                <select name="typeIncid">
                    <c:forEach var = "item" items = "${requestScope.arrIncident}" >
                        <option value=<c:out value = "${item.getId()}"/>><c:out value = "${item.getName()}"/> </option>
                    </c:forEach>
                </select>
            </p>
            <p><input type="submit" value="Отправить">
                <input type="reset" value="Очистить"></p>
        </form>
</body>
</html>
