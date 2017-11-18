package com.github.vitrocket.mybatis.servicedemo;

import com.github.vitrocket.mybatis.dao.*;
import com.github.vitrocket.mybatis.entity.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;

/**
 * @author Vit Rocket on 18.11.2017.
 * @version 1.0
 * @since on 18.11.2017
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class DataLoaderServiceImpl implements DataLoaderService {

    private final CountryMapper countryMapper;
    private final LocationMapper locationMapper;
    private final UserGroupMapper userGroupMapper;
    private final UserMapper userMapper;
    private final SessionMapper sessionMapper;

    @Override
    public List<Country> fillCountry() {
        List<Country> countries = Arrays.asList(
                new Country("United Kingdom", "English"),
                new Country("Mexico", "Spanish"),
                new Country("Austria", "German"),
                new Country("Belgium", "Dutch"),
                new Country("Brazil", "Portuguese"),
                new Country("Czech Republic", "Czech"),
                new Country("Estonia", "Estonian"),
                new Country("Indonesia", "Bahasa Indonesia"),
                new Country("Singapore", "Mandarin"),
                new Country("Turkey", "Turkish"));
        countries.forEach(countryMapper::insert);
        return countries;
    }

    @Override
    public List<Location> fillLocation(List<Country> countries) {
        Random random = new Random();
        int size = countries.size();
        List<Location> locations = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            Location location = new Location("Location_" + i, BigDecimal.valueOf(random.nextFloat() * 100), BigDecimal.valueOf(random.nextFloat() * 100));
            location.setCountry(countries.get(random.nextInt(size)));
            locationMapper.insert(location);
            locations.add(location);
        }
        return locations;
    }

    @Override
    public List<UserGroup> fillUserGroup() {
        List<UserGroup> userGroups = Arrays.asList(
                new UserGroup("Group One"),
                new UserGroup("Group Main"),
                new UserGroup("Group Clever"),
                new UserGroup("Group Car"),
                new UserGroup("Group 1"),
                new UserGroup("Group September")
        );
        userGroups.forEach(userGroupMapper::insert);
        return userGroups;
    }

    @Override
    public List<User> fillUser(List<Location> locations, List<UserGroup> userGroups) {
        Random random = new Random();
        int locationsSize = locations.size();
        int userGroupsSize = userGroups.size();
        List<User> users = new ArrayList<>();

        for (int i = 0; i < 1000; i++) {
            User user = new User(i * 100, locations.get(random.nextInt(locationsSize)), userGroups.get(random.nextInt(userGroupsSize)));
            userMapper.insert(user);
            users.add(user);
        }
        return users;
    }

    @Override
    public List<Session> fillSession(List<User> users) {
        List<Session> sessions = new ArrayList<>();
        Map<Integer, LocalDate> dates = new HashMap<>();
        dates.put(3, LocalDate.of(2017, 10, 18));
        dates.put(4, LocalDate.of(2017, 10, 25));
        dates.put(2, LocalDate.of(2017, 11, 30));
        dates.put(1, LocalDate.of(2017, 12, 10));
        dates.put(0, LocalDate.of(2017, 12, 15));

        Random random = new Random();
        for (User user : users) {
            LocalDate localDate = dates.get(random.nextInt(5));
            Session session = Session.builder()
                                     .user(user)
                                     .dateOpened(localDate)
                                     .dateClosed(localDate.plusDays(10))
                                     .build();
            sessionMapper.insert(session);
            sessions.add(session);
        }
        return sessions;
    }
}
