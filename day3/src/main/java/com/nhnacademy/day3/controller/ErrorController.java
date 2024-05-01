package com.nhnacademy.day3.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static com.nhnacademy.day3.RequestDispatcher.ERROR_EXCEPTION;
import static com.nhnacademy.day3.RequestDispatcher.ERROR_STATUS_CODE;

public class ErrorController implements Command {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {
        req.setAttribute("status_code", req.getAttribute(ERROR_STATUS_CODE));

        //todo exception_type
        Throwable throwable = (Throwable) req.getAttribute("javax.servlet.error.exception");
        String exceptionType = throwable.getClass().getName();
        req.setAttribute("exception_type", exceptionType);

        //todo message
        String message = throwable.getClass().getName();
        req.setAttribute("message", message);

        //todo exception
        req.setAttribute("exception", req.getAttribute(ERROR_EXCEPTION));

        //todo request_uri
        String requestURI = req.getRequestURI();
        req.setAttribute("request_uri", requestURI);

        //todo /error.jsp forward 처리
//        req.getRequestDispatcher("/student/error.jsp").forward(req, resp);
        return "/student/error.jsp";
    }
}
