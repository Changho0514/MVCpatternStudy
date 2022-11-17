package hello.servlet.basic.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "requestHeaderServlet", urlPatterns = "/request-header")
public class RequestHeaderServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        printStartLine(request);
    }

    private void printStartLine(HttpServletRequest request) {
        /**
         * 스타트 라인 정보 불러오기 HTTP메시지의 첫 정보를 불러오기
         */
        // start line 정보
        System.out.println("--- REQUEST - LINE - START ---");
        System.out.println("request.getMethod() = " + request.getMethod()); //GET
        System.out.println("request.getProtocol() = " + request.getProtocol()); //HTTP/1.1
        System.out.println("request.getScheme() = " + request.getScheme()); //http

        //http://localhost:8080/request-header
        System.out.println("request.getRequestURL() = " + request.getRequestURL());

        // request-header
        System.out.println("request.getRequestURI() = " + request.getRequestURI());

        //username=hi
        System.out.println("request.getQueryString() = " + request.getQueryString());
        System.out.println("request.isSecure() = " + request.isSecure());
        System.out.println("--- REQUEST - LINE - END ---");
        System.out.println();
    }
}
