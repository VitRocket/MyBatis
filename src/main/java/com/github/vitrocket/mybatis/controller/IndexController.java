package com.github.vitrocket.mybatis.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Vit Rocket on 18.11.2017.
 * @version 1.0
 * @since on 18.11.2017
 */
@RestController
public class IndexController {

    @GetMapping("/hello")
    public String index() {
        return "Hello MyBatis";
    }

}
