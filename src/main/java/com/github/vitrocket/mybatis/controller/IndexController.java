package com.github.vitrocket.mybatis.controller;

import com.github.vitrocket.mybatis.report.pojo.UserCountryDTO;
import com.github.vitrocket.mybatis.report.facade.UserCountryFacade;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

/**
 * @author Vit Rocket on 18.11.2017.
 * @version 1.0
 * @since on 18.11.2017
 */
@Slf4j
@RestController
@RequiredArgsConstructor
public class IndexController {

    private final UserCountryFacade userCountryFacade;

    @GetMapping("/hello")
    public String index() {
        return "Hello MyBatis";
    }

    @GetMapping("/demo")
    public List<UserCountryDTO> demo() {
        List<UserCountryDTO> userCountryDTOs = userCountryFacade.getUserCountryDTO(LocalDate.of(2017, 10, 25));
        log.info("sessions size: " + userCountryDTOs.size());
        return userCountryDTOs;
    }

}
