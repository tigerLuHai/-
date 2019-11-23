package cqu.domain;

import java.io.Serializable;

public class AddStudents implements Serializable {
    private String project;
    private String subject;
    private Integer count;

    @Override
    public String toString() {
        return "AddStudents{" +
                "project='" + project + '\'' +
                ", subject='" + subject + '\'' +
                ", count=" + count +
                ", classId='" + classId + '\'' +
                ", teacher='" + teacher + '\'' +
                ", studentsId='" + studentsId + '\'' +
                ", studentsName='" + studentsName + '\'' +
                ", isContinue='" + isContinue + '\'' +
                '}';
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
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
    private String isContinue;

    public String getIsContinue() {
        return isContinue;
    }

    public void setIsContinue(String isContinue) {
        this.isContinue = isContinue;
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
}
