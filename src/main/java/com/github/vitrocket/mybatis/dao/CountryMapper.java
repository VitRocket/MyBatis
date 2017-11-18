package com.github.vitrocket.mybatis.dao;

import com.github.vitrocket.mybatis.entity.Country;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author Vit Rocket on 18.11.2017.
 * @version 1.0
 * @since on 18.11.2017
 */
@Mapper
public interface CountryMapper {

    @Select("select id, country_name, language from country")
    @Results(value = {
            @Result(property = "id", column = "id"),
            @Result(property = "countryName", column = "country_name"),
            @Result(property = "language", column = "language")
    })
    List<Country> findAll();

    @Select("select id, country_name, language from country where id=#{id}")
    @Results(value = {
            @Result(property = "id", column = "id"),
            @Result(property = "countryName", column = "country_name"),
            @Result(property = "language", column = "language")
    })
    Country findById(Integer id);

    @Insert("insert into country (country_name, language) values (#{countryName}, #{language})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    void insert(Country country);

    //public void update(Country country);
    //public void delete(Integer id);
}
