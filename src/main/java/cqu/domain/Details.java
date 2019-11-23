package cqu.domain;


import java.io.Serializable;

public class Details implements Serializable {
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
    private Integer workOne;
    private Integer workTwo;
    private Integer workThree;
    private Integer workFour;
    private Integer workFive;
    private Integer workSix;
    private Integer workSeven;
    private Integer workEight;
    private Integer workNine;
    private Integer workTen;
    private Integer workEleven;
    private Integer workTwelve;
    private Integer workThirteen;
    private Integer workFourteen;
    private Integer workFifteen;
    private Integer workSixteen;
    private Integer workSeventeen;
    private Integer workEighteen;
    private Integer workNineteen;
    private Integer workTwenty;
    private Integer workTotal;
    private String workRatio;
    private Integer videoOne;
    private Integer videoTwo;
    private Integer videoThree;
    private Integer videoFour;
    private Integer videoFive;
    private Integer videoSix;
    private Integer videoSeven;
    private Integer videoEight;
    private Integer videoNine;
    private Integer videoTen;
    private Integer videoEleven;
    private Integer videoTwelve;
    private Integer videoThirteen;
    private Integer videoFourteen;
    private Integer videoFifteen;
    private Integer videoSixteen;
    private Integer videoSeventeen;
    private Integer videoEighteen;
    private Integer videoNineteen;
    private Integer videoTwenty;
    private Integer videoTotal;
    private String videoRatio;
    private Integer noteOne;
    private Integer noteTwo;
    private Integer noteThree;
    private Integer noteFour;
    private Integer noteFive;
    private Integer noteSix;
    private Integer noteSeven;
    private Integer noteEight;
    private Integer noteNine;
    private Integer noteTen;
    private Integer noteEleven;
    private Integer noteTwelve;
    private Integer noteThirteen;
    private Integer noteFourteen;
    private Integer noteFifteen;
    private Integer noteSixteen;
    private Integer noteSeventeen;
    private Integer noteEighteen;
    private Integer noteNineteen;
    private Integer noteTwenty;
    private Integer noteTotal;
    private Integer knowledgeMasterOne;
    private Integer knowledgeMasterTwo;
    private Integer knowledgeMasterThree;
    private Integer knowledgeMasterFour;
    private Integer knowledgeMasterFive;
    private Integer knowledgeMasterSix;
    private Integer knowledgeMasterSeven;
    private Integer knowledgeMasterEight;
    private Integer knowledgeMasterNine;
    private Integer knowledgeMasterTen;
    private Integer knowledgeMasterEleven;
    private Integer knowledgeMasterTwelve;
    private Integer knowledgeMasterThirteen;
    private Integer knowledgeMasterFourteen;
    private Integer knowledgeMasterFifteen;
    private Integer knowledgeMasterSixteen;
    private Integer knowledgeMasterSeventeen;
    private Integer knowledgeMasterEighteen;
    private Integer knowledgeMasterNineteen;
    private Integer knowledgeMasterTwenty;
    private Integer knowledgeMasterTotal;
    private String noteRatio;
    private Integer isContinue;
    private Integer oneToOneSum;
    private Integer oneToOne;
    private Integer isUpdate;

    public Integer getIsUpdate() {
        return isUpdate;
    }

    public void setIsUpdate(Integer isUpdate) {
        this.isUpdate = isUpdate;
    }

