package com.doza.pfp.servlet;

import com.doza.pfp.service.TaskService;
import com.doza.pfp.util.JspHelper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;



@WebServlet("/tasks")
public class TaskServlet extends HttpServlet {

    private final TaskService taskService = TaskService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long projectId = Long.valueOf(req.getParameter("projectId"));
        req.setAttribute("tasks", taskService.findAllByProjectId(projectId));

        req.getRequestDispatcher(JspHelper.getPath("tasks"))
                .forward(req, resp);
    }
}
