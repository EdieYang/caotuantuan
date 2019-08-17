package com.linkpets.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.linkpets.core.dao.ZcBrandCollectMapper;
import com.linkpets.core.dao.ZcBrandMapper;
import com.linkpets.core.model.ZcBrand;
import com.linkpets.core.model.ZcBrandCollect;
import com.linkpets.service.IBrandService;

@Service
public class BrandServiceImpl implements IBrandService {

	@Autowired
	ZcBrandMapper zcBrandMapper;

	@Autowired
	ZcBrandCollectMapper zcBrandCollectMapper;

	@Override
	public String saveBrand(ZcBrand record) {
		if (null == record.getBrandId() || "".equals(record.getBrandId())) {
			// 增
			record.setBrandId(UUID.randomUUID().toString());// 设置brandId
			zcBrandMapper.insertSelective(record);
		} else {
			// 删改
			zcBrandMapper.updateByPrimaryKeySelective(record);
		}
		return record.getBrandId();
	}

	@Override
	public JSONObject getListForPage(Map<String, Object> param, int pageNum, int pageSize, String orderBy) {
		JSONObject result = new JSONObject();
		PageHelper.startPage(pageNum, pageSize, orderBy);
		List<Map<String, Object>> list = zcBrandMapper.getList(param);
		PageInfo<Map<String, Object>> page = new PageInfo<Map<String, Object>>(list);
		result.put("page", page.getPageNum());
		result.put("total", page.getTotal());
		result.put("rows", list);
		return result;
	}

	@Override
	public void addCollect(ZcBrandCollect collect) {
		int c = zcBrandCollectMapper.getCollectCountByUser(collect.getBrandId(), collect.getUserId());
		if (c == 0) {
			//判断是否已关注，若未关注则加关注
			collect.setCreateTime(new Date());
			zcBrandCollectMapper.insertSelective(collect);
		}

	}

	@Override
	public void delCollect(ZcBrandCollect collect) {
		// 删除关注
		zcBrandCollectMapper.delCollect(collect.getBrandId(), collect.getUserId());
	}

}