    @Override
    public String toString() {
        return "Details{" +
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
                ", workOne=" + workOne +
                ", workTwo=" + workTwo +
                ", workThree=" + workThree +
                ", workFour=" + workFour +
                ", workFive=" + workFive +
                ", workSix=" + workSix +
                ", workSeven=" + workSeven +
                ", workEight=" + workEight +
                ", workNine=" + workNine +
                ", workTen=" + workTen +
                ", workEleven=" + workEleven +
                ", workTwelve=" + workTwelve +
                ", workThirteen=" + workThirteen +
                ", workFourteen=" + workFourteen +
                ", workFifteen=" + workFifteen +
                ", workSixteen=" + workSixteen +
                ", workSeventeen=" + workSeventeen +
                ", workEighteen=" + workEighteen +
                ", workNineteen=" + workNineteen +
                ", workTwenty=" + workTwenty +
                ", workTotal=" + workTotal +
                ", workRatio='" + workRatio + '\'' +
                ", videoOne=" + videoOne +
                ", videoTwo=" + videoTwo +
                ", videoThree=" + videoThree +
                ", videoFour=" + videoFour +
                ", videoFive=" + videoFive +
                ", videoSix=" + videoSix +
                ", videoSeven=" + videoSeven +
                ", videoEight=" + videoEight +
                ", videoNine=" + videoNine +
                ", videoTen=" + videoTen +
                ", videoEleven=" + videoEleven +
                ", videoTwelve=" + videoTwelve +
                ", videoThirteen=" + videoThirteen +
                ", videoFourteen=" + videoFourteen +
                ", videoFifteen=" + videoFifteen +
                ", videoSixteen=" + videoSixteen +
                ", videoSeventeen=" + videoSeventeen +
                ", videoEighteen=" + videoEighteen +
                ", videoNineteen=" + videoNineteen +
                ", videoTwenty=" + videoTwenty +
                ", videoTotal=" + videoTotal +
                ", videoRatio='" + videoRatio + '\'' +
                ", noteOne=" + noteOne +
                ", noteTwo=" + noteTwo +
                ", noteThree=" + noteThree +
                ", noteFour=" + noteFour +
                ", noteFive=" + noteFive +
                ", noteSix=" + noteSix +
                ", noteSeven=" + noteSeven +
                ", noteEight=" + noteEight +
                ", noteNine=" + noteNine +
                ", noteTen=" + noteTen +
                ", noteEleven=" + noteEleven +
                ", noteTwelve=" + noteTwelve +
                ", noteThirteen=" + noteThirteen +
                ", noteFourteen=" + noteFourteen +
                ", noteFifteen=" + noteFifteen +
                ", noteSixteen=" + noteSixteen +
                ", noteSeventeen=" + noteSeventeen +
                ", noteEighteen=" + noteEighteen +
                ", noteNineteen=" + noteNineteen +
                ", noteTwenty=" + noteTwenty +
                ", noteTotal=" + noteTotal +
                ", knowledgeMasterOne=" + knowledgeMasterOne +
                ", knowledgeMasterTwo=" + knowledgeMasterTwo +
                ", knowledgeMasterThree=" + knowledgeMasterThree +
                ", knowledgeMasterFour=" + knowledgeMasterFour +
                ", knowledgeMasterFive=" + knowledgeMasterFive +
                ", knowledgeMasterSix=" + knowledgeMasterSix +
                ", knowledgeMasterSeven=" + knowledgeMasterSeven +
                ", knowledgeMasterEight=" + knowledgeMasterEight +
                ", knowledgeMasterNine=" + knowledgeMasterNine +
                ", knowledgeMasterTen=" + knowledgeMasterTen +
                ", knowledgeMasterEleven=" + knowledgeMasterEleven +
                ", knowledgeMasterTwelve=" + knowledgeMasterTwelve +
                ", knowledgeMasterThirteen=" + knowledgeMasterThirteen +
                ", knowledgeMasterFourteen=" + knowledgeMasterFourteen +
                ", knowledgeMasterFifteen=" + knowledgeMasterFifteen +
                ", knowledgeMasterSixteen=" + knowledgeMasterSixteen +
                ", knowledgeMasterSeventeen=" + knowledgeMasterSeventeen +
                ", knowledgeMasterEighteen=" + knowledgeMasterEighteen +
                ", knowledgeMasterNineteen=" + knowledgeMasterNineteen +
                ", knowledgeMasterTwenty=" + knowledgeMasterTwenty +
                ", knowledgeMasterTotal=" + knowledgeMasterTotal +
                ", noteRatio='" + noteRatio + '\'' +
                ", isContinue=" + isContinue +
                ", oneToOneSum=" + oneToOneSum +
                ", oneToOne=" + oneToOne +
                ", isUpdate=" + isUpdate +
                ", nps='" + nps + '\'' +
                ", knowledgeMasterRatio='" + knowledgeMasterRatio + '\'' +
                '}';
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Integer getOneToOne() {
        return oneToOne;
    }

    public void setOneToOne(Integer oneToOne) {
        this.oneToOne = oneToOne;
    }

    private String nps;
    private String knowledgeMasterRatio;


    public Integer getKnowledgeMasterOne() {
        return knowledgeMasterOne;
    }

    public void setKnowledgeMasterOne(Integer knowledgeMasterOne) {
        this.knowledgeMasterOne = knowledgeMasterOne;
    }

    public Integer getKnowledgeMasterTwo() {
        return knowledgeMasterTwo;
    }

    public void setKnowledgeMasterTwo(Integer knowledgeMasterTwo) {
        this.knowledgeMasterTwo = knowledgeMasterTwo;
    }

    public Integer getKnowledgeMasterThree() {
        return knowledgeMasterThree;
    }

    public void setKnowledgeMasterThree(Integer knowledgeMasterThree) {
        this.knowledgeMasterThree = knowledgeMasterThree;
    }

    public Integer getKnowledgeMasterFour() {
        return knowledgeMasterFour;
    }

    public void setKnowledgeMasterFour(Integer knowledgeMasterFour) {
        this.knowledgeMasterFour = knowledgeMasterFour;
    }

    public Integer getKnowledgeMasterFive() {
        return knowledgeMasterFive;
    }

    public void setKnowledgeMasterFive(Integer knowledgeMasterFive) {
        this.knowledgeMasterFive = knowledgeMasterFive;
    }

    public Integer getKnowledgeMasterSix() {
        return knowledgeMasterSix;
    }

    public void setKnowledgeMasterSix(Integer knowledgeMasterSix) {
        this.knowledgeMasterSix = knowledgeMasterSix;
    }

    public Integer getKnowledgeMasterSeven() {
        return knowledgeMasterSeven;
    }

    public void setKnowledgeMasterSeven(Integer knowledgeMasterSeven) {
        this.knowledgeMasterSeven = knowledgeMasterSeven;
    }

    public Integer getKnowledgeMasterEight() {
        return knowledgeMasterEight;
    }

    public void setKnowledgeMasterEight(Integer knowledgeMasterEight) {
        this.knowledgeMasterEight = knowledgeMasterEight;
    }

    public Integer getKnowledgeMasterNine() {
        return knowledgeMasterNine;
    }

    public void setKnowledgeMasterNine(Integer knowledgeMasterNine) {
        this.knowledgeMasterNine = knowledgeMasterNine;
    }

    public Integer getKnowledgeMasterTen() {
        return knowledgeMasterTen;
    }

    public void setKnowledgeMasterTen(Integer knowledgeMasterTen) {
        this.knowledgeMasterTen = knowledgeMasterTen;
    }

    public Integer getKnowledgeMasterEleven() {
        return knowledgeMasterEleven;
    }

    public void setKnowledgeMasterEleven(Integer knowledgeMasterEleven) {
        this.knowledgeMasterEleven = knowledgeMasterEleven;
    }

    public Integer getKnowledgeMasterTwelve() {
        return knowledgeMasterTwelve;
    }

    public void setKnowledgeMasterTwelve(Integer knowledgeMasterTwelve) {
        this.knowledgeMasterTwelve = knowledgeMasterTwelve;
    }

    public Integer getKnowledgeMasterThirteen() {
        return knowledgeMasterThirteen;
    }

    public void setKnowledgeMasterThirteen(Integer knowledgeMasterThirteen) {
        this.knowledgeMasterThirteen = knowledgeMasterThirteen;
    }

    public Integer getKnowledgeMasterFourteen() {
        return knowledgeMasterFourteen;
    }

    public void setKnowledgeMasterFourteen(Integer knowledgeMasterFourteen) {
        this.knowledgeMasterFourteen = knowledgeMasterFourteen;
    }

    public Integer getKnowledgeMasterFifteen() {
        return knowledgeMasterFifteen;
    }

    public void setKnowledgeMasterFifteen(Integer knowledgeMasterFifteen) {
        this.knowledgeMasterFifteen = knowledgeMasterFifteen;
    }

    public Integer getKnowledgeMasterSixteen() {
        return knowledgeMasterSixteen;
    }

    public void setKnowledgeMasterSixteen(Integer knowledgeMasterSixteen) {
        this.knowledgeMasterSixteen = knowledgeMasterSixteen;
    }

    public Integer getKnowledgeMasterSeventeen() {
        return knowledgeMasterSeventeen;
    }

    public void setKnowledgeMasterSeventeen(Integer knowledgeMasterSeventeen) {
        this.knowledgeMasterSeventeen = knowledgeMasterSeventeen;
    }

    public Integer getKnowledgeMasterEighteen() {
        return knowledgeMasterEighteen;
    }

    public void setKnowledgeMasterEighteen(Integer knowledgeMasterEighteen) {
        this.knowledgeMasterEighteen = knowledgeMasterEighteen;
    }

    public Integer getKnowledgeMasterNineteen() {
        return knowledgeMasterNineteen;
    }

    public void setKnowledgeMasterNineteen(Integer knowledgeMasterNineteen) {
        this.knowledgeMasterNineteen = knowledgeMasterNineteen;
    }

    public Integer getKnowledgeMasterTwenty() {
        return knowledgeMasterTwenty;
    }

    public void setKnowledgeMasterTwenty(Integer knowledgeMasterTwenty) {
        this.knowledgeMasterTwenty = knowledgeMasterTwenty;
    }

    public Integer getKnowledgeMasterTotal() {
        return knowledgeMasterTotal;
    }

    public void setKnowledgeMasterTotal(Integer knowledgeMasterTotal) {
        this.knowledgeMasterTotal = knowledgeMasterTotal;
    }

    public Integer getWorkEight() {
        return workEight;
    }

    public void setWorkEight(Integer workEight) {
        this.workEight = workEight;
    }

    public Integer getWorkNine() {
        return workNine;
    }

    public void setWorkNine(Integer workNine) {
        this.workNine = workNine;
    }

    public Integer getWorkTen() {
        return workTen;
    }

    public void setWorkTen(Integer workTen) {
        this.workTen = workTen;
    }

    public Integer getWorkEleven() {
        return workEleven;
    }

    public void setWorkEleven(Integer workEleven) {
        this.workEleven = workEleven;
    }

    public Integer getWorkTwelve() {
        return workTwelve;
    }

    public void setWorkTwelve(Integer workTwelve) {
        this.workTwelve = workTwelve;
    }

    public Integer getWorkThirteen() {
        return workThirteen;
    }

    public void setWorkThirteen(Integer workThirteen) {
        this.workThirteen = workThirteen;
    }

    public Integer getWorkFourteen() {
        return workFourteen;
    }

    public void setWorkFourteen(Integer workFourteen) {
        this.workFourteen = workFourteen;
    }

    public Integer getWorkFifteen() {
        return workFifteen;
    }

    public void setWorkFifteen(Integer workFifteen) {
        this.workFifteen = workFifteen;
    }

    public Integer getWorkSixteen() {
        return workSixteen;
    }

    public void setWorkSixteen(Integer workSixteen) {
        this.workSixteen = workSixteen;
    }

    public Integer getWorkSeventeen() {
        return workSeventeen;
    }

    public void setWorkSeventeen(Integer workSeventeen) {
        this.workSeventeen = workSeventeen;
    }

    public Integer getWorkEighteen() {
        return workEighteen;
    }

    public void setWorkEighteen(Integer workEighteen) {
        this.workEighteen = workEighteen;
    }

    public Integer getWorkNineteen() {
        return workNineteen;
    }

    public void setWorkNineteen(Integer workNineteen) {
        this.workNineteen = workNineteen;
    }

    public Integer getWorkTwenty() {
        return workTwenty;
    }

    public void setWorkTwenty(Integer workTwenty) {
        this.workTwenty = workTwenty;
    }

    public Integer getVideoEight() {
        return videoEight;
    }

    public void setVideoEight(Integer videoEight) {
        this.videoEight = videoEight;
    }

    public Integer getVideoNine() {
        return videoNine;
    }

    public void setVideoNine(Integer videoNine) {
        this.videoNine = videoNine;
    }

    public Integer getVideoTen() {
        return videoTen;
    }

    public void setVideoTen(Integer videoTen) {
        this.videoTen = videoTen;
    }

    public Integer getVideoEleven() {
        return videoEleven;
    }

    public void setVideoEleven(Integer videoEleven) {
        this.videoEleven = videoEleven;
    }

    public Integer getVideoTwelve() {
        return videoTwelve;
    }

    public void setVideoTwelve(Integer videoTwelve) {
        this.videoTwelve = videoTwelve;
    }

    public Integer getVideoThirteen() {
        return videoThirteen;
    }

    public void setVideoThirteen(Integer videoThirteen) {
        this.videoThirteen = videoThirteen;
    }

    public Integer getVideoFourteen() {
        return videoFourteen;
    }

    public void setVideoFourteen(Integer videoFourteen) {
        this.videoFourteen = videoFourteen;
    }

    public Integer getVideoFifteen() {
        return videoFifteen;
    }

    public void setVideoFifteen(Integer videoFifteen) {
        this.videoFifteen = videoFifteen;
    }

    public Integer getVideoSixteen() {
        return videoSixteen;
    }

    public void setVideoSixteen(Integer videoSixteen) {
        this.videoSixteen = videoSixteen;
    }

    public Integer getVideoSeventeen() {
        return videoSeventeen;
    }

    public void setVideoSeventeen(Integer videoSeventeen) {
        this.videoSeventeen = videoSeventeen;
    }

    public Integer getVideoEighteen() {
        return videoEighteen;
    }

    public void setVideoEighteen(Integer videoEighteen) {
        this.videoEighteen = videoEighteen;
    }

    public Integer getVideoNineteen() {
        return videoNineteen;
    }

    public void setVideoNineteen(Integer videoNineteen) {
        this.videoNineteen = videoNineteen;
    }

    public Integer getVideoTwenty() {
        return videoTwenty;
    }

    public void setVideoTwenty(Integer videoTwenty) {
        this.videoTwenty = videoTwenty;
    }

    public Integer getNoteEight() {
        return noteEight;
    }

    public void setNoteEight(Integer noteEight) {
        this.noteEight = noteEight;
    }

    public Integer getNoteNine() {
        return noteNine;
    }

    public void setNoteNine(Integer noteNine) {
        this.noteNine = noteNine;
    }

    public Integer getNoteTen() {
        return noteTen;
    }

    public void setNoteTen(Integer noteTen) {
        this.noteTen = noteTen;
    }

    public Integer getNoteEleven() {
        return noteEleven;
    }

    public void setNoteEleven(Integer noteEleven) {
        this.noteEleven = noteEleven;
    }

    public Integer getNoteTwelve() {
        return noteTwelve;
    }

    public void setNoteTwelve(Integer noteTwelve) {
        this.noteTwelve = noteTwelve;
    }

    public Integer getNoteThirteen() {
        return noteThirteen;
    }

    public void setNoteThirteen(Integer noteThirteen) {
        this.noteThirteen = noteThirteen;
    }

    public Integer getNoteFourteen() {
        return noteFourteen;
    }

    public void setNoteFourteen(Integer noteFourteen) {
        this.noteFourteen = noteFourteen;
    }

    public Integer getNoteFifteen() {
        return noteFifteen;
    }

    public void setNoteFifteen(Integer noteFifteen) {
        this.noteFifteen = noteFifteen;
    }

    public Integer getNoteSixteen() {
        return noteSixteen;
    }

    public void setNoteSixteen(Integer noteSixteen) {
        this.noteSixteen = noteSixteen;
    }

    public Integer getNoteSeventeen() {
        return noteSeventeen;
    }

    public void setNoteSeventeen(Integer noteSeventeen) {
        this.noteSeventeen = noteSeventeen;
    }

    public Integer getNoteEighteen() {
        return noteEighteen;
    }

    public void setNoteEighteen(Integer noteEighteen) {
        this.noteEighteen = noteEighteen;
    }

    public Integer getNoteNineteen() {
        return noteNineteen;
    }

    public void setNoteNineteen(Integer noteNineteen) {
        this.noteNineteen = noteNineteen;
    }

    public Integer getNoteTwenty() {
        return noteTwenty;
    }

    public void setNoteTwenty(Integer noteTwenty) {
        this.noteTwenty = noteTwenty;
    }

    public String getNps() {
        return nps;
    }

    public void setNps(String nps) {
        this.nps = nps;
    }

    public String getKnowledgeMasterRatio() {
        return knowledgeMasterRatio;
    }

    public void setKnowledgeMasterRatio(String knowledgeMasterRatio) {
        this.knowledgeMasterRatio = knowledgeMasterRatio;
    }

    public Integer getIsContinue() {
        return isContinue;
    }

    public void setIsContinue(Integer isContinue) {
        this.isContinue = isContinue;
    }

    public Integer getOneToOneSum() {
        return oneToOneSum;
    }

    public void setOneToOneSum(Integer oneToOneSum) {
        this.oneToOneSum = oneToOneSum;
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

    public void setStudentsId(String studentId) {
        this.studentsId = studentId;
    }

    public String getStudentsName() {
        return studentsName;
    }

    public void setStudentsName(String studnetName) {
        this.studentsName = studnetName;
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

    public Integer getWorkOne() {
        return workOne;
    }

    public void setWorkOne(Integer workOne) {
        this.workOne = workOne;
    }

    public Integer getWorkTwo() {
        return workTwo;
    }

    public void setWorkTwo(Integer workTwo) {
        this.workTwo = workTwo;
    }

    public Integer getWorkThree() {
        return workThree;
    }

    public void setWorkThree(Integer workThree) {
        this.workThree = workThree;
    }

    public Integer getWorkFour() {
        return workFour;
    }

    public void setWorkFour(Integer workFour) {
        this.workFour = workFour;
    }

    public Integer getWorkFive() {
        return workFive;
    }

    public void setWorkFive(Integer workFive) {
        this.workFive = workFive;
    }

    public Integer getWorkSix() {
        return workSix;
    }

    public void setWorkSix(Integer workSix) {
        this.workSix = workSix;
    }

    public Integer getWorkSeven() {
        return workSeven;
    }

    public void setWorkSeven(Integer workSeven) {
        this.workSeven = workSeven;
    }

    public Integer getWorkTotal() {
        return workTotal;
    }

    public void setWorkTotal(Integer workTotal) {
        this.workTotal = workTotal;
    }

    public String getWorkRatio() {
        return workRatio;
    }

    public void setWorkRatio(String workRatio) {
        this.workRatio = workRatio;
    }

    public Integer getVideoOne() {
        return videoOne;
    }

    public void setVideoOne(Integer videoOne) {
        this.videoOne = videoOne;
    }

    public Integer getVideoTwo() {
        return videoTwo;
    }

    public void setVideoTwo(Integer videoTwo) {
        this.videoTwo = videoTwo;
    }

    public Integer getVideoThree() {
        return videoThree;
    }

    public void setVideoThree(Integer videoThree) {
        this.videoThree = videoThree;
    }

    public Integer getVideoFour() {
        return videoFour;
    }

    public void setVideoFour(Integer videoFour) {
        this.videoFour = videoFour;
    }

    public Integer getVideoFive() {
        return videoFive;
    }

    public void setVideoFive(Integer videoFive) {
        this.videoFive = videoFive;
    }

    public Integer getVideoSix() {
        return videoSix;
    }

    public void setVideoSix(Integer videoSix) {
        this.videoSix = videoSix;
    }

    public Integer getVideoSeven() {
        return videoSeven;
    }

    public void setVideoSeven(Integer videoSeven) {
        this.videoSeven = videoSeven;
    }

    public Integer getVideoTotal() {
        return videoTotal;
    }

    public void setVideoTotal(Integer videoTotal) {
        this.videoTotal = videoTotal;
    }

    public String getVideoRatio() {
        return videoRatio;
    }

    public void setVideoRatio(String videoRatio) {
        this.videoRatio = videoRatio;
    }

    public Integer getNoteOne() {
        return noteOne;
    }

    public void setNoteOne(Integer noteOne) {
        this.noteOne = noteOne;
    }

    public Integer getNoteTwo() {
        return noteTwo;
    }

    public void setNoteTwo(Integer noteTwo) {
        this.noteTwo = noteTwo;
    }

    public Integer getNoteThree() {
        return noteThree;
    }

    public void setNoteThree(Integer noteThree) {
        this.noteThree = noteThree;
    }

    public Integer getNoteFour() {
        return noteFour;
    }

    public void setNoteFour(Integer noteFour) {
        this.noteFour = noteFour;
    }

    public Integer getNoteFive() {
        return noteFive;
    }

    public void setNoteFive(Integer noteFive) {
        this.noteFive = noteFive;
    }

    public Integer getNoteSix() {
        return noteSix;
    }

    public void setNoteSix(Integer noteSix) {
        this.noteSix = noteSix;
    }

    public Integer getNoteSeven() {
        return noteSeven;
    }

    public void setNoteSeven(Integer noteSeven) {
        this.noteSeven = noteSeven;
    }

    public Integer getNoteTotal() {
        return noteTotal;
    }

    public void setNoteTotal(Integer noteTotal) {
        this.noteTotal = noteTotal;
    }

    public String getNoteRatio() {
        return noteRatio;
    }

    public void setNoteRatio(String noteRatio) {
        this.noteRatio = noteRatio;
    }
}
