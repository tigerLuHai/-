package cqu.controller;

import cqu.domain.*;
import cqu.service.DetailsService;
import cqu.utilis.DetailsUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 课程web
 */
@Controller
@RequestMapping("/details")
public class DetailsController {

    @Autowired
    private DetailsService detailsService;


    @ResponseBody
    @RequestMapping(value = "findHighSchool")
    public Map<String, List<HighSchool>> findHighSchool() {
        List<HighSchool> highSchools = detailsService.findHighSchool();
        Map data = new HashMap();
        data.put("rows", highSchools);
        return data;
    }

    @RequestMapping("/delStudents")
    @ResponseBody
    public int delStudents(@RequestBody String params) throws Exception {
        params = URLDecoder.decode(params, "utf-8");
        String classId = null;
        try {
            classId = params.split("&")[0].split("=")[1];
        } catch (Exception e) {
            classId = "";
        }
        String studentsId = null;
        try {
            studentsId = params.split("&")[1].split("=")[1];
        } catch (Exception e) {
            studentsId = "";
        }
        System.out.println(classId + studentsId);
        return detailsService.delStudents(classId, studentsId);
    }

    @RequestMapping(value = "addStudents")
    @ResponseBody
    public Map<String, Integer> addStudents(@RequestBody AddStudents addStudents) {
        Integer result = detailsService.addStudents(addStudents);
        Map data = new HashMap();
        data.put("result", result);
        return data;
    }

    @ResponseBody
    @RequestMapping(value = "updateStudentsData")
    public Map<Integer, String> updateStudentsData(@RequestBody UpdateStudents updateStudents) {
        HashMap<Integer, String> data = new HashMap<>();
        int status = detailsService.updateStudentsData(updateStudents);
        if (status == -1) {
            data.put(-1, "数据格式有误，请在指定位置输入1或0");
        }
        return data;
    }

    @ResponseBody
    @RequestMapping(value = "/queryStudentsData")
    public Map<String, Details> queryStudentsData(@RequestBody String params) throws UnsupportedEncodingException {
        params = URLDecoder.decode(params, "utf-8");
        String studentsId = params.split("&")[0].split("=")[1];
        String classId = params.split("&")[1].split("=")[1];
        Details details = detailsService.queryStudentsData(studentsId, classId);
        Map data = new HashMap();
        data.put("data", details);
        return data;
    }

    @RequestMapping(value = "upload")
    public String ajaxUploadExcel(HttpServletRequest request, HttpServletResponse response) throws Exception {
        detailsService.ajaxUploadExcel(request, response);
        return "admin/index";
    }

    @RequestMapping("/findStudents")
    @ResponseBody
    public Map<String, List<Object>> findStudents(@RequestBody String params) throws Exception {
        params = URLDecoder.decode(params, "utf-8");
        System.out.println(params);
        String classId = null;
        try {
            classId = params.split("&")[0].split("=")[1];
        } catch (Exception e) {
            classId = "";
        }
        String teacher = null;
        try {
            teacher = params.split("&")[1].split("=")[1];
        } catch (Exception e) {
            teacher = "";
        }
        String studentsName;
        try {
            studentsName = params.split("&")[2].split("=")[1];
        } catch (Exception e) {
            studentsName = "";
        }
        List<Details> details = null;
        if (!studentsName.equals("")) {
            details = detailsService.findStudentsByStudentsName(teacher, studentsName);
        } else if (!classId.equals("null")) {
            details = detailsService.findStudentsByClassId(classId);
        } else if (!teacher.equals("null")) {
            details = detailsService.findStudentsByTeacher(teacher);
        } else {
            details = detailsService.findAllStudents();
        }
        Map data = new HashMap();
        String count;
        try {
            count = params.split("&")[3].split("=")[1];
        } catch (Exception e) {
            count = null;
        }
        List<QueryStudents> queryStudents = new ArrayList<>();
        if (count != null) {
            queryStudents = DetailsUtils.detailsConvertToQueryStudents(details, Integer.valueOf(count), detailsService);
            data.put("rows", queryStudents);
        } else {
            try {
                queryStudents = DetailsUtils.detailsConvertToQueryStudents(details, Integer.valueOf(details.get(0).getCount()), detailsService);
            } catch (Exception e) {
                e.printStackTrace();
                queryStudents = null;
            }
        }
        data.put("rows", queryStudents);
        return data;
    }

