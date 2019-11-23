package cqu.service;

import cqu.domain.*;
import org.apache.ibatis.annotations.Param;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 课程service接口
 */
public interface DetailsService {

    List<Details> findStudentsByClassId(String classId);

    int delStudents(String classId, String studentsId);

    List<Details> findStudentsByTeacher(String teacher);

    List<Details> findStudentsByStudentsName(String teacher, String studentsName);

    List<Details> findStudentsByStudentsId(String classId, String studentsId);

    List<Details> findStudentsDetailByStudentsName(String teacher, String studentsName);

    List<Details> findAllStudents();

    List<Course> findProject(String project);

    List<ClassData> findClass();

    List<ClassData> findClassByTeacher(String teacher);

    List<HighSchool> findHighSchool();

    String ajaxUploadExcel(HttpServletRequest request, HttpServletResponse response);

    List<ClassData> findClassByProject(String project);

    int updateStudentsData(UpdateStudents updateStudents);

    Details queryStudentsData(String students, String classId);

    int addStudents(AddStudents addStudents);

    int updateIsUpdate(UpdateStudents updateStudents);
}
