<%--
  Created by IntelliJ IDEA.
  User: daniil
  Date: 29.02.2024
  Time: 12:28
To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<html>
<head>
  <title>Title</title>
</head>
<body>
<c:if test="${not empty requestScope.tasks}">
  <h1>List Projects:</h1>
  <ul>
    <c:forEach var="tasks" items="${requestScope.tasks}">
      <li>${fn:toUpperCase(task.name)}</li>
    </c:forEach>
  </ul>
</c:if>
</body>
</html>
