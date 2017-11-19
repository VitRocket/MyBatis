package com.github.vitrocket.mybatis.report.facade;

import com.github.vitrocket.mybatis.report.pojo.UserCountryDTO;

import java.time.LocalDate;
import java.util.List;

/**
 * @author Vit Rocket on 18.11.2017.
 * @version 1.0
 * @since on 18.11.2017
 */
public interface UserCountryFacade {

    List<UserCountryDTO> getUserCountryDTO(LocalDate localDate);

}
