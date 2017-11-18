package com.github.vitrocket.mybatis.dao;

import com.github.vitrocket.mybatis.entity.*;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author Vit Rocket on 18.11.2017.
 * @version 1.0
 * @since on 18.11.2017
 */
@Slf4j
@RunWith(SpringRunner.class)
@MybatisTest
public class SessionMapperTest {

    @Autowired
    private SessionMapper sessionMapper;
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
    private Session beforeSession;


    @Test
    public void contextLoads() throws Exception {
        assertNotNull(sessionMapper);
        assertNotNull(userMapper);
        assertNotNull(beforeCountry);
        assertNotNull(beforeLocation);
        assertNotNull(beforeUserGroup);
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

        beforeSession = Session.builder()
                               .user(beforeUser)
                               .dateOpened(LocalDate.of(2017, 12, 1))
                               .dateClosed(LocalDate.of(2017, 12, 10))
                               .build();
        sessionMapper.insert(beforeSession);
        assertNotNull(beforeSession.getId());
        log.info(beforeSession.toString());
    }

    @Test
    public void testInsert() throws Exception {
        Session session = Session.builder()
                                 .user(new User())
                                 .dateOpened(LocalDate.of(2017, 12, 1))
                                 .dateClosed(LocalDate.of(2017, 12, 10))
                                 .build();
        sessionMapper.insert(session);
        assertNotNull(session.getId());
        log.info(session.toString());
    }

    @Test
    public void testFindSessionByDateOpened() throws Exception {
        Session session = Session.builder()
                                 .user(new User())
                                 .dateOpened(LocalDate.of(2017, 12, 10))
                                 .dateClosed(LocalDate.of(2017, 12, 15))
                                 .build();
        sessionMapper.insert(session);
        assertNotNull(session.getId());
        log.info(session.toString());

        List<Session> sessions = sessionMapper.findSessionByDateOpened(LocalDate.of(2017, 12, 1));
        assertNotNull(sessions);
        assertTrue(sessions.size() > 0);
        assertFalse(sessions.contains(session));
        log.info(sessions.toString());
    }

    @Test
    public void testFindSessionByDateOpenedWithUser() throws Exception {
        Session session = Session.builder()
                                 .user(new User())
                                 .dateOpened(LocalDate.of(2017, 12, 10))
                                 .dateClosed(LocalDate.of(2017, 12, 15))
                                 .build();
        sessionMapper.insert(session);
        assertNotNull(session.getId());
        log.info(session.toString());

        List<Session> sessions = sessionMapper.findSessionByDateOpenedWithUser(LocalDate.of(2017, 12, 1));
        assertNotNull(sessions);
        assertTrue(sessions.size() > 0);
        assertFalse(sessions.contains(session));
        log.info(sessions.toString());
    }

    @Test
    public void testFindSessionByDateOpenedWithUserWithLocation() throws Exception {
        Session session = Session.builder()
                                 .user(new User())
                                 .dateOpened(LocalDate.of(2017, 12, 10))
                                 .dateClosed(LocalDate.of(2017, 12, 15))
                                 .build();
        sessionMapper.insert(session);
        assertNotNull(session.getId());
        log.info(session.toString());

        List<Session> sessions = sessionMapper.findSessionByDateOpenedWithUserWithLocation(LocalDate.of(2017, 12, 1));
        assertNotNull(sessions);
        assertTrue(sessions.size() > 0);
        assertFalse(sessions.contains(session));
        log.info(sessions.toString());
    }
}