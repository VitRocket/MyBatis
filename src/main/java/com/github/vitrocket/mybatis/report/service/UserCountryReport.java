package com.github.vitrocket.mybatis.report.service;

import com.github.vitrocket.mybatis.report.directory.DocumentType;
import com.github.vitrocket.mybatis.report.pojo.UserCountryDTO;

import java.time.LocalDate;
import java.util.List;

/**
 * @author Vit Rocket on 19.11.2017.
 * @version 1.0
 * @since on 19.11.2017
 */
public interface UserCountryReport {
    String createReport(DocumentType documentType, List<UserCountryDTO> userCountryDTOs, LocalDate localDate);
}
