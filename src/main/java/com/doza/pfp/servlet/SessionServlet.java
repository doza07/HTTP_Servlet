package com.doza.pfp.servlet;

import com.doza.pfp.dto.UserDTO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/sessions")
public class SessionServlet extends HttpServlet {

    public static final String USER = "user";
    private static Long ID = 1L;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        UserDTO user =(UserDTO) session.getAttribute(USER);
        if(user == null) {
            user = UserDTO.builder()
                    .id(ID)
                    .mail(ID + "gmail.com")
                    .build();
            ID++;
            session.setAttribute(USER, user);
        }
    }
}
