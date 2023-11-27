package com.nhnacademy.study;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Logger;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequestServlet extends HttpServlet {

    private static final Logger log = Logger.getLogger(RequestServlet.class.getName());

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        resp.setContentType("text/plain");
        resp.setCharacterEncoding("utf-8");

        try (PrintWriter pw = resp.getWriter()) {
            pw.println("locale=" + req.getLocale());
            pw.println("parameter name=" + req.getParameter("userId"));
            pw.println("content type=" + req.getContentType());
            pw.println("content length=" + req.getContentLengthLong());
            pw.println("method=" + req.getMethod());
            pw.println("servlet path=" + req.getServletPath());
            pw.println("request uri=" + req.getRequestURI());
            pw.println("request url=" + req.getRequestURL());
            pw.println("User-Agent header=" + req.getHeader("User-Agent"));

        } catch (IOException e) {
        }
    }
}
