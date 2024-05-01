package com.nhnacademy.day3;

import com.nhnacademy.day3.controller.JsonStudentRepository;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.annotation.WebServlet;
import java.util.Random;

@WebListener
public class WebApplicationListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext servletContext = sce.getServletContext();
        StudentRepository studentRepository = new JsonStudentRepository();

        for (int i = 0; i < 10; i++) {
            String id = "StudentId" + i;
            String name = "아카데미" + i;
            Gender gender = (i % 2 == 0 ? Gender.M : Gender.F);
            int age = new Random().nextInt(30-20+1)+20;
            Student student = new Student(id, name, gender, age);
            studentRepository.save(student);
        }
        servletContext.setAttribute("studentRepository", studentRepository);


    }

}
