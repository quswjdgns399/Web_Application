package com.nhnacademy.study;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Objects;
import javax.servlet.ServletConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LoginServlet extends HttpServlet {
    private String initParamId;
    private String initParamPwd;

    @Override
    public void init(ServletConfig config) {
        initParamId = config.getInitParameter("id");
        initParamPwd = config.getInitParameter("pwd");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession(false); // 있으면 가져오고 없으면 null true면 없으면 생성
        if (Objects.isNull(session) || Objects.isNull(session.getAttribute("id"))) {
            response.sendRedirect("/login.html");
        } else {
            response.setContentType("text/html");
            response.setCharacterEncoding("utf-8");

            try (PrintWriter pw = response.getWriter()) {
                pw.println("login success id : " + session.getAttribute("id"));
                pw.println("</br>");
                pw.println("<a href='/logout'>logout</a>");
            }
        }

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");
        String pwd = request.getParameter("pwd");

        if (initParamId.equals(id) && initParamPwd.equals(pwd)) {
            HttpSession session = request.getSession();
            session.setAttribute("id", id); //세션이 유지되는 동안 사용가능
            response.sendRedirect("/login");
        } else {
            log.error("아이디/패스워드가 일치하지 않습니다.");
            response.sendRedirect("/login.html");
        }
    }
}
