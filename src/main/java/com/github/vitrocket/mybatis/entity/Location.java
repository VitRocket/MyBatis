package com.github.vitrocket.mybatis.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author Vit Rocket on 18.11.2017.
 * @version 1.0
 * @since on 18.11.2017
 */
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Location {

    private Integer id;
    @NonNull
    private String locationName;
    private Country country;
    @NonNull
    private BigDecimal latitude;
    @NonNull
    private BigDecimal longitude;
    private List<User> users;

}
