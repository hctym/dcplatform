package com.zhsj.dcplatform.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.alibaba.fastjson.JSONObject;
import com.zhsj.dcplatform.constant.CookieContant;
import com.zhsj.dcplatform.service.DeveloperService;
import com.zhsj.dcplatform.util.AESUtils;
import com.zhsj.dcplatform.util.CommonResult;
import com.zhsj.dcplatform.util.CookieUtils;
import com.zhsj.dcplatform.util.DateUtil;
import com.zhsj.dcplatform.util.login.LoginUser;
import com.zhsj.dcplatform.util.login.LoginUtil;

@Controller
public class BaseController {

	private final static Logger logger = LoggerFactory.getLogger(BaseController.class);
	@Autowired
	private DeveloperService developerService;
	
	@RequestMapping("/")
	public Object main(HttpServletRequest request){
		logger.info("#BaseController.main#");
		String val = CookieUtils.readCookie(request, AESUtils.encrypt(CookieContant.NAME));
		ModelAndView mv = new ModelAndView();
		mv.setViewName("login");
		if(StringUtils.isNotBlank(val)){
			String loginUserJson = AESUtils.decrypt(val);
			try {
				loginUserJson = URLDecoder.decode(loginUserJson, "utf-8");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			LoginUser loginUser = JSONObject.parseObject(loginUserJson, LoginUser.class);
			LoginUtil.set(loginUser);
			logger.info("#BaseController.main# 用户账号：{},用户名称：{} ", loginUser.getAccount(), loginUser.getName());
			mv.addObject("loginUser", loginUser);
			mv.setView(new RedirectView("index"));
		}
		return mv;
	}

	
	@RequestMapping(value="index")
	public Object index(ModelAndView mv){
		LoginUser loginUser = LoginUtil.get();
		mv.addObject("loginUser", loginUser);
		mv.setViewName("index");
		return mv;
	}
	
	@RequestMapping(value="welcome")
	public Object welcome(ModelAndView mv){
		LoginUser loginUser = LoginUtil.get();
		mv.addObject("time", DateUtil.getCurrentTimeHaveHR());
		mv.addObject("loginUser", loginUser);
		mv.setViewName("welcome");
		return mv;
	}
	
	
	
	@RequestMapping(value="login")
	@ResponseBody
	public Object login(HttpServletResponse response, String account, String password){
		logger.info("#DeveloperController.login# account={}, password={}", account, password);
		if(StringUtils.isBlank(account)){
			return CommonResult.build(2, "账号不能为空");
		}
		if(StringUtils.isBlank(password)){
			return CommonResult.build(2, "密码不能为空");
		}
		CommonResult result = developerService.login(account, password);
		if(result.getCode() == 0){
			try {
				String loginUserJson = (String) result.getData();
				CookieUtils.writeCookie(response, AESUtils.encrypt(CookieContant.NAME), AESUtils.encrypt(URLEncoder.encode(loginUserJson, "utf-8")));
			} catch (UnsupportedEncodingException e) {
			}
		}
		return result;
	}
	
	@RequestMapping(value="logout")
	@ResponseBody
	public Object logout(HttpServletRequest request, HttpServletResponse response){
		logger.info("#DeveloperController.logout#");
		Cookie[] cookies = request.getCookies();
		for(Cookie cookie:cookies){
			   if(AESUtils.encrypt(CookieContant.NAME).equals(cookie.getName())){
				   cookie.setMaxAge(0);
				   cookie.setPath("/");
				   response.addCookie(cookie);
				   return CommonResult.success("退出成功");
			   }
		 }
		return CommonResult.defaultError("退出失败");
	}
}
