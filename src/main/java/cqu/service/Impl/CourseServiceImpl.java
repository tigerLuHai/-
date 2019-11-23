package cqu.service.Impl;

import cqu.dao.CourseDao;
import cqu.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;


@Service("courseService")
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseDao courseDao;

    @Override
    public int courseStart() {
        return courseDao.courseStart();
    }

    @Override
    public int courseEnd() {
        String time = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(new Date());
        int i = courseDao.courseEnd(time);
        if (i != 0) {
            courseDao.delete();
        }
        return 0;
    }

    @Override
    public int courseCount() {
        return courseDao.courseCount();
    }
}
