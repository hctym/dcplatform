package com.zhsj.dcplatform.controller;


import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.zhsj.dcplatform.bean.Developer;
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
	public Object getList(int page, int pageSize){
		logger.info("#DeveloperController.getList#");
		ModelAndView mv = new ModelAndView();
		Map<String, Object> resultMap = developerService.getList(page, pageSize);
		mv.addObject("map", resultMap);
		if(page == 1){
			mv.setViewName("developer/developerList");
		}else{
			mv.setViewName("developer/developerData");
		}
		return mv;
	}
	
	
	
	
	@RequestMapping("addPage")
	public Object addPage(){
		logger.info("#DeveloperController.addPage#");
		ModelAndView mv = new ModelAndView();
		mv.setViewName("developer/add");
		return mv;
	}
	
	
	
	@RequestMapping(value="add")
	@ResponseBody
	public Object add(Developer developer){
		logger.info("#DeveloperController.add# developer={}", developer);
		if(StringUtils.isBlank(developer.getAccount())){
			return CommonResult.build(2, "账号不能为空");
		}
		if(StringUtils.isBlank(developer.getName())){
			return CommonResult.build(2, "名称不能为空");
		}
		if(StringUtils.isBlank(developer.getPassword())){
			return CommonResult.build(2, "密码不能为空");
		}
		if(StringUtils.isBlank(developer.getMobile())){
			return CommonResult.build(2, "手机号不能为空");
		}
		if(StringUtils.isBlank(developer.getEmail())){
			return CommonResult.build(2, "邮箱不能为空");
		}
		CommonResult result = developerService.insert(developer);
		logger.info("#DeveloperController.add# result={}", result);
		return result;
	}
	
	@RequestMapping(value="delete")
	@ResponseBody
	public Object delete(int id){
		logger.info("#DeveloperController.delete# id={}", id);
		CommonResult result = developerService.deleteById(id);
		logger.info("#DeveloperController.delete# result={}", result);
		return result;
	}
	
	
	
	
}
