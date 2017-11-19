package com.github.vitrocket.mybatis.web.facade;


import com.github.vitrocket.mybatis.report.directory.DocumentType;

/**
 * @author Vit Rocket on 19.11.2017.
 * @version 1.0
 * @since on 19.11.2017
 */
public interface DocumentFacade {
    void makeDocument(String email, String documentType, String date);
}