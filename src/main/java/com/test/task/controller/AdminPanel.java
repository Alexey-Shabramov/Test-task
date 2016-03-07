package com.test.task.controller;

import com.test.task.dto.ClientDto;
import com.test.task.service.ClientService;
import com.test.task.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class AdminPanel {

    @Autowired
    private ClientService clientService;

    @RequestMapping(value = "/adminPanel", method = RequestMethod.GET)
    public ModelAndView init(HttpServletRequest request) {
        if (request.getSession().getAttribute(Constants.CLIENT) != null
                && ((ClientDto) request.getSession().getAttribute(Constants.CLIENT)).isAdmin()) {
            ModelAndView mav = new ModelAndView("/" + Constants.ADMIN_PANEL);
            return mav;
        } else {
            return new ModelAndView(Constants.REDIRECT_HOME + "/" + Constants.PRIVATE_AREA);
        }
    }
}
