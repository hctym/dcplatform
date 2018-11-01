package com.zhsj.dcplatform.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import com.zhsj.dcplatform.bean.Developer;
import com.zhsj.dcplatform.util.db.DS;
import com.zhsj.dcplatform.util.db.DynamicDataSource;

@Component
@DynamicDataSource(DS.DB_Data)
public interface TBDeveloperDao {

	int insert(Developer developer);
	
	List<Developer> getList(@Param("start")int start, @Param("pageSize")int pageSize);
	
	int getCount();

	Developer getByAccount(@Param("account")String account);
	
	int deleteById(@Param("id")int id);
	
	int update(Developer developer);
}
