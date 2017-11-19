package com.github.vitrocket.mybatis.report.writer;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;

/**
 * @author Vit Rocket on 19.11.2017.
 * @version 1.0
 * @since on 19.11.2017
 */
public class WriterDocx implements WriterDocument {

    @Override
    public String makeLocal(ArrayList<ArrayList<Object>> dataList, String fileName) {
        throw new UnsupportedOperationException("WriterDocx will implement next time.");
    }
}
