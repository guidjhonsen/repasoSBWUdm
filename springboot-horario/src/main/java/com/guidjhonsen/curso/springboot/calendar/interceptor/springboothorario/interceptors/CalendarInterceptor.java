package com.guidjhonsen.curso.springboot.calendar.interceptor.springboothorario.interceptors;

import java.util.Calendar;

import org.apache.tomcat.util.net.AbstractEndpoint.Handler;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class CalendarInterceptor implements HandlerInterceptor{
    @Value("${config.calendar.open}")
    private Integer open;
    @Value("${config.calendar.close}")
    private Integer close;

    @Override
    public boolean preHandle(HttpServletRequest request, 
                             HttpServletResponse response, 
                             Object handler) throws Exception {
        
        Calendar calendar = Calendar.getInstance();
        int hour = calendar.get(Calendar.HOUR_OF_DAY);

        System.out.println("Intercepting request: " + request.getRequestURI());

        if (hour < open || hour >= close) {
            System.out.println("Request blocked due to calendar restrictions.");
            
            StringBuilder message = new StringBuilder("Bienvenidos al horario de atención al cliente");
            message.append(" Atendemos desde las ").append(open).append(" hrs. hasta las ").append(close).append(" hrs.");
            request.setAttribute("message", message.toString());
            //response.setStatus(HttpServletResponse.SC_FORBIDDEN);
            return true; // Block the request
        }

        return false; // Continue with the request processing
    }

    @Override
    public void postHandle(HttpServletRequest request, 
                           HttpServletResponse response, 
                           Object handler, 
                           org.springframework.web.servlet.ModelAndView modelAndView) throws Exception {
        // After the controller method is executed
        System.out.println("Post handle for: " + request.getRequestURI());
    }

    @Override
    public void afterCompletion(HttpServletRequest request, 
                                HttpServletResponse response, 
                                Object handler, 
                                Exception ex) throws Exception {
        // After the complete request has been processed
        System.out.println("After completion for: " + request.getRequestURI());
    }
}
