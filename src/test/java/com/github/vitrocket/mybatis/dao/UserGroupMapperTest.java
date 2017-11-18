package com.github.vitrocket.mybatis.dao;

import com.github.vitrocket.mybatis.entity.UserGroup;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

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
public class UserGroupMapperTest {

    @Autowired
    private UserGroupMapper userGroupMapper;

    private UserGroup beforeUserGroup;

    @Test
    public void contextLoads() throws Exception {
        assertNotNull(userGroupMapper);
    }

    @Before
    public void setUp() throws Exception {
        beforeUserGroup = new UserGroup("Test Group");
        userGroupMapper.insert(beforeUserGroup);
        assertNotNull(beforeUserGroup.getId());
        log.info(beforeUserGroup.toString());
    }

    @Test
    public void testFindAll() throws Exception {
        List<UserGroup> userGroups = userGroupMapper.findAll();
        assertNotNull(userGroups);
        assertTrue(userGroups.size() > 0);
        log.info(userGroups.toString());
    }

    @Test
    public void testInsert() throws Exception {

    }

    @Test
    public void testFindAllWithUsers() throws Exception {
        List<UserGroup> userGroups = userGroupMapper.findAllWithUsers();
        assertNotNull(userGroups);
        assertTrue(userGroups.size() > 0);
        log.info(userGroups.toString());
    }

    @Test
    public void testFindUserByUserGroup() throws Exception {

    }
}