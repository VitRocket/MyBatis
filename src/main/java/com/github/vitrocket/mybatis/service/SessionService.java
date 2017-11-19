package com.github.vitrocket.mybatis.service;

import com.github.vitrocket.mybatis.entity.Session;

import java.time.LocalDate;
import java.util.List;

/**
 * @author Vit Rocket on 18.11.2017.
 * @version 1.0
 * @since on 18.11.2017
 */
public interface SessionService {

    List<Session> getSessionUserGroupCountry(LocalDate localDate);

}
