package com.github.vitrocket.mybatis.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.List;

/**
 * @author Vit Rocket on 18.11.2017.
 * @version 1.0
 * @since on 18.11.2017
 */
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Country {

    private Integer id;
    @NonNull
    private String countryName;
    @NonNull
    private String language;
    private List<Location> locations;
}