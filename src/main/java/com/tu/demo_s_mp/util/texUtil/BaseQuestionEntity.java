package com.tu.demo_s_mp.util.texUtil;

/**
 * 问题entity的基础类
 */
public class BaseQuestionEntity {
    protected String creatTime;
    protected String lastModifyTime;
    protected int creatorId;
    protected int lastModifyUserId;
    protected int state; //状态 0删除 1正常
    protected String supplementaryNotes; //补充说明

    public String getLastModifyTime() {
        return lastModifyTime;
    }

    public void setLastModifyTime(String lastModifyTime) {
        this.lastModifyTime = lastModifyTime;
    }

    public String getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(String creatTime) {
        this.creatTime = creatTime;
    }

    public int getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(int creatorId) {
        this.creatorId = creatorId;
    }

    public int getLastModifyUserId() {
        return lastModifyUserId;
    }

    public void setLastModifyUserId(int lastModifyUserId) {
        this.lastModifyUserId = lastModifyUserId;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getSupplementaryNotes() {
        return supplementaryNotes;
    }

    public void setSupplementaryNotes(String supplementaryNotes) {
        this.supplementaryNotes = supplementaryNotes;
    }

    @Override
    public String toString() {
        return "BaseQuestionEntity{" +
                "creatTime='" + creatTime + '\'' +
                ", lastModifyTime='" + lastModifyTime + '\'' +
                ", creatorId=" + creatorId +
                ", lastModifyUserId=" + lastModifyUserId +
                ", state=" + state +
                ", supplementaryNotes='" + supplementaryNotes + '\'' +
                '}';
    }
}
