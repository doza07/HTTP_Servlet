<%--
  Created by IntelliJ IDEA.
  User: daniil
  Date: 29.02.2024
  Time: 12:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%@include file="header.jsp" %>
<div>
    <span>Content</span>
    <p>Size: ${requestScope.projects.size()}</p>
    <p>id: ${requestScope.projects[0].id}</p>
    <p>id: ${sessionScope.projects[0]}</p>
    <p>JSESSION id: ${cookie["JSESSION"].value}, unique identifier</p>
    <p>Header: ${header["Coocie"]}</p>
    <p>Param id: ${param.id}</p>
    <p>Param test: ${param.test}</p>
</div>
<%@include file="footer.jsp" %>
</body>
</html>
