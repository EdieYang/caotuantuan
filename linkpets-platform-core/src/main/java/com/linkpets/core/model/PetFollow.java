package com.linkpets.core.model;

import java.util.Date;

public class PetFollow {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pet_follow.follow_id
     *
     * @mbggenerated Fri Mar 15 18:40:44 CST 2019
     */
    private String followId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pet_follow.user_id
     *
     * @mbggenerated Fri Mar 15 18:40:44 CST 2019
     */
    private String userId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pet_follow.pet_id
     *
     * @mbggenerated Fri Mar 15 18:40:44 CST 2019
     */
    private String petId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pet_follow.del_flag
     *
     * @mbggenerated Fri Mar 15 18:40:44 CST 2019
     */
    private String delFlag;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pet_follow.create_time
     *
     * @mbggenerated Fri Mar 15 18:40:44 CST 2019
     */
    private Date createTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pet_follow.follow_id
     *
     * @return the value of pet_follow.follow_id
     *
     * @mbggenerated Fri Mar 15 18:40:44 CST 2019
     */
    public String getFollowId() {
        return followId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pet_follow.follow_id
     *
     * @param followId the value for pet_follow.follow_id
     *
     * @mbggenerated Fri Mar 15 18:40:44 CST 2019
     */
    public void setFollowId(String followId) {
        this.followId = followId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pet_follow.user_id
     *
     * @return the value of pet_follow.user_id
     *
     * @mbggenerated Fri Mar 15 18:40:44 CST 2019
     */
    public String getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pet_follow.user_id
     *
     * @param userId the value for pet_follow.user_id
     *
     * @mbggenerated Fri Mar 15 18:40:44 CST 2019
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pet_follow.pet_id
     *
     * @return the value of pet_follow.pet_id
     *
     * @mbggenerated Fri Mar 15 18:40:44 CST 2019
     */
    public String getPetId() {
        return petId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pet_follow.pet_id
     *
     * @param petId the value for pet_follow.pet_id
     *
     * @mbggenerated Fri Mar 15 18:40:44 CST 2019
     */
    public void setPetId(String petId) {
        this.petId = petId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pet_follow.del_flag
     *
     * @return the value of pet_follow.del_flag
     *
     * @mbggenerated Fri Mar 15 18:40:44 CST 2019
     */
    public String getDelFlag() {
        return delFlag;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pet_follow.del_flag
     *
     * @param delFlag the value for pet_follow.del_flag
     *
     * @mbggenerated Fri Mar 15 18:40:44 CST 2019
     */
    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pet_follow.create_time
     *
     * @return the value of pet_follow.create_time
     *
     * @mbggenerated Fri Mar 15 18:40:44 CST 2019
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pet_follow.create_time
     *
     * @param createTime the value for pet_follow.create_time
     *
     * @mbggenerated Fri Mar 15 18:40:44 CST 2019
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}