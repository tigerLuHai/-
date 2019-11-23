package cqu.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseDao {

    @Update("update details set count=1")
    int courseStart();

    @Update("CREATE TABLE details${time} SELECT * FROM details")
    int courseEnd(@Param("time") String time);

    @Update("update details set count=count+1,isUpdate=0")
    int courseCount();

    @Delete("delete from details")
    int delete();

}
