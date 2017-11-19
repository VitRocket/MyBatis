package com.github.vitrocket.mybatis.report.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.github.vitrocket.mybatis.entity.Session;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;

/**
 * @author Vit Rocket on 18.11.2017.
 * @version 1.0
 * @since on 18.11.2017
 */
@Slf4j
@Data
public class UserCountryDTO {

    private Integer userId;
    private Integer userName;
    private String countryName;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate dateOpened;

    public static UserCountryDTO fromModel(Session session) {
        UserCountryDTO userCountryDTO = new UserCountryDTO();
        userCountryDTO.setUserId(session.getUser().getId());
        userCountryDTO.setUserName(session.getUser().getUserName());
        userCountryDTO.setCountryName(session.getUser().getLocation().getCountry().getCountryName());
        userCountryDTO.setDateOpened(session.getDateOpened());
        return userCountryDTO;
    }
}
