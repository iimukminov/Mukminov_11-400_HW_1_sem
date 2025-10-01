package ru.kpfu.itis.mukminov.filter;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebFilter(urlPatterns = "/*", filterName = "RequestLimit")
public class RequestLimitFilter implements Filter {

    private static final int MAX_REQUESTS = 10;
    private final Map<String, Integer> requestCounts = new HashMap<>();

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;

        String ip = req.getRemoteAddr();

        // Простой подсчёт запросов по IP
        int count = requestCounts.getOrDefault(ip, 0);
        if (count >= MAX_REQUESTS) {
            resp.getWriter().write("Too Many Requests");
            return;
        }

        requestCounts.put(ip, count + 1);

        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        requestCounts.clear();
    }
}
