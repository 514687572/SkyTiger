package com.skytiger.net.entity.base;

import java.io.Serializable;

import com.stip.mybatis.generator.plugin.BaseModel;

public class BDictionary extends BaseModel<String> implements Serializable {
    private String dicId;

    private String dicKey;

    private String dicValue;

    private String dicType;

    private String remark;

    private static final long serialVersionUID = 1L;

    public String getDicId() {
        return dicId;
    }

    public void setDicId(String dicId) {
        this.dicId = dicId == null ? null : dicId.trim();
    }

    public String getDicKey() {
        return dicKey;
    }

    public void setDicKey(String dicKey) {
        this.dicKey = dicKey == null ? null : dicKey.trim();
    }

    public String getDicValue() {
        return dicValue;
    }

    public void setDicValue(String dicValue) {
        this.dicValue = dicValue == null ? null : dicValue.trim();
    }

    public String getDicType() {
        return dicType;
    }

    public void setDicType(String dicType) {
        this.dicType = dicType == null ? null : dicType.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", dicId=").append(dicId);
        sb.append(", dicKey=").append(dicKey);
        sb.append(", dicValue=").append(dicValue);
        sb.append(", dicType=").append(dicType);
        sb.append(", remark=").append(remark);
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
        BDictionary other = (BDictionary) that;
        return (this.getDicId() == null ? other.getDicId() == null : this.getDicId().equals(other.getDicId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getDicId() == null) ? 0 : getDicId().hashCode());
        return result;
    }
}