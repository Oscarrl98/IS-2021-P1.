package com.gt.edu.umg.ingenieriasoftware.p1.parcial1.service;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@ControllerAdvice

public class Exeption {
    @ExceptionHandler(ExeptionFile.class)
    public ModelAndView handleException(ExeptionFile exception, RedirectAttributes redirectAttributes) {

        ModelAndView mav = new ModelAndView();
        mav.addObject("message", exception.getMsg());
        mav.setViewName("error");
        return mav;
    }
}
