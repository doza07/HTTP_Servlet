package com.doza.pfp.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/dispatcher")
public class DispatcherServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //        req.getRequestDispatcher("/projects")
//                .include(req, resp);
//
//        PrintWriter writer = resp.getWriter();
//        writer.write("Hello DispatcherServlet");

        resp.sendRedirect("/projects");
    }
}
