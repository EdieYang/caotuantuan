package com.linkpets.core.dao;

import com.linkpets.core.model.UserFollow;

public interface UserFollowMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_follow
     *
     * @mbggenerated Fri Mar 15 18:40:44 CST 2019
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_follow
     *
     * @mbggenerated Fri Mar 15 18:40:44 CST 2019
     */
    int insert(UserFollow record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_follow
     *
     * @mbggenerated Fri Mar 15 18:40:44 CST 2019
     */
    int insertSelective(UserFollow record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_follow
     *
     * @mbggenerated Fri Mar 15 18:40:44 CST 2019
     */
    UserFollow selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_follow
     *
     * @mbggenerated Fri Mar 15 18:40:44 CST 2019
     */
    int updateByPrimaryKeySelective(UserFollow record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_follow
     *
     * @mbggenerated Fri Mar 15 18:40:44 CST 2019
     */
    int updateByPrimaryKey(UserFollow record);
}