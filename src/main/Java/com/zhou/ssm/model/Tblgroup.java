package com.zhou.ssm.model;

import java.util.Date;

public class Tblgroup {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tblgroup.id
     *
     * @mbggenerated Tue Apr 18 14:54:15 CST 2017
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tblgroup.gDate
     *
     * @mbggenerated Tue Apr 18 14:54:15 CST 2017
     */
    private Date gdate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tblgroup.gSpace
     *
     * @mbggenerated Tue Apr 18 14:54:15 CST 2017
     */
    private String gspace;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tblgroup.gSpeaker
     *
     * @mbggenerated Tue Apr 18 14:54:15 CST 2017
     */
    private String gspeaker;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tblgroup.gListener
     *
     * @mbggenerated Tue Apr 18 14:54:15 CST 2017
     */
    private String glistener;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tblgroup.gTopic
     *
     * @mbggenerated Tue Apr 18 14:54:15 CST 2017
     */
    private String gtopic;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tblgroup.ppt
     *
     * @mbggenerated Tue Apr 18 14:54:15 CST 2017
     */
    private String ppt;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tblgroup.pdf
     *
     * @mbggenerated Tue Apr 18 14:54:15 CST 2017
     */
    private String pdf;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tblgroup.id
     *
     * @return the value of tblgroup.id
     *
     * @mbggenerated Tue Apr 18 14:54:15 CST 2017
     */

    private String referencePDF;
    public Integer getId() {
        return id;
    }

    public String getReferencePDF() {
        return referencePDF;
    }

    private String conference;

    public String getConference() {
        return conference;
    }

    public void setConference(String conference) {
        this.conference = conference;
    }

    public void setReferencePDF(String referencePDF) {
        this.referencePDF = referencePDF;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tblgroup.id
     *
     * @param id the value for tblgroup.id
     *
     * @mbggenerated Tue Apr 18 14:54:15 CST 2017
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tblgroup.gDate
     *
     * @return the value of tblgroup.gDate
     *
     * @mbggenerated Tue Apr 18 14:54:15 CST 2017
     */
    public Date getGdate() {
        return gdate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tblgroup.gDate
     *
     * @param gdate the value for tblgroup.gDate
     *
     * @mbggenerated Tue Apr 18 14:54:15 CST 2017
     */
    public void setGdate(Date gdate) {
        this.gdate = gdate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tblgroup.gSpace
     *
     * @return the value of tblgroup.gSpace
     *
     * @mbggenerated Tue Apr 18 14:54:15 CST 2017
     */
    public String getGspace() {
        return gspace;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tblgroup.gSpace
     *
     * @param gspace the value for tblgroup.gSpace
     *
     * @mbggenerated Tue Apr 18 14:54:15 CST 2017
     */
    public void setGspace(String gspace) {
        this.gspace = gspace == null ? null : gspace.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tblgroup.gSpeaker
     *
     * @return the value of tblgroup.gSpeaker
     *
     * @mbggenerated Tue Apr 18 14:54:15 CST 2017
     */
    public String getGspeaker() {
        return gspeaker;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tblgroup.gSpeaker
     *
     * @param gspeaker the value for tblgroup.gSpeaker
     *
     * @mbggenerated Tue Apr 18 14:54:15 CST 2017
     */
    public void setGspeaker(String gspeaker) {
        this.gspeaker = gspeaker == null ? null : gspeaker.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tblgroup.gListener
     *
     * @return the value of tblgroup.gListener
     *
     * @mbggenerated Tue Apr 18 14:54:15 CST 2017
     */
    public String getGlistener() {
        return glistener;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tblgroup.gListener
     *
     * @param glistener the value for tblgroup.gListener
     *
     * @mbggenerated Tue Apr 18 14:54:15 CST 2017
     */
    public void setGlistener(String glistener) {
        this.glistener = glistener == null ? null : glistener.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tblgroup.gTopic
     *
     * @return the value of tblgroup.gTopic
     *
     * @mbggenerated Tue Apr 18 14:54:15 CST 2017
     */
    public String getGtopic() {
        return gtopic;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tblgroup.gTopic
     *
     * @param gtopic the value for tblgroup.gTopic
     *
     * @mbggenerated Tue Apr 18 14:54:15 CST 2017
     */
    public void setGtopic(String gtopic) {
        this.gtopic = gtopic == null ? null : gtopic.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tblgroup.ppt
     *
     * @return the value of tblgroup.ppt
     *
     * @mbggenerated Tue Apr 18 14:54:15 CST 2017
     */
    public String getPpt() {
        return ppt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tblgroup.ppt
     *
     * @param ppt the value for tblgroup.ppt
     *
     * @mbggenerated Tue Apr 18 14:54:15 CST 2017
     */
    public void setPpt(String ppt) {
        this.ppt = ppt == null ? null : ppt.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tblgroup.pdf
     *
     * @return the value of tblgroup.pdf
     *
     * @mbggenerated Tue Apr 18 14:54:15 CST 2017
     */
    public String getPdf() {
        return pdf;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tblgroup.pdf
     *
     * @param pdf the value for tblgroup.pdf
     *
     * @mbggenerated Tue Apr 18 14:54:15 CST 2017
     */
    public void setPdf(String pdf) {
        this.pdf = pdf == null ? null : pdf.trim();
    }
}