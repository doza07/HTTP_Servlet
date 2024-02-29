package com.doza.pfp.servlet;

import com.doza.pfp.dto.ProjectDTO;
import com.doza.pfp.service.ProjectService;
import com.doza.pfp.util.JspHelper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static java.util.stream.Collectors.toMap;


@WebServlet("/content")
public class ContentServlet extends HttpServlet {

    private final ProjectService projectService = ProjectService.getInstance();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<ProjectDTO> projectDTOList = projectService.findAll();
        req.setAttribute("projects", projectDTOList);
        req.getSession().setAttribute("projectMap", projectDTOList.stream()
                .collect(toMap(ProjectDTO::getId, ProjectDTO::getName)));

        req.getRequestDispatcher(JspHelper.getPath("content"))
                .forward(req, resp);
    }
}
