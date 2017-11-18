package com.github.vitrocket.mybatis.dao;

import com.github.vitrocket.mybatis.entity.User;
import com.github.vitrocket.mybatis.entity.UserGroup;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author Vit Rocket on 18.11.2017.
 * @version 1.0
 * @since on 18.11.2017
 */
@Mapper
public interface UserGroupMapper {

    @Select("select id, group_name from user_group")
    @Results(value = {
            @Result(property = "id", column = "id"),
            @Result(property = "groupName", column = "group_name")
    })
    List<UserGroup> findAll();

    //public UserGroup findById(Integer id);

    @Insert("insert into user_group (group_name) values (#{groupName})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    void insert(UserGroup userGroup);

    //public void update(UserGroup userGroup);
    //public void delete(Integer id);

    @Select("select id, group_name from user_group")
    @Results(value = {
            @Result(property = "id", column = "id"),
            @Result(property = "groupName", column = "group_name"),
            @Result(property = "users", column = "id", javaType = List.class, many = @Many(select = "findUserByUserGroup"))
    })
    List<UserGroup> findAllWithUsers();

    @Select("select * from user where user_group_id = #{user_group_id}")
    @Results(value = {
            @Result(property = "id", column = "id"),
            @Result(property = "userName", column = "user_name")
    })
    List<User> findUserByUserGroup(String teamId);
}
