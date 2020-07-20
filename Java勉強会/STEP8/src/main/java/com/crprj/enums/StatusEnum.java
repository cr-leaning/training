package com.crprj.enums;

public enum StatusEnum {
  /** 列挙定数の定義 */
  VALID(0),
  INVALID(9);

  /** フィールド変数 */
  private int value;

  /** コンストラクタ */
  StatusEnum(int value) {
    this.value = value;
  }

  /** 値取得メソッド */
  public int getValue() {
    return this.value;
  }

  // 逆引きするメソッド
  public static StatusEnum getEnum(int value) {
    // values() で、列挙したオブジェクトをすべて持つ配列が得られる
    for (StatusEnum en : values()) {
      if (en.getValue() == value) { // 一致するものを探す
        return en;
      }
    }
    throw new IllegalArgumentException("no such enum object for the id: " + value);
    // Null-Object パターンにしたがって、列挙に UNKNOWN みたいなのを入れておくのも良い
    // return UNKNOWN;
  }
}
