
function loginCheck() {
    alert("检测用户密码");
    $.post({
        url:"/user/loginCheck",//请求地址
        data:{
            "usesrname": $('#inputAccount').val(),
            "password": $('#inputPassword').val()
            //传参
        },
        function(data,status){
            alert("数据：\n"+data+"\n状态"+status);
        }
    });
}