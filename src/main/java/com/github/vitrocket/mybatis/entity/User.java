package com.github.vitrocket.mybatis.entity;


import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author Vit Rocket on 18.11.2017.
 * @version 1.0
 * @since on 18.11.2017
 */
@Data
@NoArgsConstructor
public class User {

    private Integer id;
    private Integer userName;
    private Location location;
    private UserGroup userGroup;
    private List<Session> sessions;

    @Builder
    public User(Integer userName, Location location, UserGroup userGroup) {
        this.userName = userName;
        this.location = location;
        this.userGroup = userGroup;
    }
}