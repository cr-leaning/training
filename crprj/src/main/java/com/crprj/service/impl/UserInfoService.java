package com.crprj.service.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.crprj.common.util.CommonUtils;
import com.crprj.constants.MessageConst;
import com.crprj.enums.OpeTypeEnum;
import com.crprj.enums.ResultCodeEnum;
import com.crprj.enums.StatusEnum;
import com.crprj.model.dto.UserInfoDto;
import com.crprj.model.dto.UserInfoList;
import com.crprj.model.dto.UserInfoListDto;
import com.crprj.model.entity.UserInfo;
import com.crprj.repository.UserInfoRepository;
import com.crprj.service.IBaseService;
import lombok.extern.slf4j.Slf4j;
/**
 * 社員情報管理サービスクラス.
 * 社員管理機能のビジネスロジックを定義
 * @author y-suzuki
 *
 */
@Slf4j
@Service
@Qualifier("UserInfo")
public class UserInfoService extends BaseService
    implements IBaseService<UserInfoDto, UserInfoListDto> {

  @Autowired
  private UserInfoRepository userInfoRepository;

  /**
   * 一覧用データ取得.
   * 有効なユーザ情報を取得する
   * @param userInfoListDto 社員情報管理共通DTO
   * @return 
   */
  @Override
  public boolean getListData(UserInfoListDto userInfoListDto) {
    log.debug("getListData" + " start");

    List<UserInfo> userInfoListData = userInfoRepository.findByStatusFlg(StatusEnum.VALID.getValue());
    
    List<UserInfoList> result =
        userInfoListData.stream().collect(
            () -> new ArrayList<UserInfoList>(), (l, u) -> {
              UserInfoList ul = new UserInfoList();
              ul.setUserId(u.getUserId());
              ul.setName(u.getName());
              ul.setSeqNo(u.getSeqNo());
          l.add(ul);
        }, (l1, l2) -> l1.addAll(l2));
    
        userInfoListDto.setUserInfoList(result);
    
    log.debug("getListData" + " end");
    return true;
  }

  /**
   * データ登録
   * 
   * @param userInfoDto
   * @return
   */
  @Override
  public boolean register(UserInfoDto userInfoDto) {
    log.debug("register" + " start");
    this.saveUserInfo(userInfoDto, OpeTypeEnum.REGIST);
    log.debug("register" + " end");
    return true;
  }

  /**
   * 登録更新情報セット
   * 
   * @param userInfoDto
   * @param ope
   * @return
   */
  private UserInfo saveUserInfo(UserInfoDto userInfoDto, OpeTypeEnum ope) {
    log.debug("editEntity" + " start");
    
    UserInfo userInfo = new UserInfo();
    switch (ope) {
      case REGIST:
        // 登録時はパスワードを暗号化して設定
        userInfoDto.setPassword(userInfoDto.getPassword());
        break;
      default:
        // 更新時は最新データを取得し、パスワードは更新対象外とする
//        userInfo = userInfoRepository.findById(userInfoDto.getSeqNo());
        userInfoDto.setPassword(null);
        break;
    }

    BeanUtils.copyProperties(userInfoDto, userInfo, CommonUtils.getNullPropertyNames(userInfoDto));
    super.setEntityComItem(userInfo, ope);
    userInfoRepository.save(userInfo);
    log.debug("editEntity" + " end");
    return userInfo;
  }

  /**
   * ユーザ情報取得
   */
  @Override
  public boolean getData(UserInfoDto userInfoDto) {
    log.debug("getData" + " start");
    
    // ユーザ情報取得
    UserInfo userInfo = userInfoRepository.findBySeqNoAndStatusFlg(userInfoDto.getSeqNo(),
        StatusEnum.VALID.getValue());
    
    if (userInfo == null) {
      userInfoDto.setResultCode(ResultCodeEnum.ERROR.getValue());
      userInfoDto.setResultMessage(MessageConst.DATA_NOT_FOUND);
      return false;
    }

    // 画面DTOへセット
    userInfoDto.setUserId(userInfo.getUserId());
    userInfoDto.setName(userInfo.getName());
    userInfoDto.setPassword(userInfo.getPassword());
    log.debug("getData" + " end");
    return true;
  }

  @Override
  public boolean update(UserInfoDto userInfoDto) {
    log.debug("update" + " start");
    this.saveUserInfo(userInfoDto, OpeTypeEnum.UPDATE);
    log.debug("update" + " end");
    return false;
  }

  @Override
  public boolean delete(UserInfoDto dto) {
    log.debug("delete" + " start");
    // TODO 自動生成されたメソッド・スタブ
    log.debug("delete" + " end");
    return false;
  }
  
}
