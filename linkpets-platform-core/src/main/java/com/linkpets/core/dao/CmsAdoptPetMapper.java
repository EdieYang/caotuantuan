package com.linkpets.core.dao;

import java.util.List;
import java.util.Map;

import com.linkpets.core.model.CmsAdoptPet;

public interface CmsAdoptPetMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table cms_adopt_pet
	 * @mbg.generated  Sat May 18 14:37:24 GMT+08:00 2019
	 */
	int deleteByPrimaryKey(String petId);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table cms_adopt_pet
	 * @mbg.generated  Sat May 18 14:37:24 GMT+08:00 2019
	 */
	int insert(CmsAdoptPet record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table cms_adopt_pet
	 * @mbg.generated  Sat May 18 14:37:24 GMT+08:00 2019
	 */
	int insertSelective(CmsAdoptPet record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table cms_adopt_pet
	 * @mbg.generated  Sat May 18 14:37:24 GMT+08:00 2019
	 */
	CmsAdoptPet selectByPrimaryKey(String petId);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table cms_adopt_pet
	 * @mbg.generated  Sat May 18 14:37:24 GMT+08:00 2019
	 */
	int updateByPrimaryKeySelective(CmsAdoptPet record);
	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table cms_adopt_pet
	 * @mbg.generated  Sat May 18 14:37:24 GMT+08:00 2019
	 */
	int updateByPrimaryKey(CmsAdoptPet record);

	List<CmsAdoptPet> getList(Map<String, Object> param);
	
	List<String> getAdoptPetIdsByUserId(String userId);
	
	List<CmsAdoptPet> getCollectPetList(Map<String, Object> param);

	List<CmsAdoptPet> getFollowedPetList(Map<String, Object> param);

    int getPetAdoptCount(String syncDate);
}