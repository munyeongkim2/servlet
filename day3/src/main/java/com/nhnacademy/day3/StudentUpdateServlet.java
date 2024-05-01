package com.nhnacademy.day3;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "studentUpdateServlet", urlPatterns = "/student/update")
public class StudentUpdateServlet extends HttpServlet {
    private StudentRepository studentRepository;
    @Override
    public void init(ServletConfig config) throws ServletException {
        //todo init studentRepository
        ServletContext servletContext = config.getServletContext();
        studentRepository = (StudentRepository) servletContext.getAttribute("studentRepository");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, IOException {

        //todo 학생조회
        //todo null check
        String id = req.getParameter("id");
        if (id == null || id.isEmpty()) {
            resp.sendError(400, "id cannot be empty");
            return;
        }

        //todo student 조회
        Student student = studentRepository.getStudentById(id);
        req.setAttribute("student", student);

//        req.getRequestDispatcher("/student/register.jsp").forward(req, resp);
        //todo forward : /student/register.jsp

        req.setAttribute("view","/student/register.jsp");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //todo null check

        //todo student 저장
        String id = req.getParameter("id");
        String name = req.getParameter("name");
        Gender gender = Gender.valueOf(req.getParameter("gender"));
        int age = Integer.parseInt(req.getParameter("age"));
        //todo null check
        if (id != null) {
            studentRepository.update(new Student(id,name,gender,age));
//            resp.sendRedirect("/student/list");
            req.setAttribute("view","redirect:/student/list.do");

        } else {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "null");
        }


        //todo /student/view?id=student1 <-- redirect
    }
}
