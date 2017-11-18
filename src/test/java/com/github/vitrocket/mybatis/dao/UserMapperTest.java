package com.github.vitrocket.mybatis.dao;

import com.github.vitrocket.mybatis.entity.Country;
import com.github.vitrocket.mybatis.entity.Location;
import com.github.vitrocket.mybatis.entity.User;
import com.github.vitrocket.mybatis.entity.UserGroup;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * @author Vit Rocket on 18.11.2017.
 * @version 1.0
 * @since on 18.11.2017
 */
@Slf4j
@RunWith(SpringRunner.class)
@MybatisTest
public class UserMapperTest {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private CountryMapper countryMapper;
    @Autowired
    private LocationMapper locationMapper;
    @Autowired
    private UserGroupMapper userGroupMapper;

    private Country beforeCountry;
    private Location beforeLocation;
    private UserGroup beforeUserGroup;
    private User beforeUser;

    @Test
    public void contextLoads() throws Exception {
        assertNotNull(userMapper);
        assertNotNull(countryMapper);
        assertNotNull(locationMapper);
        assertNotNull(userGroupMapper);
    }

    @Before
    public void setUp() throws Exception {

        beforeCountry = new Country("Test Country", "Test Language");
        countryMapper.insert(beforeCountry);
        assertNotNull(beforeCountry.getId());
        log.info(beforeCountry.toString());

        beforeLocation = new Location("My Location", BigDecimal.valueOf(50.111), BigDecimal.valueOf(50.111));
        beforeLocation.setCountry(beforeCountry);
        locationMapper.insert(beforeLocation);
        assertNotNull(beforeLocation.getId());
        log.info(beforeLocation.toString());

        beforeUserGroup = new UserGroup("Test User Group");
        userGroupMapper.insert(beforeUserGroup);
        assertNotNull(beforeUserGroup.getId());
        log.info(beforeUserGroup.toString());

        beforeUser = new User(1345678936, beforeLocation, beforeUserGroup);
        userMapper.insert(beforeUser);
        assertNotNull(beforeUser.getId());
        log.info(beforeUser.toString());
    }

    @Test
    public void testInsert() throws Exception {
        User user = new User(1456365897, beforeLocation, beforeUserGroup);
        userMapper.insert(user);
        assertNotNull(user.getId());
        log.info(user.toString());
    }
}