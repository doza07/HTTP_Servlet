package com.doza.pfp.servlet;

import com.doza.pfp.service.TaskService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

@WebServlet("/tasks")
public class TaskServlet extends HttpServlet {

    private final TaskService taskService = TaskService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long projectId = Long.valueOf(req.getParameter("projectId"));

        resp.setContentType("text/html");
        resp.setCharacterEncoding(StandardCharsets.UTF_8.name());

        try (PrintWriter writer = resp.getWriter()) {
            writer.write("<h1>Tasks:</h1>");
            writer.write("<ul>");
            taskService.findAllByProjectId(projectId).forEach(taskDTO ->
                    writer.write("""
                            <li>
                            %s
                            </li>
                            """.formatted(taskDTO.getName())));
            writer.write("</ul>");
        }
    }
}
