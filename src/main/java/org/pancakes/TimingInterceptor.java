package org.pancakes;

import org.pancakes.controller.MainController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.*;


@Component
public class TimingInterceptor implements HandlerInterceptor {

    @Autowired
    MainController controller;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        long startTime = System.currentTimeMillis();
        request.setAttribute("startTime", startTime);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        long startTime = (Long) request.getAttribute("startTime");
        long endTime = System.currentTimeMillis();
        long executionTime = endTime - startTime;
        response.setHeader("X-Server-Time", String.valueOf(executionTime));
        if (modelAndView != null) {
            modelAndView.addObject("serverProcessingTime", executionTime);
        }
//        System.out.println(executionTime);
    }

}
