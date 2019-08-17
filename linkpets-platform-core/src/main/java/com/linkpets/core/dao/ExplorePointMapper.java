package com.linkpets.core.dao;

import com.linkpets.core.model.ExplorePoint;
import org.apache.ibatis.annotations.Mapper;


public interface ExplorePointMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table explore_point
     *
     * @mbggenerated Fri Mar 15 18:40:44 CST 2019
     */
    int deleteByPrimaryKey(String pointId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table explore_point
     *
     * @mbggenerated Fri Mar 15 18:40:44 CST 2019
     */
    int insert(ExplorePoint record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table explore_point
     *
     * @mbggenerated Fri Mar 15 18:40:44 CST 2019
     */
    int insertSelective(ExplorePoint record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table explore_point
     *
     * @mbggenerated Fri Mar 15 18:40:44 CST 2019
     */
    ExplorePoint selectByPrimaryKey(String pointId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table explore_point
     *
     * @mbggenerated Fri Mar 15 18:40:44 CST 2019
     */
    int updateByPrimaryKeySelective(ExplorePoint record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table explore_point
     *
     * @mbggenerated Fri Mar 15 18:40:44 CST 2019
     */
    int updateByPrimaryKey(ExplorePoint record);
}