package com.zhsj.dcplatform.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import com.zhsj.dcplatform.bean.Developer;
import com.zhsj.dcplatform.util.db.DS;
import com.zhsj.dcplatform.util.db.DynamicDataSource;

@Component
@DynamicDataSource(DS.DB_MANAGE)
public interface TBDeveloperDao {

	int insert(Developer developer);
	
	List<Developer> getList();
	
	int getCount();

	Developer getByAccount(@Param("account")String account);
}
