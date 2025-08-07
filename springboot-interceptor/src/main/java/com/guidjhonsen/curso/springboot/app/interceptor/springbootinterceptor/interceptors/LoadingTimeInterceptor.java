package com.guidjhonsen.curso.springboot.app.interceptor.springbootinterceptor.interceptors;

import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component("timeInterceptor")
public class LoadingTimeInterceptor implements HandlerInterceptor {

    private static final Logger logger = LoggerFactory.getLogger(LoadingTimeInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
                HandlerMethod controller = (HandlerMethod) handler;
                logger.info("LoadingTimeInterceptor: preHandle() Entrando al metodo del controlador" + controller.getMethod().getName());
                long startTime = System.currentTimeMillis();
                request.setAttribute("startTime", startTime);
                Random rand = new Random();
                Integer delay = rand.nextInt(500);
                Thread.sleep(delay);
                
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
            ModelAndView modelAndView) throws Exception {

                long startTime = (Long) request.getAttribute("startTime");
                long endTime = System.currentTimeMillis();
                long loadingTime = endTime - startTime;
                if (modelAndView != null) {
                    modelAndView.addObject("loadingTime", loadingTime);
                }
                logger.info("LoadingTimeInterceptor: loadingTime en milisegundos: " + loadingTime);
        logger.info("LoadingTimeInterceptor: postHandle() Saliendo del metodo del controlador"+((HandlerMethod) handler).getMethod().getName());            
    }
}
