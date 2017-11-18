package com.github.vitrocket.mybatis.servicedemo;

import com.github.vitrocket.mybatis.entity.*;

import java.util.List;

/**
 * @author Vit Rocket on 18.11.2017.
 * @version 1.0
 * @since on 18.11.2017
 */
public interface DataLoaderService {

    List<Country> fillCountry();
    List<Location> fillLocation(List<Country> countries);
    List<UserGroup> fillUserGroup();
    List<User> fillUser(List<Location> locations, List<UserGroup> userGroups);
    List<Session> fillSession(List<User> users);

}
