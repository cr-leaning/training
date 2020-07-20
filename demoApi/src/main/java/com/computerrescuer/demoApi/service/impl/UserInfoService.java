package com.computerrescuer.demoApi.service.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.computerrescuer.demoApi.model.dto.UserInfoDto;
import com.computerrescuer.demoApi.model.entity.UserInfo;
import com.computerrescuer.demoApi.repository.GroupMasterRepository;
import com.computerrescuer.demoApi.repository.UserInfoRepository;
import com.computerrescuer.demoApi.service.IBaseService;
import com.computerrescuer.demoApi.util.CommonUtils;
import com.computerrescuer.demoApi.util.constants.MessageConst;
import com.computerrescuer.demoApi.util.enums.OpeTypeEnum;
import com.computerrescuer.demoApi.util.enums.ResultCodeEnum;
import com.computerrescuer.demoApi.util.enums.StatusEnum;
/**
 * ユーザ情報管理サービスクラス.
 * ユーザ情報管理機能のビジネスロジックを定義
 * @author y-suzuki
 *
 */
@Service
@Qualifier("UserInfo")
public class UserInfoService extends BaseService
    implements IBaseService<UserInfoDto> {

  @Autowired
  private UserInfoRepository userInfoRepository;
  @Autowired
  private GroupMasterRepository groupMasterRepository;

  /**
   * ユーザ情報取得
   */
  @Override
  public boolean getData(UserInfoDto userInfoDto) {
    // ユーザ情報取得
    var userInfo = userInfoRepository.findBySeqNoAndStatusFlg(userInfoDto.getSeqNo(),
        StatusEnum.VALID.getValue());
    
    if (userInfo == null) {
      // 1件取得の際に有効なデータが取得できな場合、エラー
      userInfoDto.setResultCode(ResultCodeEnum.ERROR.getValue());
      userInfoDto.setResultMessage(MessageConst.DATA_NOT_FOUND);
      return false;
    }

    // DTOへセット
    BeanUtils.copyProperties(userInfo, userInfoDto);
    // グループ情報を設定
    this.getGroupMaster(userInfoDto);

    return true;
  }

  /**
   * グループマスタ情報取得
   * @param dto
   */
  private void getGroupMaster(UserInfoDto userInfoDto) {
    if (userInfoDto.getGroupSeqNo() != null) {
      var gm = groupMasterRepository.findById(userInfoDto.getGroupSeqNo());
      gm.ifPresent(g -> {
        userInfoDto.setGroupId(g.getGroupId());
        userInfoDto.setGroupName(g.getName());
      });
    }
  }

  /**
   * 一覧用データ取得.
   * 有効なユーザ情報を取得する
   * @param userInfoDtoList ユーザ情報DTO
   * @return 
   */
  @Override
  public List<UserInfoDto> getListData() {
    var userInfoList = userInfoRepository.findByStatusFlg(StatusEnum.VALID.getValue());
    
    return userInfoList.stream().collect(
            () -> new ArrayList<UserInfoDto>(), (l, u) -> {
              var dto = new UserInfoDto();
              BeanUtils.copyProperties(u, dto);
              // グループ情報を設定
              this.getGroupMaster(dto);
          l.add(dto);
        }, (l1, l2) -> l1.addAll(l2));
  }

  /**
   * データ登録
   * 
   * @param userInfoDto
   * @return
   */
  @Override
  public boolean register(UserInfoDto userInfoDto) {
    this.saveUserInfo(userInfoDto, OpeTypeEnum.REGIST);
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
    var userInfo = new UserInfo();
    switch (ope) {
      case REGIST:
        // 登録時はパスワードを暗号化して設定
        userInfoDto.setPassword(userInfoDto.getPassword());
        break;
      default:
        // 更新時は最新データを取得し、パスワードは更新対象外とする
        var ui = userInfoRepository.findById(userInfoDto.getSeqNo());
        ui.ifPresent(u -> {
          BeanUtils.copyProperties(u, userInfo);
        });
        userInfoDto.setPassword(null);
        break;
    }

    // 連携されていないデータは更新対象外
    BeanUtils.copyProperties(userInfoDto, userInfo, CommonUtils.getNullPropertyNames(userInfoDto));
    super.setEntityComItem(userInfo, ope);
    userInfoRepository.save(userInfo);
    return userInfo;
  }

  @Override
  public boolean update(UserInfoDto userInfoDto) {
    this.saveUserInfo(userInfoDto, OpeTypeEnum.UPDATE);
    return true;
  }

  @Override
  public boolean delete(UserInfoDto userInfoDto) {
    this.saveUserInfo(userInfoDto, OpeTypeEnum.DELETE);
    return true;
  }
  
}
