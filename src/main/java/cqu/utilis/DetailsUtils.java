package cqu.utilis;

import cqu.dao.DetailsDao;
import cqu.domain.ClassDetail;
import cqu.domain.Details;
import cqu.domain.QueryStudents;
import cqu.domain.UpdateStudents;
import cqu.service.DetailsService;
import org.springframework.beans.factory.annotation.Autowired;


import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DetailsUtils {

    @Autowired
    private DetailsDao detailsDao;

    public static String convertCountToString(int count) {
        switch (count) {
            case 1:
                return "One";
            case 2:
                return "Two";
            case 3:
                return "Three";
            case 4:
                return "Four";
            case 5:
                return "Five";
            case 6:
                return "Six";
            case 7:
                return "Seven";
            case 8:
                return "Eight";
            case 9:
                return "Nine";
            case 10:
                return "Ten";
            case 11:
                return "Eleven";
            case 12:
                return "Twelve";
            case 13:
                return "Thirteen";
            case 14:
                return "Fourteen";
            case 15:
                return "Fifteen";
            case 16:
                return "Sixteen";
            case 17:
                return "Seventeen";
            case 18:
                return "Eighteen";
            case 19:
                return "Nineteen";
            case 20:
                return "Twenty";
        }
        return null;
    }

    public static List<ClassDetail> detailsConvertToClassDetail(Details details) throws IllegalAccessException {
        Map map = objectToMap(details);
        List<ClassDetail> classDetails = new ArrayList<>();

        for (int i = 0; i < details.getCount(); i++) {
            ClassDetail classDetail = new ClassDetail();
            classDetail.setCount(i + 1);
            classDetail.setWork(stringToInteger(String.valueOf(map.get("work" + convertCountToString(i + 1)))));
            classDetail.setNote(stringToInteger(String.valueOf(map.get("note" + convertCountToString(i + 1)))));
            classDetail.setVideo(stringToInteger(String.valueOf(map.get("video" + convertCountToString(i + 1)))));
            classDetail.setKnowledgeMaster(stringToInteger(String.valueOf(map.get("knowledgeMaster" + convertCountToString(i + 1)))));
            classDetails.add(classDetail);
        }

        return classDetails;
    }

    public static Details workToWorkRatio(Details details) throws IllegalAccessException {
        Map map = objectToMap(details);
        details.setWorkRatio(String.valueOf(map.get("work" + convertCountToString(details.getCount()))));
        details.setVideoRatio(String.valueOf(map.get("video" + convertCountToString(details.getCount()))));
        details.setKnowledgeMasterRatio(String.valueOf(map.get("knowledgeMaster" + convertCountToString(details.getCount()))));
        details.setNoteRatio(String.valueOf(map.get("note" + convertCountToString(details.getCount()))));
        return details;
    }

    public static Map objectToMap(Details details) throws IllegalAccessException {
        Map<String, Object> map = new HashMap<>();
        Field[] fields = details.getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            map.put(field.getName(), field.get(details));
        }
        return map;
    }

    public static Integer stringToInteger(String str) {
        Integer integer;
        if (str != null) {
            integer = Integer.valueOf(str);
        } else {
            integer = 0;
        }
        return integer;
    }

    public static List<QueryStudents> detailsConvertToQueryStudents(List<Details> details, Integer count, DetailsService detailsService) throws IllegalAccessException {
        List<QueryStudents> queryStudents = new ArrayList<>();
        for (Details detail : details) {
            Map map = objectToMap(detail);
            QueryStudents queryStudents1 = new QueryStudents();
            queryStudents1.setClassId(detail.getClassId());
            queryStudents1.setProject(detail.getProject());
            queryStudents1.setSubject(detail.getSubject());
            queryStudents1.setTeacher(detail.getTeacher());
            queryStudents1.setStudentsId(detail.getStudentsId());
            queryStudents1.setStudentsName(detail.getStudentsName());
            queryStudents1.setCount(count);
            queryStudents1.setWeChat(detail.getWeChat());
            queryStudents1.setZhangYou(detail.getZhangYou());
            queryStudents1.setShoppingCart(detail.getShoppingCart());
            queryStudents1.setOneToOne(detail.getOneToOne());
            queryStudents1.setIsContinue(detail.getIsContinue());
            queryStudents1.setNps(detail.getNps());
            queryStudents1.setWorkTotal(detail.getWorkTotal());
            queryStudents1.setNoteTotal(detail.getNoteTotal());
            queryStudents1.setKnowledgeMasterTotal(detail.getKnowledgeMasterTotal());
            queryStudents1.setVideoTotal(detail.getVideoTotal());
            queryStudents1.setWork(stringToInteger(String.valueOf(map.get("work" + convertCountToString(count)))));
            queryStudents1.setNote(stringToInteger(String.valueOf(map.get("note" + convertCountToString(count)))));
            queryStudents1.setVideo(stringToInteger(String.valueOf(map.get("video" + convertCountToString(count)))));
            queryStudents1.setKnowledgeMaster(stringToInteger(String.valueOf(map.get("knowledgeMaster" + convertCountToString(count)))));
            if (queryStudents1.getWork() == 1 && queryStudents1.getVideo() == 0 && queryStudents1.getNote() == 0 && queryStudents1.getKnowledgeMaster() == 0) {
                queryStudents1.setIsUpdate(0);
            } else {
                queryStudents1.setIsUpdate(1);
            }
            queryStudents.add(queryStudents1);
        }
        return queryStudents;
    }
}
