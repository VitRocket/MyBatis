package com.github.vitrocket.mybatis.dao;

import com.github.vitrocket.mybatis.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author Vit Rocket on 18.11.2017.
 * @version 1.0
 * @since on 18.11.2017
 */
@Mapper
public interface UserMapper {

    List<User> findAll();

    //User findById(Integer id);

    @Insert("insert into user (user_name,location_id,user_group_id) " +
            "values (#{user.userName},#{user.location.id},#{user.userGroup.id})")
    @Options(useGeneratedKeys = true, keyProperty = "user.id", keyColumn = "id")
    int insert(@Param("user") User user);

    //public void update(User user);
    //public void delete(Integer id);

}
