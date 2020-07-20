package com.crprj.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crprj.model.entity.UserInfo;

public interface UserInfoRepository extends JpaRepository<UserInfo, Integer> {

}
