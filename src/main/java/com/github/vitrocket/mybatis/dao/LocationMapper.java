package com.github.vitrocket.mybatis.dao;

import com.github.vitrocket.mybatis.entity.Country;
import com.github.vitrocket.mybatis.entity.Location;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author Vit Rocket on 18.11.2017.
 * @version 1.0
 * @since on 18.11.2017
 */
@Mapper
public interface LocationMapper {

    //public List<Country> findAll();

    //public Country findById(Integer id);

    @Insert("insert into location (location_name, country_id, latitude, longitude) values (#{location.locationName}, #{location.country.id}, #{location.latitude}, #{location.longitude})")
    @Options(useGeneratedKeys = true, keyProperty = "location.id", keyColumn = "id")
    void insert(@Param("location") Location location);

    //public void update(Location location);
    //public void delete(Integer id);

    @Select("select id, country_name, language from country")
    @Results(value = {
            @Result(property = "id", column = "id"),
            @Result(property = "countryName", column = "country_name"),
            @Result(property = "language", column = "language"),
            @Result(property = "locations", column = "id", javaType = List.class, many = @Many(select = "findLocationsByCountry"))
    })
    List<Country> findAllCountryWithLocation();

    @Select("select id, location_name, country_id, latitude, longitude from location where country_id = #{countryId}")
    @Results(value = {
            @Result(property = "id", column = "id"),
            @Result(property = "locationName", column = "location_name"),
            @Result(property = "country", column = "country_id", javaType = Country.class, one = @One(select = "findCountryById")),
            @Result(property = "latitude", column = "latitude"),
            @Result(property = "longitude", column = "longitude")
    })
    List<Location> findLocationsByCountry(Integer countryId);

    @Select("select id, country_name, language from country where id = #{id}")
    @Results(value = {
            @Result(property = "id", column = "id"),
            @Result(property = "countryName", column = "country_name"),
            @Result(property = "language", column = "language")
    })
    Country findCountryById(Integer id);

}