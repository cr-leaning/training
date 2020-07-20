package com.computerrescuer.demoApi.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import com.computerrescuer.demoApi.model.entity.GroupMaster;
import com.computerrescuer.demoApi.util.constants.UrlConst;

/**
 * グループマスタエンティティクラス
 * @author YS
 *
 */
@RepositoryRestResource(path = UrlConst.GROUP_MST)
public interface GroupMasterRepository extends PagingAndSortingRepository<GroupMaster, Integer> {

}
