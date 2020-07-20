package com.computerrescuer.demoApi.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.computerrescuer.demoApi.model.entity.UserInfo;

public interface UserInfoRepository extends JpaRepository<UserInfo, Integer> {

  /** 一覧情報取得 */
  List<UserInfo> findByStatusFlg(int statusFlg);

  /** ユーザ情報取得 */
  UserInfo findBySeqNoAndStatusFlg(int seqNo, int statusFlg);

}
