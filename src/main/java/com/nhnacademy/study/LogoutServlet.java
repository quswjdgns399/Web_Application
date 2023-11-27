package com.nhnacademy.study;

import java.io.IOException;
import java.util.Objects;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();

        if (Objects.isNull(session)) {
            session.invalidate();
        }

        Cookie cookie = CookieUtils.getCookie(request, "JSESSIONID");
        if (Objects.nonNull(cookie)) {
            cookie.setValue("");
            cookie.setMaxAge(0);
            response.addCookie(cookie);
        }

        response.sendRedirect("/login.html");
    }
}
