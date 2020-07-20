/**
 * 
 */
$(function() {
	var val = $.parseJSON($("#userInfoListData").val());
	$("#userInfoList").jqGrid({
		data : val, // データ配列
		datatype : "local", // ローカルのデータ
		colModel : [ // グリッド列定義とデータ配列の関連付け
		{
			name : "seqNo",
			index : "seqNo",
			label : "seqNo",
			hidden : true
		}, {
			name : "chk",
			index : "chk",
			template : "checkboxFontAwesome4"
		}, {
			name : "userId",
			index : "userId",
			label : "ユーザID"
		}, {
			name : "name",
			index : "name",
			label : "ユーザ名"
		}, {
			name : "group",
			index : "group",
			label : "所属部署"
		}, {
			name : "position",
			index : "position",
			label : "肩書"
		}, {
			name : "title",
			index : "title",
			label : "役職"
		}, {
			name : "updDate",
			index : "updDate",
			label : "最終更新日",
			sorttype : "date",
			formatter : "date",
			formatoptions : {
				newformat : "y-M-d G:i:s"
			}
		}, ],
		rowNum : 30, // 一ページに表示する行数
		rowList : [ 30, 50, 100 ], // 変更可能な1ページ当たりの行数
		multiselect : false, // 行の複数選択はしない（単一選択）
		caption : "社員情報", // グリッドのタイトル
		hidegrid : false, // グリッドタイトルのボタンを表示しない
		responsive : true,
		pager : "pager", // footerのページャー要素のid
		shrinkToFit : true, // 各5列がグリッドの横幅に合わせて自動調整
		viewrecords : true, // footerの右下に表示する。
		guiStyle : "bootstrap4", // デザインはBootstrapを使用
		iconSet : "fontAwesome", // アイコン系はfontAwesomeを使用
		rownumbers : true, // 行番号を使用
		sortname : "updDate", // 更新日でソート
		sortorder : "desc", // 降順で表示
		threeStateSort : true, // 3回クリックでソートoff
		sortIconsBeforeText : true, // ソートは項目名の前
		multiSort : true, // マルチソート
		// ダブルクリック
		ondblClickRow : function(rowId) {
			var data = jQuery(this).getRowData(rowId);
			window.location.href = '/userInfomation/refer?id=' + data.seqNo;
			// window.open().location.href = '/userInfomation/refer?id=' +
			// data.seqNo;
		}
	}).jqGrid("filterToolbar");
});

$(window).load(function() {
	//TODO 表をFitさせるためにオンロード入れてみたが聞かなかった、、、
	$('#userInfoList').trigger('reloadGrid');
});
