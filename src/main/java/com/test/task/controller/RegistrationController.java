package com.test.task.controller;

import com.test.task.controller.form.RegistrationForm;
import com.test.task.dto.ClientDto;
import com.test.task.entity.Client;
import com.test.task.exception.ServiceException;
import com.test.task.service.ClientService;
import com.test.task.util.Constants;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class RegistrationController {
    @Autowired
    private DozerBeanMapper dozerBeanMapper;

    @Autowired
    private ClientService clientService;

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public ModelAndView init(HttpServletRequest request) {
        if (request.getSession().getAttribute(Constants.CLIENT) != null) {
            return new ModelAndView("/" + Constants.PRIVATE_AREA);
        } else {
            ModelAndView modelAndView = new ModelAndView("/" + Constants.REGISTRATION);
            modelAndView.addObject(Constants.REGISTRATION_FORM, new RegistrationForm());
            return modelAndView;
        }
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public ModelAndView registration(@ModelAttribute("registrationForm") RegistrationForm registrationForm, HttpServletRequest request) {
        if (request.getSession().getAttribute(Constants.CLIENT) != null) {
            return new ModelAndView(Constants.PRIVATE_AREA);
        }
        List<String> errorList = new ArrayList<>();
        try {
            if (clientService.getByEmail(registrationForm.getEmail()) != null) {
                errorList.add(Constants.EXIST_USER_EMAIL);
            }
        } catch (ServiceException e) {
            e.printStackTrace();
        }
        try {
            if (clientService.getByLogin(registrationForm.getLogin()) != null) {
                errorList.add(Constants.EXIST_USER_LOGIN);
            }
        } catch (ServiceException e) {
            e.printStackTrace();
        }
        if (!errorList.isEmpty()) {
            request.setAttribute(Constants.REGISTRATION_FORM, registrationForm);
            return addErrors(errorList);
        } else {
            Client client = new Client();
            dozerBeanMapper.map(registrationForm, client, Constants.REGISTRATION_FORM_TO_CLIENT);
            try {
                client = clientService.addNewClient(client);
            } catch (ServiceException e) {
                e.printStackTrace();
            }
            ClientDto clientDto = new ClientDto();
            dozerBeanMapper.map(client, clientDto, Constants.CLIENT_TO_DTO);
            request.getSession().setAttribute(Constants.CLIENT, clientDto);
            return new ModelAndView(Constants.REDIRECT_HOME + "/" + Constants.PRIVATE_AREA);
        }
    }

    private ModelAndView addErrors(List errorList) {
        ModelAndView model = new ModelAndView("/" + Constants.REGISTRATION);
        model.addObject(Constants.ERRORS, errorList);
        return model;
    }
}
