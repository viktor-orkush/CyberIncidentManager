<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<%@ page import="java.util.ArrayList" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
  <head>
    <title>Bootstrap 101 Шаблон</title>
      <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
    <script src="/js/bootstrap.js"></script>
    <link href="/css/bootstrap.css" rel="stylesheet" type="text/css">
  </head>

  <body>
    <h1>Реагування на інциденти</h1>
    <div class="row">
      <div class="col-xs-2">
        <div class="btn-group">
          <button class="btn btn-default btn-sm dropdown-toggle" type="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
            Small button <span class="caret"></span>
          </button>
          <ul class="dropdown-menu">
              <% ArrayList<String> list = (ArrayList<String>) request.getAttribute ("arrTypeIncident"); %>
              <%
                  for(String val: list){ %>
                      <li> <a href="#"><% out.println(val); %></a></li>
              <%}
              %>
              <%
                  String[] columnHeaders = {"Banana", "Apple", "Carrot", "Orange", "Lychee", "Permisson"};
                  request.setAttribute("columnHeaders", columnHeaders);
              %>

              <c:forEach var = "i" items = "${arrTypeIncident}" >
                  Item <c:out value = "${i}"/><p>
              </c:forEach>



            <li> <a href="#">1</a></li>
            <li> <a href="#">2</a></li>
          </ul>
        </div>
      </div>

    </div>
<div class="row">
  <div class="col-xs-2">.col-xs-1</div>
  <div class="col-xs-2">.col-xs-4</div>
  <div class="col-xs-6">.col-xs-4</div>
  <div class="col-xs-2">.col-xs-1</div>
</div>

  </body>
</html>