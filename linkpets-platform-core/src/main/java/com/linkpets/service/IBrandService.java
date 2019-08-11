package com.linkpets.service;

import java.util.Map;

import com.alibaba.fastjson.JSONObject;
import com.linkpets.core.model.ZcBrand;

public interface IBrandService {
	
	String saveBrand(ZcBrand record);

	JSONObject getListForPage(Map<String, Object> param, int pageNum, int pageSize);

}
