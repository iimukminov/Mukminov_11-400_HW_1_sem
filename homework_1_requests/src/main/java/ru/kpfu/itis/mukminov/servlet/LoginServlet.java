package ru.kpfu.itis.mukminov.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

@WebServlet(name = "Login", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        req.getRequestDispatcher("login.ftl").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        Map<String, String> usersData = SignUpServlet.getMapOfUserData();

        if (usersData.containsKey(login) && usersData.get(login).equals(password)) {
            //session
            HttpSession httpSession = req.getSession();
            httpSession.setAttribute("user", login);
            httpSession.setMaxInactiveInterval(60 * 60);

            //cookie
            Cookie cookie = new Cookie("user", login);
            cookie.setMaxAge(24 * 60 * 60);

            resp.addCookie(cookie);

            resp.sendRedirect("/main");
        } else {
            resp.sendRedirect("/login");
        }
    }
}
