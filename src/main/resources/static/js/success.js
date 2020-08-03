let pathTemp = "<%=path%>/img/avatar/icon";
let avatars = document.getElementsByClassName("avatar");
function showAvatar() {
}
(function () {
    for (let i = 1; i<=avatars.length ;i++){
        avatars.item(i-1).src = pathTemp + (Math.round(Math.random() * 19) + 1) + ".png";
    }
}())