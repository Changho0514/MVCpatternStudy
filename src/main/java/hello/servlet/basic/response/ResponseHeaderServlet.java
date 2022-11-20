package hello.servlet.basic.response;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ResponseHeaderServlet", urlPatterns = "/response-header")
public class ResponseHeaderServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //[status-line]
        response.setStatus(HttpServletResponse.SC_OK);

        //[response-headers]
        response.setHeader("Cache-control", "no-cache, no-store, must-revalidate");
        response.setHeader("Pragma", "no-cache");
        response.setHeader("my-header", "hello");

        //[Header 편의 메서드]
        content(response);
        cookie(response);
        redirect(response);

//        System.out.println("===== response.getWriter부분 ====");
        PrintWriter writer = response.getWriter();
//        System.out.println("===== response.getWriter부분 - END ====");
        writer.println("ok");


    }

    private void content(HttpServletResponse response) {
        response.setContentType("text/plain");
        response.setCharacterEncoding("utf-8");
    }

    private void cookie(HttpServletResponse response) {
        ////response.setHeader() 메소드 이용방법
        //Set-Cookie : myCookie=good; Max-Age=600
        //response.setHeader("Set-Cookie", "myCookie=good; Max-Age=600");

        // Cookie 객체 이용방법
        Cookie cookie = new Cookie("myCookie", "good");
        cookie.setMaxAge(600); //600초
        response.addCookie(cookie);
    }

    private void redirect(HttpServletResponse response) throws IOException {
        //Status code 302
        //Location: /basic/hello-form.html

//        //방법 1
//        response.setStatus(HttpServletResponse.SC_FOUND); //302
//        response.setHeader("Location", "/basic/hello-form.html");

        //방법 2
        response.sendRedirect("/basic/hello-form.html");
    }
}
