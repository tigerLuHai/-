package cqu.service;

import cqu.domain.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserSerivce {

    List<User> QueryUser(String username, String password);

    int modifyPassword(String username, String password, String newPassword);
}
