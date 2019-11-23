package cqu.dao;

import cqu.domain.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import javax.management.Query;
import java.util.List;

@Repository
public interface UserDao {

    @Select("select * from user where username=#{username} and password=#{password}")
    @Results(id = "userMap",
            value = {
                    @Result(column = "id", property = "id"),
                    @Result(column = "username", property = "username"),
                    @Result(column = "password", property = "password"),
                    @Result(column = "permission", property = "permission")
            })
    List<User> QueryUser(@Param("username") String username, @Param("password") String password);


    @Update("update user set password=#{newPassword} where username=#{username} and password=#{password}")
    int modifyPassword(@Param("username") String username, @Param("password") String password, @Param("newPassword") String newPassword);
}
