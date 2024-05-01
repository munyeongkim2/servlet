
package com.nhnacademy.day1.login;

import com.nhnacademy.day1.CookieUtils;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.Objects;
@WebServlet(name = "logoutServlet", urlPatterns = "/logout")
@Slf4j
public class LogoutServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);

        if(session != null) {
            session.invalidate();
        }

        Cookie cookie = CookieUtils.getCookie(req, "JSESSIONID");
        if(Objects.nonNull(cookie)) {
            cookie.setMaxAge(0);
            cookie.setValue(null);
            resp.addCookie(cookie);
        }
        resp.sendRedirect("/login.html");
    }
}