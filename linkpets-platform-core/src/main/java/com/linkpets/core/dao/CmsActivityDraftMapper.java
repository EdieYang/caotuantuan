package com.linkpets.core.dao;

import com.linkpets.core.model.CmsActivityDraft;

public interface CmsActivityDraftMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cms_activity_draft
     *
     * @mbggenerated Wed Mar 27 21:59:05 CST 2019
     */
    int deleteByPrimaryKey(String draftId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cms_activity_draft
     *
     * @mbggenerated Wed Mar 27 21:59:05 CST 2019
     */
    int insert(CmsActivityDraft record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cms_activity_draft
     *
     * @mbggenerated Wed Mar 27 21:59:05 CST 2019
     */
    int insertSelective(CmsActivityDraft record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cms_activity_draft
     *
     * @mbggenerated Wed Mar 27 21:59:05 CST 2019
     */
    CmsActivityDraft selectByPrimaryKey(String draftId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cms_activity_draft
     *
     * @mbggenerated Wed Mar 27 21:59:05 CST 2019
     */
    int updateByPrimaryKeySelective(CmsActivityDraft record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cms_activity_draft
     *
     * @mbggenerated Wed Mar 27 21:59:05 CST 2019
     */
    int updateByPrimaryKey(CmsActivityDraft record);
}