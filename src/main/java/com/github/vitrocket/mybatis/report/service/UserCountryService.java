package com.github.vitrocket.mybatis.report.service;

import com.github.vitrocket.mybatis.report.pojo.UserCountryDTO;

import java.util.List;

/**
 * @author Vit Rocket on 19.11.2017.
 * @version 1.0
 * @since on 19.11.2017
 */
public interface UserCountryService {

    String createReport(List<UserCountryDTO> userCountryDTOs);

}
