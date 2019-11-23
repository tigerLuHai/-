package cqu.dao;

import cqu.domain.*;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 课程dao接口
 */
@Repository
public interface DetailsDao {
    //查询所有老师
    @Select("select * ," +
            "IF (COUNT = 1, workOne ,\n" +
            "\t\t\tIF (COUNT = 2, ( workOne + workTwo ),\n" +
            "\t\t\t\tIF ( COUNT = 3,   workOne + workTwo + workThree ,\n" +
            "\t\t\t\tIF (COUNT = 4,  workOne+workTwo+workThree+workFour,\n" +
            "\t\t\t\tIF (COUNT = 5,  workOne+workTwo+workThree+workFour+workFive,\n" +
            "\t\t\t\tIF (COUNT = 6,  workOne+workTwo+workThree+workFour+workFive+workSix,\n" +
            "\t\t\t\tIF ( COUNT = 7,  workOne+workTwo+workThree+workFour+workFive+workSix+workSeven,\n" +
            "\t\t\t\tIF (COUNT = 8, workOne+workTwo+workThree+workFour+workFive+workSix+workSeven+workEight,\n" +
            "\t\t\t\tIF (COUNT = 9,  workOne+workTwo+workThree+workFour+workFive+workSix+workSeven+workEight+workNine,\n" +
            "\t\t\t\tIF (COUNT = 10, workOne+workTwo+workThree+workFour+workFive+workSix+workSeven+workEight+workNine+workTen,\n" +
            "\t\t\t\tIF (COUNT = 11, workOne+workTwo+workThree+workFour+workFive+workSix+workSeven+workEight+workNine+workTen+workEleven,\n" +
            "\t\t\t\tIF (COUNT = 12, workOne+workTwo+workThree+workFour+workFive+workSix+workSeven+workEight+workNine+workTen+workEleven+workTwelve,\n" +
            "\t\t\t\tIF (COUNT = 13, workOne+workTwo+workThree+workFour+workFive+workSix+workSeven+workEight+workNine+workTen+workEleven+workTwelve+workThirteen,\n" +
            "\t\t\t\tIF (COUNT = 14, workOne+workTwo+workThree+workFour+workFive+workSix+workSeven+workEight+workNine+workTen+workEleven+workTwelve+workThirteen+workFourteen,\n" +
            "\t\t\t\tIF (COUNT = 15, workOne+workTwo+workThree+workFour+workFive+workSix+workSeven+workEight+workNine+workTen+workEleven+workTwelve+workThirteen+workFourteen+workFifteen,\n" +
            "\t\t\t\tIF (COUNT = 16, workOne+workTwo+workThree+workFour+workFive+workSix+workSeven+workEight+workNine+workTen+workEleven+workTwelve+workThirteen+workFourteen+workFifteen+workSixteen,\n" +
            "\t\t\t\tIF (COUNT = 17, workOne+workTwo+workThree+workFour+workFive+workSix+workSeven+workEight+workNine+workTen+workEleven+workTwelve+workThirteen+workFourteen+workFifteen+workSixteen+workSeventeen,\n" +
            "\t\t\t\tIF (COUNT = 18, workOne+workTwo+workThree+workFour+workFive+workSix+workSeven+workEight+workNine+workTen+workEleven+workTwelve+workThirteen+workFourteen+workFifteen+workSixteen+workSeventeen+workEighteen,\n" +
            "\t\t\t\tIF (COUNT = 19, workOne+workTwo+workThree+workFour+workFive+workSix+workSeven+workEight+workNine+workTen+workEleven+workTwelve+workThirteen+workFourteen+workFifteen+workSixteen+workSeventeen+workEighteen+workNineteen,\n" +
            "\t\t\t\tIF (COUNT = 20, workOne+workTwo+workThree+workFour+workFive+workSix+workSeven+workEight+workNine+workTen+workEleven+workTwelve+workThirteen+workFourteen+workFifteen+workSixteen+workSeventeen+workEighteen+workNineteen+workTwenty,\n" +
            "\t\t\t\t\"\"))))))))))))))))))) ) workTotal," +
            "IF (COUNT = 1, videoOne ,\n" +
            "\t\t\tIF (COUNT = 2, ( videoOne + videoTwo ),\n" +
            "\t\t\t\tIF ( COUNT = 3,   videoOne + videoTwo + videoThree ,\n" +
            "\t\t\t\tIF (COUNT = 4,  videoOne+videoTwo+videoThree+videoFour,\n" +
            "\t\t\t\tIF (COUNT = 5,  videoOne+videoTwo+videoThree+videoFour+videoFive,\n" +
            "\t\t\t\tIF (COUNT = 6,  videoOne+videoTwo+videoThree+videoFour+videoFive+videoSix,\n" +
            "\t\t\t\tIF ( COUNT = 7,  videoOne+videoTwo+videoThree+videoFour+videoFive+videoSix+videoSeven,\n" +
            "\t\t\t\tIF (COUNT = 8, videoOne+videoTwo+videoThree+videoFour+videoFive+videoSix+videoSeven+videoEight,\n" +
            "\t\t\t\tIF (COUNT = 9,  videoOne+videoTwo+videoThree+videoFour+videoFive+videoSix+videoSeven+videoEight+videoNine,\n" +
            "\t\t\t\tIF (COUNT = 10, videoOne+videoTwo+videoThree+videoFour+videoFive+videoSix+videoSeven+videoEight+videoNine+videoTen,\n" +
            "\t\t\t\tIF (COUNT = 11, videoOne+videoTwo+videoThree+videoFour+videoFive+videoSix+videoSeven+videoEight+videoNine+videoTen+videoEleven,\n" +
            "\t\t\t\tIF (COUNT = 12, videoOne+videoTwo+videoThree+videoFour+videoFive+videoSix+videoSeven+videoEight+videoNine+videoTen+videoEleven+videoTwelve,\n" +
            "\t\t\t\tIF (COUNT = 13, videoOne+videoTwo+videoThree+videoFour+videoFive+videoSix+videoSeven+videoEight+videoNine+videoTen+videoEleven+videoTwelve+videoThirteen,\n" +
            "\t\t\t\tIF (COUNT = 14, videoOne+videoTwo+videoThree+videoFour+videoFive+videoSix+videoSeven+videoEight+videoNine+videoTen+videoEleven+videoTwelve+videoThirteen+videoFourteen,\n" +
            "\t\t\t\tIF (COUNT = 15, videoOne+videoTwo+videoThree+videoFour+videoFive+videoSix+videoSeven+videoEight+videoNine+videoTen+videoEleven+videoTwelve+videoThirteen+videoFourteen+videoFifteen,\n" +
            "\t\t\t\tIF (COUNT = 16, videoOne+videoTwo+videoThree+videoFour+videoFive+videoSix+videoSeven+videoEight+videoNine+videoTen+videoEleven+videoTwelve+videoThirteen+videoFourteen+videoFifteen+videoSixteen,\n" +
            "\t\t\t\tIF (COUNT = 17, videoOne+videoTwo+videoThree+videoFour+videoFive+videoSix+videoSeven+videoEight+videoNine+videoTen+videoEleven+videoTwelve+videoThirteen+videoFourteen+videoFifteen+videoSixteen+videoSeventeen,\n" +
            "\t\t\t\tIF (COUNT = 18, videoOne+videoTwo+videoThree+videoFour+videoFive+videoSix+videoSeven+videoEight+videoNine+videoTen+videoEleven+videoTwelve+videoThirteen+videoFourteen+videoFifteen+videoSixteen+videoSeventeen+videoEighteen,\n" +
            "\t\t\t\tIF (COUNT = 19, videoOne+videoTwo+videoThree+videoFour+videoFive+videoSix+videoSeven+videoEight+videoNine+videoTen+videoEleven+videoTwelve+videoThirteen+videoFourteen+videoFifteen+videoSixteen+videoSeventeen+videoEighteen+videoNineteen,\n" +
            "\t\t\t\tIF (COUNT = 20, videoOne+videoTwo+videoThree+videoFour+videoFive+videoSix+videoSeven+videoEight+videoNine+videoTen+videoEleven+videoTwelve+videoThirteen+videoFourteen+videoFifteen+videoSixteen+videoSeventeen+videoEighteen+videoNineteen+videoTwenty,\n" +
            "\t\t\t\t\"\"))))))))))))))))))) ) videoTotal," +
            "IF (COUNT = 1, noteOne ,\n" +
            "\t\t\tIF (COUNT = 2, ( noteOne + noteTwo ),\n" +
            "\t\t\t\tIF ( COUNT = 3,   noteOne + noteTwo + noteThree ,\n" +
            "\t\t\t\tIF (COUNT = 4,  noteOne+noteTwo+noteThree+noteFour,\n" +
            "\t\t\t\tIF (COUNT = 5,  noteOne+noteTwo+noteThree+noteFour+noteFive,\n" +
            "\t\t\t\tIF (COUNT = 6,  noteOne+noteTwo+noteThree+noteFour+noteFive+noteSix,\n" +
            "\t\t\t\tIF ( COUNT = 7,  noteOne+noteTwo+noteThree+noteFour+noteFive+noteSix+noteSeven,\n" +
            "\t\t\t\tIF (COUNT = 8, noteOne+noteTwo+noteThree+noteFour+noteFive+noteSix+noteSeven+noteEight,\n" +
            "\t\t\t\tIF (COUNT = 9,  noteOne+noteTwo+noteThree+noteFour+noteFive+noteSix+noteSeven+noteEight+noteNine,\n" +
            "\t\t\t\tIF (COUNT = 10, noteOne+noteTwo+noteThree+noteFour+noteFive+noteSix+noteSeven+noteEight+noteNine+noteTen,\n" +
            "\t\t\t\tIF (COUNT = 11, noteOne+noteTwo+noteThree+noteFour+noteFive+noteSix+noteSeven+noteEight+noteNine+noteTen+noteEleven,\n" +
            "\t\t\t\tIF (COUNT = 12, noteOne+noteTwo+noteThree+noteFour+noteFive+noteSix+noteSeven+noteEight+noteNine+noteTen+noteEleven+noteTwelve,\n" +
            "\t\t\t\tIF (COUNT = 13, noteOne+noteTwo+noteThree+noteFour+noteFive+noteSix+noteSeven+noteEight+noteNine+noteTen+noteEleven+noteTwelve+noteThirteen,\n" +
            "\t\t\t\tIF (COUNT = 14, noteOne+noteTwo+noteThree+noteFour+noteFive+noteSix+noteSeven+noteEight+noteNine+noteTen+noteEleven+noteTwelve+noteThirteen+noteFourteen,\n" +
            "\t\t\t\tIF (COUNT = 15, noteOne+noteTwo+noteThree+noteFour+noteFive+noteSix+noteSeven+noteEight+noteNine+noteTen+noteEleven+noteTwelve+noteThirteen+noteFourteen+noteFifteen,\n" +
            "\t\t\t\tIF (COUNT = 16, noteOne+noteTwo+noteThree+noteFour+noteFive+noteSix+noteSeven+noteEight+noteNine+noteTen+noteEleven+noteTwelve+noteThirteen+noteFourteen+noteFifteen+noteSixteen,\n" +
            "\t\t\t\tIF (COUNT = 17, noteOne+noteTwo+noteThree+noteFour+noteFive+noteSix+noteSeven+noteEight+noteNine+noteTen+noteEleven+noteTwelve+noteThirteen+noteFourteen+noteFifteen+noteSixteen+noteSeventeen,\n" +
            "\t\t\t\tIF (COUNT = 18, noteOne+noteTwo+noteThree+noteFour+noteFive+noteSix+noteSeven+noteEight+noteNine+noteTen+noteEleven+noteTwelve+noteThirteen+noteFourteen+noteFifteen+noteSixteen+noteSeventeen+noteEighteen,\n" +
            "\t\t\t\tIF (COUNT = 19, noteOne+noteTwo+noteThree+noteFour+noteFive+noteSix+noteSeven+noteEight+noteNine+noteTen+noteEleven+noteTwelve+noteThirteen+noteFourteen+noteFifteen+noteSixteen+noteSeventeen+noteEighteen+noteNineteen,\n" +
            "\t\t\t\tIF (COUNT = 20, noteOne+noteTwo+noteThree+noteFour+noteFive+noteSix+noteSeven+noteEight+noteNine+noteTen+noteEleven+noteTwelve+noteThirteen+noteFourteen+noteFifteen+noteSixteen+noteSeventeen+noteEighteen+noteNineteen+noteTwenty,\n" +
            "\t\t\t\t\"\"))))))))))))))))))) ) noteTotal," +
            "IF (COUNT = 1, knowledgeMasterOne ,\n" +
            "\t\t\tIF (COUNT = 2, ( knowledgeMasterOne + knowledgeMasterTwo ),\n" +
            "\t\t\t\tIF ( COUNT = 3,   knowledgeMasterOne + knowledgeMasterTwo + knowledgeMasterThree ,\n" +
            "\t\t\t\tIF (COUNT = 4,  knowledgeMasterOne+knowledgeMasterTwo+knowledgeMasterThree+knowledgeMasterFour,\n" +
            "\t\t\t\tIF (COUNT = 5,  knowledgeMasterOne+knowledgeMasterTwo+knowledgeMasterThree+knowledgeMasterFour+knowledgeMasterFive,\n" +
            "\t\t\t\tIF (COUNT = 6,  knowledgeMasterOne+knowledgeMasterTwo+knowledgeMasterThree+knowledgeMasterFour+knowledgeMasterFive+knowledgeMasterSix,\n" +
            "\t\t\t\tIF ( COUNT = 7,  knowledgeMasterOne+knowledgeMasterTwo+knowledgeMasterThree+knowledgeMasterFour+knowledgeMasterFive+knowledgeMasterSix+knowledgeMasterSeven,\n" +
            "\t\t\t\tIF (COUNT = 8, knowledgeMasterOne+knowledgeMasterTwo+knowledgeMasterThree+knowledgeMasterFour+knowledgeMasterFive+knowledgeMasterSix+knowledgeMasterSeven+knowledgeMasterEight,\n" +
            "\t\t\t\tIF (COUNT = 9,  knowledgeMasterOne+knowledgeMasterTwo+knowledgeMasterThree+knowledgeMasterFour+knowledgeMasterFive+knowledgeMasterSix+knowledgeMasterSeven+knowledgeMasterEight+knowledgeMasterNine,\n" +
            "\t\t\t\tIF (COUNT = 10, knowledgeMasterOne+knowledgeMasterTwo+knowledgeMasterThree+knowledgeMasterFour+knowledgeMasterFive+knowledgeMasterSix+knowledgeMasterSeven+knowledgeMasterEight+knowledgeMasterNine+knowledgeMasterTen,\n" +
            "\t\t\t\tIF (COUNT = 11, knowledgeMasterOne+knowledgeMasterTwo+knowledgeMasterThree+knowledgeMasterFour+knowledgeMasterFive+knowledgeMasterSix+knowledgeMasterSeven+knowledgeMasterEight+knowledgeMasterNine+knowledgeMasterTen+knowledgeMasterEleven,\n" +
            "\t\t\t\tIF (COUNT = 12, knowledgeMasterOne+knowledgeMasterTwo+knowledgeMasterThree+knowledgeMasterFour+knowledgeMasterFive+knowledgeMasterSix+knowledgeMasterSeven+knowledgeMasterEight+knowledgeMasterNine+knowledgeMasterTen+knowledgeMasterEleven+knowledgeMasterTwelve,\n" +
            "\t\t\t\tIF (COUNT = 13, knowledgeMasterOne+knowledgeMasterTwo+knowledgeMasterThree+knowledgeMasterFour+knowledgeMasterFive+knowledgeMasterSix+knowledgeMasterSeven+knowledgeMasterEight+knowledgeMasterNine+knowledgeMasterTen+knowledgeMasterEleven+knowledgeMasterTwelve+knowledgeMasterThirteen,\n" +
            "\t\t\t\tIF (COUNT = 14, knowledgeMasterOne+knowledgeMasterTwo+knowledgeMasterThree+knowledgeMasterFour+knowledgeMasterFive+knowledgeMasterSix+knowledgeMasterSeven+knowledgeMasterEight+knowledgeMasterNine+knowledgeMasterTen+knowledgeMasterEleven+knowledgeMasterTwelve+knowledgeMasterThirteen+knowledgeMasterFourteen,\n" +
            "\t\t\t\tIF (COUNT = 15, knowledgeMasterOne+knowledgeMasterTwo+knowledgeMasterThree+knowledgeMasterFour+knowledgeMasterFive+knowledgeMasterSix+knowledgeMasterSeven+knowledgeMasterEight+knowledgeMasterNine+knowledgeMasterTen+knowledgeMasterEleven+knowledgeMasterTwelve+knowledgeMasterThirteen+knowledgeMasterFourteen+knowledgeMasterFifteen,\n" +
            "\t\t\t\tIF (COUNT = 16, knowledgeMasterOne+knowledgeMasterTwo+knowledgeMasterThree+knowledgeMasterFour+knowledgeMasterFive+knowledgeMasterSix+knowledgeMasterSeven+knowledgeMasterEight+knowledgeMasterNine+knowledgeMasterTen+knowledgeMasterEleven+knowledgeMasterTwelve+knowledgeMasterThirteen+knowledgeMasterFourteen+knowledgeMasterFifteen+knowledgeMasterSixteen,\n" +
            "\t\t\t\tIF (COUNT = 17, knowledgeMasterOne+knowledgeMasterTwo+knowledgeMasterThree+knowledgeMasterFour+knowledgeMasterFive+knowledgeMasterSix+knowledgeMasterSeven+knowledgeMasterEight+knowledgeMasterNine+knowledgeMasterTen+knowledgeMasterEleven+knowledgeMasterTwelve+knowledgeMasterThirteen+knowledgeMasterFourteen+knowledgeMasterFifteen+knowledgeMasterSixteen+knowledgeMasterSeventeen,\n" +
            "\t\t\t\tIF (COUNT = 18, knowledgeMasterOne+knowledgeMasterTwo+knowledgeMasterThree+knowledgeMasterFour+knowledgeMasterFive+knowledgeMasterSix+knowledgeMasterSeven+knowledgeMasterEight+knowledgeMasterNine+knowledgeMasterTen+knowledgeMasterEleven+knowledgeMasterTwelve+knowledgeMasterThirteen+knowledgeMasterFourteen+knowledgeMasterFifteen+knowledgeMasterSixteen+knowledgeMasterSeventeen+knowledgeMasterEighteen,\n" +
            "\t\t\t\tIF (COUNT = 19, knowledgeMasterOne+knowledgeMasterTwo+knowledgeMasterThree+knowledgeMasterFour+knowledgeMasterFive+knowledgeMasterSix+knowledgeMasterSeven+knowledgeMasterEight+knowledgeMasterNine+knowledgeMasterTen+knowledgeMasterEleven+knowledgeMasterTwelve+knowledgeMasterThirteen+knowledgeMasterFourteen+knowledgeMasterFifteen+knowledgeMasterSixteen+knowledgeMasterSeventeen+knowledgeMasterEighteen+knowledgeMasterNineteen,\n" +
            "\t\t\t\tIF (COUNT = 20, knowledgeMasterOne+knowledgeMasterTwo+knowledgeMasterThree+knowledgeMasterFour+knowledgeMasterFive+knowledgeMasterSix+knowledgeMasterSeven+knowledgeMasterEight+knowledgeMasterNine+knowledgeMasterTen+knowledgeMasterEleven+knowledgeMasterTwelve+knowledgeMasterThirteen+knowledgeMasterFourteen+knowledgeMasterFifteen+knowledgeMasterSixteen+knowledgeMasterSeventeen+knowledgeMasterEighteen+knowledgeMasterNineteen+knowledgeMasterTwenty,\n" +
            "\t\t\t\t\"\"))))))))))))))))))) ) knowledgeMasterTotal" +
            " from details where classId = #{classId}")
    @Results(id = "detailsMap",
            value = {
                    @Result(column = "project", property = "project"),
                    @Result(column = "subject", property = "subject"),
                    @Result(column = "count", property = "count"),
                    @Result(column = "teacher", property = "teacher"),
                    @Result(column = "classId", property = "classId"),
                    @Result(column = "weChat", property = "weChat"),
                    @Result(column = "studentsId", property = "studentsId"),
                    @Result(column = "studentsName", property = "studentsName"),
                    @Result(column = "shoppingCart", property = "shoppingCart"),
                    @Result(column = "workOne", property = "workOne"),
                    @Result(column = "workTwo", property = "workTwo"),
                    @Result(column = "workThree", property = "workThree"),
                    @Result(column = "workFour", property = "workFour"),
                    @Result(column = "workFive", property = "workFive"),
                    @Result(column = "workSix", property = "workSix"),
                    @Result(column = "workSeven", property = "workSeven"),
                    @Result(column = "workTotal", property = "workTotal"),
                    @Result(column = "workRatio", property = "workRatio"),
                    @Result(column = "videoOne", property = "videoOne"),
                    @Result(column = "videoTwo", property = "videoTwo"),
                    @Result(column = "videoThree", property = "videoThree"),
                    @Result(column = "videoFour", property = "videoFour"),
                    @Result(column = "videoFive", property = "videoFive"),
                    @Result(column = "videoSix", property = "videoSix"),
                    @Result(column = "videoSeven", property = "videoSeven"),
                    @Result(column = "videoTotal", property = "videoTotal"),
                    @Result(column = "videoRatio", property = "videoRatio"),
                    @Result(column = "noteOne", property = "noteOne"),
                    @Result(column = "noteTwo", property = "noteTwo"),
                    @Result(column = "noteThree", property = "noteThree"),
                    @Result(column = "noteFour", property = "noteFour"),
                    @Result(column = "noteFive", property = "noteFive"),
                    @Result(column = "noteSix", property = "noteSix"),
                    @Result(column = "noteSeven", property = "noteSeven"),
                    @Result(column = "noteTotal", property = "noteTotal"),
                    @Result(column = "noteRatio", property = "noteRatio"),
                    @Result(column = "oneToOne", property = "oneToOne"),
                    @Result(column = "isContinue", property = "isContinue")
            })
    List<Details> findStudentsByClassId(String classId);

    @Update("delete from details where classId=#{classId} and studentsId=#{studentsId} ")
    int delStudents(@Param("classId") String classId, @Param("studentsId") String studentsId);

