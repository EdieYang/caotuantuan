package com.linkpets.core.dao;

import com.linkpets.core.model.CmsActivityAssistance;

public interface CmsActivityAssistanceMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cms_activity_assistance
     *
     * @mbggenerated Tue Mar 26 15:16:53 CST 2019
     */
    int deleteByPrimaryKey(String assistId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cms_activity_assistance
     *
     * @mbggenerated Tue Mar 26 15:16:53 CST 2019
     */
    int insert(CmsActivityAssistance record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cms_activity_assistance
     *
     * @mbggenerated Tue Mar 26 15:16:53 CST 2019
     */
    int insertSelective(CmsActivityAssistance record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cms_activity_assistance
     *
     * @mbggenerated Tue Mar 26 15:16:53 CST 2019
     */
    CmsActivityAssistance selectByPrimaryKey(String assistId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cms_activity_assistance
     *
     * @mbggenerated Tue Mar 26 15:16:53 CST 2019
     */
    int updateByPrimaryKeySelective(CmsActivityAssistance record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cms_activity_assistance
     *
     * @mbggenerated Tue Mar 26 15:16:53 CST 2019
     */
    int updateByPrimaryKey(CmsActivityAssistance record);
}