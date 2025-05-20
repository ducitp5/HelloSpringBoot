package org.o7planning.springbootinterceptors.interceptor;

import jakarta.servlet.http.HttpServletRequest; // ✅ Correct for Spring Boot 3.x
import jakarta.servlet.http.HttpServletResponse; // ✅ Correct for Spring Boot 3.x


import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.HandlerInterceptor;

public class AdminInterceptor  implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {

        System.out.println("\n-------- AdminInterceptor.preHandle --- ");
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, //
                           Object handler, ModelAndView modelAndView) throws Exception {

        System.out.println("\n-------- AdminInterceptor.postHandle --- ");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, //
                                Object handler, Exception ex) throws Exception {

        System.out.println("\n-------- AdminInterceptor.afterCompletion --- ");
    }

}
