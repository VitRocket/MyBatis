package com.github.vitrocket.mybatis.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Vit Rocket on 18.11.2017.
 * @version 1.0
 * @since on 18.11.2017
 */
@Slf4j
@RestController
public class IndexController {

    @GetMapping("/hello")
    public String index() {
        return "Hello MyBatis";
    }

}