    @Select("select * ," +
            "IF (COUNT = 1, workOne ,\n" +
            "\t\t\tIF (COUNT = 2, ( workOne + workTwo ),\n" +
            "\t\t\t\tIF ( COUNT = 3,   workOne + workTwo + workThree ,\n" +
            "\t\t\t\tIF (COUNT = 4,  workOne+workTwo+workThree+workFour,\n" +
            "\t\t\t\tIF (COUNT = 5,  workOne+workTwo+workThree+workFour+workFive,\n" +
            "\t\t\t\tIF (COUNT = 6,  workOne+workTwo+workThree+workFour+workFive+workSix,\n" +
            "\t\t\t\tIF ( COUNT = 7,  workOne+workTwo+workThree+workFour+workFive+workSix+workSeven,\n" +
            "\t\t\t\tIF (COUNT = 8, workOne+workTwo+workThree+workFour+workFive+workSix+workSeven+workEight,\n" +
            "\t\t\t\tIF (COUNT = 9,  workOne+workTwo+workThree+workFour+workFive+workSix+workSeven+workEight+workNine,\n" +
            "\t\t\t\tIF (COUNT = 10, workOne+workTwo+workThree+workFour+workFive+workSix+workSeven+workEight+workNine+workTen,\n" +
            "\t\t\t\tIF (COUNT = 11, workOne+workTwo+workThree+workFour+workFive+workSix+workSeven+workEight+workNine+workTen+workEleven,\n" +
            "\t\t\t\tIF (COUNT = 12, workOne+workTwo+workThree+workFour+workFive+workSix+workSeven+workEight+workNine+workTen+workEleven+workTwelve,\n" +
            "\t\t\t\tIF (COUNT = 13, workOne+workTwo+workThree+workFour+workFive+workSix+workSeven+workEight+workNine+workTen+workEleven+workTwelve+workThirteen,\n" +
            "\t\t\t\tIF (COUNT = 14, workOne+workTwo+workThree+workFour+workFive+workSix+workSeven+workEight+workNine+workTen+workEleven+workTwelve+workThirteen+workFourteen,\n" +
            "\t\t\t\tIF (COUNT = 15, workOne+workTwo+workThree+workFour+workFive+workSix+workSeven+workEight+workNine+workTen+workEleven+workTwelve+workThirteen+workFourteen+workFifteen,\n" +
            "\t\t\t\tIF (COUNT = 16, workOne+workTwo+workThree+workFour+workFive+workSix+workSeven+workEight+workNine+workTen+workEleven+workTwelve+workThirteen+workFourteen+workFifteen+workSixteen,\n" +
            "\t\t\t\tIF (COUNT = 17, workOne+workTwo+workThree+workFour+workFive+workSix+workSeven+workEight+workNine+workTen+workEleven+workTwelve+workThirteen+workFourteen+workFifteen+workSixteen+workSeventeen,\n" +
            "\t\t\t\tIF (COUNT = 18, workOne+workTwo+workThree+workFour+workFive+workSix+workSeven+workEight+workNine+workTen+workEleven+workTwelve+workThirteen+workFourteen+workFifteen+workSixteen+workSeventeen+workEighteen,\n" +
            "\t\t\t\tIF (COUNT = 19, workOne+workTwo+workThree+workFour+workFive+workSix+workSeven+workEight+workNine+workTen+workEleven+workTwelve+workThirteen+workFourteen+workFifteen+workSixteen+workSeventeen+workEighteen+workNineteen,\n" +
            "\t\t\t\tIF (COUNT = 20, workOne+workTwo+workThree+workFour+workFive+workSix+workSeven+workEight+workNine+workTen+workEleven+workTwelve+workThirteen+workFourteen+workFifteen+workSixteen+workSeventeen+workEighteen+workNineteen+workTwenty,\n" +
            "\t\t\t\t\"\"))))))))))))))))))) ) workTotal," +
            "IF (COUNT = 1, videoOne ,\n" +
            "\t\t\tIF (COUNT = 2, ( videoOne + videoTwo ),\n" +
            "\t\t\t\tIF ( COUNT = 3,   videoOne + videoTwo + videoThree ,\n" +
            "\t\t\t\tIF (COUNT = 4,  videoOne+videoTwo+videoThree+videoFour,\n" +
            "\t\t\t\tIF (COUNT = 5,  videoOne+videoTwo+videoThree+videoFour+videoFive,\n" +
            "\t\t\t\tIF (COUNT = 6,  videoOne+videoTwo+videoThree+videoFour+videoFive+videoSix,\n" +
            "\t\t\t\tIF ( COUNT = 7,  videoOne+videoTwo+videoThree+videoFour+videoFive+videoSix+videoSeven,\n" +
            "\t\t\t\tIF (COUNT = 8, videoOne+videoTwo+videoThree+videoFour+videoFive+videoSix+videoSeven+videoEight,\n" +
            "\t\t\t\tIF (COUNT = 9,  videoOne+videoTwo+videoThree+videoFour+videoFive+videoSix+videoSeven+videoEight+videoNine,\n" +
            "\t\t\t\tIF (COUNT = 10, videoOne+videoTwo+videoThree+videoFour+videoFive+videoSix+videoSeven+videoEight+videoNine+videoTen,\n" +
            "\t\t\t\tIF (COUNT = 11, videoOne+videoTwo+videoThree+videoFour+videoFive+videoSix+videoSeven+videoEight+videoNine+videoTen+videoEleven,\n" +
            "\t\t\t\tIF (COUNT = 12, videoOne+videoTwo+videoThree+videoFour+videoFive+videoSix+videoSeven+videoEight+videoNine+videoTen+videoEleven+videoTwelve,\n" +
            "\t\t\t\tIF (COUNT = 13, videoOne+videoTwo+videoThree+videoFour+videoFive+videoSix+videoSeven+videoEight+videoNine+videoTen+videoEleven+videoTwelve+videoThirteen,\n" +
            "\t\t\t\tIF (COUNT = 14, videoOne+videoTwo+videoThree+videoFour+videoFive+videoSix+videoSeven+videoEight+videoNine+videoTen+videoEleven+videoTwelve+videoThirteen+videoFourteen,\n" +
            "\t\t\t\tIF (COUNT = 15, videoOne+videoTwo+videoThree+videoFour+videoFive+videoSix+videoSeven+videoEight+videoNine+videoTen+videoEleven+videoTwelve+videoThirteen+videoFourteen+videoFifteen,\n" +
            "\t\t\t\tIF (COUNT = 16, videoOne+videoTwo+videoThree+videoFour+videoFive+videoSix+videoSeven+videoEight+videoNine+videoTen+videoEleven+videoTwelve+videoThirteen+videoFourteen+videoFifteen+videoSixteen,\n" +
            "\t\t\t\tIF (COUNT = 17, videoOne+videoTwo+videoThree+videoFour+videoFive+videoSix+videoSeven+videoEight+videoNine+videoTen+videoEleven+videoTwelve+videoThirteen+videoFourteen+videoFifteen+videoSixteen+videoSeventeen,\n" +
            "\t\t\t\tIF (COUNT = 18, videoOne+videoTwo+videoThree+videoFour+videoFive+videoSix+videoSeven+videoEight+videoNine+videoTen+videoEleven+videoTwelve+videoThirteen+videoFourteen+videoFifteen+videoSixteen+videoSeventeen+videoEighteen,\n" +
            "\t\t\t\tIF (COUNT = 19, videoOne+videoTwo+videoThree+videoFour+videoFive+videoSix+videoSeven+videoEight+videoNine+videoTen+videoEleven+videoTwelve+videoThirteen+videoFourteen+videoFifteen+videoSixteen+videoSeventeen+videoEighteen+videoNineteen,\n" +
            "\t\t\t\tIF (COUNT = 20, videoOne+videoTwo+videoThree+videoFour+videoFive+videoSix+videoSeven+videoEight+videoNine+videoTen+videoEleven+videoTwelve+videoThirteen+videoFourteen+videoFifteen+videoSixteen+videoSeventeen+videoEighteen+videoNineteen+videoTwenty,\n" +
            "\t\t\t\t\"\"))))))))))))))))))) ) videoTotal," +
            "IF (COUNT = 1, noteOne ,\n" +
            "\t\t\tIF (COUNT = 2, ( noteOne + noteTwo ),\n" +
            "\t\t\t\tIF ( COUNT = 3,   noteOne + noteTwo + noteThree ,\n" +
            "\t\t\t\tIF (COUNT = 4,  noteOne+noteTwo+noteThree+noteFour,\n" +
            "\t\t\t\tIF (COUNT = 5,  noteOne+noteTwo+noteThree+noteFour+noteFive,\n" +
            "\t\t\t\tIF (COUNT = 6,  noteOne+noteTwo+noteThree+noteFour+noteFive+noteSix,\n" +
            "\t\t\t\tIF ( COUNT = 7,  noteOne+noteTwo+noteThree+noteFour+noteFive+noteSix+noteSeven,\n" +
            "\t\t\t\tIF (COUNT = 8, noteOne+noteTwo+noteThree+noteFour+noteFive+noteSix+noteSeven+noteEight,\n" +
            "\t\t\t\tIF (COUNT = 9,  noteOne+noteTwo+noteThree+noteFour+noteFive+noteSix+noteSeven+noteEight+noteNine,\n" +
            "\t\t\t\tIF (COUNT = 10, noteOne+noteTwo+noteThree+noteFour+noteFive+noteSix+noteSeven+noteEight+noteNine+noteTen,\n" +
            "\t\t\t\tIF (COUNT = 11, noteOne+noteTwo+noteThree+noteFour+noteFive+noteSix+noteSeven+noteEight+noteNine+noteTen+noteEleven,\n" +
            "\t\t\t\tIF (COUNT = 12, noteOne+noteTwo+noteThree+noteFour+noteFive+noteSix+noteSeven+noteEight+noteNine+noteTen+noteEleven+noteTwelve,\n" +
            "\t\t\t\tIF (COUNT = 13, noteOne+noteTwo+noteThree+noteFour+noteFive+noteSix+noteSeven+noteEight+noteNine+noteTen+noteEleven+noteTwelve+noteThirteen,\n" +
            "\t\t\t\tIF (COUNT = 14, noteOne+noteTwo+noteThree+noteFour+noteFive+noteSix+noteSeven+noteEight+noteNine+noteTen+noteEleven+noteTwelve+noteThirteen+noteFourteen,\n" +
            "\t\t\t\tIF (COUNT = 15, noteOne+noteTwo+noteThree+noteFour+noteFive+noteSix+noteSeven+noteEight+noteNine+noteTen+noteEleven+noteTwelve+noteThirteen+noteFourteen+noteFifteen,\n" +
            "\t\t\t\tIF (COUNT = 16, noteOne+noteTwo+noteThree+noteFour+noteFive+noteSix+noteSeven+noteEight+noteNine+noteTen+noteEleven+noteTwelve+noteThirteen+noteFourteen+noteFifteen+noteSixteen,\n" +
            "\t\t\t\tIF (COUNT = 17, noteOne+noteTwo+noteThree+noteFour+noteFive+noteSix+noteSeven+noteEight+noteNine+noteTen+noteEleven+noteTwelve+noteThirteen+noteFourteen+noteFifteen+noteSixteen+noteSeventeen,\n" +
            "\t\t\t\tIF (COUNT = 18, noteOne+noteTwo+noteThree+noteFour+noteFive+noteSix+noteSeven+noteEight+noteNine+noteTen+noteEleven+noteTwelve+noteThirteen+noteFourteen+noteFifteen+noteSixteen+noteSeventeen+noteEighteen,\n" +
            "\t\t\t\tIF (COUNT = 19, noteOne+noteTwo+noteThree+noteFour+noteFive+noteSix+noteSeven+noteEight+noteNine+noteTen+noteEleven+noteTwelve+noteThirteen+noteFourteen+noteFifteen+noteSixteen+noteSeventeen+noteEighteen+noteNineteen,\n" +
            "\t\t\t\tIF (COUNT = 20, noteOne+noteTwo+noteThree+noteFour+noteFive+noteSix+noteSeven+noteEight+noteNine+noteTen+noteEleven+noteTwelve+noteThirteen+noteFourteen+noteFifteen+noteSixteen+noteSeventeen+noteEighteen+noteNineteen+noteTwenty,\n" +
            "\t\t\t\t\"\"))))))))))))))))))) ) noteTotal," +
            "IF (COUNT = 1, knowledgeMasterOne ,\n" +
            "\t\t\tIF (COUNT = 2, ( knowledgeMasterOne + knowledgeMasterTwo ),\n" +
            "\t\t\t\tIF ( COUNT = 3,   knowledgeMasterOne + knowledgeMasterTwo + knowledgeMasterThree ,\n" +
            "\t\t\t\tIF (COUNT = 4,  knowledgeMasterOne+knowledgeMasterTwo+knowledgeMasterThree+knowledgeMasterFour,\n" +
            "\t\t\t\tIF (COUNT = 5,  knowledgeMasterOne+knowledgeMasterTwo+knowledgeMasterThree+knowledgeMasterFour+knowledgeMasterFive,\n" +
            "\t\t\t\tIF (COUNT = 6,  knowledgeMasterOne+knowledgeMasterTwo+knowledgeMasterThree+knowledgeMasterFour+knowledgeMasterFive+knowledgeMasterSix,\n" +
            "\t\t\t\tIF ( COUNT = 7,  knowledgeMasterOne+knowledgeMasterTwo+knowledgeMasterThree+knowledgeMasterFour+knowledgeMasterFive+knowledgeMasterSix+knowledgeMasterSeven,\n" +
            "\t\t\t\tIF (COUNT = 8, knowledgeMasterOne+knowledgeMasterTwo+knowledgeMasterThree+knowledgeMasterFour+knowledgeMasterFive+knowledgeMasterSix+knowledgeMasterSeven+knowledgeMasterEight,\n" +
            "\t\t\t\tIF (COUNT = 9,  knowledgeMasterOne+knowledgeMasterTwo+knowledgeMasterThree+knowledgeMasterFour+knowledgeMasterFive+knowledgeMasterSix+knowledgeMasterSeven+knowledgeMasterEight+knowledgeMasterNine,\n" +
            "\t\t\t\tIF (COUNT = 10, knowledgeMasterOne+knowledgeMasterTwo+knowledgeMasterThree+knowledgeMasterFour+knowledgeMasterFive+knowledgeMasterSix+knowledgeMasterSeven+knowledgeMasterEight+knowledgeMasterNine+knowledgeMasterTen,\n" +
            "\t\t\t\tIF (COUNT = 11, knowledgeMasterOne+knowledgeMasterTwo+knowledgeMasterThree+knowledgeMasterFour+knowledgeMasterFive+knowledgeMasterSix+knowledgeMasterSeven+knowledgeMasterEight+knowledgeMasterNine+knowledgeMasterTen+knowledgeMasterEleven,\n" +
            "\t\t\t\tIF (COUNT = 12, knowledgeMasterOne+knowledgeMasterTwo+knowledgeMasterThree+knowledgeMasterFour+knowledgeMasterFive+knowledgeMasterSix+knowledgeMasterSeven+knowledgeMasterEight+knowledgeMasterNine+knowledgeMasterTen+knowledgeMasterEleven+knowledgeMasterTwelve,\n" +
            "\t\t\t\tIF (COUNT = 13, knowledgeMasterOne+knowledgeMasterTwo+knowledgeMasterThree+knowledgeMasterFour+knowledgeMasterFive+knowledgeMasterSix+knowledgeMasterSeven+knowledgeMasterEight+knowledgeMasterNine+knowledgeMasterTen+knowledgeMasterEleven+knowledgeMasterTwelve+knowledgeMasterThirteen,\n" +
            "\t\t\t\tIF (COUNT = 14, knowledgeMasterOne+knowledgeMasterTwo+knowledgeMasterThree+knowledgeMasterFour+knowledgeMasterFive+knowledgeMasterSix+knowledgeMasterSeven+knowledgeMasterEight+knowledgeMasterNine+knowledgeMasterTen+knowledgeMasterEleven+knowledgeMasterTwelve+knowledgeMasterThirteen+knowledgeMasterFourteen,\n" +
            "\t\t\t\tIF (COUNT = 15, knowledgeMasterOne+knowledgeMasterTwo+knowledgeMasterThree+knowledgeMasterFour+knowledgeMasterFive+knowledgeMasterSix+knowledgeMasterSeven+knowledgeMasterEight+knowledgeMasterNine+knowledgeMasterTen+knowledgeMasterEleven+knowledgeMasterTwelve+knowledgeMasterThirteen+knowledgeMasterFourteen+knowledgeMasterFifteen,\n" +
            "\t\t\t\tIF (COUNT = 16, knowledgeMasterOne+knowledgeMasterTwo+knowledgeMasterThree+knowledgeMasterFour+knowledgeMasterFive+knowledgeMasterSix+knowledgeMasterSeven+knowledgeMasterEight+knowledgeMasterNine+knowledgeMasterTen+knowledgeMasterEleven+knowledgeMasterTwelve+knowledgeMasterThirteen+knowledgeMasterFourteen+knowledgeMasterFifteen+knowledgeMasterSixteen,\n" +
            "\t\t\t\tIF (COUNT = 17, knowledgeMasterOne+knowledgeMasterTwo+knowledgeMasterThree+knowledgeMasterFour+knowledgeMasterFive+knowledgeMasterSix+knowledgeMasterSeven+knowledgeMasterEight+knowledgeMasterNine+knowledgeMasterTen+knowledgeMasterEleven+knowledgeMasterTwelve+knowledgeMasterThirteen+knowledgeMasterFourteen+knowledgeMasterFifteen+knowledgeMasterSixteen+knowledgeMasterSeventeen,\n" +
            "\t\t\t\tIF (COUNT = 18, knowledgeMasterOne+knowledgeMasterTwo+knowledgeMasterThree+knowledgeMasterFour+knowledgeMasterFive+knowledgeMasterSix+knowledgeMasterSeven+knowledgeMasterEight+knowledgeMasterNine+knowledgeMasterTen+knowledgeMasterEleven+knowledgeMasterTwelve+knowledgeMasterThirteen+knowledgeMasterFourteen+knowledgeMasterFifteen+knowledgeMasterSixteen+knowledgeMasterSeventeen+knowledgeMasterEighteen,\n" +
            "\t\t\t\tIF (COUNT = 19, knowledgeMasterOne+knowledgeMasterTwo+knowledgeMasterThree+knowledgeMasterFour+knowledgeMasterFive+knowledgeMasterSix+knowledgeMasterSeven+knowledgeMasterEight+knowledgeMasterNine+knowledgeMasterTen+knowledgeMasterEleven+knowledgeMasterTwelve+knowledgeMasterThirteen+knowledgeMasterFourteen+knowledgeMasterFifteen+knowledgeMasterSixteen+knowledgeMasterSeventeen+knowledgeMasterEighteen+knowledgeMasterNineteen,\n" +
            "\t\t\t\tIF (COUNT = 20, knowledgeMasterOne+knowledgeMasterTwo+knowledgeMasterThree+knowledgeMasterFour+knowledgeMasterFive+knowledgeMasterSix+knowledgeMasterSeven+knowledgeMasterEight+knowledgeMasterNine+knowledgeMasterTen+knowledgeMasterEleven+knowledgeMasterTwelve+knowledgeMasterThirteen+knowledgeMasterFourteen+knowledgeMasterFifteen+knowledgeMasterSixteen+knowledgeMasterSeventeen+knowledgeMasterEighteen+knowledgeMasterNineteen+knowledgeMasterTwenty,\n" +
            "\t\t\t\t\"\"))))))))))))))))))) ) knowledgeMasterTotal" +
            " from details where teacher= #{teacher}")
    @ResultMap("detailsMap")
    List<Details> findStudentsByTeacher(String teacher);

