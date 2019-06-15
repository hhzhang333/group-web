package com.zhou.ssm.dao;

import com.zhou.ssm.model.Tblgroup;
import com.zhou.ssm.model.TblgroupExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TblgroupMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tblgroup
     *
     * @mbggenerated Tue Apr 18 14:54:15 CST 2017
     */
    int countByExample(TblgroupExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tblgroup
     *
     * @mbggenerated Tue Apr 18 14:54:15 CST 2017
     */
    int deleteByExample(TblgroupExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tblgroup
     *
     * @mbggenerated Tue Apr 18 14:54:15 CST 2017
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tblgroup
     *
     * @mbggenerated Tue Apr 18 14:54:15 CST 2017
     */
    int insert(Tblgroup record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tblgroup
     *
     * @mbggenerated Tue Apr 18 14:54:15 CST 2017
     */
    int insertSelective(Tblgroup record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tblgroup
     *
     * @mbggenerated Tue Apr 18 14:54:15 CST 2017
     */
    List<Tblgroup> selectByExample(TblgroupExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tblgroup
     *
     * @mbggenerated Tue Apr 18 14:54:15 CST 2017
     */
    Tblgroup selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tblgroup
     *
     * @mbggenerated Tue Apr 18 14:54:15 CST 2017
     */
    int updateByExampleSelective(@Param("record") Tblgroup record, @Param("example") TblgroupExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tblgroup
     *
     * @mbggenerated Tue Apr 18 14:54:15 CST 2017
     */
    int updateByExample(@Param("record") Tblgroup record, @Param("example") TblgroupExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tblgroup
     *
     * @mbggenerated Tue Apr 18 14:54:15 CST 2017
     */
    int updateByPrimaryKeySelective(Tblgroup record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tblgroup
     *
     * @mbggenerated Tue Apr 18 14:54:15 CST 2017
     */
    int updateByPrimaryKey(Tblgroup record);
    List<Tblgroup> selectAll();
}