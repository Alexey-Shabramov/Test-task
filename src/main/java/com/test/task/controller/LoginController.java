package com.test.task.controller;

import com.test.task.controller.form.LoginForm;
import com.test.task.dto.ClientDto;
import com.test.task.entity.Client;
import com.test.task.service.ClientService;
import com.test.task.util.Constants;
import com.test.task.util.PasswordUtil;
import com.test.task.validator.LoginValidator;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class LoginController {
    @Autowired
    private ClientService clientService;

    @Autowired
    private DozerBeanMapper dozerBeanMapper;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String init(ModelMap model, HttpServletRequest request) {
        if (request.getSession().getAttribute(Constants.CLIENT) != null) {
            if(((ClientDto)request.getSession().getAttribute(Constants.CLIENT)).isAdmin()){
                return Constants.ADMIN_PANEL;
            }else{
                return Constants.PRIVATE_AREA;
            }
        } else {
            return Constants.LOGIN;
        }
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView login(@ModelAttribute("loginForm") LoginForm loginForm, HttpServletRequest request) {
        if (request.getSession().getAttribute(Constants.CLIENT) != null) {
            return new ModelAndView(Constants.PRIVATE_AREA);
        }
        List<String> errorList = new ArrayList<>();
        if (!LoginValidator.validateLogin(loginForm.getLoginOrEmail(), loginForm.getPassword())) {
            errorList.add(Constants.EMPTY_FIELD);
        }else if (clientService.getByEmailOrLogin(loginForm.getLoginOrEmail()) == null) {
            errorList.add(Constants.CLIENT_NOT_EXISTS);
        }else if (!LoginValidator.validatePasswords(PasswordUtil.encryptPassword(loginForm.getPassword()),
                clientService.getByEmailOrLogin(loginForm.getLoginOrEmail()).getPassword())) {
            errorList.add(Constants.PASSWORD_IS_INCORRECT);
        }
        if (!errorList.isEmpty()) {
            return addErrors(errorList);
        } else {
            ModelAndView mav;
            Client client = clientService.getByEmailOrLogin(loginForm.getLoginOrEmail());
            ClientDto clientDto = new ClientDto();
            dozerBeanMapper.map(client, clientDto, "clientToDto");
            request.getSession().setAttribute(Constants.CLIENT, clientDto);
            if (clientDto.isAdmin()) {
                mav = new ModelAndView(Constants.REDIRECT_HOME + "/" + Constants.ADMIN_PANEL);
            } else {
                mav = new ModelAndView(Constants.REDIRECT_HOME + "/" + Constants.PRIVATE_AREA);
            }
            return mav;
        }
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String init(HttpServletRequest request) {
        if (request.getSession().getAttribute(Constants.CLIENT) != null) {
            request.getSession().removeAttribute(Constants.CLIENT);
        }
        return Constants.REDIRECT_HOME;
    }

    private ModelAndView addErrors(List errorList) {
        ModelAndView model = new ModelAndView("/" + Constants.LOGIN);
        model.addObject(Constants.ERRORS, errorList);
        return model;
    }
}
