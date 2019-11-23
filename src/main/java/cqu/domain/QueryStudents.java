package cqu.domain;

import java.io.Serializable;

public class QueryStudents implements Serializable {
    private String project;
    private String subject;

    @Override
    public String toString() {
        return "QueryStudents{" +
                "project='" + project + '\'' +
                ", subject='" + subject + '\'' +
                ", classId='" + classId + '\'' +
                ", teacher='" + teacher + '\'' +
                ", studentsId='" + studentsId + '\'' +
                ", studentsName='" + studentsName + '\'' +
                ", isContinue=" + isContinue +
                ", zhangYou=" + zhangYou +
                ", weChat=" + weChat +
                ", shoppingCart=" + shoppingCart +
                ", work=" + work +
                ", video=" + video +
                ", note=" + note +
                ", knowledgeMaster=" + knowledgeMaster +
                ", workTotal=" + workTotal +
                ", videoTotal=" + videoTotal +
                ", noteTotal=" + noteTotal +
                ", knowledgeMasterTotal=" + knowledgeMasterTotal +
                ", count=" + count +
                ", oneToOne=" + oneToOne +
                ", nps='" + nps + '\'' +
                ", isUpdate=" + isUpdate +
                '}';
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    private String classId;
    private String teacher;
    private String studentsId;
    private String studentsName;
    private Integer isContinue;
    private Integer zhangYou;
    private Integer weChat;
    private Integer shoppingCart;
    private Integer work;
    private Integer video;
    private Integer note;
    private Integer knowledgeMaster;
    private Integer workTotal;
    private Integer videoTotal;
    private Integer noteTotal;
    private Integer knowledgeMasterTotal;
    private Integer count;
    private Integer oneToOne;
    private String nps;
    private Integer isUpdate;


    public Integer getWorkTotal() {
        return workTotal;
    }

    public void setWorkTotal(Integer workTotal) {
        this.workTotal = workTotal;
    }

    public Integer getVideoTotal() {
        return videoTotal;
    }

    public void setVideoTotal(Integer videoTotal) {
        this.videoTotal = videoTotal;
    }

    public Integer getNoteTotal() {
        return noteTotal;
    }

    public void setNoteTotal(Integer noteTotal) {
        this.noteTotal = noteTotal;
    }

    public Integer getKnowledgeMasterTotal() {
        return knowledgeMasterTotal;
    }

    public void setKnowledgeMasterTotal(Integer knowledgeMasterTotal) {
        this.knowledgeMasterTotal = knowledgeMasterTotal;
    }

    public Integer getIsUpdate() {
        return isUpdate;
    }

    public void setIsUpdate(Integer isUpdate) {
        this.isUpdate = isUpdate;
    }

    public String getNps() {
        return nps;
    }

    public void setNps(String nps) {
        this.nps = nps;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public String getStudentsId() {
        return studentsId;
    }

    public void setStudentsId(String studentsId) {
        this.studentsId = studentsId;
    }

    public String getStudentsName() {
        return studentsName;
    }

    public void setStudentsName(String studentsName) {
        this.studentsName = studentsName;
    }

    public Integer getIsContinue() {
        return isContinue;
    }

    public void setIsContinue(Integer isContinue) {
        this.isContinue = isContinue;
    }

    public Integer getZhangYou() {
        return zhangYou;
    }

    public void setZhangYou(Integer zhangYou) {
        this.zhangYou = zhangYou;
    }

    public Integer getWeChat() {
        return weChat;
    }

    public void setWeChat(Integer weChat) {
        this.weChat = weChat;
    }

    public Integer getShoppingCart() {
        return shoppingCart;
    }

    public void setShoppingCart(Integer shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    public Integer getWork() {
        return work;
    }

    public void setWork(Integer work) {
        this.work = work;
    }

    public Integer getVideo() {
        return video;
    }

    public void setVideo(Integer video) {
        this.video = video;
    }

    public Integer getNote() {
        return note;
    }

    public void setNote(Integer note) {
        this.note = note;
    }

    public Integer getKnowledgeMaster() {
        return knowledgeMaster;
    }

    public void setKnowledgeMaster(Integer knowledgeMaster) {
        this.knowledgeMaster = knowledgeMaster;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getOneToOne() {
        return oneToOne;
    }

    public void setOneToOne(Integer oneToOne) {
        this.oneToOne = oneToOne;
    }
}
