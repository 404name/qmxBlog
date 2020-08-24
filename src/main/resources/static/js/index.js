//判断是否是手机

function searchThisContent(){
  alert("搜索事件");
  let searchStr = $('#searchPostArea').val();
  let nowUrl = window.location.href;
  alert(nowUrl+"?search="+searchSt);
}
function IsMobile() {
  var isMobile = {
    Android: function () {
      return navigator.userAgent.match(/Android/i);
    },
    BlackBerry: function () {
      return navigator.userAgent.match(/BlackBerry/i);
    },
    iOS: function () {
      return navigator.userAgent.match(/iPhone|iPad|iPod/i);
    },
    Windows: function () {
      return navigator.userAgent.match(/IEMobile/i);
    },
    any: function () {
      return (isMobile.Android() || isMobile.BlackBerry() || isMobile.iOS() || isMobile.Windows());
    }
  };
  return isMobile.any(); //是移动设备
}

function sideBarFun(){
  // 侧边栏导航的开合
  $("#sidebarToggle, #sidebarToggleTop").on('click', function(e) {
    $("body").toggleClass("sidebar-toggled");
    $(".sidebar").toggleClass("toggled");
    if ($(".sidebar").hasClass("toggled")) {
      $('.sidebar .collapse').collapse('hide');
    }
  });

  // 当窗口尺寸小于768px等等条件时，缩小侧边栏以及下拉菜单或者搜索栏等等
  $(window).resize(function() {

    if(IsMobile()==null){
      if ($(window).width() < 768) {
        $("body").addClass("sidebar-toggled");
        $(".sidebar").addClass("toggled");
        $('.sidebar .collapse').collapse('hide');
      }
      // 窗口尺寸小于480px等等条件时，关闭侧边栏以及下拉菜单或者搜索栏等等
      if ($(window).width() < 480 && !$(".sidebar").hasClass("toggled")) {
        $("body").addClass("sidebar-toggled");
        $(".sidebar").addClass("toggled");
        $('.sidebar .collapse').collapse('hide');
      }
      if ($(window).width() < 1000 ) {
        $(".sidebar").addClass("toggled");
      }else{
        $(".sidebar").removeClass("toggled");
      }
    }
    else{
      $("body").addClass("sidebar-toggled");
      $(".sidebar").addClass("toggled");
      $('.sidebar .collapse').collapse('hide');
    }
  });

  // 当侧边导航栏被固定的时候，防止滑动页面时出排版bug
  $('body.fixed-nav .sidebar').on('mousewheel DOMMouseScroll wheel', function(e) {
    if ($(window).width() > 768) {
      var e0 = e.originalEvent,
          delta = e0.wheelDelta || -e0.detail;
      this.scrollTop += (delta < 0 ? 1 : -1) * 30;
      e.preventDefault();
    }
  });
}

(function($) {
  "use strict";

  sideBarFun();

  // 滚动到顶部按钮的浮现
  $(document).on('scroll', function() {
    var scrollDistance = $(this).scrollTop();
    if (scrollDistance > 100) {
      $('.scroll-to-top').fadeIn();
    } else {
      $('.scroll-to-top').fadeOut();
    }
  });

  // 搭配jQuery实现返回顶部平滑的移动
  $(document).on('click', 'a.scroll-to-top', function(e) {
    var $anchor = $(this);
    $('html, body').stop().animate({
      scrollTop: ($($anchor.attr('href')).offset().top)
    }, 1000, 'easeInOutExpo');
    e.preventDefault();
  });

  // 当未读取用户名时隐藏整个用户信息
  $(function() {
    if (!$('#userName').html()) {
      $('#user-area,#newEmailButton,#newMsgButton').hide();
      $('#login-button').show();
      $('#checkIn').hide();
    }else{
      $('#checkIn').show();
      $('#login-button').hide();
    }
  });
  // 顺滑移动我要发帖跳转
  $(document).on('click', 'a.toPostDiv', function(e) {
    var $anchor = $(this);
    $('html, body').stop().animate({
      scrollTop: ($($anchor.attr('href')).offset().top)
    }, 1000, 'easeInOutExpo');
    e.preventDefault();
  });
})(jQuery);
