/**
 * 
 */
$(function(){
  var val = $.parseJSON($("#listData").val());
  $("#list").jqGrid({
    data: val,                        // データ配列
    datatype: "local",                   // ローカルのデータ
    colNames:["事業部名", "最終ユーザユーザ名", "最終更新日"], // グリッドの列名 
    colModel:[                           // グリッド列定義とデータ配列の関連付け
        {name:"groupID", index:"G\groupID", hidden:true},
        {name:"id", index:"id"},
        {name:"name", index:"name"},
        {name:"updDate", index:"updDate"},
    ],
    rowNum : 10,                   //一ページに表示する行数
    rowList : [10, 20, 50],         //変更可能な1ページ当たりの行数
    multiselect: false,                  // 行の複数選択はしない（単一選択）
    caption: "事業部一覧",                   // グリッドのタイトル
    pager : "pager",              //footerのページャー要素のid
    shrinkToFit : true,
    viewrecords: true,              //footerの右下に表示する。
    // ダブルクリック
    ondblClickRow: function(rowId) {
    	var data = jQuery(this).getRowData(rowId);
    	location.href = '/userInfomation/refer?id=' + data.seqNo;
    	}
  }); 
});