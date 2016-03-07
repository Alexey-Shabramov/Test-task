package com.test.task.controller.form;

import java.util.Date;

public class RegistrationForm {
    private String login;
    private String email;
    private String name;
    private String password;
    private String secondaryPassword;
    private Date registrationDate = new Date();

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSecondaryPassword() {
        return secondaryPassword;
    }

    public void setSecondaryPassword(String secondaryPassword) {
        this.secondaryPassword = secondaryPassword;
    }

    public Date getRegistrationDate() {
        return new Date(registrationDate.getTime());
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = new Date(registrationDate.getTime());
    }
}
