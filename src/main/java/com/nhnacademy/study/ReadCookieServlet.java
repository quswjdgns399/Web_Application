package com.nhnacademy.study;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Locale;
import java.util.Objects;
import java.util.ResourceBundle;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ReadCookieServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Cookie cookie = CookieUtils.getCookie(request, "locale");
        Cookie cookieName = CookieUtils.getCookie(request, "myName");
        Cookie cookieAge = CookieUtils.getCookie(request, "myAge");

        if (Objects.isNull(cookie) && Objects.isNull(cookieName) && Objects.isNull(cookieAge)) {
            response.sendError(500, "cookie not fount");
            return;
        }

        String locale = cookie.getValue();

        String helloValue = ResourceBundle.getBundle("message", new Locale(locale)).getString("hello");
        response.setContentType("text/plain");
        response.setCharacterEncoding("utf-8");
        try (PrintWriter pw = response.getWriter()) {
            pw.println(cookieName.getValue());
            pw.println(cookieAge.getValue());
            pw.println(helloValue);
        }
    }
}
