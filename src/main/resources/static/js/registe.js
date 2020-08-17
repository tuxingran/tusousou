function reg() {

    if (checkphone() && checkemail() && checkfinpassword() && checkpassword()) {


        var phone = $("#r_phone").val();
        var password = $("#r_password").val();
        var yanzheng = $("#yanzhengm").val();
        var email = $('#r_email').val();
        $.ajax({
            url: "user/add.do",
            data: "phone=" + phone + "&password=" + password + "&yanzheng=" + yanzheng + "&e_mail=" + email,
            method: "POST",
            success: function (result) {
                if (result.ok) {
                    location.href = "login.html";
                } else if (result.msg == '1') {
                    $('#yanzhengm').attr('data-content', '验证码错误');
                    $("#yanzhengm").popover('show');
                } else if (result.msg == "2") {
                    $('#r_phone').attr('data-content', '此电话号已被注册');
                    $("#r_phone").popover('show');
                } else if (result.msg == "3") {
                    $('#r_email').attr('data-content', '此邮箱已被注册');
                    $("#r_email").popover('show');
                }

            }

        })
    }


}

function bianji() {

    $("#xiugainame").val("asdasdasd")

}

function yanzhengma() {
    alert("asd");
    var email = $("#r_email").val();
    $.ajax({
        url: "user/yanzheng.do",
        data: "path=" + email,
        method: "POST",
        success: function (result) {
            if (result.ok) {
                $('#yanzhengm').attr('data-content', '验证码已发送，请打开邮箱查收');
                $("#yanzhengm").popover('show');

            } else {
                $('#yanzhengm').attr('data-content', '发送验证失败，无效邮箱');
                $("#yanzhengm").popover('show');
            }
        }
    })
}

function checkphone() {


    var r_phone = $('#r_phone').val();
    var myreg = /^[1][3,4,5,7,8][0-9]{9}$/;
    if (!myreg.test(r_phone)) {
        $('#r_phone').attr('data-content', '号码必须为11为数字');
        $("#r_phone").popover('show');
        return false;
    } else {
        return true;
    }


}

function checkpassword() {
    var r_password = $('#r_password').val();
    if (r_password.length < 6) {
        $('#r_password').attr('data-content', '密码必须要大于六位');
        $("#r_password").popover('show');
        return false;
    } else {
        return true;
    }


}

function checkfinpassword() {
    var finpassword = $('#r_finpassword').val();
    var password = $('#r_password').val();
    if (finpassword != password) {
        $('#r_finpassword').attr('data-content', '两次密码不一致');
        $("#r_finpassword").popover('show');
        return false;
    }
    return true;

}

function checkemail() {
    var email = $('#r_email').val();
    var reg = /^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\.[a-zA-Z0-9_-]+)+$/;
    if (!reg.test(email)) {
        $('#r_email').attr('data-content', '邮箱格式不正确');
        $('#r_email').popover('show')
        return false;
    }

    return true;

}

