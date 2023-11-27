package com.nhnacademy.study;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Optional;
import java.util.logging.Logger;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CounterServlet extends HttpServlet {

    private static final Logger log = Logger.getLogger(CounterServlet.class.getName());

    private long counter;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        counter = Optional.ofNullable(config.getInitParameter("counter"))
                .map(Long::parseLong)
                .orElse(0l);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        counter++;
        CounterUtils.increaseCounter(getServletContext());

        try (PrintWriter pw = resp.getWriter()) {
            pw.println("<!DOCTYPE html>");
            pw.println("<html>");
            pw.println("<head>");
            pw.println("<meta charset='utf-8'>");
            pw.println("</head>");
            pw.println("<body>");
            pw.printf("<h1>%d</h1>\n", counter);
            pw.println("</body>");
            pw.println("</html>");
        } catch (IOException e) {
            log.info(e.getMessage());
        }
    }
}
