package com.linkpets.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.linkpets.core.dao.CmsUserMapper;
import com.linkpets.core.dao.ZcAppraisalAppreciateMapper;
import com.linkpets.core.dao.ZcAppraisalFavoriteMapper;
import com.linkpets.core.dao.ZcBrandCollectMapper;
import com.linkpets.core.model.CmsUser;
import com.linkpets.service.IUserService;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	CmsUserMapper cmsUserMapper;

	@Autowired
	ZcAppraisalFavoriteMapper zcAppraisalFavoriteMapper;

	@Autowired
	ZcAppraisalAppreciateMapper zcAppraisalAppreciateMapper;

	@Autowired
	ZcBrandCollectMapper zcBrandCollectMapper;

	@Override
	public JSONObject getUserInfo(String userId) {

		CmsUser u = cmsUserMapper.selectByPrimaryKey(userId);
		JSONObject data = JSONObject.parseObject(JSONObject.toJSONString(u));
		data.put("collect", zcBrandCollectMapper.getCollectCountByUser(null, userId));// 关注品牌数
		data.put("favorite", zcAppraisalFavoriteMapper.getFavoriteCountByUser(null, userId));// 收藏测评数
		data.put("appreciate", zcAppraisalAppreciateMapper.getAppreciateCountByUser(null, userId));// 赞赏测评数
		return data;
	}

}
