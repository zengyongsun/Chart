package com.zy.chart;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Administrator on 2017/6/5.
 */

public class TargetTypeBean implements Parcelable {

    private String checkType;
    private String checkTypeName;
    private Boolean selected = false;

    public TargetTypeBean(String checkType, String checkTypeName, Boolean selected) {
        this.checkType = checkType;
        this.checkTypeName = checkTypeName;
        this.selected = selected;
    }

    public Boolean getSelected() {
        return selected;
    }

    public void setSelected(Boolean selected) {
        this.selected = selected;
    }

    public String getCheckType() {
        return checkType;
    }

    public void setCheckType(String checkType) {
        this.checkType = checkType;
    }

    public String getCheckTypeName() {
        return checkTypeName;
    }

    public void setCheckTypeName(String checkTypeName) {
        this.checkTypeName = checkTypeName;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.checkType);
        dest.writeString(this.checkTypeName);
        dest.writeValue(this.selected);
    }

    public TargetTypeBean() {
    }

    protected TargetTypeBean(Parcel in) {
        this.checkType = in.readString();
        this.checkTypeName = in.readString();
        this.selected = (Boolean) in.readValue(Boolean.class.getClassLoader());
    }

    public static final Creator<TargetTypeBean> CREATOR = new Creator<TargetTypeBean>() {
        @Override
        public TargetTypeBean createFromParcel(Parcel source) {
            return new TargetTypeBean(source);
        }

        @Override
        public TargetTypeBean[] newArray(int size) {
            return new TargetTypeBean[size];
        }
    };
}
