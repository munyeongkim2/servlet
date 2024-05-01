package com.nhnacademy.day3.controller;

import com.nhnacademy.day3.Student;
import com.nhnacademy.day3.StudentRepository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class StudentViewController implements Command {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {
        //todo null check
        StudentRepository studentRepository = (StudentRepository) req.getServletContext().getAttribute("studentRepository");
        String id = req.getParameter("id");
        if (id != null ) {
            //todo student 조회
            Student student = studentRepository.getStudentById(id);
            req.setAttribute("student", student);
        }

        return "/student/view.jsp";
    }
}
