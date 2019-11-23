package cqu.service.Impl;

import cqu.dao.DetailsDao;
import cqu.domain.*;
import cqu.service.DetailsService;
import cqu.utilis.DetailsUtils;
import cqu.utilis.ExcelUtils;
import cqu.utilis.InsertThread;
import cqu.utilis.UpdateStudentsUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Service("detailsService")
public class DetailsServiceImpl implements DetailsService {

    @Autowired
    private DetailsDao detailsDao;

    @Override
    public List<Details> findStudentsByClassId(String classId) {
        return detailsDao.findStudentsByClassId(classId);
    }

    @Override
    public int delStudents(String classId, String studentsId) {
        return detailsDao.delStudents(classId, studentsId);
    }

    @Override
    public List<Details> findStudentsByTeacher(String teacher) {
        return detailsDao.findStudentsByTeacher(teacher);
    }

    @Override
    public List<Details> findStudentsByStudentsName(String teacher, String studentsName) {
        return detailsDao.findStudentsByStudentsName(teacher, "%" + studentsName + "%");
    }

    @Override
    public List<Details> findStudentsDetailByStudentsName(String teacher, String studentsName) {
        return detailsDao.findStudentsDetailByStudentsName(teacher, studentsName);
    }

    @Override
    public List<Details> findAllStudents() {
        return detailsDao.findAllStudents();
    }

    @Override
    public List<Course> findProject(String project) {
        return detailsDao.findProject(project);
    }

    @Override
    public List<ClassData> findClass() {
        return detailsDao.findClass();
    }

    @Override
    public List<ClassData> findClassByTeacher(String teacher) {
        return detailsDao.findClassByTeacher(teacher);
    }

    @Override
    public List<HighSchool> findHighSchool() {
        List<HighSchool> highSchools = detailsDao.findHighSchool();
        HighSchool highSchoolTotal = detailsDao.findHighSchoolTotal();
        highSchoolTotal.setProject("总计");
        highSchools.add(highSchoolTotal);
        return highSchools;
    }

    @Override
    public List<Details> findStudentsByStudentsId(String classId, String studentsId) {
        return detailsDao.findStudentsByStudentsId(classId, studentsId);
    }

    public String ajaxUploadExcel(HttpServletRequest request, HttpServletResponse response) {
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;

        MultipartFile file = multipartRequest.getFile("upfile");
        if (file.isEmpty()) {
            try {
                throw new Exception("文件不存在！");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        InputStream in = null;
        try {
            in = file.getInputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<List<Object>> listob = null;
        try {
            listob = new ExcelUtils().getBankListByExcel(in, file.getOriginalFilename());
        } catch (Exception e) {
            e.printStackTrace();
        }
        //该处可调用service相应方法进行数据保存到数据库中
        Map<String, Integer> index = new HashMap<>();
        index.put("message", 0);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < listob.get(i).size(); j++) {
                if (String.valueOf(String.valueOf(listob.get(i).get(j))).equals("项目")) {
                    index.put("项目", j);
                } else if (String.valueOf(String.valueOf(listob.get(i).get(j))).equals("科目")) {
                    index.put("科目", j);
                } else if (String.valueOf(String.valueOf(listob.get(i).get(j))).equals("老师")) {
                    index.put("老师", j);
                } else if (String.valueOf(String.valueOf(listob.get(i).get(j))).equals("班号")) {
                    index.put("班号", j);
                } else if (String.valueOf(String.valueOf(listob.get(i).get(j))).equals("学员号")) {
                    index.put("学员号", j);
                } else if (String.valueOf(String.valueOf(listob.get(i).get(j))).equals("学员姓名")) {
                    index.put("学员姓名", j);
                } else if (String.valueOf(String.valueOf(listob.get(i).get(j))).equals("NPS")) {
                    index.put("NPS", j);
                } else if (String.valueOf(String.valueOf(listob.get(i).get(j))).equals("是否续报春季班")) {
                    index.put("是否续报春季班", j);
                    System.out.println(j);
                }
            }
        }

        for (int i = 2; i < listob.size(); i++) {
            List<Object> lo = listob.get(i);
            InsertStudnets vo = new InsertStudnets();
            try {
                vo.setProject(String.valueOf(lo.get(index.get("项目"))));
            } catch (Exception e) {
                System.out.println(e);
            }
            try {
                vo.setSubject(String.valueOf(lo.get(index.get("科目"))));
            } catch (Exception e) {
                System.out.println(e);
            }
            try {
                vo.setClassId(String.valueOf(lo.get(index.get("班号"))));
            } catch (Exception e) {
                System.out.println(e);
            }
            try {
                vo.setTeacher(String.valueOf(lo.get(index.get("老师"))));
            } catch (Exception e) {
                System.out.println(e);
            }
            try {
                vo.setStudentsId(String.valueOf(String.valueOf(lo.get(index.get("学员号")))));
            } catch (Exception e) {
                System.out.println(e);
            }
            try {
                vo.setStudentsName(String.valueOf(String.valueOf(lo.get(index.get("学员姓名")))));
            } catch (Exception e) {
                System.out.println(e);
            }
            try {
                vo.setIsContinue(DetailsUtils.stringToInteger(String.valueOf(lo.get(index.get("是否续报春季班")))));
            } catch (Exception e) {
            }
            List<Details> studentsByStudentsName = null;
            try {
                studentsByStudentsName = detailsDao.findStudentsByStudentsId(String.valueOf(lo.get(index.get("班号"))), String.valueOf(lo.get(index.get("学员号"))));
            } catch (Exception e) {
            }
            if (studentsByStudentsName != null && studentsByStudentsName.size() > 0) {
                try {
                    vo.setNps(String.valueOf(Double.valueOf(String.valueOf(lo.get(index.get("NPS")))) * 100) + "%");
                } catch (Exception e) {
                    System.out.println(e);
                }
                System.out.println(vo);
                detailsDao.update(vo);
            } else {
                detailsDao.insert(vo);
            }
        }
        return "文件导入成功！";
    }

    @Override
    public List<ClassData> findClassByProject(String project) {
        return detailsDao.findClassByProject(project);
    }

    @Override
    public int updateIsUpdate(UpdateStudents updateStudents) {
        return detailsDao.updateIsUpdate(updateStudents);
    }

    @Override
    public int updateStudentsData(UpdateStudents updateStudents) {
        boolean isQualified = UpdateStudentsUtils.IsQualified(updateStudents);
        if (isQualified) {
            Integer count = updateStudents.getCount();
            String English = DetailsUtils.convertCountToString(count);
            updateStudents.setWorkRatio("work" + English);
            updateStudents.setNoteRatio("note" + English);
            updateStudents.setVideoRatio("video" + English);
            updateStudents.setKnowledgeMasterRatio("knowledgeMaster" + English);
            int status = detailsDao.updateStudentsData(updateStudents);
            return status;
        }
        return -1;
    }

    @Override
    public Details queryStudentsData(String studentsId, String classId) {
        return detailsDao.queryStudentsData(studentsId, classId);
    }

    @Override
    public int addStudents(AddStudents addStudents) {
        addStudents.setCount(detailsDao.findCount());
        return detailsDao.addStudents(addStudents);
    }

}
