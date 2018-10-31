package com.zhsj.dcplatform.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhsj.dcplatform.bean.Developer;
import com.zhsj.dcplatform.dao.TBDeveloperDao;
import com.zhsj.dcplatform.util.CommonResult;

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
	
	
}
