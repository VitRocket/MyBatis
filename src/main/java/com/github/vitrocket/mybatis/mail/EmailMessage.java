package com.github.vitrocket.mybatis.mail;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Vit Rocket on 21.11.2017.
 * @version 1.0
 * @since on 21.11.2017
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmailMessage {

    private String from;
    private String to;
    private String subject;
    private String content;
    private String attachment;


}
