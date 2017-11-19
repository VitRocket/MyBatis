package com.github.vitrocket.mybatis.report.service;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.github.vitrocket.mybatis.report.pojo.UserCountryDTO;
import com.github.vitrocket.mybatis.report.writer.WriterDocument;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Array;
import java.time.LocalDate;
import java.util.*;

/**
 * @author Vit Rocket on 19.11.2017.
 * @version 1.0
 * @since on 19.11.2017
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class UserCountryServiceImpl implements UserCountryService {

    private final WriterDocument writerDocument;

    @Override
    public String createReport(List<UserCountryDTO> userCountryDTOs) {
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
        String localFile = writerDocument.makeLocal(dataList);
        log.info(localFile);
        return localFile;
    }
}
