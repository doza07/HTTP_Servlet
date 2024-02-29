<%@ page import="com.doza.pfp.service.ProjectService" %>
<%@ page import="com.doza.pfp.dto.ProjectDTO" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: daniil
  Date: 29.02.2024
  Time: 12:28
To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>List Projects:</h1>
<ul>
    <%
        Long projectId = Long.valueOf(request.getParameter("projectId"));
        List<ProjectDTO> projectDTOList = ProjectService.getInstance().findAll();
        for (ProjectDTO projectDTO : projectDTOList) {
            out.write(String.format("<li>%s</li>", projectDTO.getName()));
        }
    %>
</ul>
</body>
</html>
