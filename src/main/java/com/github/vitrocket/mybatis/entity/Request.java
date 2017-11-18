package com.github.vitrocket.mybatis.entity;

import lombok.Data;

/**
 * @author Vit Rocket on 18.11.2017.
 * @version 1.0
 * @since on 18.11.2017
 */
@Data
public class Request {

    private Integer id;
    private String url;
    private String method;
    private String params;
    private Session session;

}