    @RequestMapping("/findStudentsDetail")
    @ResponseBody
    public Map<String, List<ClassDetail>> findStudentsDetail(@RequestBody String params) throws Exception {
        params = URLDecoder.decode(params, "utf-8");
        String teacher = params.split("&")[1].split("=")[1];
        String studentsName;
        try {
            studentsName = params.split("&")[2].split("=")[1];
        } catch (Exception e) {
            studentsName = "";
        }
        List<Details> details = null;
        details = detailsService.findStudentsDetailByStudentsName(teacher, studentsName);
        List<ClassDetail> classDetails = null;
        for (int i = 0; i < details.size(); i++) {
            classDetails = DetailsUtils.detailsConvertToClassDetail(details.get(i));
        }
        Map data = new HashMap();
        data.put("rows", classDetails);
        return data;
    }

    @RequestMapping("/findProject")
    @ResponseBody
    public Map<String, List<Course>> findProject(@RequestBody String params) throws UnsupportedEncodingException {
        params = URLDecoder.decode(params, "utf-8");
        String project;
        try {
            project = params.split("=")[1];
        } catch (Exception e) {
            project = "";
        }
        List<Course> courses = detailsService.findProject(project);
        Map data = new HashMap();
        data.put("rows", courses);
        return data;
    }

    @RequestMapping("/findClass")
    @ResponseBody
    public Map<String, List<ClassData>> findClass(@RequestBody String params) throws UnsupportedEncodingException {
        params = URLDecoder.decode(params, "utf-8");
        String teacher = null;
        try {
            teacher = params.split("=")[1];
        } catch (Exception e) {
            teacher = "";
        }
        List<ClassData> classDatas = null;
        if (!teacher.equals("null")) {
            classDatas = detailsService.findClassByTeacher(teacher);
        } else {
            classDatas = detailsService.findClass();
        }
        Map data = new HashMap();
        data.put("rows", classDatas);
        return data;
    }

    @RequestMapping(value = "adminProject")
    public String adminProject() {
        return "admin/projectData";
    }

    @RequestMapping(value = "adminClass")
    public String adminClass() {
        return "admin/classData";
    }

    @RequestMapping(value = "adminStudents")
    public String adminStudents() {
        return "admin/studentsData";
    }

    @RequestMapping(value = "adminIndex")
    public String adminIndex() {
        return "admin/index";
    }

    @RequestMapping(value = "adminUpload")
    public String adminUpload() {
        return "admin/upload";
    }


    @RequestMapping(value = "adminHighSchool")
    public String adminHighSchool() {
        return "admin/highSchool";
    }

    @RequestMapping(value = "adminDefinition")
    public String adminDefinition() {
        return "admin/definition";
    }

    @RequestMapping(value = "adminDetail")
    public String adminDetail() {
        return "admin/detail";
    }

    @RequestMapping(value = "adminAddStudents")
    public String adminAddStudents() {
        return "admin/addStudents";
    }

    @RequestMapping(value = "adminModify")
    public String adminModify() {
        return "admin/modify";
    }

    @RequestMapping(value = "login")
    public String adminLogin() {
        return "login";
    }

    @RequestMapping(value = "bossProject")
    public String bossProject() {
        return "boss/projectData";
    }

    @RequestMapping(value = "bossClass")
    public String bossClass() {
        return "boss/classData";
    }

    @RequestMapping(value = "bossStudents")
    public String bossStudents() {
        return "boss/studentsData";
    }

    @RequestMapping(value = "bossDetail")
    public String bossDetail() {
        return "boss/detail";
    }

    @RequestMapping(value = "bossIndex")
    public String bossIndex() {
        return "boss/index";
    }

    @RequestMapping(value = "bossHighSchool")
    public String bossHighSchool() {
        return "boss/highSchool";
    }

    @RequestMapping(value = "bossDefinition")
    public String bossDefinition() {
        return "boss/definition";
    }

    @RequestMapping(value = "teacherClass")
    public String teacherClass() {
        return "teacher/classData";
    }

    @RequestMapping(value = "teacherStudents")
    public String teacherStudents() {
        return "teacher/studentsData";
    }

    @RequestMapping(value = "teacherModify")
    public String teacherModify() {
        return "teacher/modify";
    }

    @RequestMapping(value = "teacherDetail")
    public String teacherDetail() {
        return "teacher/detail";
    }

    @RequestMapping(value = "teacherAddStudents")
    public String teacherAddStudents() {
        return "teacher/addStudents";
    }

    @RequestMapping(value = "projectClass")
    public String projectClass() {
        return "project/classData";
    }

    @RequestMapping(value = "projectStudents")
    public String projectStudents() {
        return "project/studentsData";
    }

    @RequestMapping(value = "projectModify")
    public String projectModify() {
        return "project/modify";
    }


    @RequestMapping(value = "projectDetail")
    public String projectDetail() {
        return "project/detail";
    }

    @RequestMapping(value = "projectAddStudents")
    public String projectAddStudents() {
        return "project/addStudents";
    }


    @RequestMapping(value = "projectProject")
    public String projectProject() {
        return "project/projectData";
    }

}

