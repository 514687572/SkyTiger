package com.skytiger.net.entity.base;

import java.io.Serializable;

import com.stip.mybatis.generator.plugin.BaseModel;

public class BAddressInfo extends BaseModel<String> implements Serializable {
    private String infoId;

    private String infoName;

    private String infoPhone;

    private String infoProvince;

    private String infoCity;

    private String infoArea;

    private String addressDetails;

    private String infoRemark;

    private static final long serialVersionUID = 1L;

    public String getInfoId() {
        return infoId;
    }

    public void setInfoId(String infoId) {
        this.infoId = infoId == null ? null : infoId.trim();
    }

    public String getInfoName() {
        return infoName;
    }

    public void setInfoName(String infoName) {
        this.infoName = infoName == null ? null : infoName.trim();
    }

    public String getInfoPhone() {
        return infoPhone;
    }

    public void setInfoPhone(String infoPhone) {
        this.infoPhone = infoPhone == null ? null : infoPhone.trim();
    }

    public String getInfoProvince() {
        return infoProvince;
    }

    public void setInfoProvince(String infoProvince) {
        this.infoProvince = infoProvince == null ? null : infoProvince.trim();
    }

    public String getInfoCity() {
        return infoCity;
    }

    public void setInfoCity(String infoCity) {
        this.infoCity = infoCity == null ? null : infoCity.trim();
    }

    public String getInfoArea() {
        return infoArea;
    }

    public void setInfoArea(String infoArea) {
        this.infoArea = infoArea == null ? null : infoArea.trim();
    }

    public String getAddressDetails() {
        return addressDetails;
    }

    public void setAddressDetails(String addressDetails) {
        this.addressDetails = addressDetails == null ? null : addressDetails.trim();
    }

    public String getInfoRemark() {
        return infoRemark;
    }

    public void setInfoRemark(String infoRemark) {
        this.infoRemark = infoRemark == null ? null : infoRemark.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", infoId=").append(infoId);
        sb.append(", infoName=").append(infoName);
        sb.append(", infoPhone=").append(infoPhone);
        sb.append(", infoProvince=").append(infoProvince);
        sb.append(", infoCity=").append(infoCity);
        sb.append(", infoArea=").append(infoArea);
        sb.append(", addressDetails=").append(addressDetails);
        sb.append(", infoRemark=").append(infoRemark);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        BAddressInfo other = (BAddressInfo) that;
        return (this.getInfoId() == null ? other.getInfoId() == null : this.getInfoId().equals(other.getInfoId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getInfoId() == null) ? 0 : getInfoId().hashCode());
        return result;
    }
}