package com.skytiger.net.entity.base;

import com.stip.mybatis.generator.plugin.BaseModel;
import java.io.Serializable;
import java.util.Date;

public class BSysTask extends BaseModel<String> implements Serializable {
    private String taskId;

    private String taskUrl;

    private Integer taskCount;

    private String taskStatus;

    private Date taskTime;

    private String taskBusinessName;

    private String hostName;

    private String taskRemark;

    private static final long serialVersionUID = 1L;

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId == null ? null : taskId.trim();
    }

    public String getTaskUrl() {
        return taskUrl;
    }

    public void setTaskUrl(String taskUrl) {
        this.taskUrl = taskUrl == null ? null : taskUrl.trim();
    }

    public Integer getTaskCount() {
        return taskCount;
    }

    public void setTaskCount(Integer taskCount) {
        this.taskCount = taskCount;
    }

    public String getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(String taskStatus) {
        this.taskStatus = taskStatus == null ? null : taskStatus.trim();
    }

    public Date getTaskTime() {
        return taskTime;
    }

    public void setTaskTime(Date taskTime) {
        this.taskTime = taskTime;
    }

    public String getTaskBusinessName() {
        return taskBusinessName;
    }

    public void setTaskBusinessName(String taskBusinessName) {
        this.taskBusinessName = taskBusinessName == null ? null : taskBusinessName.trim();
    }

    public String getHostName() {
        return hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName == null ? null : hostName.trim();
    }

    public String getTaskRemark() {
        return taskRemark;
    }

    public void setTaskRemark(String taskRemark) {
        this.taskRemark = taskRemark == null ? null : taskRemark.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", taskId=").append(taskId);
        sb.append(", taskUrl=").append(taskUrl);
        sb.append(", taskCount=").append(taskCount);
        sb.append(", taskStatus=").append(taskStatus);
        sb.append(", taskTime=").append(taskTime);
        sb.append(", taskBusinessName=").append(taskBusinessName);
        sb.append(", hostName=").append(hostName);
        sb.append(", taskRemark=").append(taskRemark);
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
        BSysTask other = (BSysTask) that;
        return (this.getTaskId() == null ? other.getTaskId() == null : this.getTaskId().equals(other.getTaskId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getTaskId() == null) ? 0 : getTaskId().hashCode());
        return result;
    }
}