package com.computerrescuer.demoApi.service;

import java.util.List;
import com.computerrescuer.demoApi.model.dto.BaseDto;

public interface IBaseService<T1 extends BaseDto> {
	
	/**
	 * 一覧データ取得
	 * @return
	 */
	public List<T1> getListData();

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
