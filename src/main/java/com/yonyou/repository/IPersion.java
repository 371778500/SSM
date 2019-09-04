package com.yonyou.repository;

import org.springframework.stereotype.Repository;

import com.yonyou.entity.Persion;

@Repository
public interface IPersion {
	int insert(Persion record);

	int insertSelective(Persion record);
}