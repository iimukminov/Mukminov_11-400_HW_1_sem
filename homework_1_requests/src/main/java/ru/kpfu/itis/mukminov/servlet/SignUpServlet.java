package ru.kpfu.itis.mukminov.servlet;

import ru.kpfu.itis.mukminov.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "SignUp", urlPatterns = "/signUp")
public class SignUpServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        req.getRequestDispatcher("signUp.ftl").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        String name = req.getParameter("name");
        String lastname = req.getParameter("lastname");

        Integer resSignUp = UserServiceImpl.signUp(login, password, name, lastname);
        if (resSignUp == 0) {
            resp.sendRedirect("/login");
        } else if (resSignUp == 1) {
            req.setAttribute("signUpResult", "Sorry, but this user login already exist");
            req.getRequestDispatcher("signUp.ftl").forward(req, resp);
        } else if (resSignUp == 2) {
            req.setAttribute("signUpResult", "You entered empty login or password");
            req.getRequestDispatcher("signUp.ftl").forward(req, resp);
        }
    }







}
