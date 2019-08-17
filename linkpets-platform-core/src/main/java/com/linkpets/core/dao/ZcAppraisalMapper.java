package com.linkpets.core.dao;

import com.linkpets.core.model.ZcAppraisal;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface ZcAppraisalMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table zc_appraisal
     *
     * @mbg.generated Sun Aug 11 14:03:03 GMT+08:00 2019
     */
    @Delete({
        "delete from zc_appraisal",
        "where appraisal_id = #{appraisalId,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String appraisalId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table zc_appraisal
     *
     * @mbg.generated Sun Aug 11 14:03:03 GMT+08:00 2019
     */
    @Insert({
        "insert into zc_appraisal (appraisal_id, title, ",
        "create_by, create_time, ",
        "is_valid, content)",
        "values (#{appraisalId,jdbcType=VARCHAR}, #{title,jdbcType=VARCHAR}, ",
        "#{createBy,jdbcType=VARCHAR}, #{createTime,jdbcType=TIMESTAMP}, ",
        "#{isValid,jdbcType=INTEGER}, #{content,jdbcType=LONGVARCHAR})"
    })
    int insert(ZcAppraisal record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table zc_appraisal
     *
     * @mbg.generated Sun Aug 11 14:03:03 GMT+08:00 2019
     */
    int insertSelective(ZcAppraisal record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table zc_appraisal
     *
     * @mbg.generated Sun Aug 11 14:03:03 GMT+08:00 2019
     */
    @Select({
        "select",
        "appraisal_id, title, create_by, create_time, is_valid, content",
        "from zc_appraisal",
        "where appraisal_id = #{appraisalId,jdbcType=VARCHAR}"
    })
    @ResultMap("com.linkpets.core.dao.ZcAppraisalMapper.ResultMapWithBLOBs")
    ZcAppraisal selectByPrimaryKey(String appraisalId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table zc_appraisal
     *
     * @mbg.generated Sun Aug 11 14:03:03 GMT+08:00 2019
     */
    int updateByPrimaryKeySelective(ZcAppraisal record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table zc_appraisal
     *
     * @mbg.generated Sun Aug 11 14:03:03 GMT+08:00 2019
     */
    @Update({
        "update zc_appraisal",
        "set title = #{title,jdbcType=VARCHAR},",
          "create_by = #{createBy,jdbcType=VARCHAR},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "is_valid = #{isValid,jdbcType=INTEGER},",
          "content = #{content,jdbcType=LONGVARCHAR}",
        "where appraisal_id = #{appraisalId,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKeyWithBLOBs(ZcAppraisal record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table zc_appraisal
     *
     * @mbg.generated Sun Aug 11 14:03:03 GMT+08:00 2019
     */
    @Update({
        "update zc_appraisal",
        "set title = #{title,jdbcType=VARCHAR},",
          "create_by = #{createBy,jdbcType=VARCHAR},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "is_valid = #{isValid,jdbcType=INTEGER}",
        "where appraisal_id = #{appraisalId,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(ZcAppraisal record);

	List<Map<String, Object>> getList(Map<String, Object> param);
}