package cqu.domain;

import java.io.Serializable;

public class UpdateStudents implements Serializable {
    private String project;
    private String subject;
    private String classId;
    private String teacher;
    private String studentsId;
    private String studentsName;
    private Integer count;
    private Integer weChat;
    private Integer zhangYou;
    private Integer shoppingCart;
    private Integer work;
    private Integer note;
    private Integer video;
    private Integer knowledgeMaster;
    private String workRatio;
    private String noteRatio;
    private String videoRatio;
    private String knowledgeMasterRatio;

    public UpdateStudents(String classId, String studentsId, Integer work, Integer note, Integer video, Integer knowledgeMaster, String workRatio, String noteRatio, String videoRatio, String knowledgeMasterRatio) {
        this.classId = classId;
        this.studentsId = studentsId;
        this.work = work;
        this.note = note;
        this.video = video;
        this.knowledgeMaster = knowledgeMaster;
        this.workRatio = workRatio;
        this.noteRatio = noteRatio;
        this.videoRatio = videoRatio;
        this.knowledgeMasterRatio = knowledgeMasterRatio;
    }

    public UpdateStudents() {
    }

    private Integer oneToOne;
    private Integer isContinue;


    @Override
    public String toString() {
        return "UpdateStudents{" +
                "project='" + project + '\'' +
                ", subject='" + subject + '\'' +
                ", classId='" + classId + '\'' +
                ", teacher='" + teacher + '\'' +
                ", studentsId='" + studentsId + '\'' +
                ", studentsName='" + studentsName + '\'' +
                ", count=" + count +
                ", weChat=" + weChat +
                ", zhangYou=" + zhangYou +
                ", shoppingCart=" + shoppingCart +
                ", work=" + work +
                ", note=" + note +
                ", video=" + video +
                ", knowledgeMaster=" + knowledgeMaster +
                ", workRatio='" + workRatio + '\'' +
                ", noteRatio='" + noteRatio + '\'' +
                ", videoRatio='" + videoRatio + '\'' +
                ", knowledgeMasterRatio='" + knowledgeMasterRatio + '\'' +
                ", oneToOne=" + oneToOne +
                ", isContinue=" + isContinue +
                '}';
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }


    public Integer getKnowledgeMaster() {
        return knowledgeMaster;
    }

    public void setKnowledgeMaster(Integer knowledgeMaster) {
        this.knowledgeMaster = knowledgeMaster;
    }

    public String getKnowledgeMasterRatio() {
        return knowledgeMasterRatio;
    }

    public void setKnowledgeMasterRatio(String knowledgeMasterRatio) {
        this.knowledgeMasterRatio = knowledgeMasterRatio;
    }

    public String getWorkRatio() {
        return workRatio;
    }

    public void setWorkRatio(String workRatio) {
        this.workRatio = workRatio;
    }

    public String getNoteRatio() {
        return noteRatio;
    }

    public void setNoteRatio(String noteRatio) {
        this.noteRatio = noteRatio;
    }

    public String getVideoRatio() {
        return videoRatio;
    }

    public void setVideoRatio(String videoRatio) {
        this.videoRatio = videoRatio;
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

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getWeChat() {
        return weChat;
    }

    public void setWeChat(Integer weChat) {
        this.weChat = weChat;
    }

    public Integer getZhangYou() {
        return zhangYou;
    }

    public void setZhangYou(Integer zhangYou) {
        this.zhangYou = zhangYou;
    }

    public Integer getShoppingCart() {
        return shoppingCart;
    }

    public void setShoppingCart(Integer shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    public Integer getOneToOne() {
        return oneToOne;
    }

    public void setOneToOne(Integer oneToOne) {
        this.oneToOne = oneToOne;
    }

    public Integer getIsContinue() {
        return isContinue;
    }

    public void setIsContinue(Integer isContinue) {
        this.isContinue = isContinue;
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

}
