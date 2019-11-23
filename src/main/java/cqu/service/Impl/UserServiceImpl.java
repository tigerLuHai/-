package cqu.service.Impl;

import cqu.dao.UserDao;
import cqu.domain.User;
import cqu.service.UserSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserSerivce {

    @Autowired
    private UserDao userDao;

    @Override
    public List<User> QueryUser(String username, String password) {
        return userDao.QueryUser(username, password);
    }

    @Override
    public int modifyPassword(String username, String password, String newPassword) {
        return userDao.modifyPassword(username, password, newPassword);
    }
}
