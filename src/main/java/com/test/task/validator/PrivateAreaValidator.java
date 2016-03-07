package com.test.task.validator;

import org.apache.commons.lang3.StringUtils;

import java.util.regex.Pattern;

public class PrivateAreaValidator {
    private static final String EMAIL_PATTERN =
            "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                    + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    private static Pattern emailPattern = Pattern.compile(EMAIL_PATTERN);

    public static boolean validateEmail(final String email) {
        return StringUtils.isNotEmpty(email)
                && emailPattern.matcher(email).matches();
    }

    public static boolean validateNewPassword(String oldPassword, String newPassword, String newSecondaryPassword) {
        return StringUtils.isNotEmpty(newPassword)
                && StringUtils.isNotEmpty(oldPassword)
                && StringUtils.isNotEmpty(newSecondaryPassword)
                && StringUtils.equals(newPassword, newSecondaryPassword);
    }
}
