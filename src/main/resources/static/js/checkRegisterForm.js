//输入的邮箱 $('#inputEmail').val()
// 输入的验证码 $('#inputCode').val()
// 输入的真实姓名 $("#realName").val()
// 输入的学号 $("#schoolID").val()
// 输入的密码 $("#inputPassword").val()
// 重复输入的密码 $("#repeatPassword").val()
// let ID = $("#schoolID").val();
// let email = $('#inputEmail').val();
// let verificationCode = $('#inputCode').val();
// let password = $("#inputPassword").val();
// let repeatPassword = $("#repeatPassword").val();

let judgeName = /^[\u4e00-\u9fa5]{2,}$/;
let judgeMail = /^(?:[a-zA-Z0-9]+[_\-\+\.]?)*[a-zA-Z0-9]+@(?:([a-zA-Z0-9]+[_\-]?)*[a-zA-Z0-9]+\.)+([a-zA-Z]{2,})+$/;
let judgeID = /^((201([0-9]))|(2020))+([0-9]{4})+(0[1-9])|([1-9][0-9])+$/;
let judgeIDFormat = /^[0-9]{10}$/;
let weekPassword = /^(?:\d+|[a-zA-Z]+|[!@#$%^&*]+)$/;
let ordinaryPassword = /^(?![a-zA-z]+$)(?!\d+$)(?![!@#$%^&*]+$)[a-zA-Z\d!@#$%^&*]+$/;
let strongPassword = /^(?![a-zA-z]+$)(?!\d+$)(?![!@#$%^&*]+$)(?![a-zA-z\d]+$)(?![a-zA-z!@#$%^&*]+$)(?![\d!@#$%^&*]+$)[a-zA-Z\d!@#$%^&*]+$/;
let passwordLength = /^.{6,}$/;
// 真实姓名验证信息 $('#realNameCheck')
// 学号验证信息 $('#IdCheck')
// 邮箱验证信息 $('#emailCheck')
// 验证码验证信息 $('#verificationCodeCheck')
// 密码验证信息 = $('#passwordCheck')
// 重复输入的密码验证信息 = $('#repeatPasswordCheck')

let flag = [false,false,false,false,false,false];
function checkFormValidAll() {
    checkRealName();
    checkID();
    checkEmail();
    checkVerificationCode();
    checkPassword();
    checkRepeatPassword();
    for (let i=0;i<flag.length;i++){
        if (!flag[i])
            return false;
    }
    //alert("提交通过");
    return true;
}
function checkRealName(){
    let realName = $('#realName').val();
    if(realName===""){
        $('#realNameCheck').addClass("d-block").removeClass("d-none").text("姓名不能为空");
        flag[0]=false;
    }
    else if(!judgeName.test(realName)){
        $('#realNameCheck').addClass("d-block").removeClass("d-none").text("您输入的姓名有误");
        flag[0]=false;
    }
    else {
        setTimeout(function () {
            $('#realNameCheck').addClass("d-none").removeClass("d-block");
        },300);
        flag[0]=true;
    }
}

function checkID(){
    let ID = $('#schoolID').val();
    if(ID===""){
        $('#IdCheck').addClass("d-block").removeClass("d-none").text("学号不能为空");
        flag[1]=false;
    }
    else if(!judgeIDFormat.test(ID) || !judgeID.test(ID)){
        $('#IdCheck').addClass("d-block").removeClass("d-none").text("您输入的学号有误");
        flag[1]=false;
    }
    else {
        setTimeout(function () {
            $('#IdCheck').addClass("d-none").removeClass("d-block");
        },300);
        flag[1]=true;
    }
}

function checkEmail(){
    let email = $('#inputEmail').val();
    if(email===""){
        $('#emailCheck').addClass("d-block").removeClass("d-none").text("邮箱不能为空");
        $("#sendEmailBtn").attr({"disabled":"disabled"});
        $("#returnMsg").html("请先填写您的邮箱");
        flag[2]=false;
    }
    else if(!judgeMail.test(email)){
        $('#emailCheck').addClass("d-block").removeClass("d-none").text("您输入的邮箱有误");
        $("#sendEmailBtn").attr({"disabled":"disabled"});
        $("#returnMsg").html("请先填写您的邮箱");
        flag[2]=false;
    }
    else {
        $('#sendEmailBtn').removeClass("btn-info btn-success btn-danger").addClass("btn-primary").removeAttr("disabled");
        $('#sendEmailIcon').html('<i class="fa fa-envelope"></i>');
        $("#returnMsg").html("通过邮箱发送验证码");
        setTimeout(function () {
            $('#emailCheck').addClass("d-none").removeClass("d-block");
        },300);
        flag[2]=true;
    }
}

function checkVerificationCode(){
    let verificationCode = $('#inputCode').val();
    if(verificationCode===""){
        $('#verificationCodeCheck').addClass("d-block").removeClass("d-none").text("请填写邮箱中的验证码");
        flag[3]=false;
    }
    else {
        setTimeout(function () {
            $('#verificationCodeCheck').addClass("d-none").removeClass("d-block");
        },300);
        flag[3]=true;
    }
}

function checkPassword(){
    let password = $('#inputPassword').val();
    if(password===""){
        $('#passwordCheck').addClass("d-block").removeClass("d-none").text("密码不能为空");
        $('#passwordTestDiv').addClass("d-none").removeClass("d-block");
        flag[4]=false;
    }
    else if (!passwordLength.test(password)){
        $('#passwordCheck').addClass("d-block").removeClass("d-none").text("密码长度不符合要求");
        $('#passwordTestDiv').addClass("d-none").removeClass("d-block");
        flag[4]=false;
    }
    else {
        setTimeout(function () {
            $('#passwordTestDiv').addClass("d-block").removeClass("d-none");
            $('#passwordCheck').addClass("d-none").removeClass("d-block");
        },300);
        flag[4]=true;
    }
}
function checkRepeatPassword(){
    let password = $('#inputPassword').val();
    let repeatPassword = $('#repeatPassword').val();
    if(repeatPassword===""){
        $('#repeatPasswordCheck').addClass("d-block").removeClass("d-none").text("重复密码不能为空");
        flag[5]=false;
    }
    else if (password!==repeatPassword){
        $('#repeatPasswordCheck').addClass("d-block").removeClass("d-none").text("两次输入的密码不对应");
        flag[5]=false;
    }
    else {
        setTimeout(function () {
            $('#repeatPasswordCheck').addClass("d-none").removeClass("d-block");
        },300);
        flag[5]=true;
    }
}

