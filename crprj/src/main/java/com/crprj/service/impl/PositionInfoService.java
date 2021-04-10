package com.crprj.service.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.crprj.constants.MessageConst;
import com.crprj.enums.OpeTypeEnum;
import com.crprj.enums.ResultCodeEnum;
import com.crprj.enums.StatusEnum;
import com.crprj.model.dto.UserInfoList;
import com.crprj.model.entity.PositionInfo;
import com.crprj.service.IBaseService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@Qualifier("PositionInfo")
public class PositionInfoServise extends BaseService
    implements IBaseService<PositionInfoDto, PositionInfoListDto> {

  @Autowired
  private PositionInfoRepository positionInfoRepository;

  *//**
   * 一覧用データ取得
   * 
   * @return
   *//*
  @Override
  public boolean getListData(PositionInfoListDto positionInfoListDto) {
    log.debug("getListData start");
    List<PositionInfo> positionInfoListData = positionInfoRepository.findByStatusFlg(StatusEnum.VALID.getValue());
    
    List<PositionInfoList> result =
        positionInfoListData.stream().collect(
            () -> new ArrayList<UserInfoList>(), (l, u) -> {
              PositionInfoList ul = new PositionInfoList();
              ul.setPositionMei(u.getPositionMei());
              ul.setPositionAllowance(u.getPositionAllowance());
              ul.setPositionId(u.getPositionId());
          l.add(ul);
        }, (l1, l2) -> l1.addAll(l2));
    
    positionInfoListDto.setPositionInfoList(result);
    
    return true;
  }

  *//**
   * データ登録
   * 
   * @param positionInfoDto
   * @return
   *//*
  @Override
  public boolean register(PositionInfoDto positionInfoDto) {
    positionInfoRepository.save(this.editEntity(positionInfoDto, OpeTypeEnum.REGISTER));
    return true;
  }

  *//**
   * 登録更新情報セット
   * 
   * @param positionInfoDto
   * @param ope
   * @return
   *//*
  private PositionInfo editEntity(PositionInfoDto positionInfoDto, OpeTypeEnum ope) {
    PositionInfo positionInfo = new PositionInfo();

    positionInfo.PositionMei(positionInfoDto.getPositionMei());
    positionInfo.PositionAllowance(positionInfoDto.getPositionAllowance());
    positionInfo.setPositionId(positionInfoDto.getPositionId());
    super.setEntityComItem(positionInfo, ope);
    return positionInfo;
  }

  *//**
   * 役職情報取得
   *//*
  @Override
  public boolean getData(PositionInfoDto positionInfoDto) {
    
    // ユーザ情報取得
    PositionInfo ｐositionInfo = positionInfoRepository.findBySeqNoAndStatusFlg(positionInfoDto.getPositionId(),
        StatusEnum.VALID.getValue());
    
    if (PositionInfo == null) {
      positionInfoDto.setResultCode(ResultCodeEnum.ERROR.getValue());
      positionInfoDto.setResultMessage(MessageConst.DATA_NOT_FOUND);
      return false;
    }

    // 画面DTOへセット
    positionInfoDto.setPositionMei(ｐositionInfo.getPositionMei());
    positionInfoDto.setPositionAllowance(ｐositionInfo.getPositionAllowance());
    positionInfoDto.setPositionId(ｐositionInfo.getPositionId());
    return true;
  }

  @Override
  public boolean update(PositionInfoDto dto) {
    // TODO 自動生成されたメソッド・スタブ
    return false;
  }

  @Override
  public boolean delete(PositionInfoDto dto) {
    // TODO 自動生成されたメソッド・スタブ
    return false;
  }

}
