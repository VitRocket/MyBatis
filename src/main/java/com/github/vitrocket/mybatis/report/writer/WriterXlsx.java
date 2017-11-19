package com.github.vitrocket.mybatis.report.writer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 * @author Vit Rocket on 19.11.2017.
 * @version 1.0
 * @since on 19.11.2017
 */
@Slf4j
public class WriterXlsx implements WriterDocument {

    @Override
    public String makeLocal(ArrayList<ArrayList<Object>> dataList, String fileName) {
        String rootPath = System.getProperty("user.dir") + "/reports";
        File destFile = new File(rootPath);
        destFile.mkdirs();
        String fileNameOut = rootPath + "/" + fileName + ".slsx";

        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Country user");

        int rowNum = 0;

        for (ArrayList<Object> objects : dataList) {
            Row row = sheet.createRow(rowNum++);
            int colNum = 0;
            for (Object field : objects) {
                Cell cell = row.createCell(colNum++);
                if (field instanceof String) {
                    cell.setCellValue((String) field);
                } else if (field instanceof Integer) {
                    cell.setCellValue((Integer) field);
                } else if (field instanceof LocalDate) {
                    cell.setCellValue(String.valueOf(field));
                }
            }
        }

        try {
            FileOutputStream outputStream = new FileOutputStream(fileNameOut);
            workbook.write(outputStream);
            workbook.close();
        } catch (IOException e) {
            log.error(e.getLocalizedMessage());
        }
        return fileNameOut;
    }
}