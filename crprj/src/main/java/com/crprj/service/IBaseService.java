package com.crprj.service;

import com.crprj.model.dto.BaseDto;

public interface IBaseService<T1 extends BaseDto, T2 extends BaseDto> {
	
	/**
	 * 一覧データ取得
	 * @return
	 */
	public boolean getListData(T2 dto);

	/**
	 * 参照処理
	 * @param dto
	 * @return
	 */
	public boolean getData(T1 dto);

	/**
	 * 登録処理
	 * @param dto
	 * @return
	 */
	public boolean register(T1 dto);

	/**
	 * 更新処理
	 * @param dto
	 * @return
	 */
	public boolean update(T1 dto);

	/**
	 * 削除処理
	 * @param dto
	 * @return
	 */
	public boolean delete(T1 dto);

}
