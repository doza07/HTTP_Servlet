package com.doza.pfp.servlet;

import com.doza.pfp.dto.CreateUserDTO;
import com.doza.pfp.exception.ValidationException;
import com.doza.pfp.service.UserService;
import com.doza.pfp.util.JspHelper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet {

    private final UserService userService = UserService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("role", List.of("USER", "GUEST"));
        req.setAttribute("gender", List.of("MALE", "FEMALE"));
        req.getRequestDispatcher(JspHelper.getPath("registration"))
                .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var userDTO = CreateUserDTO.builder()
                .name(req.getParameter("name"))
                .birthday(req.getParameter("birthday"))
                .email(req.getParameter("email"))
                .password(req.getParameter("password"))
                .role(req.getParameter("role"))
                .gender(req.getParameter("gender"))
                .build();

        try {
            userService.create(userDTO);
            resp.sendRedirect("/login");
        } catch (ValidationException e) {
            req.setAttribute("errors", e.getErrors());
            doGet(req, resp);
        }


    }
}
