package com.linkpets.core.dao;

import com.linkpets.core.model.UserTemp;

public interface UserTempMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_temp
     *
     * @mbggenerated Fri Mar 15 18:40:44 CST 2019
     */
    int deleteByPrimaryKey(String userTempId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_temp
     *
     * @mbggenerated Fri Mar 15 18:40:44 CST 2019
     */
    int insert(UserTemp record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_temp
     *
     * @mbggenerated Fri Mar 15 18:40:44 CST 2019
     */
    int insertSelective(UserTemp record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_temp
     *
     * @mbggenerated Fri Mar 15 18:40:44 CST 2019
     */
    UserTemp selectByPrimaryKey(String userTempId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_temp
     *
     * @mbggenerated Fri Mar 15 18:40:44 CST 2019
     */
    int updateByPrimaryKeySelective(UserTemp record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_temp
     *
     * @mbggenerated Fri Mar 15 18:40:44 CST 2019
     */
    int updateByPrimaryKey(UserTemp record);
}