    @Select("select * ," +
            "IF (COUNT = 1, workOne ,\n" +
            "\t\t\tIF (COUNT = 2, ( workOne + workTwo ),\n" +
            "\t\t\t\tIF ( COUNT = 3,   workOne + workTwo + workThree ,\n" +
            "\t\t\t\tIF (COUNT = 4,  workOne+workTwo+workThree+workFour,\n" +
            "\t\t\t\tIF (COUNT = 5,  workOne+workTwo+workThree+workFour+workFive,\n" +
            "\t\t\t\tIF (COUNT = 6,  workOne+workTwo+workThree+workFour+workFive+workSix,\n" +
            "\t\t\t\tIF ( COUNT = 7,  workOne+workTwo+workThree+workFour+workFive+workSix+workSeven,\n" +
            "\t\t\t\tIF (COUNT = 8, workOne+workTwo+workThree+workFour+workFive+workSix+workSeven+workEight,\n" +
            "\t\t\t\tIF (COUNT = 9,  workOne+workTwo+workThree+workFour+workFive+workSix+workSeven+workEight+workNine,\n" +
            "\t\t\t\tIF (COUNT = 10, workOne+workTwo+workThree+workFour+workFive+workSix+workSeven+workEight+workNine+workTen,\n" +
            "\t\t\t\tIF (COUNT = 11, workOne+workTwo+workThree+workFour+workFive+workSix+workSeven+workEight+workNine+workTen+workEleven,\n" +
            "\t\t\t\tIF (COUNT = 12, workOne+workTwo+workThree+workFour+workFive+workSix+workSeven+workEight+workNine+workTen+workEleven+workTwelve,\n" +
            "\t\t\t\tIF (COUNT = 13, workOne+workTwo+workThree+workFour+workFive+workSix+workSeven+workEight+workNine+workTen+workEleven+workTwelve+workThirteen,\n" +
            "\t\t\t\tIF (COUNT = 14, workOne+workTwo+workThree+workFour+workFive+workSix+workSeven+workEight+workNine+workTen+workEleven+workTwelve+workThirteen+workFourteen,\n" +
            "\t\t\t\tIF (COUNT = 15, workOne+workTwo+workThree+workFour+workFive+workSix+workSeven+workEight+workNine+workTen+workEleven+workTwelve+workThirteen+workFourteen+workFifteen,\n" +
            "\t\t\t\tIF (COUNT = 16, workOne+workTwo+workThree+workFour+workFive+workSix+workSeven+workEight+workNine+workTen+workEleven+workTwelve+workThirteen+workFourteen+workFifteen+workSixteen,\n" +
            "\t\t\t\tIF (COUNT = 17, workOne+workTwo+workThree+workFour+workFive+workSix+workSeven+workEight+workNine+workTen+workEleven+workTwelve+workThirteen+workFourteen+workFifteen+workSixteen+workSeventeen,\n" +
            "\t\t\t\tIF (COUNT = 18, workOne+workTwo+workThree+workFour+workFive+workSix+workSeven+workEight+workNine+workTen+workEleven+workTwelve+workThirteen+workFourteen+workFifteen+workSixteen+workSeventeen+workEighteen,\n" +
            "\t\t\t\tIF (COUNT = 19, workOne+workTwo+workThree+workFour+workFive+workSix+workSeven+workEight+workNine+workTen+workEleven+workTwelve+workThirteen+workFourteen+workFifteen+workSixteen+workSeventeen+workEighteen+workNineteen,\n" +
            "\t\t\t\tIF (COUNT = 20, workOne+workTwo+workThree+workFour+workFive+workSix+workSeven+workEight+workNine+workTen+workEleven+workTwelve+workThirteen+workFourteen+workFifteen+workSixteen+workSeventeen+workEighteen+workNineteen+workTwenty,\n" +
            "\t\t\t\t\"\"))))))))))))))))))) ) workTotal," +
            "IF (COUNT = 1, videoOne ,\n" +
            "\t\t\tIF (COUNT = 2, ( videoOne + videoTwo ),\n" +
            "\t\t\t\tIF ( COUNT = 3,   videoOne + videoTwo + videoThree ,\n" +
            "\t\t\t\tIF (COUNT = 4,  videoOne+videoTwo+videoThree+videoFour,\n" +
            "\t\t\t\tIF (COUNT = 5,  videoOne+videoTwo+videoThree+videoFour+videoFive,\n" +
            "\t\t\t\tIF (COUNT = 6,  videoOne+videoTwo+videoThree+videoFour+videoFive+videoSix,\n" +
            "\t\t\t\tIF ( COUNT = 7,  videoOne+videoTwo+videoThree+videoFour+videoFive+videoSix+videoSeven,\n" +
            "\t\t\t\tIF (COUNT = 8, videoOne+videoTwo+videoThree+videoFour+videoFive+videoSix+videoSeven+videoEight,\n" +
            "\t\t\t\tIF (COUNT = 9,  videoOne+videoTwo+videoThree+videoFour+videoFive+videoSix+videoSeven+videoEight+videoNine,\n" +
            "\t\t\t\tIF (COUNT = 10, videoOne+videoTwo+videoThree+videoFour+videoFive+videoSix+videoSeven+videoEight+videoNine+videoTen,\n" +
            "\t\t\t\tIF (COUNT = 11, videoOne+videoTwo+videoThree+videoFour+videoFive+videoSix+videoSeven+videoEight+videoNine+videoTen+videoEleven,\n" +
            "\t\t\t\tIF (COUNT = 12, videoOne+videoTwo+videoThree+videoFour+videoFive+videoSix+videoSeven+videoEight+videoNine+videoTen+videoEleven+videoTwelve,\n" +
            "\t\t\t\tIF (COUNT = 13, videoOne+videoTwo+videoThree+videoFour+videoFive+videoSix+videoSeven+videoEight+videoNine+videoTen+videoEleven+videoTwelve+videoThirteen,\n" +
            "\t\t\t\tIF (COUNT = 14, videoOne+videoTwo+videoThree+videoFour+videoFive+videoSix+videoSeven+videoEight+videoNine+videoTen+videoEleven+videoTwelve+videoThirteen+videoFourteen,\n" +
            "\t\t\t\tIF (COUNT = 15, videoOne+videoTwo+videoThree+videoFour+videoFive+videoSix+videoSeven+videoEight+videoNine+videoTen+videoEleven+videoTwelve+videoThirteen+videoFourteen+videoFifteen,\n" +
            "\t\t\t\tIF (COUNT = 16, videoOne+videoTwo+videoThree+videoFour+videoFive+videoSix+videoSeven+videoEight+videoNine+videoTen+videoEleven+videoTwelve+videoThirteen+videoFourteen+videoFifteen+videoSixteen,\n" +
            "\t\t\t\tIF (COUNT = 17, videoOne+videoTwo+videoThree+videoFour+videoFive+videoSix+videoSeven+videoEight+videoNine+videoTen+videoEleven+videoTwelve+videoThirteen+videoFourteen+videoFifteen+videoSixteen+videoSeventeen,\n" +
            "\t\t\t\tIF (COUNT = 18, videoOne+videoTwo+videoThree+videoFour+videoFive+videoSix+videoSeven+videoEight+videoNine+videoTen+videoEleven+videoTwelve+videoThirteen+videoFourteen+videoFifteen+videoSixteen+videoSeventeen+videoEighteen,\n" +
            "\t\t\t\tIF (COUNT = 19, videoOne+videoTwo+videoThree+videoFour+videoFive+videoSix+videoSeven+videoEight+videoNine+videoTen+videoEleven+videoTwelve+videoThirteen+videoFourteen+videoFifteen+videoSixteen+videoSeventeen+videoEighteen+videoNineteen,\n" +
            "\t\t\t\tIF (COUNT = 20, videoOne+videoTwo+videoThree+videoFour+videoFive+videoSix+videoSeven+videoEight+videoNine+videoTen+videoEleven+videoTwelve+videoThirteen+videoFourteen+videoFifteen+videoSixteen+videoSeventeen+videoEighteen+videoNineteen+videoTwenty,\n" +
            "\t\t\t\t\"\"))))))))))))))))))) ) videoTotal," +
            "IF (COUNT = 1, noteOne ,\n" +
            "\t\t\tIF (COUNT = 2, ( noteOne + noteTwo ),\n" +
            "\t\t\t\tIF ( COUNT = 3,   noteOne + noteTwo + noteThree ,\n" +
            "\t\t\t\tIF (COUNT = 4,  noteOne+noteTwo+noteThree+noteFour,\n" +
            "\t\t\t\tIF (COUNT = 5,  noteOne+noteTwo+noteThree+noteFour+noteFive,\n" +
            "\t\t\t\tIF (COUNT = 6,  noteOne+noteTwo+noteThree+noteFour+noteFive+noteSix,\n" +
            "\t\t\t\tIF ( COUNT = 7,  noteOne+noteTwo+noteThree+noteFour+noteFive+noteSix+noteSeven,\n" +
            "\t\t\t\tIF (COUNT = 8, noteOne+noteTwo+noteThree+noteFour+noteFive+noteSix+noteSeven+noteEight,\n" +
            "\t\t\t\tIF (COUNT = 9,  noteOne+noteTwo+noteThree+noteFour+noteFive+noteSix+noteSeven+noteEight+noteNine,\n" +
            "\t\t\t\tIF (COUNT = 10, noteOne+noteTwo+noteThree+noteFour+noteFive+noteSix+noteSeven+noteEight+noteNine+noteTen,\n" +
            "\t\t\t\tIF (COUNT = 11, noteOne+noteTwo+noteThree+noteFour+noteFive+noteSix+noteSeven+noteEight+noteNine+noteTen+noteEleven,\n" +
            "\t\t\t\tIF (COUNT = 12, noteOne+noteTwo+noteThree+noteFour+noteFive+noteSix+noteSeven+noteEight+noteNine+noteTen+noteEleven+noteTwelve,\n" +
            "\t\t\t\tIF (COUNT = 13, noteOne+noteTwo+noteThree+noteFour+noteFive+noteSix+noteSeven+noteEight+noteNine+noteTen+noteEleven+noteTwelve+noteThirteen,\n" +
            "\t\t\t\tIF (COUNT = 14, noteOne+noteTwo+noteThree+noteFour+noteFive+noteSix+noteSeven+noteEight+noteNine+noteTen+noteEleven+noteTwelve+noteThirteen+noteFourteen,\n" +
            "\t\t\t\tIF (COUNT = 15, noteOne+noteTwo+noteThree+noteFour+noteFive+noteSix+noteSeven+noteEight+noteNine+noteTen+noteEleven+noteTwelve+noteThirteen+noteFourteen+noteFifteen,\n" +
            "\t\t\t\tIF (COUNT = 16, noteOne+noteTwo+noteThree+noteFour+noteFive+noteSix+noteSeven+noteEight+noteNine+noteTen+noteEleven+noteTwelve+noteThirteen+noteFourteen+noteFifteen+noteSixteen,\n" +
            "\t\t\t\tIF (COUNT = 17, noteOne+noteTwo+noteThree+noteFour+noteFive+noteSix+noteSeven+noteEight+noteNine+noteTen+noteEleven+noteTwelve+noteThirteen+noteFourteen+noteFifteen+noteSixteen+noteSeventeen,\n" +
            "\t\t\t\tIF (COUNT = 18, noteOne+noteTwo+noteThree+noteFour+noteFive+noteSix+noteSeven+noteEight+noteNine+noteTen+noteEleven+noteTwelve+noteThirteen+noteFourteen+noteFifteen+noteSixteen+noteSeventeen+noteEighteen,\n" +
            "\t\t\t\tIF (COUNT = 19, noteOne+noteTwo+noteThree+noteFour+noteFive+noteSix+noteSeven+noteEight+noteNine+noteTen+noteEleven+noteTwelve+noteThirteen+noteFourteen+noteFifteen+noteSixteen+noteSeventeen+noteEighteen+noteNineteen,\n" +
            "\t\t\t\tIF (COUNT = 20, noteOne+noteTwo+noteThree+noteFour+noteFive+noteSix+noteSeven+noteEight+noteNine+noteTen+noteEleven+noteTwelve+noteThirteen+noteFourteen+noteFifteen+noteSixteen+noteSeventeen+noteEighteen+noteNineteen+noteTwenty,\n" +
            "\t\t\t\t\"\"))))))))))))))))))) ) noteTotal," +
            "IF (COUNT = 1, knowledgeMasterOne ,\n" +
            "\t\t\tIF (COUNT = 2, ( knowledgeMasterOne + knowledgeMasterTwo ),\n" +
            "\t\t\t\tIF ( COUNT = 3,   knowledgeMasterOne + knowledgeMasterTwo + knowledgeMasterThree ,\n" +
            "\t\t\t\tIF (COUNT = 4,  knowledgeMasterOne+knowledgeMasterTwo+knowledgeMasterThree+knowledgeMasterFour,\n" +
            "\t\t\t\tIF (COUNT = 5,  knowledgeMasterOne+knowledgeMasterTwo+knowledgeMasterThree+knowledgeMasterFour+knowledgeMasterFive,\n" +
            "\t\t\t\tIF (COUNT = 6,  knowledgeMasterOne+knowledgeMasterTwo+knowledgeMasterThree+knowledgeMasterFour+knowledgeMasterFive+knowledgeMasterSix,\n" +
            "\t\t\t\tIF ( COUNT = 7,  knowledgeMasterOne+knowledgeMasterTwo+knowledgeMasterThree+knowledgeMasterFour+knowledgeMasterFive+knowledgeMasterSix+knowledgeMasterSeven,\n" +
            "\t\t\t\tIF (COUNT = 8, knowledgeMasterOne+knowledgeMasterTwo+knowledgeMasterThree+knowledgeMasterFour+knowledgeMasterFive+knowledgeMasterSix+knowledgeMasterSeven+knowledgeMasterEight,\n" +
            "\t\t\t\tIF (COUNT = 9,  knowledgeMasterOne+knowledgeMasterTwo+knowledgeMasterThree+knowledgeMasterFour+knowledgeMasterFive+knowledgeMasterSix+knowledgeMasterSeven+knowledgeMasterEight+knowledgeMasterNine,\n" +
            "\t\t\t\tIF (COUNT = 10, knowledgeMasterOne+knowledgeMasterTwo+knowledgeMasterThree+knowledgeMasterFour+knowledgeMasterFive+knowledgeMasterSix+knowledgeMasterSeven+knowledgeMasterEight+knowledgeMasterNine+knowledgeMasterTen,\n" +
            "\t\t\t\tIF (COUNT = 11, knowledgeMasterOne+knowledgeMasterTwo+knowledgeMasterThree+knowledgeMasterFour+knowledgeMasterFive+knowledgeMasterSix+knowledgeMasterSeven+knowledgeMasterEight+knowledgeMasterNine+knowledgeMasterTen+knowledgeMasterEleven,\n" +
            "\t\t\t\tIF (COUNT = 12, knowledgeMasterOne+knowledgeMasterTwo+knowledgeMasterThree+knowledgeMasterFour+knowledgeMasterFive+knowledgeMasterSix+knowledgeMasterSeven+knowledgeMasterEight+knowledgeMasterNine+knowledgeMasterTen+knowledgeMasterEleven+knowledgeMasterTwelve,\n" +
            "\t\t\t\tIF (COUNT = 13, knowledgeMasterOne+knowledgeMasterTwo+knowledgeMasterThree+knowledgeMasterFour+knowledgeMasterFive+knowledgeMasterSix+knowledgeMasterSeven+knowledgeMasterEight+knowledgeMasterNine+knowledgeMasterTen+knowledgeMasterEleven+knowledgeMasterTwelve+knowledgeMasterThirteen,\n" +
            "\t\t\t\tIF (COUNT = 14, knowledgeMasterOne+knowledgeMasterTwo+knowledgeMasterThree+knowledgeMasterFour+knowledgeMasterFive+knowledgeMasterSix+knowledgeMasterSeven+knowledgeMasterEight+knowledgeMasterNine+knowledgeMasterTen+knowledgeMasterEleven+knowledgeMasterTwelve+knowledgeMasterThirteen+knowledgeMasterFourteen,\n" +
            "\t\t\t\tIF (COUNT = 15, knowledgeMasterOne+knowledgeMasterTwo+knowledgeMasterThree+knowledgeMasterFour+knowledgeMasterFive+knowledgeMasterSix+knowledgeMasterSeven+knowledgeMasterEight+knowledgeMasterNine+knowledgeMasterTen+knowledgeMasterEleven+knowledgeMasterTwelve+knowledgeMasterThirteen+knowledgeMasterFourteen+knowledgeMasterFifteen,\n" +
            "\t\t\t\tIF (COUNT = 16, knowledgeMasterOne+knowledgeMasterTwo+knowledgeMasterThree+knowledgeMasterFour+knowledgeMasterFive+knowledgeMasterSix+knowledgeMasterSeven+knowledgeMasterEight+knowledgeMasterNine+knowledgeMasterTen+knowledgeMasterEleven+knowledgeMasterTwelve+knowledgeMasterThirteen+knowledgeMasterFourteen+knowledgeMasterFifteen+knowledgeMasterSixteen,\n" +
            "\t\t\t\tIF (COUNT = 17, knowledgeMasterOne+knowledgeMasterTwo+knowledgeMasterThree+knowledgeMasterFour+knowledgeMasterFive+knowledgeMasterSix+knowledgeMasterSeven+knowledgeMasterEight+knowledgeMasterNine+knowledgeMasterTen+knowledgeMasterEleven+knowledgeMasterTwelve+knowledgeMasterThirteen+knowledgeMasterFourteen+knowledgeMasterFifteen+knowledgeMasterSixteen+knowledgeMasterSeventeen,\n" +
            "\t\t\t\tIF (COUNT = 18, knowledgeMasterOne+knowledgeMasterTwo+knowledgeMasterThree+knowledgeMasterFour+knowledgeMasterFive+knowledgeMasterSix+knowledgeMasterSeven+knowledgeMasterEight+knowledgeMasterNine+knowledgeMasterTen+knowledgeMasterEleven+knowledgeMasterTwelve+knowledgeMasterThirteen+knowledgeMasterFourteen+knowledgeMasterFifteen+knowledgeMasterSixteen+knowledgeMasterSeventeen+knowledgeMasterEighteen,\n" +
            "\t\t\t\tIF (COUNT = 19, knowledgeMasterOne+knowledgeMasterTwo+knowledgeMasterThree+knowledgeMasterFour+knowledgeMasterFive+knowledgeMasterSix+knowledgeMasterSeven+knowledgeMasterEight+knowledgeMasterNine+knowledgeMasterTen+knowledgeMasterEleven+knowledgeMasterTwelve+knowledgeMasterThirteen+knowledgeMasterFourteen+knowledgeMasterFifteen+knowledgeMasterSixteen+knowledgeMasterSeventeen+knowledgeMasterEighteen+knowledgeMasterNineteen,\n" +
            "\t\t\t\tIF (COUNT = 20, knowledgeMasterOne+knowledgeMasterTwo+knowledgeMasterThree+knowledgeMasterFour+knowledgeMasterFive+knowledgeMasterSix+knowledgeMasterSeven+knowledgeMasterEight+knowledgeMasterNine+knowledgeMasterTen+knowledgeMasterEleven+knowledgeMasterTwelve+knowledgeMasterThirteen+knowledgeMasterFourteen+knowledgeMasterFifteen+knowledgeMasterSixteen+knowledgeMasterSeventeen+knowledgeMasterEighteen+knowledgeMasterNineteen+knowledgeMasterTwenty,\n" +
            "\t\t\t\t\"\"))))))))))))))))))) ) knowledgeMasterTotal" +
            " from details where teacher=#{teacher} and studentsName like #{studentsName}")
    @ResultMap("detailsMap")
    List<Details> findStudentsByStudentsName(@Param("teacher") String teacher, @Param("studentsName") String studentsName);

    @Select("select * from details where classId=#{classId} and studentsId=#{studentsId}")
    List<Details> findStudentsByStudentsId(@Param("classId") String classId, @Param("studentsId") String studentsId);

    @Select("select * from details where teacher=#{teacher1} and studentsName=#{studentsName1}")
    @ResultMap("detailsMap")
    List<Details> findStudentsDetailByStudentsName(@Param("teacher1") String teacher, @Param("studentsName1") String studentsName);

