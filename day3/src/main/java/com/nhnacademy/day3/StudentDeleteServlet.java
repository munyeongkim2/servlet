package com.nhnacademy.day3;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@WebServlet(name = "studentDeleteServlet", urlPatterns = "/student/delete")
public class StudentDeleteServlet extends HttpServlet {

    private StudentRepository studentRepository;

    @Override
    public void init(ServletConfig config) throws ServletException {
        //todo init studentRepository
        ServletContext servletContext = config.getServletContext();
        studentRepository = (StudentRepository) servletContext.getAttribute("studentRepository");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, IOException {
        //todo get parameter  : id , id가 존재하지 않을경우 throw new RuntimeException("...")

        //todo /student/list <-- redirect

        //todo null check

        //todo student 저장
        String id = req.getParameter("id");
        //todo null check
        if (id != null) {
            studentRepository.deleteById(id);
//            resp.sendRedirect("/student/list");
            req.setAttribute("view","redirect:/student/list.do");

        } else {
            throw new RuntimeException("... id is null");
        }
    }
}