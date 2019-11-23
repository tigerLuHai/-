package cqu.controller;

import cqu.domain.User;
import cqu.service.CourseService;
import cqu.service.UserSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/details/user")
public class UserController {

    @Autowired
    private UserSerivce userSerivce;

    @RequestMapping(value = "login")
    @ResponseBody
    public User login(@RequestBody String params) {
        String username = null;
        String password = null;
        try {
            username = params.split("&")[0].split("=")[1];
            password = params.split("&")[1].split("=")[1];
            List<User> users = userSerivce.QueryUser(username, password);
            if (users != null && users.size() > 0) {
                return users.get(0);
            }
            User user = new User();
            user.setPermission("0");
            return user;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @RequestMapping(value = "modifyPassword")
    @ResponseBody
    public User modifyPassword(@RequestBody String params) {
        System.out.println(params);
        String username = params.split("&")[0].split("=")[1];
        String password = params.split("&")[1].split("=")[1];
        String newPassword = params.split("&")[2].split("=")[1];
        String checkPassword = params.split("&")[3].split("=")[1];
        User user = new User();
        List<User> users = userSerivce.QueryUser(username, password);
        if (users != null && users.size() > 0) {
            System.out.println("开始修改");
            if (newPassword.equals(checkPassword)) {
                int update = userSerivce.modifyPassword(username, password, newPassword);
                user.setPermission("修改成功");
            } else {
                System.out.println("密码错误");
                user.setPermission("密码确认有误");
            }
        } else {
            user.setPermission("密码有误");
        }
        return user;
    }
}
