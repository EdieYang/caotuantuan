package com.linkpets.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.linkpets.core.model.ZcCommodity;
import com.linkpets.service.ICommodityService;

@RestController
@RequestMapping("/commodity")
public class CommodityController {
	
	@Autowired
	ICommodityService commodityService;
	
	/**
	 * 
	* @Title: saveBrand 
	* @Description: 获取商品列表(分页、排序、模糊搜索)
	* @param @param record
	* @param @return
	* @return String
	* @author wando 
	* @throws
	* @date 2019年8月11日 下午4:19:54 
	* @version V1.0   
	 */
	@PostMapping("/record")
	String saveRecord(@RequestBody ZcCommodity record) {
		return commodityService.saveRecord(record);
	}
	
	/**
	 * 
	* @Title: getList 
	* @Description: 获取商品列表(分页、排序、模糊搜索)
	* @param @param pageNum
	* @param @param pageSize
	* @param @param search
	* @param @param sortCol
	* @param @param sort
	* @param @return
	* @return JSONObject
	* @author wando 
	* @throws
	* @date 2019年8月11日 下午3:27:23 
	* @version V1.0   
	 */
	@GetMapping(value = "/list")
	public JSONObject getList(@RequestParam(value = "pageNum", required = false, defaultValue = "1") int pageNum, 
			@RequestParam(value = "pageSize", required = false, defaultValue = "10000") int pageSize,
			@RequestParam(value = "search", required = false, defaultValue = "") String search,
			@RequestParam(value = "sortCol", required = false, defaultValue = "commodityName") String sortCol,
			@RequestParam(value = "sort", required = false, defaultValue = "asc") String sort) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("search", search);
		JSONObject data = commodityService.getListForPage(param, pageNum, pageSize);
		return data;
	}

}
