$(function () {
    $("#register-form").validate({
        rules: {
            login: {
                required: true
            },
            email: {
                required: true,
                email: true
            },
            password: {
                required: true,
                minlength: 6
            },
            secondaryPassword: {
                required: true,
                minlength: 6,
                equalTo: "#password"
            },
        },
        messages: {
            login: {
                required: "Введите логин!."
            },
            password: {
                required: "Введите, пожалуйста, пароль.",
                minlength: "Длина пароля не менее 6 символов."
            },
            secondaryPassword: {
                required: "Введите, пожалуйста, пароль.",
                minlength: "Длина пароля не менее 6 символов.",
                equalTo: "Пароли не совпадают. Повторите ввод."
            },
            email: {
                required: "Введите, пожалуйста, E-mail.",
                email: "Введите, пожалуйста, корректный E-mail."
            },

        },
        submitHandler: function (form) {
            form.submit();
        }
    });
});