    @Select("select * ," +
            "IF (COUNT = 1, workOne ,\n" +
            "\t\t\tIF (COUNT = 2, ( workOne + workTwo ),\n" +
            "\t\t\t\tIF ( COUNT = 3,   workOne + workTwo + workThree ,\n" +
            "\t\t\t\tIF (COUNT = 4,  workOne+workTwo+workThree+workFour,\n" +
            "\t\t\t\tIF (COUNT = 5,  workOne+workTwo+workThree+workFour+workFive,\n" +
            "\t\t\t\tIF (COUNT = 6,  workOne+workTwo+workThree+workFour+workFive+workSix,\n" +
            "\t\t\t\tIF ( COUNT = 7,  workOne+workTwo+workThree+workFour+workFive+workSix+workSeven,\n" +
            "\t\t\t\tIF (COUNT = 8, workOne+workTwo+workThree+workFour+workFive+workSix+workSeven+workEight,\n" +
            "\t\t\t\tIF (COUNT = 9,  workOne+workTwo+workThree+workFour+workFive+workSix+workSeven+workEight+workNine,\n" +
            "\t\t\t\tIF (COUNT = 10, workOne+workTwo+workThree+workFour+workFive+workSix+workSeven+workEight+workNine+workTen,\n" +
            "\t\t\t\tIF (COUNT = 11, workOne+workTwo+workThree+workFour+workFive+workSix+workSeven+workEight+workNine+workTen+workEleven,\n" +
            "\t\t\t\tIF (COUNT = 12, workOne+workTwo+workThree+workFour+workFive+workSix+workSeven+workEight+workNine+workTen+workEleven+workTwelve,\n" +
            "\t\t\t\tIF (COUNT = 13, workOne+workTwo+workThree+workFour+workFive+workSix+workSeven+workEight+workNine+workTen+workEleven+workTwelve+workThirteen,\n" +
            "\t\t\t\tIF (COUNT = 14, workOne+workTwo+workThree+workFour+workFive+workSix+workSeven+workEight+workNine+workTen+workEleven+workTwelve+workThirteen+workFourteen,\n" +
            "\t\t\t\tIF (COUNT = 15, workOne+workTwo+workThree+workFour+workFive+workSix+workSeven+workEight+workNine+workTen+workEleven+workTwelve+workThirteen+workFourteen+workFifteen,\n" +
            "\t\t\t\tIF (COUNT = 16, workOne+workTwo+workThree+workFour+workFive+workSix+workSeven+workEight+workNine+workTen+workEleven+workTwelve+workThirteen+workFourteen+workFifteen+workSixteen,\n" +
            "\t\t\t\tIF (COUNT = 17, workOne+workTwo+workThree+workFour+workFive+workSix+workSeven+workEight+workNine+workTen+workEleven+workTwelve+workThirteen+workFourteen+workFifteen+workSixteen+workSeventeen,\n" +
            "\t\t\t\tIF (COUNT = 18, workOne+workTwo+workThree+workFour+workFive+workSix+workSeven+workEight+workNine+workTen+workEleven+workTwelve+workThirteen+workFourteen+workFifteen+workSixteen+workSeventeen+workEighteen,\n" +
            "\t\t\t\tIF (COUNT = 19, workOne+workTwo+workThree+workFour+workFive+workSix+workSeven+workEight+workNine+workTen+workEleven+workTwelve+workThirteen+workFourteen+workFifteen+workSixteen+workSeventeen+workEighteen+workNineteen,\n" +
            "\t\t\t\tIF (COUNT = 20, workOne+workTwo+workThree+workFour+workFive+workSix+workSeven+workEight+workNine+workTen+workEleven+workTwelve+workThirteen+workFourteen+workFifteen+workSixteen+workSeventeen+workEighteen+workNineteen+workTwenty,\n" +
            "\t\t\t\t\"\"))))))))))))))))))) ) workTotal," +
            "IF (COUNT = 1, videoOne ,\n" +
            "\t\t\tIF (COUNT = 2, ( videoOne + videoTwo ),\n" +
            "\t\t\t\tIF ( COUNT = 3,   videoOne + videoTwo + videoThree ,\n" +
            "\t\t\t\tIF (COUNT = 4,  videoOne+videoTwo+videoThree+videoFour,\n" +
            "\t\t\t\tIF (COUNT = 5,  videoOne+videoTwo+videoThree+videoFour+videoFive,\n" +
            "\t\t\t\tIF (COUNT = 6,  videoOne+videoTwo+videoThree+videoFour+videoFive+videoSix,\n" +
            "\t\t\t\tIF ( COUNT = 7,  videoOne+videoTwo+videoThree+videoFour+videoFive+videoSix+videoSeven,\n" +
            "\t\t\t\tIF (COUNT = 8, videoOne+videoTwo+videoThree+videoFour+videoFive+videoSix+videoSeven+videoEight,\n" +
            "\t\t\t\tIF (COUNT = 9,  videoOne+videoTwo+videoThree+videoFour+videoFive+videoSix+videoSeven+videoEight+videoNine,\n" +
            "\t\t\t\tIF (COUNT = 10, videoOne+videoTwo+videoThree+videoFour+videoFive+videoSix+videoSeven+videoEight+videoNine+videoTen,\n" +
            "\t\t\t\tIF (COUNT = 11, videoOne+videoTwo+videoThree+videoFour+videoFive+videoSix+videoSeven+videoEight+videoNine+videoTen+videoEleven,\n" +
            "\t\t\t\tIF (COUNT = 12, videoOne+videoTwo+videoThree+videoFour+videoFive+videoSix+videoSeven+videoEight+videoNine+videoTen+videoEleven+videoTwelve,\n" +
            "\t\t\t\tIF (COUNT = 13, videoOne+videoTwo+videoThree+videoFour+videoFive+videoSix+videoSeven+videoEight+videoNine+videoTen+videoEleven+videoTwelve+videoThirteen,\n" +
            "\t\t\t\tIF (COUNT = 14, videoOne+videoTwo+videoThree+videoFour+videoFive+videoSix+videoSeven+videoEight+videoNine+videoTen+videoEleven+videoTwelve+videoThirteen+videoFourteen,\n" +
            "\t\t\t\tIF (COUNT = 15, videoOne+videoTwo+videoThree+videoFour+videoFive+videoSix+videoSeven+videoEight+videoNine+videoTen+videoEleven+videoTwelve+videoThirteen+videoFourteen+videoFifteen,\n" +
            "\t\t\t\tIF (COUNT = 16, videoOne+videoTwo+videoThree+videoFour+videoFive+videoSix+videoSeven+videoEight+videoNine+videoTen+videoEleven+videoTwelve+videoThirteen+videoFourteen+videoFifteen+videoSixteen,\n" +
            "\t\t\t\tIF (COUNT = 17, videoOne+videoTwo+videoThree+videoFour+videoFive+videoSix+videoSeven+videoEight+videoNine+videoTen+videoEleven+videoTwelve+videoThirteen+videoFourteen+videoFifteen+videoSixteen+videoSeventeen,\n" +
            "\t\t\t\tIF (COUNT = 18, videoOne+videoTwo+videoThree+videoFour+videoFive+videoSix+videoSeven+videoEight+videoNine+videoTen+videoEleven+videoTwelve+videoThirteen+videoFourteen+videoFifteen+videoSixteen+videoSeventeen+videoEighteen,\n" +
            "\t\t\t\tIF (COUNT = 19, videoOne+videoTwo+videoThree+videoFour+videoFive+videoSix+videoSeven+videoEight+videoNine+videoTen+videoEleven+videoTwelve+videoThirteen+videoFourteen+videoFifteen+videoSixteen+videoSeventeen+videoEighteen+videoNineteen,\n" +
            "\t\t\t\tIF (COUNT = 20, videoOne+videoTwo+videoThree+videoFour+videoFive+videoSix+videoSeven+videoEight+videoNine+videoTen+videoEleven+videoTwelve+videoThirteen+videoFourteen+videoFifteen+videoSixteen+videoSeventeen+videoEighteen+videoNineteen+videoTwenty,\n" +
            "\t\t\t\t\"\"))))))))))))))))))) ) videoTotal," +
            "IF (COUNT = 1, noteOne ,\n" +
            "\t\t\tIF (COUNT = 2, ( noteOne + noteTwo ),\n" +
            "\t\t\t\tIF ( COUNT = 3,   noteOne + noteTwo + noteThree ,\n" +
            "\t\t\t\tIF (COUNT = 4,  noteOne+noteTwo+noteThree+noteFour,\n" +
            "\t\t\t\tIF (COUNT = 5,  noteOne+noteTwo+noteThree+noteFour+noteFive,\n" +
            "\t\t\t\tIF (COUNT = 6,  noteOne+noteTwo+noteThree+noteFour+noteFive+noteSix,\n" +
            "\t\t\t\tIF ( COUNT = 7,  noteOne+noteTwo+noteThree+noteFour+noteFive+noteSix+noteSeven,\n" +
            "\t\t\t\tIF (COUNT = 8, noteOne+noteTwo+noteThree+noteFour+noteFive+noteSix+noteSeven+noteEight,\n" +
            "\t\t\t\tIF (COUNT = 9,  noteOne+noteTwo+noteThree+noteFour+noteFive+noteSix+noteSeven+noteEight+noteNine,\n" +
            "\t\t\t\tIF (COUNT = 10, noteOne+noteTwo+noteThree+noteFour+noteFive+noteSix+noteSeven+noteEight+noteNine+noteTen,\n" +
            "\t\t\t\tIF (COUNT = 11, noteOne+noteTwo+noteThree+noteFour+noteFive+noteSix+noteSeven+noteEight+noteNine+noteTen+noteEleven,\n" +
            "\t\t\t\tIF (COUNT = 12, noteOne+noteTwo+noteThree+noteFour+noteFive+noteSix+noteSeven+noteEight+noteNine+noteTen+noteEleven+noteTwelve,\n" +
            "\t\t\t\tIF (COUNT = 13, noteOne+noteTwo+noteThree+noteFour+noteFive+noteSix+noteSeven+noteEight+noteNine+noteTen+noteEleven+noteTwelve+noteThirteen,\n" +
            "\t\t\t\tIF (COUNT = 14, noteOne+noteTwo+noteThree+noteFour+noteFive+noteSix+noteSeven+noteEight+noteNine+noteTen+noteEleven+noteTwelve+noteThirteen+noteFourteen,\n" +
            "\t\t\t\tIF (COUNT = 15, noteOne+noteTwo+noteThree+noteFour+noteFive+noteSix+noteSeven+noteEight+noteNine+noteTen+noteEleven+noteTwelve+noteThirteen+noteFourteen+noteFifteen,\n" +
            "\t\t\t\tIF (COUNT = 16, noteOne+noteTwo+noteThree+noteFour+noteFive+noteSix+noteSeven+noteEight+noteNine+noteTen+noteEleven+noteTwelve+noteThirteen+noteFourteen+noteFifteen+noteSixteen,\n" +
            "\t\t\t\tIF (COUNT = 17, noteOne+noteTwo+noteThree+noteFour+noteFive+noteSix+noteSeven+noteEight+noteNine+noteTen+noteEleven+noteTwelve+noteThirteen+noteFourteen+noteFifteen+noteSixteen+noteSeventeen,\n" +
            "\t\t\t\tIF (COUNT = 18, noteOne+noteTwo+noteThree+noteFour+noteFive+noteSix+noteSeven+noteEight+noteNine+noteTen+noteEleven+noteTwelve+noteThirteen+noteFourteen+noteFifteen+noteSixteen+noteSeventeen+noteEighteen,\n" +
            "\t\t\t\tIF (COUNT = 19, noteOne+noteTwo+noteThree+noteFour+noteFive+noteSix+noteSeven+noteEight+noteNine+noteTen+noteEleven+noteTwelve+noteThirteen+noteFourteen+noteFifteen+noteSixteen+noteSeventeen+noteEighteen+noteNineteen,\n" +
            "\t\t\t\tIF (COUNT = 20, noteOne+noteTwo+noteThree+noteFour+noteFive+noteSix+noteSeven+noteEight+noteNine+noteTen+noteEleven+noteTwelve+noteThirteen+noteFourteen+noteFifteen+noteSixteen+noteSeventeen+noteEighteen+noteNineteen+noteTwenty,\n" +
            "\t\t\t\t\"\"))))))))))))))))))) ) noteTotal," +
            "IF (COUNT = 1, knowledgeMasterOne ,\n" +
            "\t\t\tIF (COUNT = 2, ( knowledgeMasterOne + knowledgeMasterTwo ),\n" +
            "\t\t\t\tIF ( COUNT = 3,   knowledgeMasterOne + knowledgeMasterTwo + knowledgeMasterThree ,\n" +
            "\t\t\t\tIF (COUNT = 4,  knowledgeMasterOne+knowledgeMasterTwo+knowledgeMasterThree+knowledgeMasterFour,\n" +
            "\t\t\t\tIF (COUNT = 5,  knowledgeMasterOne+knowledgeMasterTwo+knowledgeMasterThree+knowledgeMasterFour+knowledgeMasterFive,\n" +
            "\t\t\t\tIF (COUNT = 6,  knowledgeMasterOne+knowledgeMasterTwo+knowledgeMasterThree+knowledgeMasterFour+knowledgeMasterFive+knowledgeMasterSix,\n" +
            "\t\t\t\tIF ( COUNT = 7,  knowledgeMasterOne+knowledgeMasterTwo+knowledgeMasterThree+knowledgeMasterFour+knowledgeMasterFive+knowledgeMasterSix+knowledgeMasterSeven,\n" +
            "\t\t\t\tIF (COUNT = 8, knowledgeMasterOne+knowledgeMasterTwo+knowledgeMasterThree+knowledgeMasterFour+knowledgeMasterFive+knowledgeMasterSix+knowledgeMasterSeven+knowledgeMasterEight,\n" +
            "\t\t\t\tIF (COUNT = 9,  knowledgeMasterOne+knowledgeMasterTwo+knowledgeMasterThree+knowledgeMasterFour+knowledgeMasterFive+knowledgeMasterSix+knowledgeMasterSeven+knowledgeMasterEight+knowledgeMasterNine,\n" +
            "\t\t\t\tIF (COUNT = 10, knowledgeMasterOne+knowledgeMasterTwo+knowledgeMasterThree+knowledgeMasterFour+knowledgeMasterFive+knowledgeMasterSix+knowledgeMasterSeven+knowledgeMasterEight+knowledgeMasterNine+knowledgeMasterTen,\n" +
            "\t\t\t\tIF (COUNT = 11, knowledgeMasterOne+knowledgeMasterTwo+knowledgeMasterThree+knowledgeMasterFour+knowledgeMasterFive+knowledgeMasterSix+knowledgeMasterSeven+knowledgeMasterEight+knowledgeMasterNine+knowledgeMasterTen+knowledgeMasterEleven,\n" +
            "\t\t\t\tIF (COUNT = 12, knowledgeMasterOne+knowledgeMasterTwo+knowledgeMasterThree+knowledgeMasterFour+knowledgeMasterFive+knowledgeMasterSix+knowledgeMasterSeven+knowledgeMasterEight+knowledgeMasterNine+knowledgeMasterTen+knowledgeMasterEleven+knowledgeMasterTwelve,\n" +
            "\t\t\t\tIF (COUNT = 13, knowledgeMasterOne+knowledgeMasterTwo+knowledgeMasterThree+knowledgeMasterFour+knowledgeMasterFive+knowledgeMasterSix+knowledgeMasterSeven+knowledgeMasterEight+knowledgeMasterNine+knowledgeMasterTen+knowledgeMasterEleven+knowledgeMasterTwelve+knowledgeMasterThirteen,\n" +
            "\t\t\t\tIF (COUNT = 14, knowledgeMasterOne+knowledgeMasterTwo+knowledgeMasterThree+knowledgeMasterFour+knowledgeMasterFive+knowledgeMasterSix+knowledgeMasterSeven+knowledgeMasterEight+knowledgeMasterNine+knowledgeMasterTen+knowledgeMasterEleven+knowledgeMasterTwelve+knowledgeMasterThirteen+knowledgeMasterFourteen,\n" +
            "\t\t\t\tIF (COUNT = 15, knowledgeMasterOne+knowledgeMasterTwo+knowledgeMasterThree+knowledgeMasterFour+knowledgeMasterFive+knowledgeMasterSix+knowledgeMasterSeven+knowledgeMasterEight+knowledgeMasterNine+knowledgeMasterTen+knowledgeMasterEleven+knowledgeMasterTwelve+knowledgeMasterThirteen+knowledgeMasterFourteen+knowledgeMasterFifteen,\n" +
            "\t\t\t\tIF (COUNT = 16, knowledgeMasterOne+knowledgeMasterTwo+knowledgeMasterThree+knowledgeMasterFour+knowledgeMasterFive+knowledgeMasterSix+knowledgeMasterSeven+knowledgeMasterEight+knowledgeMasterNine+knowledgeMasterTen+knowledgeMasterEleven+knowledgeMasterTwelve+knowledgeMasterThirteen+knowledgeMasterFourteen+knowledgeMasterFifteen+knowledgeMasterSixteen,\n" +
            "\t\t\t\tIF (COUNT = 17, knowledgeMasterOne+knowledgeMasterTwo+knowledgeMasterThree+knowledgeMasterFour+knowledgeMasterFive+knowledgeMasterSix+knowledgeMasterSeven+knowledgeMasterEight+knowledgeMasterNine+knowledgeMasterTen+knowledgeMasterEleven+knowledgeMasterTwelve+knowledgeMasterThirteen+knowledgeMasterFourteen+knowledgeMasterFifteen+knowledgeMasterSixteen+knowledgeMasterSeventeen,\n" +
            "\t\t\t\tIF (COUNT = 18, knowledgeMasterOne+knowledgeMasterTwo+knowledgeMasterThree+knowledgeMasterFour+knowledgeMasterFive+knowledgeMasterSix+knowledgeMasterSeven+knowledgeMasterEight+knowledgeMasterNine+knowledgeMasterTen+knowledgeMasterEleven+knowledgeMasterTwelve+knowledgeMasterThirteen+knowledgeMasterFourteen+knowledgeMasterFifteen+knowledgeMasterSixteen+knowledgeMasterSeventeen+knowledgeMasterEighteen,\n" +
            "\t\t\t\tIF (COUNT = 19, knowledgeMasterOne+knowledgeMasterTwo+knowledgeMasterThree+knowledgeMasterFour+knowledgeMasterFive+knowledgeMasterSix+knowledgeMasterSeven+knowledgeMasterEight+knowledgeMasterNine+knowledgeMasterTen+knowledgeMasterEleven+knowledgeMasterTwelve+knowledgeMasterThirteen+knowledgeMasterFourteen+knowledgeMasterFifteen+knowledgeMasterSixteen+knowledgeMasterSeventeen+knowledgeMasterEighteen+knowledgeMasterNineteen,\n" +
            "\t\t\t\tIF (COUNT = 20, knowledgeMasterOne+knowledgeMasterTwo+knowledgeMasterThree+knowledgeMasterFour+knowledgeMasterFive+knowledgeMasterSix+knowledgeMasterSeven+knowledgeMasterEight+knowledgeMasterNine+knowledgeMasterTen+knowledgeMasterEleven+knowledgeMasterTwelve+knowledgeMasterThirteen+knowledgeMasterFourteen+knowledgeMasterFifteen+knowledgeMasterSixteen+knowledgeMasterSeventeen+knowledgeMasterEighteen+knowledgeMasterNineteen+knowledgeMasterTwenty,\n" +
            "\t\t\t\t\"\"))))))))))))))))))) ) knowledgeMasterTotal" +
            " from details")
    @ResultMap("detailsMap")
    List<Details> findAllStudents();

    @Select("SELECT COUNT FROM details GROUP BY COUNT")
    Integer findCount();

