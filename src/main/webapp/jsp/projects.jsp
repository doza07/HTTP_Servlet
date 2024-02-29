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
    <h1>List Projets:</h1>
<ui>
    <c:forEach var="project" items="${requestScope.projects}">
        <li>
            <a href="/tasks?projectId=${project.id}">${project.name}</a>
        </li>
    </c:forEach>
</ui>
</body>
</html>