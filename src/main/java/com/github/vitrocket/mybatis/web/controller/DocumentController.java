package com.github.vitrocket.mybatis.web.controller;

import com.github.vitrocket.mybatis.report.directory.DocumentType;
import com.github.vitrocket.mybatis.web.facade.DocumentFacade;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author Vit Rocket on 19.11.2017.
 * @version 1.0
 * @since on 19.11.2017
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/get_document")
public class DocumentController {

    private final DocumentFacade documentFacade;

    //Example http://localhost:8181/get_document/?email=test@mail.com&doc_format=xls&filter=2017-10-25

    @GetMapping(value = "/")
    @ResponseBody
    public ResponseEntity<String> getRequest(
            @RequestParam("email") String email,
            @RequestParam("doc_format") String documentType,
            @RequestParam("filter") String date) {
        documentFacade.makeDocument(email, documentType, date);
        return new ResponseEntity<>("Your data: " + email + " | " + documentType + " | " + date, HttpStatus.OK);
    }
}