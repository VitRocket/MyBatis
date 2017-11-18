package com.github.vitrocket.mybatis;

import com.github.vitrocket.mybatis.entity.*;
import com.github.vitrocket.mybatis.servicedemo.DataLoaderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Vit Rocket on 18.11.2017.
 * @version 1.0
 * @since on 18.11.2017
 */
@Slf4j
@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    private DataLoaderService dataLoaderService;

    @Override
    public void run(ApplicationArguments applicationArguments) throws Exception {
        log.info("Data loader");
        List<Country> countries = dataLoaderService.fillCountry();
        log.info(countries.toString());
        List<Location> locations = dataLoaderService.fillLocation(countries);
        log.info("locations size: " + locations.size());
        List<UserGroup> userGroups = dataLoaderService.fillUserGroup();
        log.info(userGroups.toString());
        List<User> users = dataLoaderService.fillUser(locations,userGroups);
        log.info("user size: " + users.size());
        List<Session> sessions = dataLoaderService.fillSession(users);
        log.info("sessions size: " + sessions.size());

        







    }
}
