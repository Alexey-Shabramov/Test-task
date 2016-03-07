package com.test.task.controller;

import com.test.task.controller.form.PasswordForm;
import com.test.task.controller.form.PrivateInfoForm;
import com.test.task.dto.ClientDto;
import com.test.task.entity.Client;
import com.test.task.exception.ServiceException;
import com.test.task.service.ClientService;
import com.test.task.util.Constants;
import com.test.task.util.PasswordUtil;
import com.test.task.validator.PrivateAreaValidator;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
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
public class ClientController {
    private final static Logger log = Logger.getLogger(ClientController.class);
    @Autowired
    private ClientService clientService;

    @Autowired
    private DozerBeanMapper dozerBeanMapper;

    @RequestMapping(value = "/changePassword", method = RequestMethod.POST)
    public ModelAndView changePassword(@ModelAttribute("passwordForm") PasswordForm passwordForm, HttpServletRequest request) {
        if (request.getSession().getAttribute(Constants.CLIENT) != null) {
            List<String> errorList = new ArrayList<>();
            if (!StringUtils.isNotBlank(passwordForm.getOldPassword())) {
                errorList.add(Constants.OLD_PASSWORD_IS_EMPTY);
            } else if (!StringUtils.equals(((ClientDto) request.getSession().getAttribute(Constants.CLIENT)).getPassword(), PasswordUtil.encryptPassword(passwordForm.getOldPassword()))) {
                errorList.add(Constants.OLD_PASSWORD_NOT_EQUAL);
            }
            if (!StringUtils.isNotBlank(passwordForm.getPassword())
                    || !StringUtils.isNotBlank(passwordForm.getSecondaryPassword())) {
                errorList.add(Constants.NEW_PASSWORDS_FIELD_IS_EMPTY);
            } else if (!StringUtils.equals(passwordForm.getPassword(), passwordForm.getSecondaryPassword())) {
                errorList.add(Constants.PASSWORDS_NOT_EQUALS);
            }
            if (!errorList.isEmpty()) {
                return addErrors(errorList);
            } else {
                Client client = null;
                try {
                    client = clientService.changePassword(((ClientDto) request.getSession().getAttribute(Constants.CLIENT)).getId(), passwordForm.getPassword());
                } catch (ServiceException e) {
                    e.printStackTrace();
                }
                ClientDto clientDto = (ClientDto) request.getSession().getAttribute(Constants.CLIENT);
                dozerBeanMapper.map(client, clientDto, Constants.PASSWORD_CHANGE);
                request.getSession().setAttribute(Constants.CLIENT, clientDto);
                return new ModelAndView(Constants.REDIRECT_HOME + "/" + Constants.PRIVATE_AREA);
            }
        }
        return new ModelAndView(Constants.REDIRECT_HOME + "/" + Constants.PASSWORD_CHANGE_IMPOSIBLE);
    }

    @RequestMapping(value = "/savePersonSettings", method = RequestMethod.POST)
    public ModelAndView savePersonSettings(@ModelAttribute("privateInfoForm") PrivateInfoForm privateInfoForm, HttpServletRequest request) {
        if (request.getSession().getAttribute(Constants.CLIENT) != null) {
            ClientDto clientDto = (ClientDto) (request.getSession().getAttribute(Constants.CLIENT));
            clientDto.setName(privateInfoForm.getName());
            Client client = new Client();
            dozerBeanMapper.map(clientDto, client, Constants.CHANGE_PRIVATE_INFO);
            client.setId(clientDto.getId());
            try {
                clientService.save(client);
            } catch (ServiceException e) {
                e.printStackTrace();
            }
            request.getSession().setAttribute(Constants.CLIENT, clientDto);
        }
        return new ModelAndView(Constants.REDIRECT_HOME + "/" + Constants.PRIVATE_AREA);
    }

    @RequestMapping(value = "/changeEmail", method = RequestMethod.POST)
    public ModelAndView changeEmail(@ModelAttribute("email") String email, HttpServletRequest request) {
        if (request.getSession().getAttribute(Constants.CLIENT) != null) {
            System.out.println(email);
            List<String> errorList = new ArrayList<>();
            if (!PrivateAreaValidator.validateEmail(email)) {
                errorList.add(Constants.EMAIL_IS_NOT_CORRECT);
            } else if (StringUtils.equals(((ClientDto) (request.getSession().getAttribute(Constants.CLIENT))).getEmail(), email)) {
                errorList.add(Constants.EMAIL_MUST_NOT_EQUAL_TO_CURRENT);
            } else try {
                if (clientService.getByEmail(email) != null) {
                    errorList.add(Constants.EMAIL_IS_ALREADY_EXISTS);
                }
            } catch (ServiceException e) {
                e.printStackTrace();
            }
            if (!errorList.isEmpty()) {
                return addErrors(errorList);
            } else {
                ClientDto clientDto = (ClientDto) request.getSession().getAttribute(Constants.CLIENT);
                clientDto.setEmail(email);
                Client client = new Client();
                dozerBeanMapper.map(clientDto, client, Constants.CHANGE_PRIVATE_EMAIL);
                client.setId(clientDto.getId());
                try {
                    clientService.save(client);
                } catch (ServiceException e) {
                    e.printStackTrace();
                }
                request.getSession().setAttribute(Constants.CLIENT, clientDto);
                return new ModelAndView(Constants.REDIRECT_HOME + "/" + Constants.PRIVATE_AREA);
            }
        }
        return new ModelAndView("/" + Constants.INDEX);
    }

    private ModelAndView addErrors(List errorList) {
        ModelAndView model = new ModelAndView("/" + Constants.PRIVATE_AREA);
        model.addObject(Constants.ERRORS, errorList);
        return model;
    }
}
