package com.github.vitrocket.mybatis.report.service;

import com.github.vitrocket.mybatis.report.directory.DocumentType;
import com.github.vitrocket.mybatis.report.pojo.UserCountryDTO;
import com.github.vitrocket.mybatis.report.writer.WriterDocument;
import com.github.vitrocket.mybatis.report.writer.WriterFactory;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

/**
 * @author Vit Rocket on 19.11.2017.
 * @version 1.0
 * @since on 19.11.2017
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class UserCountryReportImpl implements UserCountryReport {

    private final WriterFactory writerFactory;

    @Override
    public String createReport(DocumentType documentType, List<UserCountryDTO> userCountryDTOs, LocalDate localDate) {
        ArrayList<ArrayList<Object>> dataList = new ArrayList<>();
        ArrayList<Object> header = new ArrayList<>(Arrays.asList(
                "Country Name",
                "User id",
                "User Name",
                "Date opened"));
        dataList.add(header);

        for (UserCountryDTO userCountryDTO : userCountryDTOs) {
            ArrayList<Object> data = new ArrayList<>(Arrays.asList(
                    userCountryDTO.getCountryName(),
                    userCountryDTO.getUserId(),
                    userCountryDTO.getUserName(),
                    userCountryDTO.getDateOpened()));
            dataList.add(data);
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String fileName = "UserCountry_" + localDate.format(formatter);

        WriterDocument writerDocument = writerFactory.getWriterDocument(documentType);
        String localFile = writerDocument.makeLocal(dataList, fileName);
        log.info(localFile);
        return localFile;
    }
}