package com.yonyou.component.quartz;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yonyou.entity.Persion;

@Controller
@RequestMapping(value = "/quartz")
public class QuartzController {
	
	@RequestMapping(value = "test1", method = RequestMethod.GET)
	@ResponseBody
	public Persion test1() {
		Persion p = new Persion();
		return p;
	}

}
