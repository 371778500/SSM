package com.yonyou.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yonyou.entity.Persion;
import com.yonyou.repository.IPersion;

@Service
public class TestPersionService {
	@Resource
	private IPersion persion;

	public int insertPersion(Persion record) {
		return persion.insertSelective(record);
	}

}