    @Select("SELECT \n" +
            "\tteacher,\n" +
            "\tCOUNT(*) total,\n" +
            "\tCONCAT(TRUNCATE(SUM(weChat)/COUNT(*)*100,0),\"%\") weChat,\n" +
            "\tCONCAT(TRUNCATE(SUM(zhangYou)/COUNT(*)*100,0),\"%\") zhangYou,\n" +
            "\tCONCAT(TRUNCATE(SUM(shoppingCart)/COUNT(*)*100,0),\"%\") shoppingCart,\n" +
            "CONCAT(TRUNCATE(IF (COUNT = 1, SUM(workOne)/COUNT(0) , -- count eq 1\n" +
            "\t\t\tIF (COUNT = 2, ( (SUM(workOne) + SUM(workTwo))/(2 * COUNT(0)) ), -- count eq 2\n" +
            "\t\t\t\tIF ( COUNT = 3,  ( (SUM(workOne) + SUM(workTwo) + SUM(workThree) )/(3 * COUNT(0)) ),\n" +
            "\t\t\t\tIF (COUNT = 4, ( (SUM(workOne)+SUM(workTwo)+SUM(workThree)+SUM(workFour))/(4*COUNT(0))),\n" +
            "\t\t\t\tIF (COUNT = 5, ( (SUM(workOne)+SUM(workTwo)+SUM(workThree)+SUM(workFour)+SUM(workFive))/(5*COUNT(0))),\n" +
            "\t\t\t\tIF (COUNT = 6, ( (SUM(workOne)+SUM(workTwo)+SUM(workThree)+SUM(workFour)+SUM(workFive)+SUM(workSix))/(6*COUNT(0))),\n" +
            "\t\t\t\tIF ( COUNT = 7, ( (SUM(workOne)+SUM(workTwo)+SUM(workThree)+SUM(workFour)+SUM(workFive)+SUM(workSix)+SUM(workSeven))/(7*COUNT(0))),\n" +
            "\t\t\t\tIF (COUNT = 8,( (SUM(workOne)+SUM(workTwo)+SUM(workThree)+SUM(workFour)+SUM(workFive)+SUM(workSix)+SUM(workSeven)+SUM(workEight))/(8*COUNT(0))),\n" +
            "\t\t\t\tIF (COUNT = 9, ( (SUM(workOne)+SUM(workTwo)+SUM(workThree)+SUM(workFour)+SUM(workFive)+SUM(workSix)+SUM(workSeven)+SUM(workEight)+SUM(workNine))/(9*COUNT(0))),\n" +
            "\t\t\t\tIF (COUNT = 10, ( (SUM(workOne)+SUM(workTwo)+SUM(workThree)+SUM(workFour)+SUM(workFive)+SUM(workSix)+SUM(workSeven)+SUM(workEight)+SUM(workNine)+SUM(workTen))/(10*COUNT(0))),\n" +
            "\t\t\t\tIF (COUNT = 11, ( (SUM(workOne)+SUM(workTwo)+SUM(workThree)+SUM(workFour)+SUM(workFive)+SUM(workSix)+SUM(workSeven)+SUM(workEight)+SUM(workNine)+SUM(workTen)+SUM(workEleven))/(11*COUNT(0))),\n" +
            "\t\t\t\tIF (COUNT = 12, ( (SUM(workOne)+SUM(workTwo)+SUM(workThree)+SUM(workFour)+SUM(workFive)+SUM(workSix)+SUM(workSeven)+SUM(workEight)+SUM(workNine)+SUM(workTen)+SUM(workEleven)+SUM(workTwelve))/(12*COUNT(0))),\n" +
            "\t\t\t\tIF (COUNT = 13, ( (SUM(workOne)+SUM(workTwo)+SUM(workThree)+SUM(workFour)+SUM(workFive)+SUM(workSix)+SUM(workSeven)+SUM(workEight)+SUM(workNine)+SUM(workTen)+SUM(workEleven)+SUM(workTwelve)+SUM(workThirteen))/(13*COUNT(0))),\n" +
            "\t\t\t\tIF (COUNT = 14, ( (SUM(workOne)+SUM(workTwo)+SUM(workThree)+SUM(workFour)+SUM(workFive)+SUM(workSix)+SUM(workSeven)+SUM(workEight)+SUM(workNine)+SUM(workTen)+SUM(workEleven)+SUM(workTwelve)+SUM(workThirteen)+SUM(workFourteen))/(14*COUNT(0))),\n" +
            "\t\t\t\tIF (COUNT = 15, ( (SUM(workOne)+SUM(workTwo)+SUM(workThree)+SUM(workFour)+SUM(workFive)+SUM(workSix)+SUM(workSeven)+SUM(workEight)+SUM(workNine)+SUM(workTen)+SUM(workEleven)+SUM(workTwelve)+SUM(workThirteen)+SUM(workFourteen)+SUM(workFifteen))/(15*COUNT(0))),\n" +
            "\t\t\t\tIF (COUNT = 16, ( (SUM(workOne)+SUM(workTwo)+SUM(workThree)+SUM(workFour)+SUM(workFive)+SUM(workSix)+SUM(workSeven)+SUM(workEight)+SUM(workNine)+SUM(workTen)+SUM(workEleven)+SUM(workTwelve)+SUM(workThirteen)+SUM(workFourteen)+SUM(workFifteen)+SUM(workSixteen))/(16*COUNT(0))),\n" +
            "\t\t\t\tIF (COUNT = 17, ( (SUM(workOne)+SUM(workTwo)+SUM(workThree)+SUM(workFour)+SUM(workFive)+SUM(workSix)+SUM(workSeven)+SUM(workEight)+SUM(workNine)+SUM(workTen)+SUM(workEleven)+SUM(workTwelve)+SUM(workThirteen)+SUM(workFourteen)+SUM(workFifteen)+SUM(workSixteen)+SUM(workSeventeen))/(17*COUNT(0))),\n" +
            "\t\t\t\tIF (COUNT = 18, ( (SUM(workOne)+SUM(workTwo)+SUM(workThree)+SUM(workFour)+SUM(workFive)+SUM(workSix)+SUM(workSeven)+SUM(workEight)+SUM(workNine)+SUM(workTen)+SUM(workEleven)+SUM(workTwelve)+SUM(workThirteen)+SUM(workFourteen)+SUM(workFifteen)+SUM(workSixteen)+SUM(workSeventeen)+SUM(workEighteen))/(18*COUNT(0))),\n" +
            "\t\t\t\tIF (COUNT = 19, ( (SUM(workOne)+SUM(workTwo)+SUM(workThree)+SUM(workFour)+SUM(workFive)+SUM(workSix)+SUM(workSeven)+SUM(workEight)+SUM(workNine)+SUM(workTen)+SUM(workEleven)+SUM(workTwelve)+SUM(workThirteen)+SUM(workFourteen)+SUM(workFifteen)+SUM(workSixteen)+SUM(workSeventeen)+SUM(workEighteen)+SUM(workNineteen))/(19*COUNT(0))),\n" +
            "\t\t\t\tIF (COUNT = 20, ( (SUM(workOne)+SUM(workTwo)+SUM(workThree)+SUM(workFour)+SUM(workFive)+SUM(workSix)+SUM(workSeven)+SUM(workEight)+SUM(workNine)+SUM(workTen)+SUM(workEleven)+SUM(workTwelve)+SUM(workThirteen)+SUM(workFourteen)+SUM(workFifteen)+SUM(workSixteen)+SUM(workSeventeen)+SUM(workEighteen)+SUM(workNineteen)+SUM(workTwenty))/(20*COUNT(0))),\n" +
            "\t\t\t\t\"\"))))))))))))))))))) )*100,0),\"%\") workRatio," +
            "CONCAT(TRUNCATE(IF (COUNT = 1, SUM(videoOne)/COUNT(0) , -- count eq 1\n" +
            "\t\t\tIF (COUNT = 2, ( (SUM(videoOne) + SUM(videoTwo))/(2 * COUNT(0)) ), -- count eq 2\n" +
            "\t\t\t\tIF ( COUNT = 3,  ( (SUM(videoOne) + SUM(videoTwo) + SUM(videoThree) )/(3 * COUNT(0)) ),\n" +
            "\t\t\t\tIF (COUNT = 4, ( (SUM(videoOne)+SUM(videoTwo)+SUM(videoThree)+SUM(videoFour))/(4*COUNT(0))),\n" +
            "\t\t\t\tIF (COUNT = 5, ( (SUM(videoOne)+SUM(videoTwo)+SUM(videoThree)+SUM(videoFour)+SUM(videoFive))/(5*COUNT(0))),\n" +
            "\t\t\t\tIF (COUNT = 6, ( (SUM(videoOne)+SUM(videoTwo)+SUM(videoThree)+SUM(videoFour)+SUM(videoFive)+SUM(videoSix))/(6*COUNT(0))),\n" +
            "\t\t\t\tIF ( COUNT = 7, ( (SUM(videoOne)+SUM(videoTwo)+SUM(videoThree)+SUM(videoFour)+SUM(videoFive)+SUM(videoSix)+SUM(videoSeven))/(7*COUNT(0))),\n" +
            "\t\t\t\tIF (COUNT = 8,( (SUM(videoOne)+SUM(videoTwo)+SUM(videoThree)+SUM(videoFour)+SUM(videoFive)+SUM(videoSix)+SUM(videoSeven)+SUM(videoEight))/(8*COUNT(0))),\n" +
            "\t\t\t\tIF (COUNT = 9, ( (SUM(videoOne)+SUM(videoTwo)+SUM(videoThree)+SUM(videoFour)+SUM(videoFive)+SUM(videoSix)+SUM(videoSeven)+SUM(videoEight)+SUM(videoNine))/(9*COUNT(0))),\n" +
            "\t\t\t\tIF (COUNT = 10, ( (SUM(videoOne)+SUM(videoTwo)+SUM(videoThree)+SUM(videoFour)+SUM(videoFive)+SUM(videoSix)+SUM(videoSeven)+SUM(videoEight)+SUM(videoNine)+SUM(videoTen))/(10*COUNT(0))),\n" +
            "\t\t\t\tIF (COUNT = 11, ( (SUM(videoOne)+SUM(videoTwo)+SUM(videoThree)+SUM(videoFour)+SUM(videoFive)+SUM(videoSix)+SUM(videoSeven)+SUM(videoEight)+SUM(videoNine)+SUM(videoTen)+SUM(videoEleven))/(11*COUNT(0))),\n" +
            "\t\t\t\tIF (COUNT = 12, ( (SUM(videoOne)+SUM(videoTwo)+SUM(videoThree)+SUM(videoFour)+SUM(videoFive)+SUM(videoSix)+SUM(videoSeven)+SUM(videoEight)+SUM(videoNine)+SUM(videoTen)+SUM(videoEleven)+SUM(videoTwelve))/(12*COUNT(0))),\n" +
            "\t\t\t\tIF (COUNT = 13, ( (SUM(videoOne)+SUM(videoTwo)+SUM(videoThree)+SUM(videoFour)+SUM(videoFive)+SUM(videoSix)+SUM(videoSeven)+SUM(videoEight)+SUM(videoNine)+SUM(videoTen)+SUM(videoEleven)+SUM(videoTwelve)+SUM(videoThirteen))/(13*COUNT(0))),\n" +
            "\t\t\t\tIF (COUNT = 14, ( (SUM(videoOne)+SUM(videoTwo)+SUM(videoThree)+SUM(videoFour)+SUM(videoFive)+SUM(videoSix)+SUM(videoSeven)+SUM(videoEight)+SUM(videoNine)+SUM(videoTen)+SUM(videoEleven)+SUM(videoTwelve)+SUM(videoThirteen)+SUM(videoFourteen))/(14*COUNT(0))),\n" +
            "\t\t\t\tIF (COUNT = 15, ( (SUM(videoOne)+SUM(videoTwo)+SUM(videoThree)+SUM(videoFour)+SUM(videoFive)+SUM(videoSix)+SUM(videoSeven)+SUM(videoEight)+SUM(videoNine)+SUM(videoTen)+SUM(videoEleven)+SUM(videoTwelve)+SUM(videoThirteen)+SUM(videoFourteen)+SUM(videoFifteen))/(15*COUNT(0))),\n" +
            "\t\t\t\tIF (COUNT = 16, ( (SUM(videoOne)+SUM(videoTwo)+SUM(videoThree)+SUM(videoFour)+SUM(videoFive)+SUM(videoSix)+SUM(videoSeven)+SUM(videoEight)+SUM(videoNine)+SUM(videoTen)+SUM(videoEleven)+SUM(videoTwelve)+SUM(videoThirteen)+SUM(videoFourteen)+SUM(videoFifteen)+SUM(videoSixteen))/(16*COUNT(0))),\n" +
            "\t\t\t\tIF (COUNT = 17, ( (SUM(videoOne)+SUM(videoTwo)+SUM(videoThree)+SUM(videoFour)+SUM(videoFive)+SUM(videoSix)+SUM(videoSeven)+SUM(videoEight)+SUM(videoNine)+SUM(videoTen)+SUM(videoEleven)+SUM(videoTwelve)+SUM(videoThirteen)+SUM(videoFourteen)+SUM(videoFifteen)+SUM(videoSixteen)+SUM(videoSeventeen))/(17*COUNT(0))),\n" +
            "\t\t\t\tIF (COUNT = 18, ( (SUM(videoOne)+SUM(videoTwo)+SUM(videoThree)+SUM(videoFour)+SUM(videoFive)+SUM(videoSix)+SUM(videoSeven)+SUM(videoEight)+SUM(videoNine)+SUM(videoTen)+SUM(videoEleven)+SUM(videoTwelve)+SUM(videoThirteen)+SUM(videoFourteen)+SUM(videoFifteen)+SUM(videoSixteen)+SUM(videoSeventeen)+SUM(videoEighteen))/(18*COUNT(0))),\n" +
            "\t\t\t\tIF (COUNT = 19, ( (SUM(videoOne)+SUM(videoTwo)+SUM(videoThree)+SUM(videoFour)+SUM(videoFive)+SUM(videoSix)+SUM(videoSeven)+SUM(videoEight)+SUM(videoNine)+SUM(videoTen)+SUM(videoEleven)+SUM(videoTwelve)+SUM(videoThirteen)+SUM(videoFourteen)+SUM(videoFifteen)+SUM(videoSixteen)+SUM(videoSeventeen)+SUM(videoEighteen)+SUM(videoNineteen))/(19*COUNT(0))),\n" +
            "\t\t\t\tIF (COUNT = 20, ( (SUM(videoOne)+SUM(videoTwo)+SUM(videoThree)+SUM(videoFour)+SUM(videoFive)+SUM(videoSix)+SUM(videoSeven)+SUM(videoEight)+SUM(videoNine)+SUM(videoTen)+SUM(videoEleven)+SUM(videoTwelve)+SUM(videoThirteen)+SUM(videoFourteen)+SUM(videoFifteen)+SUM(videoSixteen)+SUM(videoSeventeen)+SUM(videoEighteen)+SUM(videoNineteen)+SUM(videoTwenty))/(20*COUNT(0))),\n" +
            "\t\t\t\t\"\"))))))))))))))))))) )*100,0),\"%\") videoRatio," +
            "CONCAT(TRUNCATE(IF (COUNT = 1, SUM(noteOne)/COUNT(0) , -- count eq 1\n" +
            "\t\t\tIF (COUNT = 2, ( (SUM(noteOne) + SUM(noteTwo))/(2 * COUNT(0)) ), -- count eq 2\n" +
            "\t\t\t\tIF ( COUNT = 3,  ( (SUM(noteOne) + SUM(noteTwo) + SUM(noteThree) )/(3 * COUNT(0)) ),\n" +
            "\t\t\t\tIF (COUNT = 4, ( (SUM(noteOne)+SUM(noteTwo)+SUM(noteThree)+SUM(noteFour))/(4*COUNT(0))),\n" +
            "\t\t\t\tIF (COUNT = 5, ( (SUM(noteOne)+SUM(noteTwo)+SUM(noteThree)+SUM(noteFour)+SUM(noteFive))/(5*COUNT(0))),\n" +
            "\t\t\t\tIF (COUNT = 6, ( (SUM(noteOne)+SUM(noteTwo)+SUM(noteThree)+SUM(noteFour)+SUM(noteFive)+SUM(noteSix))/(6*COUNT(0))),\n" +
            "\t\t\t\tIF ( COUNT = 7, ( (SUM(noteOne)+SUM(noteTwo)+SUM(noteThree)+SUM(noteFour)+SUM(noteFive)+SUM(noteSix)+SUM(noteSeven))/(7*COUNT(0))),\n" +
            "\t\t\t\tIF (COUNT = 8,( (SUM(noteOne)+SUM(noteTwo)+SUM(noteThree)+SUM(noteFour)+SUM(noteFive)+SUM(noteSix)+SUM(noteSeven)+SUM(noteEight))/(8*COUNT(0))),\n" +
            "\t\t\t\tIF (COUNT = 9, ( (SUM(noteOne)+SUM(noteTwo)+SUM(noteThree)+SUM(noteFour)+SUM(noteFive)+SUM(noteSix)+SUM(noteSeven)+SUM(noteEight)+SUM(noteNine))/(9*COUNT(0))),\n" +
            "\t\t\t\tIF (COUNT = 10, ( (SUM(noteOne)+SUM(noteTwo)+SUM(noteThree)+SUM(noteFour)+SUM(noteFive)+SUM(noteSix)+SUM(noteSeven)+SUM(noteEight)+SUM(noteNine)+SUM(noteTen))/(10*COUNT(0))),\n" +
            "\t\t\t\tIF (COUNT = 11, ( (SUM(noteOne)+SUM(noteTwo)+SUM(noteThree)+SUM(noteFour)+SUM(noteFive)+SUM(noteSix)+SUM(noteSeven)+SUM(noteEight)+SUM(noteNine)+SUM(noteTen)+SUM(noteEleven))/(11*COUNT(0))),\n" +
            "\t\t\t\tIF (COUNT = 12, ( (SUM(noteOne)+SUM(noteTwo)+SUM(noteThree)+SUM(noteFour)+SUM(noteFive)+SUM(noteSix)+SUM(noteSeven)+SUM(noteEight)+SUM(noteNine)+SUM(noteTen)+SUM(noteEleven)+SUM(noteTwelve))/(12*COUNT(0))),\n" +
            "\t\t\t\tIF (COUNT = 13, ( (SUM(noteOne)+SUM(noteTwo)+SUM(noteThree)+SUM(noteFour)+SUM(noteFive)+SUM(noteSix)+SUM(noteSeven)+SUM(noteEight)+SUM(noteNine)+SUM(noteTen)+SUM(noteEleven)+SUM(noteTwelve)+SUM(noteThirteen))/(13*COUNT(0))),\n" +
            "\t\t\t\tIF (COUNT = 14, ( (SUM(noteOne)+SUM(noteTwo)+SUM(noteThree)+SUM(noteFour)+SUM(noteFive)+SUM(noteSix)+SUM(noteSeven)+SUM(noteEight)+SUM(noteNine)+SUM(noteTen)+SUM(noteEleven)+SUM(noteTwelve)+SUM(noteThirteen)+SUM(noteFourteen))/(14*COUNT(0))),\n" +
            "\t\t\t\tIF (COUNT = 15, ( (SUM(noteOne)+SUM(noteTwo)+SUM(noteThree)+SUM(noteFour)+SUM(noteFive)+SUM(noteSix)+SUM(noteSeven)+SUM(noteEight)+SUM(noteNine)+SUM(noteTen)+SUM(noteEleven)+SUM(noteTwelve)+SUM(noteThirteen)+SUM(noteFourteen)+SUM(noteFifteen))/(15*COUNT(0))),\n" +
            "\t\t\t\tIF (COUNT = 16, ( (SUM(noteOne)+SUM(noteTwo)+SUM(noteThree)+SUM(noteFour)+SUM(noteFive)+SUM(noteSix)+SUM(noteSeven)+SUM(noteEight)+SUM(noteNine)+SUM(noteTen)+SUM(noteEleven)+SUM(noteTwelve)+SUM(noteThirteen)+SUM(noteFourteen)+SUM(noteFifteen)+SUM(noteSixteen))/(16*COUNT(0))),\n" +
            "\t\t\t\tIF (COUNT = 17, ( (SUM(noteOne)+SUM(noteTwo)+SUM(noteThree)+SUM(noteFour)+SUM(noteFive)+SUM(noteSix)+SUM(noteSeven)+SUM(noteEight)+SUM(noteNine)+SUM(noteTen)+SUM(noteEleven)+SUM(noteTwelve)+SUM(noteThirteen)+SUM(noteFourteen)+SUM(noteFifteen)+SUM(noteSixteen)+SUM(noteSeventeen))/(17*COUNT(0))),\n" +
            "\t\t\t\tIF (COUNT = 18, ( (SUM(noteOne)+SUM(noteTwo)+SUM(noteThree)+SUM(noteFour)+SUM(noteFive)+SUM(noteSix)+SUM(noteSeven)+SUM(noteEight)+SUM(noteNine)+SUM(noteTen)+SUM(noteEleven)+SUM(noteTwelve)+SUM(noteThirteen)+SUM(noteFourteen)+SUM(noteFifteen)+SUM(noteSixteen)+SUM(noteSeventeen)+SUM(noteEighteen))/(18*COUNT(0))),\n" +
            "\t\t\t\tIF (COUNT = 19, ( (SUM(noteOne)+SUM(noteTwo)+SUM(noteThree)+SUM(noteFour)+SUM(noteFive)+SUM(noteSix)+SUM(noteSeven)+SUM(noteEight)+SUM(noteNine)+SUM(noteTen)+SUM(noteEleven)+SUM(noteTwelve)+SUM(noteThirteen)+SUM(noteFourteen)+SUM(noteFifteen)+SUM(noteSixteen)+SUM(noteSeventeen)+SUM(noteEighteen)+SUM(noteNineteen))/(19*COUNT(0))),\n" +
            "\t\t\t\tIF (COUNT = 20, ( (SUM(noteOne)+SUM(noteTwo)+SUM(noteThree)+SUM(noteFour)+SUM(noteFive)+SUM(noteSix)+SUM(noteSeven)+SUM(noteEight)+SUM(noteNine)+SUM(noteTen)+SUM(noteEleven)+SUM(noteTwelve)+SUM(noteThirteen)+SUM(noteFourteen)+SUM(noteFifteen)+SUM(noteSixteen)+SUM(noteSeventeen)+SUM(noteEighteen)+SUM(noteNineteen)+SUM(noteTwenty))/(20*COUNT(0))),\n" +
            "\t\t\t\t\"\"))))))))))))))))))) )*100,0),\"%\") noteRatio," +
            "CONCAT(TRUNCATE(IF (COUNT = 1, SUM(knowledgeMasterOne)/COUNT(0) , -- count eq 1\n" +
            "\t\t\tIF (COUNT = 2, ( (SUM(knowledgeMasterOne) + SUM(knowledgeMasterTwo))/(2 * COUNT(0)) ), -- count eq 2\n" +
            "\t\t\t\tIF ( COUNT = 3,  ( (SUM(knowledgeMasterOne) + SUM(knowledgeMasterTwo) + SUM(knowledgeMasterThree) )/(3 * COUNT(0)) ),\n" +
            "\t\t\t\tIF (COUNT = 4, ( (SUM(knowledgeMasterOne)+SUM(knowledgeMasterTwo)+SUM(knowledgeMasterThree)+SUM(knowledgeMasterFour))/(4*COUNT(0))),\n" +
            "\t\t\t\tIF (COUNT = 5, ( (SUM(knowledgeMasterOne)+SUM(knowledgeMasterTwo)+SUM(knowledgeMasterThree)+SUM(knowledgeMasterFour)+SUM(knowledgeMasterFive))/(5*COUNT(0))),\n" +
            "\t\t\t\tIF (COUNT = 6, ( (SUM(knowledgeMasterOne)+SUM(knowledgeMasterTwo)+SUM(knowledgeMasterThree)+SUM(knowledgeMasterFour)+SUM(knowledgeMasterFive)+SUM(knowledgeMasterSix))/(6*COUNT(0))),\n" +
            "\t\t\t\tIF ( COUNT = 7, ( (SUM(knowledgeMasterOne)+SUM(knowledgeMasterTwo)+SUM(knowledgeMasterThree)+SUM(knowledgeMasterFour)+SUM(knowledgeMasterFive)+SUM(knowledgeMasterSix)+SUM(knowledgeMasterSeven))/(7*COUNT(0))),\n" +
            "\t\t\t\tIF (COUNT = 8,( (SUM(knowledgeMasterOne)+SUM(knowledgeMasterTwo)+SUM(knowledgeMasterThree)+SUM(knowledgeMasterFour)+SUM(knowledgeMasterFive)+SUM(knowledgeMasterSix)+SUM(knowledgeMasterSeven)+SUM(knowledgeMasterEight))/(8*COUNT(0))),\n" +
            "\t\t\t\tIF (COUNT = 9, ( (SUM(knowledgeMasterOne)+SUM(knowledgeMasterTwo)+SUM(knowledgeMasterThree)+SUM(knowledgeMasterFour)+SUM(knowledgeMasterFive)+SUM(knowledgeMasterSix)+SUM(knowledgeMasterSeven)+SUM(knowledgeMasterEight)+SUM(knowledgeMasterNine))/(9*COUNT(0))),\n" +
            "\t\t\t\tIF (COUNT = 10, ( (SUM(knowledgeMasterOne)+SUM(knowledgeMasterTwo)+SUM(knowledgeMasterThree)+SUM(knowledgeMasterFour)+SUM(knowledgeMasterFive)+SUM(knowledgeMasterSix)+SUM(knowledgeMasterSeven)+SUM(knowledgeMasterEight)+SUM(knowledgeMasterNine)+SUM(knowledgeMasterTen))/(10*COUNT(0))),\n" +
            "\t\t\t\tIF (COUNT = 11, ( (SUM(knowledgeMasterOne)+SUM(knowledgeMasterTwo)+SUM(knowledgeMasterThree)+SUM(knowledgeMasterFour)+SUM(knowledgeMasterFive)+SUM(knowledgeMasterSix)+SUM(knowledgeMasterSeven)+SUM(knowledgeMasterEight)+SUM(knowledgeMasterNine)+SUM(knowledgeMasterTen)+SUM(knowledgeMasterEleven))/(11*COUNT(0))),\n" +
            "\t\t\t\tIF (COUNT = 12, ( (SUM(knowledgeMasterOne)+SUM(knowledgeMasterTwo)+SUM(knowledgeMasterThree)+SUM(knowledgeMasterFour)+SUM(knowledgeMasterFive)+SUM(knowledgeMasterSix)+SUM(knowledgeMasterSeven)+SUM(knowledgeMasterEight)+SUM(knowledgeMasterNine)+SUM(knowledgeMasterTen)+SUM(knowledgeMasterEleven)+SUM(knowledgeMasterTwelve))/(12*COUNT(0))),\n" +
            "\t\t\t\tIF (COUNT = 13, ( (SUM(knowledgeMasterOne)+SUM(knowledgeMasterTwo)+SUM(knowledgeMasterThree)+SUM(knowledgeMasterFour)+SUM(knowledgeMasterFive)+SUM(knowledgeMasterSix)+SUM(knowledgeMasterSeven)+SUM(knowledgeMasterEight)+SUM(knowledgeMasterNine)+SUM(knowledgeMasterTen)+SUM(knowledgeMasterEleven)+SUM(knowledgeMasterTwelve)+SUM(knowledgeMasterThirteen))/(13*COUNT(0))),\n" +
            "\t\t\t\tIF (COUNT = 14, ( (SUM(knowledgeMasterOne)+SUM(knowledgeMasterTwo)+SUM(knowledgeMasterThree)+SUM(knowledgeMasterFour)+SUM(knowledgeMasterFive)+SUM(knowledgeMasterSix)+SUM(knowledgeMasterSeven)+SUM(knowledgeMasterEight)+SUM(knowledgeMasterNine)+SUM(knowledgeMasterTen)+SUM(knowledgeMasterEleven)+SUM(knowledgeMasterTwelve)+SUM(knowledgeMasterThirteen)+SUM(knowledgeMasterFourteen))/(14*COUNT(0))),\n" +
            "\t\t\t\tIF (COUNT = 15, ( (SUM(knowledgeMasterOne)+SUM(knowledgeMasterTwo)+SUM(knowledgeMasterThree)+SUM(knowledgeMasterFour)+SUM(knowledgeMasterFive)+SUM(knowledgeMasterSix)+SUM(knowledgeMasterSeven)+SUM(knowledgeMasterEight)+SUM(knowledgeMasterNine)+SUM(knowledgeMasterTen)+SUM(knowledgeMasterEleven)+SUM(knowledgeMasterTwelve)+SUM(knowledgeMasterThirteen)+SUM(knowledgeMasterFourteen)+SUM(knowledgeMasterFifteen))/(15*COUNT(0))),\n" +
            "\t\t\t\tIF (COUNT = 16, ( (SUM(knowledgeMasterOne)+SUM(knowledgeMasterTwo)+SUM(knowledgeMasterThree)+SUM(knowledgeMasterFour)+SUM(knowledgeMasterFive)+SUM(knowledgeMasterSix)+SUM(knowledgeMasterSeven)+SUM(knowledgeMasterEight)+SUM(knowledgeMasterNine)+SUM(knowledgeMasterTen)+SUM(knowledgeMasterEleven)+SUM(knowledgeMasterTwelve)+SUM(knowledgeMasterThirteen)+SUM(knowledgeMasterFourteen)+SUM(knowledgeMasterFifteen)+SUM(knowledgeMasterSixteen))/(16*COUNT(0))),\n" +
            "\t\t\t\tIF (COUNT = 17, ( (SUM(knowledgeMasterOne)+SUM(knowledgeMasterTwo)+SUM(knowledgeMasterThree)+SUM(knowledgeMasterFour)+SUM(knowledgeMasterFive)+SUM(knowledgeMasterSix)+SUM(knowledgeMasterSeven)+SUM(knowledgeMasterEight)+SUM(knowledgeMasterNine)+SUM(knowledgeMasterTen)+SUM(knowledgeMasterEleven)+SUM(knowledgeMasterTwelve)+SUM(knowledgeMasterThirteen)+SUM(knowledgeMasterFourteen)+SUM(knowledgeMasterFifteen)+SUM(knowledgeMasterSixteen)+SUM(knowledgeMasterSeventeen))/(17*COUNT(0))),\n" +
            "\t\t\t\tIF (COUNT = 18, ( (SUM(knowledgeMasterOne)+SUM(knowledgeMasterTwo)+SUM(knowledgeMasterThree)+SUM(knowledgeMasterFour)+SUM(knowledgeMasterFive)+SUM(knowledgeMasterSix)+SUM(knowledgeMasterSeven)+SUM(knowledgeMasterEight)+SUM(knowledgeMasterNine)+SUM(knowledgeMasterTen)+SUM(knowledgeMasterEleven)+SUM(knowledgeMasterTwelve)+SUM(knowledgeMasterThirteen)+SUM(knowledgeMasterFourteen)+SUM(knowledgeMasterFifteen)+SUM(knowledgeMasterSixteen)+SUM(knowledgeMasterSeventeen)+SUM(knowledgeMasterEighteen))/(18*COUNT(0))),\n" +
            "\t\t\t\tIF (COUNT = 19, ( (SUM(knowledgeMasterOne)+SUM(knowledgeMasterTwo)+SUM(knowledgeMasterThree)+SUM(knowledgeMasterFour)+SUM(knowledgeMasterFive)+SUM(knowledgeMasterSix)+SUM(knowledgeMasterSeven)+SUM(knowledgeMasterEight)+SUM(knowledgeMasterNine)+SUM(knowledgeMasterTen)+SUM(knowledgeMasterEleven)+SUM(knowledgeMasterTwelve)+SUM(knowledgeMasterThirteen)+SUM(knowledgeMasterFourteen)+SUM(knowledgeMasterFifteen)+SUM(knowledgeMasterSixteen)+SUM(knowledgeMasterSeventeen)+SUM(knowledgeMasterEighteen)+SUM(knowledgeMasterNineteen))/(19*COUNT(0))),\n" +
            "\t\t\t\tIF (COUNT = 20, ( (SUM(knowledgeMasterOne)+SUM(knowledgeMasterTwo)+SUM(knowledgeMasterThree)+SUM(knowledgeMasterFour)+SUM(knowledgeMasterFive)+SUM(knowledgeMasterSix)+SUM(knowledgeMasterSeven)+SUM(knowledgeMasterEight)+SUM(knowledgeMasterNine)+SUM(knowledgeMasterTen)+SUM(knowledgeMasterEleven)+SUM(knowledgeMasterTwelve)+SUM(knowledgeMasterThirteen)+SUM(knowledgeMasterFourteen)+SUM(knowledgeMasterFifteen)+SUM(knowledgeMasterSixteen)+SUM(knowledgeMasterSeventeen)+SUM(knowledgeMasterEighteen)+SUM(knowledgeMasterNineteen)+SUM(knowledgeMasterTwenty))/(20*COUNT(0))),\n" +
            "\t\t\t\t\"\"))))))))))))))))))) )*100,0),\"%\") knowledgeMasterRatio," +
            "\tCONCAT(TRUNCATE(SUM(oneToOne)/COUNT(*)*100,0),\"%\") oneToOneRatio,\n" +
            "\tCONCAT(TRUNCATE(SUM(isContinue)/COUNT(*)*100,0),\"%\") isContinueRatio\n" +
            "FROM \n" +
            "\tdetails \n" +
            "WHERE\n" +
            "\tproject=#{project}\n" +
            "GROUP BY \n" +
            "\tteacher;")
    @Results(id = "courseMap",
            value = {
                    @Result(column = "teacher", property = "teacher"),
                    @Result(column = "total", property = "total"),
                    @Result(column = "weChat", property = "weChat"),
                    @Result(column = "zhangYou", property = "zhangYou"),
                    @Result(column = "workRatio", property = "workRatio"),
                    @Result(column = "videoRatio", property = "videoRatio"),
                    @Result(column = "noteRatio", property = "noteRatio"),
                    @Result(column = "knowledgeMasterRatio", property = "knowledgeMasterRatio"),
                    @Result(column = "oneToOneRatio", property = "oneToOneRatio"),
                    @Result(column = "isContinueRatio", property = "isContinueRatio"),
                    @Result(column = "shoppingCart", property = "shoppingCart")
            })
    List<Course> findProject(String project);

    @Select("SELECT \n" +
            "\tteacher,\n" +
            "\tclassId,\n" +
            "\tCOUNT(*) total,\n" +
            "\tCONCAT(TRUNCATE(SUM(weChat)/COUNT(*)*100,0),\"%\") weChat,\n" +
            "\tCONCAT(TRUNCATE(SUM(zhangYou)/COUNT(*)*100,0),\"%\") zhangYou,\n" +
            "\tCONCAT(TRUNCATE(SUM(shoppingCart)/COUNT(*)*100,0),\"%\") shoppingCart\n" +
            "FROM\n" +
            "\tdetails\n" +
            "GROUP BY\n" +
            "\tclassId;")
    @Results(id = "classMap",
            value = {
                    @Result(column = "teacher", property = "teacher"),
                    @Result(column = "classId", property = "classId"),
                    @Result(column = "total", property = "total"),
                    @Result(column = "weChat", property = "weChat"),
                    @Result(column = "zhangYou", property = "zhangYou"),
                    @Result(column = "shoppingCart", property = "shoppingCart")
            })
    List<ClassData> findClass();

