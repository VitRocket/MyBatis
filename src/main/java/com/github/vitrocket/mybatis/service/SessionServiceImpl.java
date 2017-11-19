package com.github.vitrocket.mybatis.service;

import com.github.vitrocket.mybatis.dao.SessionMapper;
import com.github.vitrocket.mybatis.entity.Session;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

/**
 * @author Vit Rocket on 18.11.2017.
 * @version 1.0
 * @since on 18.11.2017
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class SessionServiceImpl implements SessionService {

    private final SessionMapper sessionMapper;

    @Override
    public List<Session> getSessionUserGroupCountry(LocalDate localDate) {
        List<Session> sessions = sessionMapper.findSessionByDateOpenedWithUserWithLocation(localDate);
        return sessions;
    }
}
