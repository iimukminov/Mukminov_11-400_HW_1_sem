package ru.kpfu.itis.mukminov.server;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "SignUp", urlPatterns = "/signUp")
public class SignUpServlet extends HttpServlet {
    private static Map<String, String> mapOfUserData = new HashMap<>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.sendRedirect("signUp.html");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");

        //Проверка данных на корректность
        if (login != null && password != null
                && !login.isEmpty() && !password.isEmpty()
                && !mapOfUserData.containsKey(login)) {

            mapOfUserData.put(login, password);
            System.out.println("New user added: " + login +": " + password);
            resp.sendRedirect("/login");
        } else {
            resp.sendRedirect("/signUp");
        }
    }

    public static Map<String, String> getMapOfUserData() {
        return mapOfUserData;
    }
}
