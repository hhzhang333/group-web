package com.zhou.ssm.model;

import java.util.Date;

public class Tblnews {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tblnews.id
     *
     * @mbggenerated Tue Apr 18 14:54:15 CST 2017
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tblnews.title
     *
     * @mbggenerated Tue Apr 18 14:54:15 CST 2017
     */
    private String title;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tblnews.author
     *
     * @mbggenerated Tue Apr 18 14:54:15 CST 2017
     */
    private String author;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tblnews.nDate
     *
     * @mbggenerated Tue Apr 18 14:54:15 CST 2017
     */
    private Date ndate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tblnews.nContent
     *
     * @mbggenerated Tue Apr 18 14:54:15 CST 2017
     */
    private String ncontent;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tblnews.id
     *
     * @return the value of tblnews.id
     *
     * @mbggenerated Tue Apr 18 14:54:15 CST 2017
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tblnews.id
     *
     * @param id the value for tblnews.id
     *
     * @mbggenerated Tue Apr 18 14:54:15 CST 2017
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tblnews.title
     *
     * @return the value of tblnews.title
     *
     * @mbggenerated Tue Apr 18 14:54:15 CST 2017
     */
    public String getTitle() {
        return title;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tblnews.title
     *
     * @param title the value for tblnews.title
     *
     * @mbggenerated Tue Apr 18 14:54:15 CST 2017
     */
    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tblnews.author
     *
     * @return the value of tblnews.author
     *
     * @mbggenerated Tue Apr 18 14:54:15 CST 2017
     */
    public String getAuthor() {
        return author;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tblnews.author
     *
     * @param author the value for tblnews.author
     *
     * @mbggenerated Tue Apr 18 14:54:15 CST 2017
     */
    public void setAuthor(String author) {
        this.author = author == null ? null : author.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tblnews.nDate
     *
     * @return the value of tblnews.nDate
     *
     * @mbggenerated Tue Apr 18 14:54:15 CST 2017
     */
    public Date getNdate() {
        return ndate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tblnews.nDate
     *
     * @param ndate the value for tblnews.nDate
     *
     * @mbggenerated Tue Apr 18 14:54:15 CST 2017
     */
    public void setNdate(Date ndate) {
        this.ndate = ndate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tblnews.nContent
     *
     * @return the value of tblnews.nContent
     *
     * @mbggenerated Tue Apr 18 14:54:15 CST 2017
     */
    public String getNcontent() {
        return ncontent;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tblnews.nContent
     *
     * @param ncontent the value for tblnews.nContent
     *
     * @mbggenerated Tue Apr 18 14:54:15 CST 2017
     */
    public void setNcontent(String ncontent) {
        this.ncontent = ncontent == null ? null : ncontent.trim();
    }
}