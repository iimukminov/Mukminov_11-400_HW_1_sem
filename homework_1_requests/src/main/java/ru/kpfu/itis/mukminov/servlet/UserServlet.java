package ru.kpfu.itis.mukminov.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ru.kpfu.itis.mukminov.dto.UserDto;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "User", urlPatterns = "/user")
public class UserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("users", List.of(new UserDto("Ivan", 100, "pro100Ivan")));
        req.getRequestDispatcher("users.ftl").forward(req, resp);
    }
}
