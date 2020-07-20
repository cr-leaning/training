package com.crprj.enums;

public enum OpeTypeEnum {
  /** 列挙定数の定義 */
  REFER("0"),
  REGIST("1"),
  UPDATE("2"),
  DELETE("3");

  /** フィールド変数 */
  private String value;

  /** コンストラクタ */
  OpeTypeEnum(String value) {
    this.value = value;
  }

  /** 値取得メソッド */
  public String getValue() {
    return this.value;
  }

  // 逆引きするメソッド
  public static OpeTypeEnum getEnum(String value) {
    if (value == null) return null;
    // values() で、列挙したオブジェクトをすべて持つ配列が得られる
    for (OpeTypeEnum en : values()) {
      if (en.getValue().equals(value)) { // 一致するものを探す
        return en;
      }
    }
    throw new IllegalArgumentException("no such enum object for the id: " + value);
    // Null-Object パターンにしたがって、列挙に UNKNOWN みたいなのを入れておくのも良い
    // return UNKNOWN;
  }
}
