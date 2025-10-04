package ru.kpfu.itis.mukminov.filter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebFilter(urlPatterns = "/*", filterName = "RequestLimit")
public class RequestLimitFilter implements Filter {

    private static final int MAX_REQUESTS = 1000;
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
            requestCounts.put(ip, 0);
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
