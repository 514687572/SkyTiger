package com.skytiger.net.entity.base;

import java.io.Serializable;

import com.stip.mybatis.generator.plugin.BaseModel;

public class BSysBusiness extends BaseModel<String> implements Serializable {
    private String sbId;

    private String sbName;

    private String sbPassword;

    private String sbTitle;

    private Integer sbCount;

    private String sbRemark;

    private static final long serialVersionUID = 1L;

    public String getSbId() {
        return sbId;
    }

    public void setSbId(String sbId) {
        this.sbId = sbId == null ? null : sbId.trim();
    }

    public String getSbName() {
        return sbName;
    }

    public void setSbName(String sbName) {
        this.sbName = sbName == null ? null : sbName.trim();
    }

    public String getSbPassword() {
        return sbPassword;
    }

    public void setSbPassword(String sbPassword) {
        this.sbPassword = sbPassword == null ? null : sbPassword.trim();
    }

    public String getSbTitle() {
        return sbTitle;
    }

    public void setSbTitle(String sbTitle) {
        this.sbTitle = sbTitle == null ? null : sbTitle.trim();
    }

    public Integer getSbCount() {
        return sbCount;
    }

    public void setSbCount(Integer sbCount) {
        this.sbCount = sbCount;
    }

    public String getSbRemark() {
        return sbRemark;
    }

    public void setSbRemark(String sbRemark) {
        this.sbRemark = sbRemark == null ? null : sbRemark.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", sbId=").append(sbId);
        sb.append(", sbName=").append(sbName);
        sb.append(", sbPassword=").append(sbPassword);
        sb.append(", sbTitle=").append(sbTitle);
        sb.append(", sbCount=").append(sbCount);
        sb.append(", sbRemark=").append(sbRemark);
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
        BSysBusiness other = (BSysBusiness) that;
		return false;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        return result;
    }
}