package com.zhsj.dcplatform.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhsj.dcplatform.service.DeveloperService;
import com.zhsj.dcplatform.util.CommonResult;

@Controller
@RequestMapping(value="developer")
public class DeveloperController {

	private final static Logger logger = LoggerFactory.getLogger(DeveloperController.class);
	@Autowired
	private DeveloperService developerService;
	
	
	@RequestMapping(value="getList")
	@ResponseBody
	public Object getList(){
		logger.info("#DeveloperController.getList#");
		CommonResult result = developerService.getList();
		logger.info("#DeveloperController.getList# result={}", result);
		return result;
	}
	
}
