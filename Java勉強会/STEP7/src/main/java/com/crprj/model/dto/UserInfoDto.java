package com.crprj.model.dto;

/**
 * ユーザ情報画面用DTO
 * @author YS
 *
 */
public class UserInfoDto extends BaseDto {

  /** ユーザID */
  private String id;

  /** ユーザ名 */
  private String name;

  /** パスワード */
  private String password;
  
  /** ユーザID setter */
  public void setId(String id) {
    this.id = id;
  }
  
  /** ユーザID getter */
  public String getId() {
    return this.id;
  }
  
  /** ユーザ名 setter */
  public void setName(String name) {
    this.name = name;
  }
  
  /** ユーザ名 getter */
  public String getName() {
    return this.name;
  }
  
  /** パスワード setter */
  public void setPassword(String password) {
    this.password = password;
  }
  
  /** パスワード getter */
  public String getPassword() {
    return this.password;
  }
  
}
