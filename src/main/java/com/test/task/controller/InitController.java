package com.test.task.controller;

import com.test.task.util.Constants;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class InitController {
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView init(){
        ModelAndView modelAndView = new ModelAndView("/" + Constants.INDEX);
        return modelAndView;
    }
}
