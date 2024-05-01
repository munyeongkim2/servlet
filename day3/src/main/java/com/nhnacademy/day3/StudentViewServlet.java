package com.nhnacademy.day3;

import com.nhnacademy.day3.Student;
import com.nhnacademy.day3.StudentRepository;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;

@Slf4j
@WebServlet(name = "studentViewServlet", urlPatterns = "/student/view")
public class StudentViewServlet extends HttpServlet {
    private StudentRepository studentRepository;

    @Override
    public void init(ServletConfig config) throws ServletException {
        studentRepository = (StudentRepository) config.getServletContext().getAttribute("studentRepository");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //todo null check
        String id = req.getParameter("id");
        if (id == null || id.isEmpty()) {
            resp.sendError(400, "id cannot be empty");
            return;
        }

        //todo student 조회
        Student student = studentRepository.getStudentById(id);
        req.setAttribute("student", student);

        //todo /student/view.jsp <-- forward
//        req.getRequestDispatcher("/student/view.jsp").forward(req, resp);
        req.setAttribute("view","/student/view.jsp");
    }

}