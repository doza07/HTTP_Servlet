package com.doza.pfp.servlet;

import com.doza.pfp.service.ProjectService;
import com.doza.pfp.util.JspHelper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

@WebServlet("/projects")
public class ProjectServlet extends HttpServlet {

    private final ProjectService projectService = ProjectService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("projects", projectService.findAll());

        req.getRequestDispatcher(JspHelper.getPath("projects"))
                        .forward(req, resp);
    }
}
