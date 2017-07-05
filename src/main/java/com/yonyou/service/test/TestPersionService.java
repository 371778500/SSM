package com.yonyou.service.test;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yonyou.entity.test.Persion;
import com.yonyou.repository.test.IPersion;

@Service
public class TestPersionService {
	@Resource
	private IPersion persion;

	public int insertPersion(Persion record) {
		return persion.insertSelective(record);
	}

}
