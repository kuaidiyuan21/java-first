package com.qingguatang.java5minute.course9;

import org.springframework.boot.autoconfigure.web.servlet.error.ErrorViewResolver;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
public class GlobalExceptionHandler implements ErrorViewResolver {

    @Override
    public ModelAndView resolveErrorView(HttpServletRequest request, HttpStatus status, Map<String, Object> model){
        ModelAndView mav = new ModelAndView();
        mav.addObject("url",request.getRequestURI());
        mav.addAllObjects(model);
        mav.setViewName("error");
        return mav;
    }
}
