package cqu.domain;

import java.io.Serializable;

public class InsertStudnets implements Serializable {
    private String project;
    private String subject;
    private String classId;
    private String teacher;
    private String studentsId;
    private String studentsName;

    @Override
    public String toString() {
        return "InsertStudnets{" +
                "project='" + project + '\'' +
                ", subject='" + subject + '\'' +
                ", classId='" + classId + '\'' +
                ", teacher='" + teacher + '\'' +
                ", studentsId='" + studentsId + '\'' +
                ", studentsName='" + studentsName + '\'' +
                ", isContinue=" + isContinue +
                ", nps='" + nps + '\'' +
                '}';
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
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

    public String getNps() {
        return nps;
    }

    public void setNps(String nps) {
        this.nps = nps;
    }

    private Integer isContinue;
    private String nps;
}
