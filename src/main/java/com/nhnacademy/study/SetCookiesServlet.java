package com.nhnacademy.study;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Objects;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SetCookiesServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String locale = request.getParameter("locale");

        if (Objects.isNull(locale)) {
            locale = "ko";
        }

        Cookie cookie = new Cookie("locale", locale);
        cookie.setMaxAge(-1);
        cookie.setPath("/");
        response.addCookie(cookie);

        try (PrintWriter pw = response.getWriter()) {
            pw.println("OK");
        }
    }
}
