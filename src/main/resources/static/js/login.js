
function u_login() {
    var phone = $('#userPhone').val();
    var password = $('#userPassword').val();
    var data = "phone=" + phone + "&password=" + password;
    if ($('#remeberMe').is(':checked')) {
        data += "&rememberMe=" + 6000;
    }
    $.ajax({

        url: "user/login.do",
        data: data,
        methos: "POST",
        success: function (result) {
            if (result.ok) {
                location.href = "personaldata.html";
            }
            else {
                $('#userPhone').attr('data-content', '电话号或密码错误');
                $("#userPhone").popover('show');
            }

        }


    })

}