    @Select("SELECT \n" +
            "\tproject,\n" +
            "\tCOUNT(*) total,\n" +
            "\tCONCAT(TRUNCATE(SUM(weChat)/COUNT(*)*100,0),\"%\") weChat,\n" +
            "\tCONCAT(TRUNCATE(SUM(zhangYou)/COUNT(*)*100,0),\"%\") zhangYou,\n" +
            "\tCONCAT(TRUNCATE(SUM(shoppingCart)/COUNT(*)*100,0),\"%\") shoppingCart,\n" +
            "CONCAT(TRUNCATE(IF (COUNT = 1, SUM(workOne)/COUNT(0) , -- count eq 1\n" +
            "\t\t\tIF (COUNT = 2, ( (SUM(workOne) + SUM(workTwo))/(2 * COUNT(0)) ), -- count eq 2\n" +
            "\t\t\t\tIF ( COUNT = 3,  ( (SUM(workOne) + SUM(workTwo) + SUM(workThree) )/(3 * COUNT(0)) ),\n" +
            "\t\t\t\tIF (COUNT = 4, ( (SUM(workOne)+SUM(workTwo)+SUM(workThree)+SUM(workFour))/(4*COUNT(0))),\n" +
            "\t\t\t\tIF (COUNT = 5, ( (SUM(workOne)+SUM(workTwo)+SUM(workThree)+SUM(workFour)+SUM(workFive))/(5*COUNT(0))),\n" +
            "\t\t\t\tIF (COUNT = 6, ( (SUM(workOne)+SUM(workTwo)+SUM(workThree)+SUM(workFour)+SUM(workFive)+SUM(workSix))/(6*COUNT(0))),\n" +
            "\t\t\t\tIF ( COUNT = 7, ( (SUM(workOne)+SUM(workTwo)+SUM(workThree)+SUM(workFour)+SUM(workFive)+SUM(workSix)+SUM(workSeven))/(7*COUNT(0))),\n" +
            "\t\t\t\tIF (COUNT = 8,( (SUM(workOne)+SUM(workTwo)+SUM(workThree)+SUM(workFour)+SUM(workFive)+SUM(workSix)+SUM(workSeven)+SUM(workEight))/(8*COUNT(0))),\n" +
            "\t\t\t\tIF (COUNT = 9, ( (SUM(workOne)+SUM(workTwo)+SUM(workThree)+SUM(workFour)+SUM(workFive)+SUM(workSix)+SUM(workSeven)+SUM(workEight)+SUM(workNine))/(9*COUNT(0))),\n" +
            "\t\t\t\tIF (COUNT = 10, ( (SUM(workOne)+SUM(workTwo)+SUM(workThree)+SUM(workFour)+SUM(workFive)+SUM(workSix)+SUM(workSeven)+SUM(workEight)+SUM(workNine)+SUM(workTen))/(10*COUNT(0))),\n" +
            "\t\t\t\tIF (COUNT = 11, ( (SUM(workOne)+SUM(workTwo)+SUM(workThree)+SUM(workFour)+SUM(workFive)+SUM(workSix)+SUM(workSeven)+SUM(workEight)+SUM(workNine)+SUM(workTen)+SUM(workEleven))/(11*COUNT(0))),\n" +
            "\t\t\t\tIF (COUNT = 12, ( (SUM(workOne)+SUM(workTwo)+SUM(workThree)+SUM(workFour)+SUM(workFive)+SUM(workSix)+SUM(workSeven)+SUM(workEight)+SUM(workNine)+SUM(workTen)+SUM(workEleven)+SUM(workTwelve))/(12*COUNT(0))),\n" +
            "\t\t\t\tIF (COUNT = 13, ( (SUM(workOne)+SUM(workTwo)+SUM(workThree)+SUM(workFour)+SUM(workFive)+SUM(workSix)+SUM(workSeven)+SUM(workEight)+SUM(workNine)+SUM(workTen)+SUM(workEleven)+SUM(workTwelve)+SUM(workThirteen))/(13*COUNT(0))),\n" +
            "\t\t\t\tIF (COUNT = 14, ( (SUM(workOne)+SUM(workTwo)+SUM(workThree)+SUM(workFour)+SUM(workFive)+SUM(workSix)+SUM(workSeven)+SUM(workEight)+SUM(workNine)+SUM(workTen)+SUM(workEleven)+SUM(workTwelve)+SUM(workThirteen)+SUM(workFourteen))/(14*COUNT(0))),\n" +
            "\t\t\t\tIF (COUNT = 15, ( (SUM(workOne)+SUM(workTwo)+SUM(workThree)+SUM(workFour)+SUM(workFive)+SUM(workSix)+SUM(workSeven)+SUM(workEight)+SUM(workNine)+SUM(workTen)+SUM(workEleven)+SUM(workTwelve)+SUM(workThirteen)+SUM(workFourteen)+SUM(workFifteen))/(15*COUNT(0))),\n" +
            "\t\t\t\tIF (COUNT = 16, ( (SUM(workOne)+SUM(workTwo)+SUM(workThree)+SUM(workFour)+SUM(workFive)+SUM(workSix)+SUM(workSeven)+SUM(workEight)+SUM(workNine)+SUM(workTen)+SUM(workEleven)+SUM(workTwelve)+SUM(workThirteen)+SUM(workFourteen)+SUM(workFifteen)+SUM(workSixteen))/(16*COUNT(0))),\n" +
            "\t\t\t\tIF (COUNT = 17, ( (SUM(workOne)+SUM(workTwo)+SUM(workThree)+SUM(workFour)+SUM(workFive)+SUM(workSix)+SUM(workSeven)+SUM(workEight)+SUM(workNine)+SUM(workTen)+SUM(workEleven)+SUM(workTwelve)+SUM(workThirteen)+SUM(workFourteen)+SUM(workFifteen)+SUM(workSixteen)+SUM(workSeventeen))/(17*COUNT(0))),\n" +
            "\t\t\t\tIF (COUNT = 18, ( (SUM(workOne)+SUM(workTwo)+SUM(workThree)+SUM(workFour)+SUM(workFive)+SUM(workSix)+SUM(workSeven)+SUM(workEight)+SUM(workNine)+SUM(workTen)+SUM(workEleven)+SUM(workTwelve)+SUM(workThirteen)+SUM(workFourteen)+SUM(workFifteen)+SUM(workSixteen)+SUM(workSeventeen)+SUM(workEighteen))/(18*COUNT(0))),\n" +
            "\t\t\t\tIF (COUNT = 19, ( (SUM(workOne)+SUM(workTwo)+SUM(workThree)+SUM(workFour)+SUM(workFive)+SUM(workSix)+SUM(workSeven)+SUM(workEight)+SUM(workNine)+SUM(workTen)+SUM(workEleven)+SUM(workTwelve)+SUM(workThirteen)+SUM(workFourteen)+SUM(workFifteen)+SUM(workSixteen)+SUM(workSeventeen)+SUM(workEighteen)+SUM(workNineteen))/(19*COUNT(0))),\n" +
            "\t\t\t\tIF (COUNT = 20, ( (SUM(workOne)+SUM(workTwo)+SUM(workThree)+SUM(workFour)+SUM(workFive)+SUM(workSix)+SUM(workSeven)+SUM(workEight)+SUM(workNine)+SUM(workTen)+SUM(workEleven)+SUM(workTwelve)+SUM(workThirteen)+SUM(workFourteen)+SUM(workFifteen)+SUM(workSixteen)+SUM(workSeventeen)+SUM(workEighteen)+SUM(workNineteen)+SUM(workTwenty))/(20*COUNT(0))),\n" +
            "\t\t\t\t\"\"))))))))))))))))))) )*100,0),\"%\") workRatio," +
            "CONCAT(TRUNCATE(IF (COUNT = 1, SUM(videoOne)/COUNT(0) , -- count eq 1\n" +
            "\t\t\tIF (COUNT = 2, ( (SUM(videoOne) + SUM(videoTwo))/(2 * COUNT(0)) ), -- count eq 2\n" +
            "\t\t\t\tIF ( COUNT = 3,  ( (SUM(videoOne) + SUM(videoTwo) + SUM(videoThree) )/(3 * COUNT(0)) ),\n" +
            "\t\t\t\tIF (COUNT = 4, ( (SUM(videoOne)+SUM(videoTwo)+SUM(videoThree)+SUM(videoFour))/(4*COUNT(0))),\n" +
            "\t\t\t\tIF (COUNT = 5, ( (SUM(videoOne)+SUM(videoTwo)+SUM(videoThree)+SUM(videoFour)+SUM(videoFive))/(5*COUNT(0))),\n" +
            "\t\t\t\tIF (COUNT = 6, ( (SUM(videoOne)+SUM(videoTwo)+SUM(videoThree)+SUM(videoFour)+SUM(videoFive)+SUM(videoSix))/(6*COUNT(0))),\n" +
            "\t\t\t\tIF ( COUNT = 7, ( (SUM(videoOne)+SUM(videoTwo)+SUM(videoThree)+SUM(videoFour)+SUM(videoFive)+SUM(videoSix)+SUM(videoSeven))/(7*COUNT(0))),\n" +
            "\t\t\t\tIF (COUNT = 8,( (SUM(videoOne)+SUM(videoTwo)+SUM(videoThree)+SUM(videoFour)+SUM(videoFive)+SUM(videoSix)+SUM(videoSeven)+SUM(videoEight))/(8*COUNT(0))),\n" +
            "\t\t\t\tIF (COUNT = 9, ( (SUM(videoOne)+SUM(videoTwo)+SUM(videoThree)+SUM(videoFour)+SUM(videoFive)+SUM(videoSix)+SUM(videoSeven)+SUM(videoEight)+SUM(videoNine))/(9*COUNT(0))),\n" +
            "\t\t\t\tIF (COUNT = 10, ( (SUM(videoOne)+SUM(videoTwo)+SUM(videoThree)+SUM(videoFour)+SUM(videoFive)+SUM(videoSix)+SUM(videoSeven)+SUM(videoEight)+SUM(videoNine)+SUM(videoTen))/(10*COUNT(0))),\n" +
            "\t\t\t\tIF (COUNT = 11, ( (SUM(videoOne)+SUM(videoTwo)+SUM(videoThree)+SUM(videoFour)+SUM(videoFive)+SUM(videoSix)+SUM(videoSeven)+SUM(videoEight)+SUM(videoNine)+SUM(videoTen)+SUM(videoEleven))/(11*COUNT(0))),\n" +
            "\t\t\t\tIF (COUNT = 12, ( (SUM(videoOne)+SUM(videoTwo)+SUM(videoThree)+SUM(videoFour)+SUM(videoFive)+SUM(videoSix)+SUM(videoSeven)+SUM(videoEight)+SUM(videoNine)+SUM(videoTen)+SUM(videoEleven)+SUM(videoTwelve))/(12*COUNT(0))),\n" +
            "\t\t\t\tIF (COUNT = 13, ( (SUM(videoOne)+SUM(videoTwo)+SUM(videoThree)+SUM(videoFour)+SUM(videoFive)+SUM(videoSix)+SUM(videoSeven)+SUM(videoEight)+SUM(videoNine)+SUM(videoTen)+SUM(videoEleven)+SUM(videoTwelve)+SUM(videoThirteen))/(13*COUNT(0))),\n" +
            "\t\t\t\tIF (COUNT = 14, ( (SUM(videoOne)+SUM(videoTwo)+SUM(videoThree)+SUM(videoFour)+SUM(videoFive)+SUM(videoSix)+SUM(videoSeven)+SUM(videoEight)+SUM(videoNine)+SUM(videoTen)+SUM(videoEleven)+SUM(videoTwelve)+SUM(videoThirteen)+SUM(videoFourteen))/(14*COUNT(0))),\n" +
            "\t\t\t\tIF (COUNT = 15, ( (SUM(videoOne)+SUM(videoTwo)+SUM(videoThree)+SUM(videoFour)+SUM(videoFive)+SUM(videoSix)+SUM(videoSeven)+SUM(videoEight)+SUM(videoNine)+SUM(videoTen)+SUM(videoEleven)+SUM(videoTwelve)+SUM(videoThirteen)+SUM(videoFourteen)+SUM(videoFifteen))/(15*COUNT(0))),\n" +
            "\t\t\t\tIF (COUNT = 16, ( (SUM(videoOne)+SUM(videoTwo)+SUM(videoThree)+SUM(videoFour)+SUM(videoFive)+SUM(videoSix)+SUM(videoSeven)+SUM(videoEight)+SUM(videoNine)+SUM(videoTen)+SUM(videoEleven)+SUM(videoTwelve)+SUM(videoThirteen)+SUM(videoFourteen)+SUM(videoFifteen)+SUM(videoSixteen))/(16*COUNT(0))),\n" +
            "\t\t\t\tIF (COUNT = 17, ( (SUM(videoOne)+SUM(videoTwo)+SUM(videoThree)+SUM(videoFour)+SUM(videoFive)+SUM(videoSix)+SUM(videoSeven)+SUM(videoEight)+SUM(videoNine)+SUM(videoTen)+SUM(videoEleven)+SUM(videoTwelve)+SUM(videoThirteen)+SUM(videoFourteen)+SUM(videoFifteen)+SUM(videoSixteen)+SUM(videoSeventeen))/(17*COUNT(0))),\n" +
            "\t\t\t\tIF (COUNT = 18, ( (SUM(videoOne)+SUM(videoTwo)+SUM(videoThree)+SUM(videoFour)+SUM(videoFive)+SUM(videoSix)+SUM(videoSeven)+SUM(videoEight)+SUM(videoNine)+SUM(videoTen)+SUM(videoEleven)+SUM(videoTwelve)+SUM(videoThirteen)+SUM(videoFourteen)+SUM(videoFifteen)+SUM(videoSixteen)+SUM(videoSeventeen)+SUM(videoEighteen))/(18*COUNT(0))),\n" +
            "\t\t\t\tIF (COUNT = 19, ( (SUM(videoOne)+SUM(videoTwo)+SUM(videoThree)+SUM(videoFour)+SUM(videoFive)+SUM(videoSix)+SUM(videoSeven)+SUM(videoEight)+SUM(videoNine)+SUM(videoTen)+SUM(videoEleven)+SUM(videoTwelve)+SUM(videoThirteen)+SUM(videoFourteen)+SUM(videoFifteen)+SUM(videoSixteen)+SUM(videoSeventeen)+SUM(videoEighteen)+SUM(videoNineteen))/(19*COUNT(0))),\n" +
            "\t\t\t\tIF (COUNT = 20, ( (SUM(videoOne)+SUM(videoTwo)+SUM(videoThree)+SUM(videoFour)+SUM(videoFive)+SUM(videoSix)+SUM(videoSeven)+SUM(videoEight)+SUM(videoNine)+SUM(videoTen)+SUM(videoEleven)+SUM(videoTwelve)+SUM(videoThirteen)+SUM(videoFourteen)+SUM(videoFifteen)+SUM(videoSixteen)+SUM(videoSeventeen)+SUM(videoEighteen)+SUM(videoNineteen)+SUM(videoTwenty))/(20*COUNT(0))),\n" +
            "\t\t\t\t\"\"))))))))))))))))))) )*100,0),\"%\") videoRatio," +
            "CONCAT(TRUNCATE(IF (COUNT = 1, SUM(noteOne)/COUNT(0) , -- count eq 1\n" +
            "\t\t\tIF (COUNT = 2, ( (SUM(noteOne) + SUM(noteTwo))/(2 * COUNT(0)) ), -- count eq 2\n" +
            "\t\t\t\tIF ( COUNT = 3,  ( (SUM(noteOne) + SUM(noteTwo) + SUM(noteThree) )/(3 * COUNT(0)) ),\n" +
            "\t\t\t\tIF (COUNT = 4, ( (SUM(noteOne)+SUM(noteTwo)+SUM(noteThree)+SUM(noteFour))/(4*COUNT(0))),\n" +
            "\t\t\t\tIF (COUNT = 5, ( (SUM(noteOne)+SUM(noteTwo)+SUM(noteThree)+SUM(noteFour)+SUM(noteFive))/(5*COUNT(0))),\n" +
            "\t\t\t\tIF (COUNT = 6, ( (SUM(noteOne)+SUM(noteTwo)+SUM(noteThree)+SUM(noteFour)+SUM(noteFive)+SUM(noteSix))/(6*COUNT(0))),\n" +
            "\t\t\t\tIF ( COUNT = 7, ( (SUM(noteOne)+SUM(noteTwo)+SUM(noteThree)+SUM(noteFour)+SUM(noteFive)+SUM(noteSix)+SUM(noteSeven))/(7*COUNT(0))),\n" +
            "\t\t\t\tIF (COUNT = 8,( (SUM(noteOne)+SUM(noteTwo)+SUM(noteThree)+SUM(noteFour)+SUM(noteFive)+SUM(noteSix)+SUM(noteSeven)+SUM(noteEight))/(8*COUNT(0))),\n" +
            "\t\t\t\tIF (COUNT = 9, ( (SUM(noteOne)+SUM(noteTwo)+SUM(noteThree)+SUM(noteFour)+SUM(noteFive)+SUM(noteSix)+SUM(noteSeven)+SUM(noteEight)+SUM(noteNine))/(9*COUNT(0))),\n" +
            "\t\t\t\tIF (COUNT = 10, ( (SUM(noteOne)+SUM(noteTwo)+SUM(noteThree)+SUM(noteFour)+SUM(noteFive)+SUM(noteSix)+SUM(noteSeven)+SUM(noteEight)+SUM(noteNine)+SUM(noteTen))/(10*COUNT(0))),\n" +
            "\t\t\t\tIF (COUNT = 11, ( (SUM(noteOne)+SUM(noteTwo)+SUM(noteThree)+SUM(noteFour)+SUM(noteFive)+SUM(noteSix)+SUM(noteSeven)+SUM(noteEight)+SUM(noteNine)+SUM(noteTen)+SUM(noteEleven))/(11*COUNT(0))),\n" +
            "\t\t\t\tIF (COUNT = 12, ( (SUM(noteOne)+SUM(noteTwo)+SUM(noteThree)+SUM(noteFour)+SUM(noteFive)+SUM(noteSix)+SUM(noteSeven)+SUM(noteEight)+SUM(noteNine)+SUM(noteTen)+SUM(noteEleven)+SUM(noteTwelve))/(12*COUNT(0))),\n" +
            "\t\t\t\tIF (COUNT = 13, ( (SUM(noteOne)+SUM(noteTwo)+SUM(noteThree)+SUM(noteFour)+SUM(noteFive)+SUM(noteSix)+SUM(noteSeven)+SUM(noteEight)+SUM(noteNine)+SUM(noteTen)+SUM(noteEleven)+SUM(noteTwelve)+SUM(noteThirteen))/(13*COUNT(0))),\n" +
            "\t\t\t\tIF (COUNT = 14, ( (SUM(noteOne)+SUM(noteTwo)+SUM(noteThree)+SUM(noteFour)+SUM(noteFive)+SUM(noteSix)+SUM(noteSeven)+SUM(noteEight)+SUM(noteNine)+SUM(noteTen)+SUM(noteEleven)+SUM(noteTwelve)+SUM(noteThirteen)+SUM(noteFourteen))/(14*COUNT(0))),\n" +
            "\t\t\t\tIF (COUNT = 15, ( (SUM(noteOne)+SUM(noteTwo)+SUM(noteThree)+SUM(noteFour)+SUM(noteFive)+SUM(noteSix)+SUM(noteSeven)+SUM(noteEight)+SUM(noteNine)+SUM(noteTen)+SUM(noteEleven)+SUM(noteTwelve)+SUM(noteThirteen)+SUM(noteFourteen)+SUM(noteFifteen))/(15*COUNT(0))),\n" +
            "\t\t\t\tIF (COUNT = 16, ( (SUM(noteOne)+SUM(noteTwo)+SUM(noteThree)+SUM(noteFour)+SUM(noteFive)+SUM(noteSix)+SUM(noteSeven)+SUM(noteEight)+SUM(noteNine)+SUM(noteTen)+SUM(noteEleven)+SUM(noteTwelve)+SUM(noteThirteen)+SUM(noteFourteen)+SUM(noteFifteen)+SUM(noteSixteen))/(16*COUNT(0))),\n" +
            "\t\t\t\tIF (COUNT = 17, ( (SUM(noteOne)+SUM(noteTwo)+SUM(noteThree)+SUM(noteFour)+SUM(noteFive)+SUM(noteSix)+SUM(noteSeven)+SUM(noteEight)+SUM(noteNine)+SUM(noteTen)+SUM(noteEleven)+SUM(noteTwelve)+SUM(noteThirteen)+SUM(noteFourteen)+SUM(noteFifteen)+SUM(noteSixteen)+SUM(noteSeventeen))/(17*COUNT(0))),\n" +
            "\t\t\t\tIF (COUNT = 18, ( (SUM(noteOne)+SUM(noteTwo)+SUM(noteThree)+SUM(noteFour)+SUM(noteFive)+SUM(noteSix)+SUM(noteSeven)+SUM(noteEight)+SUM(noteNine)+SUM(noteTen)+SUM(noteEleven)+SUM(noteTwelve)+SUM(noteThirteen)+SUM(noteFourteen)+SUM(noteFifteen)+SUM(noteSixteen)+SUM(noteSeventeen)+SUM(noteEighteen))/(18*COUNT(0))),\n" +
            "\t\t\t\tIF (COUNT = 19, ( (SUM(noteOne)+SUM(noteTwo)+SUM(noteThree)+SUM(noteFour)+SUM(noteFive)+SUM(noteSix)+SUM(noteSeven)+SUM(noteEight)+SUM(noteNine)+SUM(noteTen)+SUM(noteEleven)+SUM(noteTwelve)+SUM(noteThirteen)+SUM(noteFourteen)+SUM(noteFifteen)+SUM(noteSixteen)+SUM(noteSeventeen)+SUM(noteEighteen)+SUM(noteNineteen))/(19*COUNT(0))),\n" +
            "\t\t\t\tIF (COUNT = 20, ( (SUM(noteOne)+SUM(noteTwo)+SUM(noteThree)+SUM(noteFour)+SUM(noteFive)+SUM(noteSix)+SUM(noteSeven)+SUM(noteEight)+SUM(noteNine)+SUM(noteTen)+SUM(noteEleven)+SUM(noteTwelve)+SUM(noteThirteen)+SUM(noteFourteen)+SUM(noteFifteen)+SUM(noteSixteen)+SUM(noteSeventeen)+SUM(noteEighteen)+SUM(noteNineteen)+SUM(noteTwenty))/(20*COUNT(0))),\n" +
            "\t\t\t\t\"\"))))))))))))))))))) )*100,0),\"%\") noteRatio," +
            "CONCAT(TRUNCATE(IF (COUNT = 1, SUM(knowledgeMasterOne)/COUNT(0) , -- count eq 1\n" +
            "\t\t\tIF (COUNT = 2, ( (SUM(knowledgeMasterOne) + SUM(knowledgeMasterTwo))/(2 * COUNT(0)) ), -- count eq 2\n" +
            "\t\t\t\tIF ( COUNT = 3,  ( (SUM(knowledgeMasterOne) + SUM(knowledgeMasterTwo) + SUM(knowledgeMasterThree) )/(3 * COUNT(0)) ),\n" +
            "\t\t\t\tIF (COUNT = 4, ( (SUM(knowledgeMasterOne)+SUM(knowledgeMasterTwo)+SUM(knowledgeMasterThree)+SUM(knowledgeMasterFour))/(4*COUNT(0))),\n" +
            "\t\t\t\tIF (COUNT = 5, ( (SUM(knowledgeMasterOne)+SUM(knowledgeMasterTwo)+SUM(knowledgeMasterThree)+SUM(knowledgeMasterFour)+SUM(knowledgeMasterFive))/(5*COUNT(0))),\n" +
            "\t\t\t\tIF (COUNT = 6, ( (SUM(knowledgeMasterOne)+SUM(knowledgeMasterTwo)+SUM(knowledgeMasterThree)+SUM(knowledgeMasterFour)+SUM(knowledgeMasterFive)+SUM(knowledgeMasterSix))/(6*COUNT(0))),\n" +
            "\t\t\t\tIF ( COUNT = 7, ( (SUM(knowledgeMasterOne)+SUM(knowledgeMasterTwo)+SUM(knowledgeMasterThree)+SUM(knowledgeMasterFour)+SUM(knowledgeMasterFive)+SUM(knowledgeMasterSix)+SUM(knowledgeMasterSeven))/(7*COUNT(0))),\n" +
            "\t\t\t\tIF (COUNT = 8,( (SUM(knowledgeMasterOne)+SUM(knowledgeMasterTwo)+SUM(knowledgeMasterThree)+SUM(knowledgeMasterFour)+SUM(knowledgeMasterFive)+SUM(knowledgeMasterSix)+SUM(knowledgeMasterSeven)+SUM(knowledgeMasterEight))/(8*COUNT(0))),\n" +
            "\t\t\t\tIF (COUNT = 9, ( (SUM(knowledgeMasterOne)+SUM(knowledgeMasterTwo)+SUM(knowledgeMasterThree)+SUM(knowledgeMasterFour)+SUM(knowledgeMasterFive)+SUM(knowledgeMasterSix)+SUM(knowledgeMasterSeven)+SUM(knowledgeMasterEight)+SUM(knowledgeMasterNine))/(9*COUNT(0))),\n" +
            "\t\t\t\tIF (COUNT = 10, ( (SUM(knowledgeMasterOne)+SUM(knowledgeMasterTwo)+SUM(knowledgeMasterThree)+SUM(knowledgeMasterFour)+SUM(knowledgeMasterFive)+SUM(knowledgeMasterSix)+SUM(knowledgeMasterSeven)+SUM(knowledgeMasterEight)+SUM(knowledgeMasterNine)+SUM(knowledgeMasterTen))/(10*COUNT(0))),\n" +
            "\t\t\t\tIF (COUNT = 11, ( (SUM(knowledgeMasterOne)+SUM(knowledgeMasterTwo)+SUM(knowledgeMasterThree)+SUM(knowledgeMasterFour)+SUM(knowledgeMasterFive)+SUM(knowledgeMasterSix)+SUM(knowledgeMasterSeven)+SUM(knowledgeMasterEight)+SUM(knowledgeMasterNine)+SUM(knowledgeMasterTen)+SUM(knowledgeMasterEleven))/(11*COUNT(0))),\n" +
            "\t\t\t\tIF (COUNT = 12, ( (SUM(knowledgeMasterOne)+SUM(knowledgeMasterTwo)+SUM(knowledgeMasterThree)+SUM(knowledgeMasterFour)+SUM(knowledgeMasterFive)+SUM(knowledgeMasterSix)+SUM(knowledgeMasterSeven)+SUM(knowledgeMasterEight)+SUM(knowledgeMasterNine)+SUM(knowledgeMasterTen)+SUM(knowledgeMasterEleven)+SUM(knowledgeMasterTwelve))/(12*COUNT(0))),\n" +
            "\t\t\t\tIF (COUNT = 13, ( (SUM(knowledgeMasterOne)+SUM(knowledgeMasterTwo)+SUM(knowledgeMasterThree)+SUM(knowledgeMasterFour)+SUM(knowledgeMasterFive)+SUM(knowledgeMasterSix)+SUM(knowledgeMasterSeven)+SUM(knowledgeMasterEight)+SUM(knowledgeMasterNine)+SUM(knowledgeMasterTen)+SUM(knowledgeMasterEleven)+SUM(knowledgeMasterTwelve)+SUM(knowledgeMasterThirteen))/(13*COUNT(0))),\n" +
            "\t\t\t\tIF (COUNT = 14, ( (SUM(knowledgeMasterOne)+SUM(knowledgeMasterTwo)+SUM(knowledgeMasterThree)+SUM(knowledgeMasterFour)+SUM(knowledgeMasterFive)+SUM(knowledgeMasterSix)+SUM(knowledgeMasterSeven)+SUM(knowledgeMasterEight)+SUM(knowledgeMasterNine)+SUM(knowledgeMasterTen)+SUM(knowledgeMasterEleven)+SUM(knowledgeMasterTwelve)+SUM(knowledgeMasterThirteen)+SUM(knowledgeMasterFourteen))/(14*COUNT(0))),\n" +
            "\t\t\t\tIF (COUNT = 15, ( (SUM(knowledgeMasterOne)+SUM(knowledgeMasterTwo)+SUM(knowledgeMasterThree)+SUM(knowledgeMasterFour)+SUM(knowledgeMasterFive)+SUM(knowledgeMasterSix)+SUM(knowledgeMasterSeven)+SUM(knowledgeMasterEight)+SUM(knowledgeMasterNine)+SUM(knowledgeMasterTen)+SUM(knowledgeMasterEleven)+SUM(knowledgeMasterTwelve)+SUM(knowledgeMasterThirteen)+SUM(knowledgeMasterFourteen)+SUM(knowledgeMasterFifteen))/(15*COUNT(0))),\n" +
            "\t\t\t\tIF (COUNT = 16, ( (SUM(knowledgeMasterOne)+SUM(knowledgeMasterTwo)+SUM(knowledgeMasterThree)+SUM(knowledgeMasterFour)+SUM(knowledgeMasterFive)+SUM(knowledgeMasterSix)+SUM(knowledgeMasterSeven)+SUM(knowledgeMasterEight)+SUM(knowledgeMasterNine)+SUM(knowledgeMasterTen)+SUM(knowledgeMasterEleven)+SUM(knowledgeMasterTwelve)+SUM(knowledgeMasterThirteen)+SUM(knowledgeMasterFourteen)+SUM(knowledgeMasterFifteen)+SUM(knowledgeMasterSixteen))/(16*COUNT(0))),\n" +
            "\t\t\t\tIF (COUNT = 17, ( (SUM(knowledgeMasterOne)+SUM(knowledgeMasterTwo)+SUM(knowledgeMasterThree)+SUM(knowledgeMasterFour)+SUM(knowledgeMasterFive)+SUM(knowledgeMasterSix)+SUM(knowledgeMasterSeven)+SUM(knowledgeMasterEight)+SUM(knowledgeMasterNine)+SUM(knowledgeMasterTen)+SUM(knowledgeMasterEleven)+SUM(knowledgeMasterTwelve)+SUM(knowledgeMasterThirteen)+SUM(knowledgeMasterFourteen)+SUM(knowledgeMasterFifteen)+SUM(knowledgeMasterSixteen)+SUM(knowledgeMasterSeventeen))/(17*COUNT(0))),\n" +
            "\t\t\t\tIF (COUNT = 18, ( (SUM(knowledgeMasterOne)+SUM(knowledgeMasterTwo)+SUM(knowledgeMasterThree)+SUM(knowledgeMasterFour)+SUM(knowledgeMasterFive)+SUM(knowledgeMasterSix)+SUM(knowledgeMasterSeven)+SUM(knowledgeMasterEight)+SUM(knowledgeMasterNine)+SUM(knowledgeMasterTen)+SUM(knowledgeMasterEleven)+SUM(knowledgeMasterTwelve)+SUM(knowledgeMasterThirteen)+SUM(knowledgeMasterFourteen)+SUM(knowledgeMasterFifteen)+SUM(knowledgeMasterSixteen)+SUM(knowledgeMasterSeventeen)+SUM(knowledgeMasterEighteen))/(18*COUNT(0))),\n" +
            "\t\t\t\tIF (COUNT = 19, ( (SUM(knowledgeMasterOne)+SUM(knowledgeMasterTwo)+SUM(knowledgeMasterThree)+SUM(knowledgeMasterFour)+SUM(knowledgeMasterFive)+SUM(knowledgeMasterSix)+SUM(knowledgeMasterSeven)+SUM(knowledgeMasterEight)+SUM(knowledgeMasterNine)+SUM(knowledgeMasterTen)+SUM(knowledgeMasterEleven)+SUM(knowledgeMasterTwelve)+SUM(knowledgeMasterThirteen)+SUM(knowledgeMasterFourteen)+SUM(knowledgeMasterFifteen)+SUM(knowledgeMasterSixteen)+SUM(knowledgeMasterSeventeen)+SUM(knowledgeMasterEighteen)+SUM(knowledgeMasterNineteen))/(19*COUNT(0))),\n" +
            "\t\t\t\tIF (COUNT = 20, ( (SUM(knowledgeMasterOne)+SUM(knowledgeMasterTwo)+SUM(knowledgeMasterThree)+SUM(knowledgeMasterFour)+SUM(knowledgeMasterFive)+SUM(knowledgeMasterSix)+SUM(knowledgeMasterSeven)+SUM(knowledgeMasterEight)+SUM(knowledgeMasterNine)+SUM(knowledgeMasterTen)+SUM(knowledgeMasterEleven)+SUM(knowledgeMasterTwelve)+SUM(knowledgeMasterThirteen)+SUM(knowledgeMasterFourteen)+SUM(knowledgeMasterFifteen)+SUM(knowledgeMasterSixteen)+SUM(knowledgeMasterSeventeen)+SUM(knowledgeMasterEighteen)+SUM(knowledgeMasterNineteen)+SUM(knowledgeMasterTwenty))/(20*COUNT(0))),\n" +
            "\t\t\t\t\"\"))))))))))))))))))) )*100,0),\"%\") knowledgeMasterRatio," +
            "\tCONCAT(TRUNCATE(SUM(oneToOne)/COUNT(*)*100,0),\"%\") oneToOneSum,\n" +
            "\tCONCAT(TRUNCATE(SUM(isContinue)/COUNT(*)*100,0),\"%\") isContinueRatio\n" +
            "FROM \n" +
            "\tdetails \n" +
            "GROUP BY \n" +
            "\tproject;")
    @Results(id = "highSchoolMap",
            value = {
                    @Result(column = "project", property = "project"),
                    @Result(column = "workRatio", property = "workRatio"),
                    @Result(column = "videoRatio", property = "videoRatio"),
                    @Result(column = "noteRatio", property = "noteRatio"),
                    @Result(column = "oneToOneSum", property = "oneToOneRatio"),
                    @Result(column = "isContinueRatio", property = "isContinueRatio"),
                    @Result(column = "total", property = "total"),
                    @Result(column = "weChat", property = "weChat"),
                    @Result(column = "zhangYou", property = "zhangYou"),
                    @Result(column = "shoppingCart", property = "shoppingCart")
            })
    List<HighSchool> findHighSchool();

