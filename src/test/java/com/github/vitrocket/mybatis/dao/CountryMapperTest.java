package com.github.vitrocket.mybatis.dao;

import com.github.vitrocket.mybatis.entity.Country;
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
public class CountryMapperTest {

    @Autowired
    private CountryMapper countryMapper;

    private Country beforeCountry;

    @Test
    public void contextLoads() throws Exception {
        assertNotNull(countryMapper);
    }

    @Before
    public void setUp() throws Exception {
        beforeCountry = new Country("USA", "English");
        countryMapper.insert(beforeCountry);
        assertNotNull(beforeCountry.getId());
    }

    @Test
    public void testInsertCountry() throws Exception {
        Country country = new Country("Angola", "Portuguese");
        countryMapper.insert(country);
        assertNotNull(country.getId());
        log.info("country: " + country);
    }

    @Test
    public void testFindCountryById() throws Exception {
        Country country = countryMapper.findById(beforeCountry.getId());
        assertEquals(beforeCountry, country);
        log.info(country.toString());
    }

    @Test
    public void testGetAllCountry() throws Exception {
        List<Country> countries = countryMapper.findAll();
        assertNotNull(countries);
        assertTrue(countries.size() > 0);
        log.info("countries: " + countries);
    }

}