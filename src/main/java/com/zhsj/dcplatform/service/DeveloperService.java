package com.zhsj.dcplatform.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	
	
	public Map<String, Object> getList(int page, int pageSize){
		logger.info("#DeveloperService.getList# page={}, pageSize={}", page, pageSize);
		Map<String, Object> resultMap = new HashMap<>();
		page = page<1?1:page;
		pageSize = pageSize<1?10:pageSize;
		try {
			int start = (page-1)*pageSize;
			List<Developer> list = tbDeveloperDao.getList(start, pageSize);
			resultMap.put("list", list);
			if(page == 1){
			   int count = tbDeveloperDao.getCount();
			   resultMap.put("count", count);
			}
			
		} catch (Exception e) {
			logger.error("#Developer.getList# page={}, pageSize={}", page, pageSize, e);
		}
		return resultMap;
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

	
	public CommonResult insert(Developer developer){
		logger.info("#Developer.insert# developer={}", developer);
		try {
			String account = developer.getAccount();
			Developer der = tbDeveloperDao.getByAccount(account);
			if(der != null){
				return CommonResult.build(2, "账号已存在");
			}
			developer.setPassword(MD5Util.encode(developer.getPassword()));
			tbDeveloperDao.insert(developer);
			return CommonResult.success("添加成功");
		} catch (Exception e) {
			logger.error("#Developer.insert# developer={}", developer, e);
		}
		return CommonResult.defaultError("出错了呀");
	}
	
	
	

	public CommonResult deleteById(int id) {
		logger.info("#Developer.deleteById# id={}", id);
		try {
			tbDeveloperDao.deleteById(id);
			return CommonResult.success("删除成功");
		} catch (Exception e) {
			logger.error("#Developer.deleteById# id={}", id, e);
		}
		return CommonResult.defaultError("出错了呀");
	}
	
	
	
	
	
	
}
