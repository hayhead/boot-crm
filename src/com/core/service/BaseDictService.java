package com.core.service;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.core.pojo.BaseDict;


public interface BaseDictService {
	
	public List<BaseDict> findBaseDictByTypeCode(String code);

}
