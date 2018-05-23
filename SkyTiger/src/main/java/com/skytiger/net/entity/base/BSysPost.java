package com.skytiger.net.entity.base;

import com.stip.mybatis.generator.plugin.BaseModel;
import java.io.Serializable;
import java.util.Date;

public class BSysPost extends BaseModel<String> implements Serializable {
    private String postId;

    private String postNum;

    private Date createTime;

    private String postRemark;

    private static final long serialVersionUID = 1L;

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId == null ? null : postId.trim();
    }

    public String getPostNum() {
        return postNum;
    }

    public void setPostNum(String postNum) {
        this.postNum = postNum == null ? null : postNum.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getPostRemark() {
        return postRemark;
    }

    public void setPostRemark(String postRemark) {
        this.postRemark = postRemark == null ? null : postRemark.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", postId=").append(postId);
        sb.append(", postNum=").append(postNum);
        sb.append(", createTime=").append(createTime);
        sb.append(", postRemark=").append(postRemark);
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
        BSysPost other = (BSysPost) that;
        return (this.getPostId() == null ? other.getPostId() == null : this.getPostId().equals(other.getPostId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getPostId() == null) ? 0 : getPostId().hashCode());
        return result;
    }
}