    @Select("SELECT \n" +
            "\tCOUNT(*) total,\n" +
            "\tCONCAT(TRUNCATE(SUM(weChat)/COUNT(*)*100,0),\"%\") weChat,\n" +
            "\tCONCAT(TRUNCATE(SUM(zhangYou)/COUNT(*)*100,0),\"%\") zhangYou,\n" +
            "\tCONCAT(TRUNCATE(SUM(shoppingCart)/COUNT(*)*100,0),\"%\") shoppingCart,\n" +
            "CONCAT(TRUNCATE(IF (COUNT = 1, SUM(videoOne)/COUNT(0) , -- count eq 1\n" +
            "\t\t\tIF (COUNT = 2, ( (SUM(videoOne) + SUM(videoTwo))/(2 * COUNT(0)) ), -- count eq 2\n" +
            "\t\t\t\tIF ( COUNT = 3,  ( (SUM(videoOne) + SUM(videoTwo) + SUM(videoThree) )/(3 * COUNT(0)) ),\n" +
            "\t\t\t\tIF (COUNT = 4, ( (SUM(videoOne)+SUM(videoTwo)+SUM(videoThree)+SUM(videoFour))/(4*COUNT(0))),\n" +
            "\t\t\t\tIF (COUNT = 5, ( (SUM(videoOne)+SUM(videoTwo)+SUM(videoThree)+SUM(videoFour)+SUM(videoFive))/(5*COUNT(0))),\n" +
            "\t\t\t\tIF (COUNT = 6, ( (SUM(videoOne)+SUM(videoTwo)+SUM(videoThree)+SUM(videoFour)+SUM(videoFive)+SUM(videoSix))/(6*COUNT(0))),\n" +
            "\t\t\t\tIF ( COUNT = 7, ( (SUM(videoOne)+SUM(videoTwo)+SUM(videoThree)+SUM(videoFour)+SUM(videoFive)+SUM(videoSix)+SUM(videoSeven))/(7*COUNT(0))),\n" +
            "\t\t\t\tIF (COUNT = 8,( (SUM(videoOne)+SUM(videoTwo)+SUM(videoThree)+SUM(videoFour)+SUM(videoFive)+SUM(videoSix)+SUM(videoSeven)+SUM(videoEight))/(8*COUNT(0))),\n" +
            "\t\t\t\tIF (COUNT = 9, ( (SUM(videoOne)+SUM(videoTwo)+SUM(videoThree)+SUM(videoFour)+SUM(videoFive)+SUM(videoSix)+SUM(videoSeven)+SUM(videoEight)+SUM(videoNine))/(9*COUNT(0))),\n" +
            "\t\t\t\tIF (COUNT = 10, ( (SUM(videoOne)+SUM(videoTwo)+SUM(videoThree)+SUM(videoFour)+SUM(videoFive)+SUM(videoSix)+SUM(videoSeven)+SUM(videoEight)+SUM(videoNine)+SUM(videoTen))/(10*COUNT(0))),\n" +
            "\t\t\t\tIF (COUNT = 11, ( (SUM(videoOne)+SUM(videoTwo)+SUM(videoThree)+SUM(videoFour)+SUM(videoFive)+SUM(videoSix)+SUM(videoSeven)+SUM(videoEight)+SUM(videoNine)+SUM(videoTen)+SUM(videoEleven))/(11*COUNT(0))),\n" +
            "\t\t\t\tIF (COUNT = 12, ( (SUM(videoOne)+SUM(videoTwo)+SUM(videoThree)+SUM(videoFour)+SUM(videoFive)+SUM(videoSix)+SUM(videoSeven)+SUM(videoEight)+SUM(videoNine)+SUM(videoTen)+SUM(videoEleven)+SUM(videoTwelve))/(12*COUNT(0))),\n" +
            "\t\t\t\tIF (COUNT = 13, ( (SUM(videoOne)+SUM(videoTwo)+SUM(videoThree)+SUM(videoFour)+SUM(videoFive)+SUM(videoSix)+SUM(videoSeven)+SUM(videoEight)+SUM(videoNine)+SUM(videoTen)+SUM(videoEleven)+SUM(videoTwelve)+SUM(videoThirteen))/(13*COUNT(0))),\n" +
            "\t\t\t\tIF (COUNT = 14, ( (SUM(videoOne)+SUM(videoTwo)+SUM(videoThree)+SUM(videoFour)+SUM(videoFive)+SUM(videoSix)+SUM(videoSeven)+SUM(videoEight)+SUM(videoNine)+SUM(videoTen)+SUM(videoEleven)+SUM(videoTwelve)+SUM(videoThirteen)+SUM(videoFourteen))/(14*COUNT(0))),\n" +
            "\t\t\t\tIF (COUNT = 15, ( (SUM(videoOne)+SUM(videoTwo)+SUM(videoThree)+SUM(videoFour)+SUM(videoFive)+SUM(videoSix)+SUM(videoSeven)+SUM(videoEight)+SUM(videoNine)+SUM(videoTen)+SUM(videoEleven)+SUM(videoTwelve)+SUM(videoThirteen)+SUM(videoFourteen)+SUM(videoFifteen))/(15*COUNT(0))),\n" +
            "\t\t\t\tIF (COUNT = 16, ( (SUM(videoOne)+SUM(videoTwo)+SUM(videoThree)+SUM(videoFour)+SUM(videoFive)+SUM(videoSix)+SUM(videoSeven)+SUM(videoEight)+SUM(videoNine)+SUM(videoTen)+SUM(videoEleven)+SUM(videoTwelve)+SUM(videoThirteen)+SUM(videoFourteen)+SUM(videoFifteen)+SUM(videoSixteen))/(16*COUNT(0))),\n" +
            "\t\t\t\tIF (COUNT = 17, ( (SUM(videoOne)+SUM(videoTwo)+SUM(videoThree)+SUM(videoFour)+SUM(videoFive)+SUM(videoSix)+SUM(videoSeven)+SUM(videoEight)+SUM(videoNine)+SUM(videoTen)+SUM(videoEleven)+SUM(videoTwelve)+SUM(videoThirteen)+SUM(videoFourteen)+SUM(videoFifteen)+SUM(videoSixteen)+SUM(videoSeventeen))/(17*COUNT(0))),\n" +
            "\t\t\t\tIF (COUNT = 18, ( (SUM(videoOne)+SUM(videoTwo)+SUM(videoThree)+SUM(videoFour)+SUM(videoFive)+SUM(videoSix)+SUM(videoSeven)+SUM(videoEight)+SUM(videoNine)+SUM(videoTen)+SUM(videoEleven)+SUM(videoTwelve)+SUM(videoThirteen)+SUM(videoFourteen)+SUM(videoFifteen)+SUM(videoSixteen)+SUM(videoSeventeen)+SUM(videoEighteen))/(18*COUNT(0))),\n" +
            "\t\t\t\tIF (COUNT = 19, ( (SUM(videoOne)+SUM(videoTwo)+SUM(videoThree)+SUM(videoFour)+SUM(videoFive)+SUM(videoSix)+SUM(videoSeven)+SUM(videoEight)+SUM(videoNine)+SUM(videoTen)+SUM(videoEleven)+SUM(videoTwelve)+SUM(videoThirteen)+SUM(videoFourteen)+SUM(videoFifteen)+SUM(videoSixteen)+SUM(videoSeventeen)+SUM(videoEighteen)+SUM(videoNineteen))/(19*COUNT(0))),\n" +
            "\t\t\t\tIF (COUNT = 20, ( (SUM(videoOne)+SUM(videoTwo)+SUM(videoThree)+SUM(videoFour)+SUM(videoFive)+SUM(videoSix)+SUM(videoSeven)+SUM(videoEight)+SUM(videoNine)+SUM(videoTen)+SUM(videoEleven)+SUM(videoTwelve)+SUM(videoThirteen)+SUM(videoFourteen)+SUM(videoFifteen)+SUM(videoSixteen)+SUM(videoSeventeen)+SUM(videoEighteen)+SUM(videoNineteen)+SUM(videoTwenty))/(20*COUNT(0))),\n" +
            "\t\t\t\t\"\"))))))))))))))))))) )*100,0),\"%\") videoRatio," +
            "CONCAT(TRUNCATE(IF (COUNT = 1, SUM(noteOne)/COUNT(0) , -- count eq 1\n" +
            "\t\t\tIF (COUNT = 2, ( (SUM(noteOne) + SUM(noteTwo))/(2 * COUNT(0)) ), -- count eq 2\n" +
            "\t\t\t\tIF ( COUNT = 3,  ( (SUM(noteOne) + SUM(noteTwo) + SUM(noteThree) )/(3 * COUNT(0)) ),\n" +
            "\t\t\t\tIF (COUNT = 4, ( (SUM(noteOne)+SUM(noteTwo)+SUM(noteThree)+SUM(noteFour))/(4*COUNT(0))),\n" +
            "\t\t\t\tIF (COUNT = 5, ( (SUM(noteOne)+SUM(noteTwo)+SUM(noteThree)+SUM(noteFour)+SUM(noteFive))/(5*COUNT(0))),\n" +
            "\t\t\t\tIF (COUNT = 6, ( (SUM(noteOne)+SUM(noteTwo)+SUM(noteThree)+SUM(noteFour)+SUM(noteFive)+SUM(noteSix))/(6*COUNT(0))),\n" +
            "\t\t\t\tIF ( COUNT = 7, ( (SUM(noteOne)+SUM(noteTwo)+SUM(noteThree)+SUM(noteFour)+SUM(noteFive)+SUM(noteSix)+SUM(noteSeven))/(7*COUNT(0))),\n" +
            "\t\t\t\tIF (COUNT = 8,( (SUM(noteOne)+SUM(noteTwo)+SUM(noteThree)+SUM(noteFour)+SUM(noteFive)+SUM(noteSix)+SUM(noteSeven)+SUM(noteEight))/(8*COUNT(0))),\n" +
            "\t\t\t\tIF (COUNT = 9, ( (SUM(noteOne)+SUM(noteTwo)+SUM(noteThree)+SUM(noteFour)+SUM(noteFive)+SUM(noteSix)+SUM(noteSeven)+SUM(noteEight)+SUM(noteNine))/(9*COUNT(0))),\n" +
            "\t\t\t\tIF (COUNT = 10, ( (SUM(noteOne)+SUM(noteTwo)+SUM(noteThree)+SUM(noteFour)+SUM(noteFive)+SUM(noteSix)+SUM(noteSeven)+SUM(noteEight)+SUM(noteNine)+SUM(noteTen))/(10*COUNT(0))),\n" +
            "\t\t\t\tIF (COUNT = 11, ( (SUM(noteOne)+SUM(noteTwo)+SUM(noteThree)+SUM(noteFour)+SUM(noteFive)+SUM(noteSix)+SUM(noteSeven)+SUM(noteEight)+SUM(noteNine)+SUM(noteTen)+SUM(noteEleven))/(11*COUNT(0))),\n" +
            "\t\t\t\tIF (COUNT = 12, ( (SUM(noteOne)+SUM(noteTwo)+SUM(noteThree)+SUM(noteFour)+SUM(noteFive)+SUM(noteSix)+SUM(noteSeven)+SUM(noteEight)+SUM(noteNine)+SUM(noteTen)+SUM(noteEleven)+SUM(noteTwelve))/(12*COUNT(0))),\n" +
            "\t\t\t\tIF (COUNT = 13, ( (SUM(noteOne)+SUM(noteTwo)+SUM(noteThree)+SUM(noteFour)+SUM(noteFive)+SUM(noteSix)+SUM(noteSeven)+SUM(noteEight)+SUM(noteNine)+SUM(noteTen)+SUM(noteEleven)+SUM(noteTwelve)+SUM(noteThirteen))/(13*COUNT(0))),\n" +
            "\t\t\t\tIF (COUNT = 14, ( (SUM(noteOne)+SUM(noteTwo)+SUM(noteThree)+SUM(noteFour)+SUM(noteFive)+SUM(noteSix)+SUM(noteSeven)+SUM(noteEight)+SUM(noteNine)+SUM(noteTen)+SUM(noteEleven)+SUM(noteTwelve)+SUM(noteThirteen)+SUM(noteFourteen))/(14*COUNT(0))),\n" +
            "\t\t\t\tIF (COUNT = 15, ( (SUM(noteOne)+SUM(noteTwo)+SUM(noteThree)+SUM(noteFour)+SUM(noteFive)+SUM(noteSix)+SUM(noteSeven)+SUM(noteEight)+SUM(noteNine)+SUM(noteTen)+SUM(noteEleven)+SUM(noteTwelve)+SUM(noteThirteen)+SUM(noteFourteen)+SUM(noteFifteen))/(15*COUNT(0))),\n" +
            "\t\t\t\tIF (COUNT = 16, ( (SUM(noteOne)+SUM(noteTwo)+SUM(noteThree)+SUM(noteFour)+SUM(noteFive)+SUM(noteSix)+SUM(noteSeven)+SUM(noteEight)+SUM(noteNine)+SUM(noteTen)+SUM(noteEleven)+SUM(noteTwelve)+SUM(noteThirteen)+SUM(noteFourteen)+SUM(noteFifteen)+SUM(noteSixteen))/(16*COUNT(0))),\n" +
            "\t\t\t\tIF (COUNT = 17, ( (SUM(noteOne)+SUM(noteTwo)+SUM(noteThree)+SUM(noteFour)+SUM(noteFive)+SUM(noteSix)+SUM(noteSeven)+SUM(noteEight)+SUM(noteNine)+SUM(noteTen)+SUM(noteEleven)+SUM(noteTwelve)+SUM(noteThirteen)+SUM(noteFourteen)+SUM(noteFifteen)+SUM(noteSixteen)+SUM(noteSeventeen))/(17*COUNT(0))),\n" +
            "\t\t\t\tIF (COUNT = 18, ( (SUM(noteOne)+SUM(noteTwo)+SUM(noteThree)+SUM(noteFour)+SUM(noteFive)+SUM(noteSix)+SUM(noteSeven)+SUM(noteEight)+SUM(noteNine)+SUM(noteTen)+SUM(noteEleven)+SUM(noteTwelve)+SUM(noteThirteen)+SUM(noteFourteen)+SUM(noteFifteen)+SUM(noteSixteen)+SUM(noteSeventeen)+SUM(noteEighteen))/(18*COUNT(0))),\n" +
            "\t\t\t\tIF (COUNT = 19, ( (SUM(noteOne)+SUM(noteTwo)+SUM(noteThree)+SUM(noteFour)+SUM(noteFive)+SUM(noteSix)+SUM(noteSeven)+SUM(noteEight)+SUM(noteNine)+SUM(noteTen)+SUM(noteEleven)+SUM(noteTwelve)+SUM(noteThirteen)+SUM(noteFourteen)+SUM(noteFifteen)+SUM(noteSixteen)+SUM(noteSeventeen)+SUM(noteEighteen)+SUM(noteNineteen))/(19*COUNT(0))),\n" +
            "\t\t\t\tIF (COUNT = 20, ( (SUM(noteOne)+SUM(noteTwo)+SUM(noteThree)+SUM(noteFour)+SUM(noteFive)+SUM(noteSix)+SUM(noteSeven)+SUM(noteEight)+SUM(noteNine)+SUM(noteTen)+SUM(noteEleven)+SUM(noteTwelve)+SUM(noteThirteen)+SUM(noteFourteen)+SUM(noteFifteen)+SUM(noteSixteen)+SUM(noteSeventeen)+SUM(noteEighteen)+SUM(noteNineteen)+SUM(noteTwenty))/(20*COUNT(0))),\n" +
            "\t\t\t\t\"\"))))))))))))))))))) )*100,0),\"%\") noteRatio," +
            "CONCAT(TRUNCATE(IF (COUNT = 1, SUM(workOne)/COUNT(0) , -- count eq 1\n" +
            "\t\t\tIF (COUNT = 2, ( (SUM(workOne) + SUM(workTwo))/(2 * COUNT(0)) ), -- count eq 2\n" +
            "\t\t\t\tIF ( COUNT = 3,  ( (SUM(workOne) + SUM(workTwo) + SUM(workThree) )/(3 * COUNT(0)) ),\n" +
            "\t\t\t\tIF (COUNT = 4, ( (SUM(workOne)+SUM(workTwo)+SUM(workThree)+SUM(workFour))/(4*COUNT(0))),\n" +
            "\t\t\t\tIF (COUNT = 5, ( (SUM(workOne)+SUM(workTwo)+SUM(workThree)+SUM(workFour)+SUM(workFive))/(5*COUNT(0))),\n" +
            "\t\t\t\tIF (COUNT = 6, ( (SUM(workOne)+SUM(workTwo)+SUM(workThree)+SUM(workFour)+SUM(workFive)+SUM(workSix))/(6*COUNT(0))),\n" +
            "\t\t\t\tIF ( COUNT = 7, ( (SUM(workOne)+SUM(workTwo)+SUM(workThree)+SUM(workFour)+SUM(workFive)+SUM(workSix)+SUM(workSeven))/(7*COUNT(0))),\n" +
            "\t\t\t\tIF (COUNT = 8,( (SUM(workOne)+SUM(workTwo)+SUM(workThree)+SUM(workFour)+SUM(workFive)+SUM(workSix)+SUM(workSeven)+SUM(workEight))/(8*COUNT(0))),\n" +
            "\t\t\t\tIF (COUNT = 9, ( (SUM(workOne)+SUM(workTwo)+SUM(workThree)+SUM(workFour)+SUM(workFive)+SUM(workSix)+SUM(workSeven)+SUM(workEight)+SUM(workNine))/(9*COUNT(0))),\n" +
            "\t\t\t\tIF (COUNT = 10, ( (SUM(workOne)+SUM(workTwo)+SUM(workThree)+SUM(workFour)+SUM(workFive)+SUM(workSix)+SUM(workSeven)+SUM(workEight)+SUM(workNine)+SUM(workTen))/(10*COUNT(0))),\n" +
            "\t\t\t\tIF (COUNT = 11, ( (SUM(workOne)+SUM(workTwo)+SUM(workThree)+SUM(workFour)+SUM(workFive)+SUM(workSix)+SUM(workSeven)+SUM(workEight)+SUM(workNine)+SUM(workTen)+SUM(workEleven))/(11*COUNT(0))),\n" +
            "\t\t\t\tIF (COUNT = 12, ( (SUM(workOne)+SUM(workTwo)+SUM(workThree)+SUM(workFour)+SUM(workFive)+SUM(workSix)+SUM(workSeven)+SUM(workEight)+SUM(workNine)+SUM(workTen)+SUM(workEleven)+SUM(workTwelve))/(12*COUNT(0))),\n" +
            "\t\t\t\tIF (COUNT = 13, ( (SUM(workOne)+SUM(workTwo)+SUM(workThree)+SUM(workFour)+SUM(workFive)+SUM(workSix)+SUM(workSeven)+SUM(workEight)+SUM(workNine)+SUM(workTen)+SUM(workEleven)+SUM(workTwelve)+SUM(workThirteen))/(13*COUNT(0))),\n" +
            "\t\t\t\tIF (COUNT = 14, ( (SUM(workOne)+SUM(workTwo)+SUM(workThree)+SUM(workFour)+SUM(workFive)+SUM(workSix)+SUM(workSeven)+SUM(workEight)+SUM(workNine)+SUM(workTen)+SUM(workEleven)+SUM(workTwelve)+SUM(workThirteen)+SUM(workFourteen))/(14*COUNT(0))),\n" +
            "\t\t\t\tIF (COUNT = 15, ( (SUM(workOne)+SUM(workTwo)+SUM(workThree)+SUM(workFour)+SUM(workFive)+SUM(workSix)+SUM(workSeven)+SUM(workEight)+SUM(workNine)+SUM(workTen)+SUM(workEleven)+SUM(workTwelve)+SUM(workThirteen)+SUM(workFourteen)+SUM(workFifteen))/(15*COUNT(0))),\n" +
            "\t\t\t\tIF (COUNT = 16, ( (SUM(workOne)+SUM(workTwo)+SUM(workThree)+SUM(workFour)+SUM(workFive)+SUM(workSix)+SUM(workSeven)+SUM(workEight)+SUM(workNine)+SUM(workTen)+SUM(workEleven)+SUM(workTwelve)+SUM(workThirteen)+SUM(workFourteen)+SUM(workFifteen)+SUM(workSixteen))/(16*COUNT(0))),\n" +
            "\t\t\t\tIF (COUNT = 17, ( (SUM(workOne)+SUM(workTwo)+SUM(workThree)+SUM(workFour)+SUM(workFive)+SUM(workSix)+SUM(workSeven)+SUM(workEight)+SUM(workNine)+SUM(workTen)+SUM(workEleven)+SUM(workTwelve)+SUM(workThirteen)+SUM(workFourteen)+SUM(workFifteen)+SUM(workSixteen)+SUM(workSeventeen))/(17*COUNT(0))),\n" +
            "\t\t\t\tIF (COUNT = 18, ( (SUM(workOne)+SUM(workTwo)+SUM(workThree)+SUM(workFour)+SUM(workFive)+SUM(workSix)+SUM(workSeven)+SUM(workEight)+SUM(workNine)+SUM(workTen)+SUM(workEleven)+SUM(workTwelve)+SUM(workThirteen)+SUM(workFourteen)+SUM(workFifteen)+SUM(workSixteen)+SUM(workSeventeen)+SUM(workEighteen))/(18*COUNT(0))),\n" +
            "\t\t\t\tIF (COUNT = 19, ( (SUM(workOne)+SUM(workTwo)+SUM(workThree)+SUM(workFour)+SUM(workFive)+SUM(workSix)+SUM(workSeven)+SUM(workEight)+SUM(workNine)+SUM(workTen)+SUM(workEleven)+SUM(workTwelve)+SUM(workThirteen)+SUM(workFourteen)+SUM(workFifteen)+SUM(workSixteen)+SUM(workSeventeen)+SUM(workEighteen)+SUM(workNineteen))/(19*COUNT(0))),\n" +
            "\t\t\t\tIF (COUNT = 20, ( (SUM(workOne)+SUM(workTwo)+SUM(workThree)+SUM(workFour)+SUM(workFive)+SUM(workSix)+SUM(workSeven)+SUM(workEight)+SUM(workNine)+SUM(workTen)+SUM(workEleven)+SUM(workTwelve)+SUM(workThirteen)+SUM(workFourteen)+SUM(workFifteen)+SUM(workSixteen)+SUM(workSeventeen)+SUM(workEighteen)+SUM(workNineteen)+SUM(workTwenty))/(20*COUNT(0))),\n" +
            "\t\t\t\t\"\"))))))))))))))))))) )*100,0),\"%\") workRatio," +
            "CONCAT(TRUNCATE(IF (COUNT = 1, SUM(knowledgeMasterOne)/COUNT(0) , -- count eq 1\n" +
            "\t\t\tIF (COUNT = 2, ( (SUM(knowledgeMasterOne) + SUM(knowledgeMasterTwo))/(2 * COUNT(0)) ), -- count eq 2\n" +
            "\t\t\t\tIF ( COUNT = 3,  ( (SUM(knowledgeMasterOne) + SUM(knowledgeMasterTwo) + SUM(knowledgeMasterThree) )/(3 * COUNT(0)) ),\n" +
            "\t\t\t\tIF (COUNT = 4, ( (SUM(knowledgeMasterOne)+SUM(knowledgeMasterTwo)+SUM(knowledgeMasterThree)+SUM(knowledgeMasterFour))/(4*COUNT(0))),\n" +
            "\t\t\t\tIF (COUNT = 5, ( (SUM(knowledgeMasterOne)+SUM(knowledgeMasterTwo)+SUM(knowledgeMasterThree)+SUM(knowledgeMasterFour)+SUM(knowledgeMasterFive))/(5*COUNT(0))),\n" +
            "\t\t\t\tIF (COUNT = 6, ( (SUM(knowledgeMasterOne)+SUM(knowledgeMasterTwo)+SUM(knowledgeMasterThree)+SUM(knowledgeMasterFour)+SUM(knowledgeMasterFive)+SUM(knowledgeMasterSix))/(6*COUNT(0))),\n" +
            "\t\t\t\tIF ( COUNT = 7, ( (SUM(knowledgeMasterOne)+SUM(knowledgeMasterTwo)+SUM(knowledgeMasterThree)+SUM(knowledgeMasterFour)+SUM(knowledgeMasterFive)+SUM(knowledgeMasterSix)+SUM(knowledgeMasterSeven))/(7*COUNT(0))),\n" +
            "\t\t\t\tIF (COUNT = 8,( (SUM(knowledgeMasterOne)+SUM(knowledgeMasterTwo)+SUM(knowledgeMasterThree)+SUM(knowledgeMasterFour)+SUM(knowledgeMasterFive)+SUM(knowledgeMasterSix)+SUM(knowledgeMasterSeven)+SUM(knowledgeMasterEight))/(8*COUNT(0))),\n" +
            "\t\t\t\tIF (COUNT = 9, ( (SUM(knowledgeMasterOne)+SUM(knowledgeMasterTwo)+SUM(knowledgeMasterThree)+SUM(knowledgeMasterFour)+SUM(knowledgeMasterFive)+SUM(knowledgeMasterSix)+SUM(knowledgeMasterSeven)+SUM(knowledgeMasterEight)+SUM(knowledgeMasterNine))/(9*COUNT(0))),\n" +
            "\t\t\t\tIF (COUNT = 10, ( (SUM(knowledgeMasterOne)+SUM(knowledgeMasterTwo)+SUM(knowledgeMasterThree)+SUM(knowledgeMasterFour)+SUM(knowledgeMasterFive)+SUM(knowledgeMasterSix)+SUM(knowledgeMasterSeven)+SUM(knowledgeMasterEight)+SUM(knowledgeMasterNine)+SUM(knowledgeMasterTen))/(10*COUNT(0))),\n" +
            "\t\t\t\tIF (COUNT = 11, ( (SUM(knowledgeMasterOne)+SUM(knowledgeMasterTwo)+SUM(knowledgeMasterThree)+SUM(knowledgeMasterFour)+SUM(knowledgeMasterFive)+SUM(knowledgeMasterSix)+SUM(knowledgeMasterSeven)+SUM(knowledgeMasterEight)+SUM(knowledgeMasterNine)+SUM(knowledgeMasterTen)+SUM(knowledgeMasterEleven))/(11*COUNT(0))),\n" +
            "\t\t\t\tIF (COUNT = 12, ( (SUM(knowledgeMasterOne)+SUM(knowledgeMasterTwo)+SUM(knowledgeMasterThree)+SUM(knowledgeMasterFour)+SUM(knowledgeMasterFive)+SUM(knowledgeMasterSix)+SUM(knowledgeMasterSeven)+SUM(knowledgeMasterEight)+SUM(knowledgeMasterNine)+SUM(knowledgeMasterTen)+SUM(knowledgeMasterEleven)+SUM(knowledgeMasterTwelve))/(12*COUNT(0))),\n" +
            "\t\t\t\tIF (COUNT = 13, ( (SUM(knowledgeMasterOne)+SUM(knowledgeMasterTwo)+SUM(knowledgeMasterThree)+SUM(knowledgeMasterFour)+SUM(knowledgeMasterFive)+SUM(knowledgeMasterSix)+SUM(knowledgeMasterSeven)+SUM(knowledgeMasterEight)+SUM(knowledgeMasterNine)+SUM(knowledgeMasterTen)+SUM(knowledgeMasterEleven)+SUM(knowledgeMasterTwelve)+SUM(knowledgeMasterThirteen))/(13*COUNT(0))),\n" +
            "\t\t\t\tIF (COUNT = 14, ( (SUM(knowledgeMasterOne)+SUM(knowledgeMasterTwo)+SUM(knowledgeMasterThree)+SUM(knowledgeMasterFour)+SUM(knowledgeMasterFive)+SUM(knowledgeMasterSix)+SUM(knowledgeMasterSeven)+SUM(knowledgeMasterEight)+SUM(knowledgeMasterNine)+SUM(knowledgeMasterTen)+SUM(knowledgeMasterEleven)+SUM(knowledgeMasterTwelve)+SUM(knowledgeMasterThirteen)+SUM(knowledgeMasterFourteen))/(14*COUNT(0))),\n" +
            "\t\t\t\tIF (COUNT = 15, ( (SUM(knowledgeMasterOne)+SUM(knowledgeMasterTwo)+SUM(knowledgeMasterThree)+SUM(knowledgeMasterFour)+SUM(knowledgeMasterFive)+SUM(knowledgeMasterSix)+SUM(knowledgeMasterSeven)+SUM(knowledgeMasterEight)+SUM(knowledgeMasterNine)+SUM(knowledgeMasterTen)+SUM(knowledgeMasterEleven)+SUM(knowledgeMasterTwelve)+SUM(knowledgeMasterThirteen)+SUM(knowledgeMasterFourteen)+SUM(knowledgeMasterFifteen))/(15*COUNT(0))),\n" +
            "\t\t\t\tIF (COUNT = 16, ( (SUM(knowledgeMasterOne)+SUM(knowledgeMasterTwo)+SUM(knowledgeMasterThree)+SUM(knowledgeMasterFour)+SUM(knowledgeMasterFive)+SUM(knowledgeMasterSix)+SUM(knowledgeMasterSeven)+SUM(knowledgeMasterEight)+SUM(knowledgeMasterNine)+SUM(knowledgeMasterTen)+SUM(knowledgeMasterEleven)+SUM(knowledgeMasterTwelve)+SUM(knowledgeMasterThirteen)+SUM(knowledgeMasterFourteen)+SUM(knowledgeMasterFifteen)+SUM(knowledgeMasterSixteen))/(16*COUNT(0))),\n" +
            "\t\t\t\tIF (COUNT = 17, ( (SUM(knowledgeMasterOne)+SUM(knowledgeMasterTwo)+SUM(knowledgeMasterThree)+SUM(knowledgeMasterFour)+SUM(knowledgeMasterFive)+SUM(knowledgeMasterSix)+SUM(knowledgeMasterSeven)+SUM(knowledgeMasterEight)+SUM(knowledgeMasterNine)+SUM(knowledgeMasterTen)+SUM(knowledgeMasterEleven)+SUM(knowledgeMasterTwelve)+SUM(knowledgeMasterThirteen)+SUM(knowledgeMasterFourteen)+SUM(knowledgeMasterFifteen)+SUM(knowledgeMasterSixteen)+SUM(knowledgeMasterSeventeen))/(17*COUNT(0))),\n" +
            "\t\t\t\tIF (COUNT = 18, ( (SUM(knowledgeMasterOne)+SUM(knowledgeMasterTwo)+SUM(knowledgeMasterThree)+SUM(knowledgeMasterFour)+SUM(knowledgeMasterFive)+SUM(knowledgeMasterSix)+SUM(knowledgeMasterSeven)+SUM(knowledgeMasterEight)+SUM(knowledgeMasterNine)+SUM(knowledgeMasterTen)+SUM(knowledgeMasterEleven)+SUM(knowledgeMasterTwelve)+SUM(knowledgeMasterThirteen)+SUM(knowledgeMasterFourteen)+SUM(knowledgeMasterFifteen)+SUM(knowledgeMasterSixteen)+SUM(knowledgeMasterSeventeen)+SUM(knowledgeMasterEighteen))/(18*COUNT(0))),\n" +
            "\t\t\t\tIF (COUNT = 19, ( (SUM(knowledgeMasterOne)+SUM(knowledgeMasterTwo)+SUM(knowledgeMasterThree)+SUM(knowledgeMasterFour)+SUM(knowledgeMasterFive)+SUM(knowledgeMasterSix)+SUM(knowledgeMasterSeven)+SUM(knowledgeMasterEight)+SUM(knowledgeMasterNine)+SUM(knowledgeMasterTen)+SUM(knowledgeMasterEleven)+SUM(knowledgeMasterTwelve)+SUM(knowledgeMasterThirteen)+SUM(knowledgeMasterFourteen)+SUM(knowledgeMasterFifteen)+SUM(knowledgeMasterSixteen)+SUM(knowledgeMasterSeventeen)+SUM(knowledgeMasterEighteen)+SUM(knowledgeMasterNineteen))/(19*COUNT(0))),\n" +
            "\t\t\t\tIF (COUNT = 20, ( (SUM(knowledgeMasterOne)+SUM(knowledgeMasterTwo)+SUM(knowledgeMasterThree)+SUM(knowledgeMasterFour)+SUM(knowledgeMasterFive)+SUM(knowledgeMasterSix)+SUM(knowledgeMasterSeven)+SUM(knowledgeMasterEight)+SUM(knowledgeMasterNine)+SUM(knowledgeMasterTen)+SUM(knowledgeMasterEleven)+SUM(knowledgeMasterTwelve)+SUM(knowledgeMasterThirteen)+SUM(knowledgeMasterFourteen)+SUM(knowledgeMasterFifteen)+SUM(knowledgeMasterSixteen)+SUM(knowledgeMasterSeventeen)+SUM(knowledgeMasterEighteen)+SUM(knowledgeMasterNineteen)+SUM(knowledgeMasterTwenty))/(20*COUNT(0))),\n" +
            "\t\t\t\t\"\"))))))))))))))))))) )*100,0),\"%\") knowledgeMasterRatio," +
            "\tCONCAT(TRUNCATE(SUM(oneToOne)/COUNT(*)*100,0),\"%\") oneToOneSum,\n" +
            "\tCONCAT(TRUNCATE(SUM(isContinue)/COUNT(*)*100,0),\"%\") isContinueRatio\n" +
            "FROM \n" +
            "\tdetails \n")
    @ResultMap("highSchoolMap")
    HighSchool findHighSchoolTotal();

