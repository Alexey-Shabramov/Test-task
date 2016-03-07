package com.test.task.validator;

import org.apache.commons.lang3.StringUtils;

public class LoginValidator {
    public static boolean validateLogin(String loginOrEmail, String password) {
        return StringUtils.isNoneEmpty(loginOrEmail)
                && StringUtils.isNoneEmpty(loginOrEmail);
    }

    public static boolean validatePasswords(String enteredPassword, String password) {
        return StringUtils.equals(enteredPassword, password);
    }
}
