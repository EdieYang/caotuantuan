package com.linkpets.service.impl;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.linkpets.core.dao.ZcCommodityMapper;
import com.linkpets.core.model.ZcCommodity;
import com.linkpets.service.ICommodityService;

@Service
public class CommmodityServiceImpl implements ICommodityService{

	@Autowired
	ZcCommodityMapper zcCommodityMapper;
	
	@Override
	public String saveRecord(ZcCommodity record) {
		if(null == record.getBrandId() || "".equals(record.getBrandId())) {
			//增
			record.setBrandId(UUID.randomUUID().toString());//设置brandId
			zcCommodityMapper.insertSelective(record);
		}else{
			//删改
			zcCommodityMapper.updateByPrimaryKeySelective(record);
		}
		return record.getBrandId();
	}

	@Override
	public JSONObject getListForPage(Map<String, Object> param, int pageNum, int pageSize) {
		JSONObject result = new JSONObject();
		PageHelper.startPage(pageNum, pageSize);
		List<Map<String, Object>> list = zcCommodityMapper.getList(param);
		PageInfo<Map<String, Object>> page = new PageInfo<Map<String, Object>>(list);
		result.put("page", page.getPageNum());
		result.put("total", page.getTotal());
		result.put("rows", list);
		return result;
	}

}
