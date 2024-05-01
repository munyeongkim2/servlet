package com.nhnacademy.day3.controller;

import com.nhnacademy.day3.Gender;
import com.nhnacademy.day3.Student;
import com.nhnacademy.day3.StudentRepository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class StudentRegisterController implements Command{
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {
        return "/student/register.jsp";
    }
}
