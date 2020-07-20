/**
 * 
 */
$(function(){
  $('#js-register').bind('click', function(){
    $('#userInfoDto').submit();
  });

  $('#js-back').bind('click', function(){
    $('#userInfoDto').attr('action', '/userInfomation/back');
    $('#userInfoDto').submit();
  });
});