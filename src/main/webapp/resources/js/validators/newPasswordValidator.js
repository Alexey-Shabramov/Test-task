$(function () {
    $.validator.setDefaults({ignore: ":hidden:not(select)"})
    $("#newPasswordSave").validate({
        rules: {
            oldPassword: {
                required:true
            },
            password: {
                required: true
            },
            secondaryPassword: {
                required: true,
                equalTo: "#password"
            }
        },

        messages: {
            oldPassword: {
                required: "Область пароля пуста. Введите Ваш старый пароль."
            },
            password: {
                required: "Область пароля пуста. Введите Ваш новый пароль.",
                minlength: "Пароль, должен быть не меньше 5 символов."
            },
            secondaryPassword: {
                required: "Введите пароль повторно.",
                equalTo: "Пароли не совпадают. Повторите ввод."
            }
        },
        submitHandler: function (form) {
            form.submit();
        }
    });
});

