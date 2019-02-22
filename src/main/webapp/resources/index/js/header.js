$(document).ready(function () {
      $(".navbar-nav li a").on('click', function (event) {
        $('.navbar-nav li ').removeClass('active');
        $(this).closest('li').addClass('active');
      });
      $(".navbar-collapse a").on('click', function () {
        $(".navbar-collapse.collapse").removeClass('in');
      });
      $('.navbar-toggler').click(() => {
          $('#header-top').css("background", "rgba(0, 0,0, 0.8)");
          $('#header-top a').css("color", "#fff");    
        });
        $('.nav-item').click(() => {
          $('#header-top').css("background", "rgba(0, 0,0, 0.8)");
          $('#header-top a').css("color", "#fff");    
        });
        $(window).on('scroll', function () {
            if ($(window).scrollTop()) {
              $('#header-top').css("background", "rgba(0, 0,0, 0.8)");
              $('#header-top a').css("color", "#fff");
            }
            else {
              $('#header-top').css("background", "");
              $('#header-top a').css("color", "black");
            }
          });
    });
   
