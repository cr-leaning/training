/**
 * 
 */
$(function(){
  var val = $.parseJSON($("#listData").val());
  $("#list").jqGrid({
    data: val,                        // データ配列
    datatype: "local",                   // ローカルのデータ
    colNames:["ユーザID", "ユーザ名", "最終更新日"], // グリッドの列名 
    colModel:[                           // グリッド列定義とデータ配列の関連付け
        {name:"id", index:"id"},
        {name:"name", index:"name"},
        {name:"updDate", index:"updDate"},
    ],
    rowNum : 10,                   //一ページに表示する行数
    rowList : [10, 20, 50],         //変更可能な1ページ当たりの行数
    multiselect: false,                  // 行の複数選択はしない（単一選択）
    caption: "ユーザ一覧",                   // グリッドのタイトル
    pager : "pager",              //footerのページャー要素のid
    shrinkToFit : true,
    viewrecords: true              //footerの右下に表示する。
  }); 
});