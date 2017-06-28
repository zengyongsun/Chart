package com.zy.chart;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Administrator on 2017/6/12.
 */

public class ReminderTargetBean implements Serializable {

    /**
     * checkType : 5
     * empId : 1
     * year : 2017
     * month : 6
     * queryType : 1
     * personalTargetTypeList : [{"checkType":"1","checkTypeName":"电话拜访客户数"},{"checkType":"2","checkTypeName":"外出拜访客户数"},{"checkType":"4","checkTypeName":"新增机会数"}]
     */

    private String checkType;
    private String empId;
    private String year;
    private String month;
    private String queryType;
    private ArrayList<TargetTypeBean> personalTargetTypeList;
    public ArrayList<TargetTypeBean> orgTargetTypeList;

    public ArrayList<TargetTypeBean> getOrgTargetTypeList() {
        return orgTargetTypeList;
    }

    public void setOrgTargetTypeList(ArrayList<TargetTypeBean> orgTargetTypeList) {
        this.orgTargetTypeList = orgTargetTypeList;
    }

    public String getCheckType() {
        return checkType;
    }

    public void setCheckType(String checkType) {
        this.checkType = checkType;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getQueryType() {
        return queryType;
    }

    public void setQueryType(String queryType) {
        this.queryType = queryType;
    }

    public ArrayList<TargetTypeBean> getPersonalTargetTypeList() {
        return personalTargetTypeList;
    }

    public void setPersonalTargetTypeList(ArrayList<TargetTypeBean> personalTargetTypeList) {
        this.personalTargetTypeList = personalTargetTypeList;
    }

}
