package com.nhnacademy.day3.controller;

import com.nhnacademy.day3.Student;
import com.nhnacademy.day3.StudentRepository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class StudentUpdateController implements Command{
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {
        StudentRepository studentRepository = (StudentRepository) req.getServletContext().getAttribute("studentRepository");
        //todo 학생조회
        //todo null check
        String id = req.getParameter("id");
        if (id != null) {
            Student student = studentRepository.getStudentById(id);
            req.setAttribute("student", student);

        }
        return "/student/register.jsp";
    }
}
