package com.linkpets.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.linkpets.service.IAppraisalService;

/**
*
* 项目名称：linkpets-platform-cms
* 类名称：AppraisalController
* 类描述：
* 创建人：wando 
* 创建时间：2019年8月11日 下午2:24:03
* 修改人：wando 
* 修改时间：2019年8月11日 下午2:24:03
* 修改备注：
* @version
*
*/
@RestController
@RequestMapping("/appraisal")
public class AppraisalController {
	
	@Autowired
	IAppraisalService appraisalService;
	
	/**
	 * 
	* @Title: saveBrand 
	* @Description: 获取测评列表(分页、排序、模糊搜索)
	* @param @param record
	* @param @return
	* @return String
	* @author wando 
	* @throws
	* @date 2019年8月11日 下午4:19:54 
	* @version V1.0   
	 */
	@PostMapping("/record")
	String saveRecord(@RequestBody JSONObject data) {
		return appraisalService.saveRecord(data);
	}
	
	/**
	 * 
	* @Title: getList 
	* @Description: 获取测评列表(分页、排序、模糊搜索)
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
			@RequestParam(value = "brandId", required = false, defaultValue = "") String brandId,
			@RequestParam(value = "commodityId", required = false, defaultValue = "") String commodityId,
			@RequestParam(value = "sortCol", required = false, defaultValue = "createTime") String sortCol,
			@RequestParam(value = "sort", required = false, defaultValue = "desc") String sort) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("search", search);
		param.put("brandId", brandId);
		param.put("commodityId", commodityId);
		JSONObject data = appraisalService.getListForPage(param, pageNum, pageSize);
		return data;
	}
	
	@GetMapping("{appraisalId}")
	public JSONObject getDetail(@PathVariable String appraisalId) {
		return appraisalService.getDetail(appraisalId);
	}

}
