package com.linkpets.core.dao;

import com.linkpets.core.model.ZcBrand;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface ZcBrandMapper {
    /**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table zc_brand
	 * @mbg.generated  Sat Aug 17 15:12:42 GMT+08:00 2019
	 */
	@Delete({ "delete from zc_brand", "where brand_id = #{brandId,jdbcType=VARCHAR}" })
	int deleteByPrimaryKey(String brandId);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table zc_brand
	 * @mbg.generated  Sat Aug 17 15:12:42 GMT+08:00 2019
	 */
	@Insert({ "insert into zc_brand (brand_id, brand_name, ", "logo_url, origin, ", "scope, is_vaild)",
			"values (#{brandId,jdbcType=VARCHAR}, #{brandName,jdbcType=VARCHAR}, ",
			"#{logoUrl,jdbcType=VARCHAR}, #{origin,jdbcType=VARCHAR}, ",
			"#{scope,jdbcType=VARCHAR}, #{isVaild,jdbcType=INTEGER})" })
	int insert(ZcBrand record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table zc_brand
	 * @mbg.generated  Sat Aug 17 15:12:42 GMT+08:00 2019
	 */
	int insertSelective(ZcBrand record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table zc_brand
	 * @mbg.generated  Sat Aug 17 15:12:42 GMT+08:00 2019
	 */
	@Select({ "select", "brand_id, brand_name, logo_url, origin, scope, is_vaild", "from zc_brand",
			"where brand_id = #{brandId,jdbcType=VARCHAR}" })
	@ResultMap("com.linkpets.core.dao.ZcBrandMapper.BaseResultMap")
	ZcBrand selectByPrimaryKey(String brandId);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table zc_brand
	 * @mbg.generated  Sat Aug 17 15:12:42 GMT+08:00 2019
	 */
	int updateByPrimaryKeySelective(ZcBrand record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table zc_brand
	 * @mbg.generated  Sat Aug 17 15:12:42 GMT+08:00 2019
	 */
	@Update({ "update zc_brand", "set brand_name = #{brandName,jdbcType=VARCHAR},",
			"logo_url = #{logoUrl,jdbcType=VARCHAR},", "origin = #{origin,jdbcType=VARCHAR},",
			"scope = #{scope,jdbcType=VARCHAR},", "is_vaild = #{isVaild,jdbcType=INTEGER}",
			"where brand_id = #{brandId,jdbcType=VARCHAR}" })
	int updateByPrimaryKey(ZcBrand record);

	List<Map<String, Object>> getList(Map<String, Object> param);
}