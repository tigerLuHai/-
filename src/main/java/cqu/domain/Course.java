package cqu.domain;

import java.io.Serializable;

public class Course implements Serializable {
    private String teacher;
    private Integer total;
    private String weChat;
    private String zhangYou;
    private String shoppingCart;
    private String workRatio;
    private String videoRatio;
    private String oneToOneRatio;
    private String noteRatio;
    private String knowledgeMasterRatio;

    @Override
    public String toString() {
        return "Course{" +
                "teacher='" + teacher + '\'' +
                ", total=" + total +
                ", weChat='" + weChat + '\'' +
                ", zhangYou='" + zhangYou + '\'' +
                ", shoppingCart='" + shoppingCart + '\'' +
                ", workRatio='" + workRatio + '\'' +
                ", videoRatio='" + videoRatio + '\'' +
                ", oneToOneRatio='" + oneToOneRatio + '\'' +
                ", noteRatio='" + noteRatio + '\'' +
                ", knowledgeMasterRatio='" + knowledgeMasterRatio + '\'' +
                ", isContinueRatio='" + isContinueRatio + '\'' +
                '}';
    }

    public String getKnowledgeMasterRatio() {
        return knowledgeMasterRatio;
    }

    public void setKnowledgeMasterRatio(String knowledgeMasterRatio) {
        this.knowledgeMasterRatio = knowledgeMasterRatio;
    }

    private String isContinueRatio;

    public String getIsContinueRatio() {
        return isContinueRatio;
    }

    public void setIsContinueRatio(String isContinueRatio) {
        this.isContinueRatio = isContinueRatio;
    }

    public String getWorkRatio() {
        return workRatio;
    }

    public void setWorkRatio(String workRatio) {
        this.workRatio = workRatio;
    }

    public String getVideoRatio() {
        return videoRatio;
    }

    public void setVideoRatio(String videoRatio) {
        this.videoRatio = videoRatio;
    }

    public String getOneToOneRatio() {
        return oneToOneRatio;
    }

    public void setOneToOneRatio(String oneToOneRatio) {
        this.oneToOneRatio = oneToOneRatio;
    }

    public String getNoteRatio() {
        return noteRatio;
    }

    public void setNoteRatio(String noteRatio) {
        this.noteRatio = noteRatio;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public String getWeChat() {
        return weChat;
    }

    public void setWeChat(String weChat) {
        this.weChat = weChat;
    }

    public String getZhangYou() {
        return zhangYou;
    }

    public void setZhangYou(String zhangYou) {
        this.zhangYou = zhangYou;
    }

    public String getShoppingCart() {
        return shoppingCart;
    }

    public void setShoppingCart(String shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

}