    @Select("SELECT \n" +
            "\tteacher,\n" +
            "\tclassId,\n" +
            "\tCOUNT(*) total,\n" +
            "\tCONCAT(TRUNCATE(SUM(weChat)/COUNT(*)*100,0),\"%\") weChat,\n" +
            "\tCONCAT(TRUNCATE(SUM(zhangYou)/COUNT(*)*100,0),\"%\") zhangYou,\n" +
            "\tCONCAT(TRUNCATE(SUM(shoppingCart)/COUNT(*)*100,0),\"%\") shoppingCart\n" +
            "FROM\n" +
            "\tdetails\n" +
            "WHERE\n" +
            "\tteacher=#{teacher}\n" +
            "GROUP BY\n" +
            "\tclassId;")
    @ResultMap("classMap")
    List<ClassData> findClassByTeacher(String teacher);

    @Select("SELECT \n" +
            "\tteacher,\n" +
            "\tclassId,\n" +
            "\tCOUNT(*) total,\n" +
            "\tCONCAT(TRUNCATE(SUM(weChat)/COUNT(*)*100,0),\"%\") weChat,\n" +
            "\tCONCAT(TRUNCATE(SUM(zhangYou)/COUNT(*)*100,0),\"%\") zhangYou,\n" +
            "\tCONCAT(TRUNCATE(SUM(shoppingCart)/COUNT(*)*100,0),\"%\") shoppingCart\n" +
            "FROM\n" +
            "\tdetails\n" +
            "WHERE\n" +
            "\tproject=#{project}\n" +
            "GROUP BY\n" +
            "\tclassId;")
    @ResultMap("classMap")
    List<ClassData> findClassByProject(String project);

    @Insert("insert into details(project,subject,classId,teacher,studentsId,studentsName,isContinue) values(#{details.project},#{details.subject},#{details.classId}," +
            "#{details.teacher},#{details.studentsId},#{details.studentsName},#{details.isContinue})")
    int insert(@Param("details") InsertStudnets details);

    @Update("update details set nps=#{details.nps} where teacher=#{details.teacher} and studentsName=#{details.studentsName}")
    int update(@Param("details") InsertStudnets details);

    @Update("update details set ${updateStudents.workRatio}=#{updateStudents.work}," +
            " ${updateStudents.videoRatio}=#{updateStudents.video}," +
            "${updateStudents.noteRatio}=#{updateStudents.note}," +
            "${updateStudents.knowledgeMasterRatio}=#{updateStudents.knowledgeMaster}," +
            "weChat=#{updateStudents.weChat}," +
            "zhangYou=#{updateStudents.zhangYou}," +
            "shoppingCart=#{updateStudents.shoppingCart}," +
            "oneToOne=#{updateStudents.oneToOne}," +
            "isContinue=#{updateStudents.isContinue}" +
            " where studentsId=#{updateStudents.studentsId} and classId=#{updateStudents.classId}")
    int updateStudentsData(@Param("updateStudents") UpdateStudents updateStudents);

    @Update("update details set isUpdate=if(${updateStudents.workRatio}!=1 or " +
            " ${updateStudents.videoRatio}!=0 or " +
            "${updateStudents.noteRatio}!=0 or " +
            "${updateStudents.knowledgeMasterRatio}!=0,1,0)" +
            "where studentsId=#{updateStudents.studentsId} and classId=#{updateStudents.classId}")
    int updateIsUpdate(@Param("updateStudents") UpdateStudents updateStudents);

    @Select("SELECT * FROM details where studentsId=#{studentsId} and classId=#{classId}")
    Details queryStudentsData(@Param("studentsId") String studentsId, @Param("classId") String classId);

    @Update("insert into details(project,subject,classId,teacher,studentsId,studentsName,count,isContinue) values(#{addStudents.project},#{addStudents.subject},#{addStudents.classId}," +
            "#{addStudents.teacher},#{addStudents.studentsId},#{addStudents.studentsName},#{addStudents.count},#{addStudents.isContinue})")
    int addStudents(@Param("addStudents") AddStudents addStudents);
}
