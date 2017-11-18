package com.github.vitrocket.mybatis.dao;

import com.github.vitrocket.mybatis.entity.Country;
import com.github.vitrocket.mybatis.entity.Location;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
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
public class LocationMapperTest {

    @Autowired
    private LocationMapper locationMapper;

    @Autowired
    private CountryMapper countryMapper;

    private Country beforeCountry;
    private Location beforeLocation;

    @Test
    public void contextLoads() throws Exception {
        assertNotNull(locationMapper);
        assertNotNull(beforeCountry);
    }

    @Before
    public void setUp() throws Exception {
        beforeCountry = new Country("USA", "English");
        countryMapper.insert(beforeCountry);
        assertNotNull(beforeCountry.getId());
        beforeLocation = new Location();
        beforeLocation.setLocationName("Columbus");
        beforeLocation.setCountry(beforeCountry);
        beforeLocation.setLatitude(BigDecimal.valueOf(40.001497));
        beforeLocation.setLongitude(BigDecimal.valueOf(83.019063));
        locationMapper.insert(beforeLocation);
        assertNotNull(beforeLocation.getId());
        log.info(beforeLocation.toString());
    }

    @Test
    public void testInsertLocation() throws Exception {
        Country country = countryMapper.findById(beforeCountry.getId());
        Location location = new Location();
        location.setLocationName("Columbus");
        location.setCountry(country);
        location.setLatitude(BigDecimal.valueOf(40.001497));
        location.setLongitude(BigDecimal.valueOf(83.019063));
        locationMapper.insert(location);
        assertNotNull(location.getId());
        log.info(location.toString());
    }

    @Test
    public void testGetAllCountry() throws Exception {
        List<Country> countries = locationMapper.findAllCountryWithLocation();
        assertNotNull(countries);
        log.info(countries.toString());
    }

    @Test
    public void testSelectLocations() throws Exception {
        List<Location> locations = locationMapper.findLocationsByCountry(beforeCountry.getId());
        assertNotNull(locations);
        log.info(locations.toString());
    }

    @Test
    public void testSelectCountry() throws Exception {
        Country country = locationMapper.findCountryById(beforeCountry.getId());
        assertEquals(beforeCountry, country);
        log.info(country.toString());
    }
}