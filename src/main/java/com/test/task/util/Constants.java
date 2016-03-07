package com.test.task.util;

public class Constants {

    /**
     * JSP pre-desing pages(locations)
     */
    public static final String INDEX = "index";
    public static final String LOGIN = "login";
    public static final String PRIVATE_AREA = "privateArea";
    public static final String REGISTRATION = "registration";
    public static final String ADMIN_PANEL = "adminPanel";
    public static final String REDIRECT_HOME = "redirect:";
    public static final String ERRORS = "errors";

    /**
     * Entities and session attributes names
     */
    public static final String CLIENT = "client";
    public static final String CLIENT_STATS = "clientStats";
    public static final String REGISTRATION_FORM = "registrationForm";
    public static final String PASSWORD_FORM = "passwordForm";
    public static final String PRIVATE_INFO_FORM = "privateInfoForm";

    /**
     * Errors and exception messages names
     */
    public static final String EMPTY_FIELD = "Обязательное поле - пустое. Проверьте Ваши поля и повторите ввод.";
    public static final String PASSWORDS_NOT_EQUALS = "Ваши пароли не совпадают, проверьте правильность ввода.";
    public static final String EXIST_USER_EMAIL = "Пользователь с таким email и паролем уже существует. Выберите другой email.";
    public static final String EXIST_USER_LOGIN = "Пользователь с таким ником уже зарегестрирован. Выберите другой ник.";
    public static final String PASSWORD_IS_INCORRECT = "Введён неверный пароль. Проверьте правильность ввода пароля.";
    public static final String CLIENT_NOT_EXISTS = "Пользователя с таким ником или email-ом не существует.";
    public static final String PASSWORD_CHANGE_IMPOSIBLE = "Не удалось изменить пароль. Проверьте правильность ввода.";
    public static final String CHECK_YOUR_PASSWORDS = "Ошибка. Проверьте правильность введённых паролей и повторите попытку.";
    public static final String EMAIL_IS_NOT_CORRECT = "Введённый вами email неправильный. Проверьте правильность и попробуйте заново.";
    public static final String EMAIL_IS_ALREADY_EXISTS = "Такой email уже существует. Выберите другой.";
    public static final String OLD_PASSWORD_NOT_EQUAL = "Старый пароль не совпадает.";
    public static final String OLD_PASSWORD_IS_EMPTY = "Поле со старым паролем пустое.";
    public static final String NEW_PASSWORDS_FIELD_IS_EMPTY = "Поле с новым паролем пустое.";
    public static final String EMAIL_MUST_NOT_EQUAL_TO_CURRENT = "Новый email не должен совпадать с текущим.";

    /**
     * Dozer mapping names
     */
    public static final String DTO_TO_CLIENT = "dtoToClient";
    public static final String PASSWORD_CHANGE = "passwordChange";
}
