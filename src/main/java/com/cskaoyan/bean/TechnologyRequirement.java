package com.cskaoyan.bean;

import java.util.Date;

public class TechnologyRequirement {
    private String technologyRequirementId;

    private String technologyId;

    private String technologyName;

    private String requirement;

    private Date addTime;

    private Date reviseTime;

    public TechnologyRequirement() {
    }

    public TechnologyRequirement(String technologyRequirementId, String technologyId, String technologyName, String requirement, Date addTime, Date reviseTime) {
        this.technologyRequirementId = technologyRequirementId;
        this.technologyId = technologyId;
        this.technologyName = technologyName;
        this.requirement = requirement;
        this.addTime = addTime;
        this.reviseTime = reviseTime;
    }

    public String getTechnologyRequirementId() {
        return technologyRequirementId;
    }

    public void setTechnologyRequirementId(String technologyRequirementId) {
        this.technologyRequirementId = technologyRequirementId;
    }

    public String getTechnologyId() {
        return technologyId;
    }

    public void setTechnologyId(String technologyId) {
        this.technologyId = technologyId;
    }

    public String getTechnologyName() {
        return technologyName;
    }

    public void setTechnologyName(String technologyName) {
        this.technologyName = technologyName;
    }

    public String getRequirement() {
        return requirement;
    }

    public void setRequirement(String requirement) {
        this.requirement = requirement;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public Date getReviseTime() {
        return reviseTime;
    }

    public void setReviseTime(Date reviseTime) {
        this.reviseTime = reviseTime;
    }

    @Override
    public String toString() {
        return "TechnologyRequirement{" +
                "technologyRequirementId='" + technologyRequirementId + '\'' +
                ", technologyId='" + technologyId + '\'' +
                ", technologyName='" + technologyName + '\'' +
                ", requirement='" + requirement + '\'' +
                ", addTime=" + addTime +
                ", reviseTime=" + reviseTime +
                '}';
    }
}