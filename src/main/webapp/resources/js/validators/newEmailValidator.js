$(function () {
    $("#emailChange").validate({
        rules: {
            email: {
                required: true,
                email: true
            }
        },
        messages: {
            email: {
                required: "Введите, пожалуйста, E-mail.",
                email: "Введите, пожалуйста, корректный E-mail."
            }
        },
        submitHandler: function (form) {
            form.submit();
        }
    });
});