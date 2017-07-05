package com.yonyou.repository.test;

import org.springframework.stereotype.Repository;

import com.yonyou.entity.test.Persion;

@Repository
public interface IPersion {
	int insert(Persion record);

	int insertSelective(Persion record);
}