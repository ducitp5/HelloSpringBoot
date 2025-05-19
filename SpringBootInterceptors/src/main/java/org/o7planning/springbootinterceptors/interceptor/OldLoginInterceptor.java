package org.o7planning.springbootinterceptors.interceptor;

import jakarta.servlet.http.HttpServletRequest; // ✅ Correct for Spring Boot 3.x
import jakarta.servlet.http.HttpServletResponse; // ✅ Correct for Spring Boot 3.x

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.HandlerInterceptor;

public class OldLoginInterceptor implements  HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {

        System.out.println("\n-------- OldLoginInterceptor.preHandle --- ");
        System.out.println("Request URL: " + request.getRequestURL());
        System.out.println("Sorry! This URL is no longer used, Redirect to /admin/login");

        response.sendRedirect(request.getContextPath() + "/admin/login");
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, //
                           Object handler, ModelAndView modelAndView) throws Exception {

        // This code will never be run.
        System.out.println("\n-------- OldLoginInterceptor.postHandle --- ");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, //
                                Object handler, Exception ex) throws Exception {

        // This code will never be run.
        System.out.println("\n-------- QueryStringInterceptor.afterCompletion --- ");
    }

}