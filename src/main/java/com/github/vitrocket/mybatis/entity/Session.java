package com.github.vitrocket.mybatis.entity;

import lombok.*;

import java.time.LocalDate;

/**
 * @author Vit Rocket on 18.11.2017.
 * @version 1.0
 * @since on 18.11.2017
 */
@Data
@NoArgsConstructor
public class Session {

    private Integer id;
    private User user;
    private LocalDate dateOpened;
    private LocalDate dateClosed;

    @Builder
    public Session(User user, LocalDate dateOpened, LocalDate dateClosed) {
        this.user = user;
        this.dateOpened = dateOpened;
        this.dateClosed = dateClosed;
    }

}
