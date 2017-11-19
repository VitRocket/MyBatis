package com.github.vitrocket.mybatis.web.facade;

import com.github.vitrocket.mybatis.report.directory.DocumentType;
import com.github.vitrocket.mybatis.report.facade.UserCountryFacade;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * @author Vit Rocket on 19.11.2017.
 * @version 1.0
 * @since on 19.11.2017
 */
@Service
@RequiredArgsConstructor
public class DocumentFacadeImpl implements DocumentFacade {

    private final UserCountryFacade userCountryFacade;

    @Override
    public void makeDocument(String email, String documentType, String date) {
        //TODO validate email
        documentType = documentType.toUpperCase();
        DocumentType documentType1 = DocumentType.valueOf(documentType);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate localDate = LocalDate.parse(date, formatter);
        userCountryFacade.makeDocument(email, documentType1, localDate);
    }
}
