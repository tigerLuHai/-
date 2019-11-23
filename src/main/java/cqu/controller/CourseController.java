package cqu.controller;

import cqu.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/details/course")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @RequestMapping("start")
    @ResponseBody
    public int courseStart() {
        return courseService.courseStart();
    }

    @RequestMapping("end")
    @ResponseBody
    public int courseEnd() {
        return courseService.courseEnd();
    }

    @RequestMapping("count")
    @ResponseBody
    public int courseCount() {
        return courseService.courseCount();
    }


    @RequestMapping(value = "toLogin")
    public String toLogin() {
        return "login";
    }
}
