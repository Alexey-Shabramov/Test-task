package com.test.task.controller;

import com.test.task.controller.form.PasswordForm;
import com.test.task.controller.form.PrivateInfoForm;
import com.test.task.util.Constants;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class PrivateAreaController {
    @RequestMapping(value = "/privateArea", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView init(ModelAndView modelAndView, HttpServletRequest request) {
        if (request.getSession().getAttribute(Constants.CLIENT) != null) {
            modelAndView.addObject(Constants.PASSWORD_FORM, new PasswordForm());
            modelAndView.addObject(Constants.PRIVATE_INFO_FORM, new PrivateInfoForm());
            return modelAndView;
        } else {
            return new ModelAndView(Constants.REDIRECT_HOME + "/" + Constants.LOGIN);
        }
    }
}
