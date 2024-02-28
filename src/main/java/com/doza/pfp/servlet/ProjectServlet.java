package com.doza.pfp.servlet;

import com.doza.pfp.service.ProjectService;
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

        resp.setContentType("text/html");
        resp.setCharacterEncoding(StandardCharsets.UTF_8.name());

        try (PrintWriter writer = resp.getWriter()) {
            writer.write("<h1>List Projects:</h1>");
            writer.write("<il>");
            projectService.findAll().forEach(projectDTO -> {
                writer.write("""
                        <li>
                            <a href="/tasks?projectId=%d">%s</a>
                        </li>
                        """.formatted(projectDTO.getId(), projectDTO.getName()));
            });
            writer.write("</il>");
        }
    }
}
