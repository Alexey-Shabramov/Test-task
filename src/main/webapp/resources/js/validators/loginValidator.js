$(function () {
    $("#loginForm").validate({
        rules: {
            loginOrEmail: {
                required: true
            },

            password: {
                required: true,
                minlength: 6
            }
        },
        messages: {
            loginOrEmail: {
                required: "Поле ника или email не должно быть пустым."
            },

            password: {
                required: "Введите, пожалуйста, пароль.",
                minlength: "Длина пароля не менее 6 символов."
            }
        },
        submitHandler: function (form) {
            form.submit();
        }
    });
});