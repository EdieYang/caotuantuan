package com.linkpets.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.linkpets.service.IAppraisalService;
import com.linkpets.service.IBrandService;
import com.linkpets.service.IUserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	IUserService userService;
	
	@Autowired
	IBrandService brandService;
	
	@Autowired
	IAppraisalService appraisalService;
	
	/**
	 * 
	* @Title: getList 
	* @Description: 获取用户信息
	* @param @param userId
	* @param @return
	* @return JSONObject
	* @author wando 
	* @throws
	* @date 2019年8月17日 下午3:13:43 
	* @version V1.0   
	 */
	@GetMapping(value = "/{userId}/info")
	public JSONObject getList(@PathVariable("userId") String userId) {
		return userService.getUserInfo(userId);
	}
	
	/**
	 * 
	* @Title: getCollectList 
	* @Description: 关注的品牌
	* @param @param userId
	* @param @return
	* @return JSONObject
	* @author wando 
	* @throws
	* @date 2019年8月17日 下午3:15:11 
	* @version V1.0   
	 */
	@GetMapping(value = "/{userId}/collect")
	public JSONObject getCollectList(@PathVariable("userId") String userId,
			@RequestParam(value = "pageNum", required = false, defaultValue = "1") int pageNum, 
			@RequestParam(value = "pageSize", required = false, defaultValue = "10000") int pageSize,
			@RequestParam(value = "search", required = false, defaultValue = "") String search,
			@RequestParam(value = "sortCol", required = false, defaultValue = "brandName") String sortCol,
			@RequestParam(value = "sort", required = false, defaultValue = "asc") String sort) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("search", search);
		param.put("collectBy", userId);
		return brandService.getListForPage(param, pageNum, pageSize, sortCol + " " + sort);
	}
	/**
	 * 
	* @Title: getFavoriteList 
	* @Description: 收藏的测评
	* @param @param userId
	* @param @return
	* @return JSONObject
	* @author wando 
	* @throws
	* @date 2019年8月17日 下午3:15:36 
	* @version V1.0   
	 */
	@GetMapping(value = "/{userId}/favorite")
	public JSONObject getFavoriteList(@PathVariable("userId") String userId,
			@RequestParam(value = "pageNum", required = false, defaultValue = "1") int pageNum, 
			@RequestParam(value = "pageSize", required = false, defaultValue = "10000") int pageSize,
			@RequestParam(value = "search", required = false, defaultValue = "") String search,
			@RequestParam(value = "sortCol", required = false, defaultValue = "createTime") String sortCol,
			@RequestParam(value = "sort", required = false, defaultValue = "desc") String sort) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("search", search);
		param.put("userId", userId);
		param.put("favoriteBy", userId);
		return appraisalService.getListForPage(param, pageNum, pageSize, sortCol + " " + sort);
	}
	
	/**
	 * 
	* @Title: getAppreciateList 
	* @Description: 赞赏的测评
	* @param @param userId
	* @param @return
	* @return JSONObject
	* @author wando 
	* @throws
	* @date 2019年8月17日 下午3:15:40 
	* @version V1.0   
	 */
	@GetMapping(value = "/{userId}/appreciate")
	public JSONObject getAppreciateList(@PathVariable("userId") String userId,
			@RequestParam(value = "pageNum", required = false, defaultValue = "1") int pageNum, 
			@RequestParam(value = "pageSize", required = false, defaultValue = "10000") int pageSize,
			@RequestParam(value = "search", required = false, defaultValue = "") String search,
			@RequestParam(value = "sortCol", required = false, defaultValue = "createTime") String sortCol,
			@RequestParam(value = "sort", required = false, defaultValue = "desc") String sort) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("search", search);
		param.put("userId", userId);
		param.put("appreciateBy", userId);
		return appraisalService.getListForPage(param, pageNum, pageSize, sortCol + " " + sort);
	}
	

}
