package com.linkpets.service;

import java.util.Map;

import com.alibaba.fastjson.JSONObject;

public interface IAppraisalService {

	JSONObject getListForPage(Map<String, Object> param, int pageNum, int pageSize);

	String saveRecord(JSONObject data);

	JSONObject getDetail(String appraisalId);

}
