package com.zhsj.dcplatform.interceptors;

import java.net.URLDecoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.zhsj.dcplatform.constant.CookieContant;
import com.zhsj.dcplatform.util.AESUtils;
import com.zhsj.dcplatform.util.CookieUtils;
import com.zhsj.dcplatform.util.login.LoginUser;
import com.zhsj.dcplatform.util.login.LoginUtil;

public class DcInterceptor extends AbstractInterceptor {
	
	private static Logger logger = LoggerFactory.getLogger(DcInterceptor.class);

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String val = CookieUtils.readCookie(request, AESUtils.encrypt(CookieContant.NAME));
		if(StringUtils.isNotBlank(val)){
			String loginUserJson = AESUtils.decrypt(val);
			loginUserJson = URLDecoder.decode(loginUserJson, "utf-8");
			LoginUser loginUser = JSONObject.parseObject(loginUserJson, LoginUser.class);
			LoginUtil.set(loginUser);
//			logger.info("#DcInterceptor.preHandle# 用户账号：{},用户名称：{} ", loginUser.getAccount(), loginUser.getName());
			return true;
		}
		String path = request.getContextPath();
		String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
    	response.getWriter().write("<script>parent.location.href=\""+basePath+"\";</script>");
        return false;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		super.postHandle(request, response, handler, modelAndView);
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
//		logger.info("#DcInterceptor.afterCompletion#");
		super.afterCompletion(request, response, handler, ex);
	}

	
}
