package com.zhsj.dcplatform.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.zhsj.dcplatform.bean.Developer;
import com.zhsj.dcplatform.dao.TBDeveloperDao;
import com.zhsj.dcplatform.util.CommonResult;
import com.zhsj.dcplatform.util.MD5Util;
import com.zhsj.dcplatform.util.login.LoginUser;
import com.zhsj.dcplatform.util.login.LoginUtil;

@Service
public class DeveloperService {

	private final static Logger logger = LoggerFactory.getLogger(DeveloperService.class);
	@Autowired
	private TBDeveloperDao tbDeveloperDao;
	
	
	public CommonResult getList(){
		logger.info("#DeveloperService.getList#");
		try {
			List<Developer> list = tbDeveloperDao.getList();
			return CommonResult.success("", list);
		} catch (Exception e) {
			logger.error("#Developer.getList#", e);
		}
		return CommonResult.defaultError("");
	}
	
	
	public CommonResult login(String account, String password){
		logger.info("#DeveloperService.login# account={}, password={}", account, password);
		try {
			Developer developer = tbDeveloperDao.getByAccount(account);
			if(developer == null){
				return CommonResult.build(2, "账号不存在");
			}
			if(!MD5Util.encode(password).equals(developer.getPassword())){
				return CommonResult.build(2, "密码错误");
			}
			LoginUser loginUser = new LoginUser();
			loginUser.setId(developer.getId());
			loginUser.setAccount(developer.getAccount());
			loginUser.setName(developer.getName());
			LoginUtil.set(loginUser);
			String loginUserJson = JSONObject.toJSONString(loginUser);
			return CommonResult.success("登录成功", loginUserJson);
		} catch (Exception e) {
			logger.info("#DeveloperService.login# account={}, password={}", account, password, e);
		}
		return CommonResult.defaultError("出错了额");
	}
	
	
	
}
