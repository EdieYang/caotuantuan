package com.linkpets.core.dao;

import com.linkpets.core.model.CmsActivityRegistry;

public interface CmsActivityRegistryMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cms_activity_registry
     *
     * @mbggenerated Sat Mar 23 02:03:01 CST 2019
     */
    int deleteByPrimaryKey(String registryId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cms_activity_registry
     *
     * @mbggenerated Sat Mar 23 02:03:01 CST 2019
     */
    int insert(CmsActivityRegistry record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cms_activity_registry
     *
     * @mbggenerated Sat Mar 23 02:03:01 CST 2019
     */
    int insertSelective(CmsActivityRegistry record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cms_activity_registry
     *
     * @mbggenerated Sat Mar 23 02:03:01 CST 2019
     */
    CmsActivityRegistry selectByPrimaryKey(String registryId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cms_activity_registry
     *
     * @mbggenerated Sat Mar 23 02:03:01 CST 2019
     */
    int updateByPrimaryKeySelective(CmsActivityRegistry record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cms_activity_registry
     *
     * @mbggenerated Sat Mar 23 02:03:01 CST 2019
     */
    int updateByPrimaryKey(CmsActivityRegistry record);
}