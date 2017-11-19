package com.github.vitrocket.mybatis.controller;

import com.github.vitrocket.mybatis.web.controller.IndexController;
import javafx.beans.binding.Bindings;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @author Vit Rocket on 18.11.2017.
 * @version 1.0
 * @since on 18.11.2017
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class IndexControllerTest {

    @Autowired
    private IndexController indexController;

    @Autowired
    private TestRestTemplate restTemplate;

    @LocalServerPort
    private int port;

    @Test
    public void contextLoads() throws Exception {
        assertNotNull(indexController);
        assertNotNull(restTemplate);
        assertNotNull(port);

    }

    @Test
    public void testIndex() throws Exception {
        assertEquals("Hello MyBatis", this.restTemplate.getForObject("http://localhost:" + port + "/hello", String.class));
    }

}