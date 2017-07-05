package com.yonyou.web.test;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yonyou.entity.test.Persion;
import com.yonyou.service.test.TestPersionService;

@Controller
@RequestMapping(value = "/test")
public class TestMybatis {

	private static Logger logger = Logger.getLogger(TestMybatis.class);
	private ApplicationContext ac = null;
	@Autowired
	private TestPersionService testservice;

	@Before
	public void before() {
		ac = new ClassPathXmlApplicationContext("spring-mybatis.xml");
	}

	@RequestMapping(value = "test1", method = RequestMethod.GET)
	@ResponseBody
	public Persion test1() {
		Persion p = new Persion();
		System.out.println(testservice.insertPersion(p));
		return p;
	}

}
