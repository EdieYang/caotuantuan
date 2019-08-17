package com.linkpets.service;

import java.util.Map;

import com.alibaba.fastjson.JSONObject;
import com.linkpets.core.model.ZcBrand;
import com.linkpets.core.model.ZcBrandCollect;

public interface IBrandService {
	
	String saveBrand(ZcBrand record);

	JSONObject getListForPage(Map<String, Object> param, int pageNum, int pageSize, String orderBy);

	/**
	 * 
	* @Title: addCollect 
	* @Description: 添加用户关注
	* @param @param collect
	* @return void
	* @author wando 
	* @throws
	* @date 2019年8月17日 下午5:25:59 
	* @version V1.0   
	 */
	void addCollect(ZcBrandCollect collect);

	/**
	 * 
	* @Title: delCollect 
	* @Description: 取消用户关注
	* @param @param collect
	* @return void
	* @author wando 
	* @throws
	* @date 2019年8月17日 下午5:26:13 
	* @version V1.0   
	 */
	void delCollect(ZcBrandCollect collect);

}
