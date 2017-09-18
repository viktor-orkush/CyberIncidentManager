<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
</head>
    <%@ include file="includeCssJs.jsp"%>

<body onload="startTime()">
<div class="container">
    <div class="jumbotron text-center">
        <h1>Алгоритм дій</h1>
        <p><c:out value = "${requestScope.incidName}"/></p>
        <h3 class = "timer" id="txt"></h3>
        <div id="clock" class="clock">loading ...</div>
    </div>

    <table class="table table-hover">
        <thead>
        <tr>
            <th class="col-md-1">№</th>
            <th class="col-md-1">Поточный час</th>
            <th class="col-md-1">Операцію виконати до</th>
            <th class="col-md-6">Дія</th>
            <th class="col-md-1"></th>
        </tr>
        </thead>
        <tbody>
                <c:forEach var = "item" items = "${requestScope.arrActionOnIncident}" >
                <tr>
                    <td><c:out value = "${item.getId()}"/></td>
                    <td>  </td>

                    <td><c:out value="${sessionScope.arrTimeIncReact.get(item.getId() - 1)}"/></td>
                    <td><c:out value = "${item.getName()}"/></td>
                    <td><button type="button" class="btn btn-warning" id="myelement">Виконано</button></td>
                </tr>
                </c:forEach>
        </tbody>
    </table>
</div>

</body>
</html>

<script>
    function startTime() {
        var today = new Date();
        var h = today.getHours();
        var m = today.getMinutes();
        var s = today.getSeconds();
        m = checkTime(m);
        s = checkTime(s);
        document.getElementById('txt').innerHTML =
            h + ":" + m + ":" + s;
        var t = setTimeout(startTime, 500);
    }
    function checkTime(i) {
        if (i < 10) {i = "0" + i};  // add zero in front of numbers < 10
        return i;
    }
</script>

<script>
$('#clock').fitText(1.3);

function update() {
$('#clock').html(moment().format('D. MMMM YYYY H:mm:ss'));
}

setInterval(update, 1000);
</script>

<script>
    $(document).ready(function() {
    $( "button" ).click(function() {
             console.log("Страница полностью загружена");
            $(this).parents('tr').toggleClass('Success');
            $(this).removeClass('btn-warning').addClass('btn-success');
        });
        });
</script>