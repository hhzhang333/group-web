package com.zhou.ssm.model;

import java.util.Date;

public class Tblpaper {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tblpaper.id
     *
     * @mbggenerated Tue Apr 18 14:54:15 CST 2017
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tblpaper.title
     *
     * @mbggenerated Tue Apr 18 14:54:15 CST 2017
     */
    private String title;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tblpaper.author
     *
     * @mbggenerated Tue Apr 18 14:54:15 CST 2017
     */
    private String author;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tblpaper.pGroup
     *
     * @mbggenerated Tue Apr 18 14:54:15 CST 2017
     */
    private String pgroup;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tblpaper.pDate
     *
     * @mbggenerated Tue Apr 18 14:54:15 CST 2017
     */
    private Date pdate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tblpaper.pPages
     *
     * @mbggenerated Tue Apr 18 14:54:15 CST 2017
     */
    private String ppages;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tblpaper.pName
     *
     * @mbggenerated Tue Apr 18 14:54:15 CST 2017
     */
    private String pname;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tblpaper.id
     *
     * @return the value of tblpaper.id
     *
     * @mbggenerated Tue Apr 18 14:54:15 CST 2017
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tblpaper.id
     *
     * @param id the value for tblpaper.id
     *
     * @mbggenerated Tue Apr 18 14:54:15 CST 2017
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tblpaper.title
     *
     * @return the value of tblpaper.title
     *
     * @mbggenerated Tue Apr 18 14:54:15 CST 2017
     */
    public String getTitle() {
        return title;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tblpaper.title
     *
     * @param title the value for tblpaper.title
     *
     * @mbggenerated Tue Apr 18 14:54:15 CST 2017
     */
    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tblpaper.author
     *
     * @return the value of tblpaper.author
     *
     * @mbggenerated Tue Apr 18 14:54:15 CST 2017
     */
    public String getAuthor() {
        return author;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tblpaper.author
     *
     * @param author the value for tblpaper.author
     *
     * @mbggenerated Tue Apr 18 14:54:15 CST 2017
     */
    public void setAuthor(String author) {
        this.author = author == null ? null : author.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tblpaper.pGroup
     *
     * @return the value of tblpaper.pGroup
     *
     * @mbggenerated Tue Apr 18 14:54:15 CST 2017
     */
    public String getPgroup() {
        return pgroup;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tblpaper.pGroup
     *
     * @param pgroup the value for tblpaper.pGroup
     *
     * @mbggenerated Tue Apr 18 14:54:15 CST 2017
     */
    public void setPgroup(String pgroup) {
        this.pgroup = pgroup == null ? null : pgroup.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tblpaper.pDate
     *
     * @return the value of tblpaper.pDate
     *
     * @mbggenerated Tue Apr 18 14:54:15 CST 2017
     */
    public Date getPdate() {
        return pdate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tblpaper.pDate
     *
     * @param pdate the value for tblpaper.pDate
     *
     * @mbggenerated Tue Apr 18 14:54:15 CST 2017
     */
    public void setPdate(Date pdate) {
        this.pdate = pdate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tblpaper.pPages
     *
     * @return the value of tblpaper.pPages
     *
     * @mbggenerated Tue Apr 18 14:54:15 CST 2017
     */
    public String getPpages() {
        return ppages;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tblpaper.pPages
     *
     * @param ppages the value for tblpaper.pPages
     *
     * @mbggenerated Tue Apr 18 14:54:15 CST 2017
     */
    public void setPpages(String ppages) {
        this.ppages = ppages;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tblpaper.pName
     *
     * @return the value of tblpaper.pName
     *
     * @mbggenerated Tue Apr 18 14:54:15 CST 2017
     */
    public String getPname() {
        return pname;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tblpaper.pName
     *
     * @param pname the value for tblpaper.pName
     *
     * @mbggenerated Tue Apr 18 14:54:15 CST 2017
     */
    public void setPname(String pname) {
        this.pname = pname == null ? null : pname.trim();
    }
}