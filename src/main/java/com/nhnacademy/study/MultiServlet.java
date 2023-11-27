package com.nhnacademy.study;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Logger;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MultiServlet extends HttpServlet {
    private static final Logger log = Logger.getLogger(MultiServlet.class.getName());

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        String[] values = req.getParameterValues("class");
        String url = getServletContext().getInitParameter("url");
        try (PrintWriter pw = resp.getWriter()) {
            pw.println(String.join(",", values));
            pw.printf("url:%s\n", url);
        } catch (IOException e) {
            log.info(e.getMessage());
        }
    }

}
