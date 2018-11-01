package com.zhsj.dcplatform.controller;

import java.io.UnsupportedEncodingException;
import java.net.CookieStore;
import java.net.URLEncoder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.aspectj.weaver.ast.Var;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.zhsj.dcplatform.constant.CookieContant;
import com.zhsj.dcplatform.service.DeveloperService;
import com.zhsj.dcplatform.util.AESUtils;
import com.zhsj.dcplatform.util.CommonResult;
import com.zhsj.dcplatform.util.CookieUtils;
import com.zhsj.dcplatform.util.MD5Util;

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
