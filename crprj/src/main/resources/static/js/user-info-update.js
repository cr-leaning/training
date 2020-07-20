/**
 * 
 */
$(function() {
	if ($('#resultCode')) {

	}
	// 初期フォーカス
	$('#id').focus();
	// 確認画面
	$('#js-confirm').bind('click', function() {
		$('#mode').val(MODE_UPDATE);
		$('#userInfoDto').submit();
	});
	// 一覧へ戻る
	$('#js-list').bind('click', function() {
		$(location).attr('href', '/userInfomation/');
	});
});