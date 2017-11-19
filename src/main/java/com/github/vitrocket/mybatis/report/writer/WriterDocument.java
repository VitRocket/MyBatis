package com.github.vitrocket.mybatis.report.writer;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * @author Vit Rocket on 19.11.2017.
 * @version 1.0
 * @since on 19.11.2017
 */
public interface WriterDocument {
    String makeLocal(ArrayList<ArrayList<Object>> dataList, String fileName);
}