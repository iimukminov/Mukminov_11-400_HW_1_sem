package ru.kpfu.itis.mukminov.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ru.kpfu.itis.mukminov.dao.UserDao;
import ru.kpfu.itis.mukminov.dao.impl.UserDaoImpl;
import ru.kpfu.itis.mukminov.service.UserService;
import ru.kpfu.itis.mukminov.service.impl.UserServiceImpl;

import java.io.IOException;

@WebServlet(name = "User", urlPatterns = "/user")
public class UserServlet extends HttpServlet {

    private final UserService userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setAttribute("users", userService.getAll());
        req.getRequestDispatcher("users.ftl").forward(req, resp);
    }
}
