/**
 * 
 */
$(function() {
	$('#js-back').bind('click', function() {
		$('#userInfoDto').attr('action', '/userInfomation/back');
		$('#userInfoDto').submit();
	});

	switch ($('#mode').val()) {
	case MODE_REGIST:
		$('#js-register').show();
		$('#passwordPanel').show();
		$('#js-register').bind('click', function() {
			$('#userInfoDto').submit();
		});
		break;
	case MODE_UPDATE:
		$('#js-update').show();
		$('#js-update').bind('click', function() {
			$('#userInfoDto').submit();
		});
		break;
	default:
		break;
	}
});