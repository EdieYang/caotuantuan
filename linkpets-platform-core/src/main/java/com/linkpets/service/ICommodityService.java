package com.linkpets.service;

import java.util.Map;

import com.alibaba.fastjson.JSONObject;
import com.linkpets.core.model.ZcCommodity;

public interface ICommodityService {

	String saveRecord(ZcCommodity record);

	JSONObject getListForPage(Map<String, Object> param, int pageNum, int pageSize);

}
