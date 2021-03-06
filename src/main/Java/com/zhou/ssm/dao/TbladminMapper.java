package com.zhou.ssm.dao;

import com.zhou.ssm.model.Tbladmin;
import com.zhou.ssm.model.TbladminExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TbladminMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbladmin
     *
     * @mbggenerated Mon Apr 03 19:35:45 CST 2017
     */
    int countByExample(TbladminExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbladmin
     *
     * @mbggenerated Mon Apr 03 19:35:45 CST 2017
     */
    int deleteByExample(TbladminExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbladmin
     *
     * @mbggenerated Mon Apr 03 19:35:45 CST 2017
     */
    int deleteByPrimaryKey(String userid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbladmin
     *
     * @mbggenerated Mon Apr 03 19:35:45 CST 2017
     */
    int insert(Tbladmin record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbladmin
     *
     * @mbggenerated Mon Apr 03 19:35:45 CST 2017
     */
    int insertSelective(Tbladmin record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbladmin
     *
     * @mbggenerated Mon Apr 03 19:35:45 CST 2017
     */
    List<Tbladmin> selectByExample(TbladminExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbladmin
     *
     * @mbggenerated Mon Apr 03 19:35:45 CST 2017
     */
    Tbladmin selectByPrimaryKey(String userid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbladmin
     *
     * @mbggenerated Mon Apr 03 19:35:45 CST 2017
     */
    int updateByExampleSelective(@Param("record") Tbladmin record, @Param("example") TbladminExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbladmin
     *
     * @mbggenerated Mon Apr 03 19:35:45 CST 2017
     */
    int updateByExample(@Param("record") Tbladmin record, @Param("example") TbladminExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbladmin
     *
     * @mbggenerated Mon Apr 03 19:35:45 CST 2017
     */
    int updateByPrimaryKeySelective(Tbladmin record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbladmin
     *
     * @mbggenerated Mon Apr 03 19:35:45 CST 2017
     */
    int updateByPrimaryKey(Tbladmin record);
    List<Tbladmin> selectAll();
}