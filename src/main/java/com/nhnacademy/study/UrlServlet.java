package com.nhnacademy.study;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UrlServlet extends HttpServlet {

    private static final Logger log = Logger.getLogger(UrlServlet.class.getName());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CounterUtils.increaseCounter(getServletContext());

        resp.setContentType("text/plain");
        resp.setCharacterEncoding("UTF-8");

        try (PrintWriter pw = resp.getWriter()) {
            pw.println("local=" + req.getLocale());
            pw.println("prameter name=" + req.getParameter("userID"));
            pw.println("content type=" + req.getContentType());
            pw.println("content length=" + req.getContentLengthLong());
            pw.println("method=" + req.getMethod());
            pw.println("servlet path=" + req.getServletPath());
            pw.println("request uri=" + req.getRequestURI());
            pw.println("request url=" + req.getRequestURL());
            pw.println("User-Agent header=" + req.getHeader("User-Agent"));
        } catch (Exception e) {
        }
    }
}
