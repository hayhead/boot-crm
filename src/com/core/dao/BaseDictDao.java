package com.core.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.core.pojo.BaseDict;

@Repository
public interface BaseDictDao {
	
	/*
	 * �����������ѯ
	 */
	public List<BaseDict> selectBaseDictByTypeCode(String type);

}
