package com.github.vitrocket.mybatis.report.facade;

import com.github.vitrocket.mybatis.entity.Session;
import com.github.vitrocket.mybatis.report.pojo.UserCountryDTO;
import com.github.vitrocket.mybatis.report.service.UserCountryService;
import com.github.vitrocket.mybatis.service.SessionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Vit Rocket on 18.11.2017.
 * @version 1.0
 * @since on 18.11.2017
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class UserCountryFacadeImpl implements UserCountryFacade {

    private final SessionService sessionService;
    private final UserCountryService userCountryService;

    @Override
    public List<UserCountryDTO> getUserCountryDTO(LocalDate localDate) {
        List<Session> sessions = sessionService.getSessionUserGroupCountry(localDate);
        List<UserCountryDTO> userCountryDTOs = sessions.stream().map(UserCountryDTO::fromModel).collect(Collectors.toList());
        Collections.sort(userCountryDTOs, ((o1, o2) -> o1.getCountryName().compareTo(o2.getCountryName())));



        String file = userCountryService.createReport(userCountryDTOs);
        log.info(file);



        return userCountryDTOs;
    }
}
