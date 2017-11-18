package com.github.vitrocket.mybatis.dao;

import com.github.vitrocket.mybatis.entity.Country;
import com.github.vitrocket.mybatis.entity.Location;
import com.github.vitrocket.mybatis.entity.Session;
import com.github.vitrocket.mybatis.entity.User;
import org.apache.ibatis.annotations.*;

import java.time.LocalDate;
import java.util.List;

/**
 * @author Vit Rocket on 18.11.2017.
 * @version 1.0
 * @since on 18.11.2017
 */
@Mapper
public interface SessionMapper {

    //public List<Session> findAll();
    //public Session findById(Integer id);

    @Insert("insert into session (user_id,date_opened,date_closed) " +
            "values (#{session.user.id},#{session.dateOpened},#{session.dateClosed})")
    @Options(useGeneratedKeys = true, keyProperty = "session.id", keyColumn = "id")
    void insert(@Param("session") Session session);

    //public void update(Session session);
    //public void delete(Integer id);

    @Select("select * from session where  date_opened= #{dateOpened}")
    @Results(value = {
            @Result(property = "id", column = "id"),
            @Result(property = "dateOpened", column = "date_opened"),
            @Result(property = "dateClosed", column = "date_closed")
    })
    List<Session> findSessionByDateOpened(LocalDate dateOpened);

    @Select("select * from session where  date_opened= #{dateOpened}")
    @Results(value = {
            @Result(property = "id", column = "id"),
            @Result(property = "dateOpened", column = "date_opened"),
            @Result(property = "dateClosed", column = "date_closed"),
            @Result(property = "user", column = "user_id", javaType = User.class, one = @One(select = "findUserById"))
    })
    List<Session> findSessionByDateOpenedWithUser(LocalDate dateOpened);


    @Select("select id, user_name, location_id, user_group_id from user where id = #{id}")
    @Results(value = {
            @Result(property = "id", column = "id"),
            @Result(property = "userName", column = "user_name")
    })
    User findUserById(Integer id);

    @Select("select * from session where  date_opened= #{dateOpened}")
    @Results(value = {
            @Result(property = "id", column = "id"),
            @Result(property = "dateOpened", column = "date_opened"),
            @Result(property = "dateClosed", column = "date_closed"),
            @Result(property = "user", column = "user_id", javaType = User.class, one = @One(select = "findUserByIdWithLocation"))
    })
    List<Session> findSessionByDateOpenedWithUserWithLocation(LocalDate dateOpened);

    @Select("select id, user_name, location_id, user_group_id from user where id = #{id}")
    @Results(value = {
            @Result(property = "id", column = "id"),
            @Result(property = "userName", column = "user_name"),
            @Result(property = "location", column = "location_id", javaType = Location.class, one = @One(select = "findLocationByIdWithCountry"))
    })
    User findUserByIdWithLocation(Integer id);

    @Select("select id, location_name, country_id, latitude, longitude from location where id = #{id}")
    @Results(value = {
            @Result(property = "id", column = "id"),
            @Result(property = "locationName", column = "location_name"),
            @Result(property = "latitude", column = "latitude"),
            @Result(property = "longitude", column = "longitude"),
            @Result(property = "country", column = "country_id", javaType = Country.class, one = @One(select = "findCountryById"))
    })
    Location findLocationByIdWithCountry(Integer id);

    @Select("select id, country_name, language from country where id=#{id}")
    @Results(value = {
            @Result(property = "id", column = "id"),
            @Result(property = "countryName", column = "country_name"),
            @Result(property = "language", column = "language")
    })
    Country findCountryById(Integer id);

}
