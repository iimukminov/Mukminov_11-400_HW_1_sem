package ru.kpfu.itis.mukminov.servlet;

import ru.kpfu.itis.mukminov.dao.UserDao;
import ru.kpfu.itis.mukminov.dao.impl.UserDaoImpl;
import ru.kpfu.itis.mukminov.entity.User;
import ru.kpfu.itis.mukminov.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/signUp/check")
public class SignUpCheckServlet extends HttpServlet {

    private static final UserDao userDao = new UserDaoImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        User user = userDao.getByLogin((String) req.getParameter("login"));
        resp.setContentType("text/plain");

        if (user != null) {
            resp.getWriter().write("This login already exist");
        }
    }
}
