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

@WebServlet(name = "Main", urlPatterns = "/main")
public class MainServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {


        String sessionUser = (String) req.getSession().getAttribute("user");

        if (sessionUser == null) {
            resp.sendRedirect("login.ftl");
        }

        String cookieUser = "";
        String sessionId = "";
        Cookie[] cookies = req.getCookies();
        if (cookies != null){
            for (Cookie c : cookies) {
                if ("user".equalsIgnoreCase(c.getName())) {
                    cookieUser = c.getValue();
                } else if ("jsessionid".equalsIgnoreCase(c.getName())) {
                    sessionId = c.getValue();
                }
            }
        } else {
            sessionId = req.getSession().getId();
        }


        req.setAttribute("sessionUser", sessionUser);
        req.setAttribute("sessionId", sessionId);
        req.setAttribute("cookieUser", cookieUser);

        req.getRequestDispatcher("main.ftl").forward(req, resp);
    }
}
