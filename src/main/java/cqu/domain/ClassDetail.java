package cqu.domain;

import java.io.Serializable;

public class ClassDetail implements Serializable {
    private Integer count;
    private Integer work;
    private Integer video;
    private Integer note;
    private Integer knowledgeMaster;

    @Override
    public String toString() {
        return "ClassDetail{" +
                "count=" + count +
                ", work=" + work +
                ", video=" + video +
                ", note=" + note +
                ", knowledgeMaster=" + knowledgeMaster +
                '}';
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
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
}
