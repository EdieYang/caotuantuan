package com.linkpets.service.impl;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.linkpets.core.dao.ZcAppraisalMapper;
import com.linkpets.core.model.ZcAppraisal;
import com.linkpets.service.IAppraisalService;

/**
 * 
* @ClassName: AppraisalServiceImpl 
* @Description: 测评
* @author wando
* @date 2019年8月11日 下午2:30:34 
* @version V1.0 
 */
@Service
public class AppraisalServiceImpl implements IAppraisalService{

	@Autowired
	ZcAppraisalMapper zcAppraisalMapper;

	@Override
	public JSONObject getListForPage(Map<String, Object> param, int pageNum, int pageSize, String orderBy) {
		JSONObject result = new JSONObject();
		PageHelper.startPage(pageNum, pageSize, orderBy);
		List<Map<String, Object>> list = zcAppraisalMapper.getList(param);
		PageInfo<Map<String, Object>> page = new PageInfo<Map<String, Object>>(list);
		result.put("page", page.getPageNum());
		result.put("total", page.getTotal());
		result.put("rows", list);
		return result;
	}

	@Override
	public String saveRecord(JSONObject data) {
		ZcAppraisal record = JSONObject.toJavaObject(data, ZcAppraisal.class);
		if(null == record.getAppraisalId() || "".equals(record.getAppraisalId())) {
			//增
			record.setAppraisalId(UUID.randomUUID().toString());//设置brandId
			zcAppraisalMapper.insertSelective(record);
		}else{
			//删改
			zcAppraisalMapper.updateByPrimaryKeySelective(record);
		}
		return record.getAppraisalId();
	}

	@Override
	public JSONObject getDetail(String appraisalId) {
		return null;
	}
	
	
}
