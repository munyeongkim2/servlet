//package com.nhnacademy.day3;
//
//import lombok.extern.slf4j.Slf4j;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import javax.servlet.RequestDispatcher;
//
//@Slf4j
//@WebServlet(name = "frontServlet", urlPatterns = "*.do")
//public class FrontServlet extends HttpServlet {
//    private static final String REDIRECT_PREFIX="redirect";
//
//    @Override
//    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//
////        //todo 공통 처리 - 응답 content-type, character encoding 지정.
//        resp.setContentType("text/html; charset=UTF-8");
//        resp.setCharacterEncoding("UTF-8");
//        req.setCharacterEncoding("UTF-8");
//
//        try{
//            //실제 요청 처리할 servlet을 결정
//            String servletPath = resolveServlet(req.getServletPath());
//
//            RequestDispatcher rd = req.getRequestDispatcher(servletPath);
//            rd.include(req, resp);
//
//            //실제 요청을 처리한 servlet이 'view'라는 request 속성값으로 view를 전달해 줌.
//            String view = (String) req.getAttribute("view");
//            if (view.startsWith(REDIRECT_PREFIX)) {
//                String url = view.substring(REDIRECT_PREFIX.length()+1);
//                log.error("redirect-url : {}", url);
//                // todo  `redirect:`로 시작하면 redirect 처리.
//                resp.sendRedirect(url);
//
//            } else {
//                //todo redirect 아니면 JSP에게 view 처리를 위임하여 그 결과를 include시킴.
//                RequestDispatcher jspRd = req.getRequestDispatcher(view);
//                jspRd.include(req, resp);
//
//            }
//        }catch(Exception ex){
//            //todo 공통 error 처리 - ErrorServlet 참고해서 처리
//
//
//            //todo  forward - /error.jsp
//
//        }
//    }
//
//    private String resolveServlet(String servletPath){
//        String processingServlet = null;
//        if("/student/list.do".equals(servletPath)){
//            processingServlet = "/student/list";
//        }else if("/student/register.do".equals(servletPath)){
//            processingServlet = "/student/register";
//        }else if("/student/update.do".equals(servletPath)){
//            processingServlet = "/student/update";
//        }else if("/student/delete.do".equals(servletPath)){
//            processingServlet = "/student/delete";
//        }else if("/student/view.do".contains(servletPath)){
//            processingServlet = "/student/view";
//        }
//
//        //todo 실행할 servlet 결정하기
//
//        return processingServlet;
//    }
//
//}