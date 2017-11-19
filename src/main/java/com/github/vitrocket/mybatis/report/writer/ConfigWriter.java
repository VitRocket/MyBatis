package com.github.vitrocket.mybatis.report.writer;

import com.github.vitrocket.mybatis.report.directory.DocumentType;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Vit Rocket on 19.11.2017.
 * @version 1.0
 * @since on 19.11.2017
 */
@Configuration
public class ConfigWriter {

    @Bean
    Map<DocumentType, WriterDocument> writers() {
        Map<DocumentType, WriterDocument> writers = new HashMap<>();
        writers.put(DocumentType.DOC, new WriterDoc());
        writers.put(DocumentType.DOCX, new WriterDocx());
        writers.put(DocumentType.XLS, new WriterXls());
        writers.put(DocumentType.XLSX, new WriterXlsx());
        writers.put(DocumentType.PDF, new WriterPdf());
        return writers;
    }
}
