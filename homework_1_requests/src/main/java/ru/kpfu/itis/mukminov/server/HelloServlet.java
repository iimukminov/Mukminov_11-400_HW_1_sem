package ru.kpfu.itis.mukminov.server;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.stream.Collectors;

@WebServlet(name = "Hello", urlPatterns = "/hello")
public class HelloServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        writer.write("Hello, user!");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        String body = req.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
        writer.println(body);
        writer.println("  Added " + body.split(",")[1].split(":")[1]);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        String body = req.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
        writer.println(body);
        writer.println("  Changed to " + body.split(",")[1].split(":")[1]);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        String body = req.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
        writer.println(body);
        writer.println("  Deleted " + body.split(",")[1].split(":")[1]);
    }
}
