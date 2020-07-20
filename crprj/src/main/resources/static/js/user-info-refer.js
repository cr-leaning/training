/**
 * 
 */
$(function() {
	// 一覧へ戻る
	$('#js-list').bind('click', function() {
		$(location).attr('href', '/userInfomation/');
	});
	// 更新画面遷移
	$('#js-update').bind('click', function() {
		var url = '/userInfomation/update?id=' + getParam('id');
		$(location).attr('href', url);

		// var id =getParam('id');
		// $(location).attr('href','/userInfomation/');
		// $.ajax({
		// url: '/userInfomation/update',
		// type:'GET',
		// dataType: 'json',
		// data : {'id' : id },
		// async: false,
		// }).done(function(userInfoDto) {
		// $('#userInfoDto').val(userInfoDto);
		// }).fail(function(XMLHttpRequest, textStatus, errorThrown) {
		// alert("error");
		// })
	});

});