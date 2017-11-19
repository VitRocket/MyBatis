package com.github.vitrocket.mybatis.report.writer;

import com.github.vitrocket.mybatis.report.directory.DocumentType;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author Vit Rocket on 19.11.2017.
 * @version 1.0
 * @since on 19.11.2017
 */
@Component
@RequiredArgsConstructor
public class WriterFactory {

    private final Map<DocumentType, WriterDocument> writers;

    public WriterDocument getWriterDocument(DocumentType documentType) {
        return writers.get(documentType);
    }

}
